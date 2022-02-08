import {Injectable} from '@angular/core';
import {BehaviorSubject, firstValueFrom, Observable} from "rxjs";
import {User} from "../models/models";
import {Router} from "@angular/router";
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private readonly baseUrl: string;
  private readonly isLoggedInSubject: BehaviorSubject<boolean>;
  private readonly userSubject: BehaviorSubject<User | null>;
  private token: string | null;


  constructor(private readonly router: Router,
              private readonly http: HttpClient) {
    this.isLoggedInSubject = new BehaviorSubject<boolean>(false);
    this._password = null;
    this.baseUrl = environment.baseUrl
    this.token = null;
    this.userSubject = new BehaviorSubject<User | null>(null);
  }

  private _password: string | null;

  public get loggedInState(): boolean {
    return this.isLoggedInSubject.value;
  }

  public set loggedInState(state: boolean) {
    this.isLoggedInSubject.next(state);
  }

  public get loggedInStateAsObservable(): Observable<boolean> {
    return this.isLoggedInSubject;
  }

  public get password(): string | null {
    return this._password;
  }

  public authenticate(username: string, password: string): Promise<User> {
    this._password = password;
    return firstValueFrom(this.http.post<User>(`${this.baseUrl}/user/authenticate`, {username, password}));
  }

  public get userObservable(): Observable<User | null> {
    return this.userSubject;
  }

  public get user(): User | null {
    return this.userSubject.value;
  }

  public setUser(user: User | null) {
    this.userSubject.next(user);
  }

  public signOut(): void {
    this.isLoggedInSubject.next(false);
    this.userSubject.next(null);
    this.router.navigateByUrl('/signin')
    sessionStorage.removeItem('user');
  }

  public getToken(): string | null {
    return this.token;
  }

  public setToken(token: string): void {
    this.token = token;
  }

}

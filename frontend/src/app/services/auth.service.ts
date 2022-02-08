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
  public user: User | null;
  private readonly isLoggedInSubject: BehaviorSubject<boolean>;
  private token: string | null;

  constructor(private readonly router: Router,
              private readonly http: HttpClient) {
    this.isLoggedInSubject = new BehaviorSubject<boolean>(false);
    this.user = null;
    this._password = null;
    this.baseUrl = environment.baseUrl
    this.token = null;
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

  public authenticate(username: string, password: string): Promise<Object> {
    this._password = password;
    return firstValueFrom(this.http.post(`${this.baseUrl}/user/authenticate`, {username, password}));
  }

  public setUser(user: User | null) {
    this.user = user;
  }

  public signOut(): void {
    this.isLoggedInSubject.next(false);
    this.user = null;
    this.router.navigateByUrl('/signin')
  }

  public getToken(): string | null {
    return this.token;
  }

  public setToken(token: string): void {
    this.token = token;
  }

}

import {Injectable} from '@angular/core';
import {BackendService} from "./backend.service";
import {BehaviorSubject, Observable} from "rxjs";
import {User} from "../models/models";
import {Router} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  public user: User | null;
  private readonly isLoggedInSubject: BehaviorSubject<boolean>;

  constructor(private readonly backend: BackendService, private readonly router: Router) {
    this.isLoggedInSubject = new BehaviorSubject<boolean>(false);
    this.user = null;
  }

  public get loggedInState(): boolean {
    return this.isLoggedInSubject.value;
  }

  public set loggedInState(state: boolean) {
    this.isLoggedInSubject.next(state);
  }

  public get loggedInStateAsObservable(): Observable<boolean> {
    return this.isLoggedInSubject;
  }

  public authenticate(username: string, password: string): Promise<Object> {
    return this.backend.post('user/authenticate', {username, password});
  }

  public setUser(user: User | null) {
    this.user = user;
  }

  public signOut(): void {
    this.isLoggedInSubject.next(false);
    this.user = null;
    this.router.navigateByUrl('/signin')
  }
}

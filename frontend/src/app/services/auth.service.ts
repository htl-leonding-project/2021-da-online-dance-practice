import {Injectable} from '@angular/core';
import {BackendService} from "./backend.service";
import {BehaviorSubject, Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private readonly isLoggedInSubject: BehaviorSubject<boolean>;

  constructor(private readonly backend: BackendService) {
    this.isLoggedInSubject = new BehaviorSubject<boolean>(false);
  }

  public authenticate(username: string, password: string): Promise<Object> {
    return this.backend.post('user/authenticate', {username, password});
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
}

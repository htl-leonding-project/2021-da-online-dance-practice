import {Injectable} from '@angular/core';
import {BackendService} from "./backend.service";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private readonly backend: BackendService) {
  }

  public authenticate(username: string, password: string): Promise<Object> {
    return this.backend.post('user/authenticate', {username, password});
  }
}

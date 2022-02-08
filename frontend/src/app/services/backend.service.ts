import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {firstValueFrom} from "rxjs";
import {AuthService} from "./auth.service";

@Injectable({
  providedIn: 'root'
})
export class BackendService {
  private readonly baseUrl: string;

  constructor(private readonly http: HttpClient, private readonly auth: AuthService) {
    this.baseUrl = environment.baseUrl
  }


  public post<T>(route: string, body: any): Promise<T> {
    return firstValueFrom(this.http.post<T>(`${this.baseUrl}/${route}`, body, {
      headers: this.buildHeader()
    }));
  }

  public put(route: string, body: any): Promise<Object> {
    return firstValueFrom(this.http.put(`${this.baseUrl}/${route}`, body, {
      headers: this.buildHeader()
    }));
  }

  public get(route: string): Promise<Object> {
    return firstValueFrom(this.http.get(`${this.baseUrl}/${route}`, {
      headers: this.buildHeader()
    }));
  }

  public postFile(route: string, body: any): Promise<Object> {
    return firstValueFrom(this.http.post(`${this.baseUrl}/${route}`, body, {
      headers: {
        'Content-Type': 'multipart/form-data',
        Authorization: this.getAuthContent()
      }
    }))
  }

  public delete(route: string): Promise<Object> {
    return firstValueFrom(this.http.delete(`${this.baseUrl}/${route}`, {
      headers: this.buildHeader()
    }));
  }

  private buildHeader(): any {
    if (this.auth.getToken()) {
      return {
        'X-Token': this.auth.getToken()
      }
    } else if (this.auth.user) {
      return {
        Authorization: this.getAuthContent()
      };
    } else {
      return {};
    }
  }

  private getAuthContent() {
    return `Basic ${btoa(`${this.auth.user?.username}:${this.auth.password}`)}`;
  }

}

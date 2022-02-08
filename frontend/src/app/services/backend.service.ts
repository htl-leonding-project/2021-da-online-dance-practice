import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {firstValueFrom} from "rxjs";
import {AuthService} from "./auth.service";
import {Course} from "../models/models";

@Injectable({
  providedIn: 'root'
})
export class BackendService {
  private readonly baseUrl: string;

  constructor(private readonly http: HttpClient, private readonly auth: AuthService) {
    this.baseUrl = environment.baseUrl
  }


  public post(route: string, body: any): Promise<Object> {
    return firstValueFrom(this.http.post(`${this.baseUrl}/${route}`, body, {
      headers: {
        Authorization: this.getAuthContent()
      }
    }));
  }

  public put(route: string, body: any): Promise<Object> {
    return firstValueFrom(this.http.put(`${this.baseUrl}/${route}`, body, {
      headers: {
        Authorization: this.getAuthContent()
      }
    }));
  }

  public get(route: string): Promise<Object> {
    return firstValueFrom(this.http.get(`${this.baseUrl}/${route}`, {
      headers: {
        Authorization: this.getAuthContent()
      }
    }));
  }

  public postFile(route: string, body: Blob, imagename:string, course:Course, description:string): Promise<Object> {
    let resp = this.http.post(`${this.baseUrl}/file/${imagename}?courseId=${course.id}&description=${description}`, body, {
      // headers: {
      //   'Content-Type': 'multipart/form-data',
      //   Authorization: this.getAuthContent()
      // }
    });
    console.log("Open resp is: ",resp);
    return firstValueFrom(resp);
  }

  public delete(route: string): Promise<Object> {
    return firstValueFrom(this.http.delete(`${this.baseUrl}/${route}`, {
      headers: {
        Authorization: this.getAuthContent()
      }
    }));
  }

  private getAuthContent() {
    return `Basic ${btoa(`${this.auth.user?.username}:${this.auth.password}`)}`;
  }

}

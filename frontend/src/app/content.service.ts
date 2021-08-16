import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable, Subject} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ContentService {


  constructor(public http: HttpClient) {

  }

  public getPath(id: number): Observable<string> {
    const pathsSubject: Subject<string> = new Subject<string>();

    this.http.get<File>('http://localhost:8080/file/' + id).subscribe(file => {
      pathsSubject.next('http://localhost:8080/' + file.path + '/' + file.name);
    });
    return pathsSubject;
  }
}
interface File{
  id: number;
  name: string;
  path: string;
  contentType: string;
}

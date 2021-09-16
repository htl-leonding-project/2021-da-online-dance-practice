import {Component, Input} from '@angular/core';
import {HttpClient, HttpEventType} from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent{


  fileName = '';

  constructor(private http: HttpClient) {}

  onFileSelected(event: any): void {

    const file: File = event.target.files[0];

    if (file) {
      this.fileName = file.name;
      const formData = new FormData();
      formData.append('thumbnail', file);
      const upload$ = this.http.post('http://localhost:8080/api/file/upload', formData);
      upload$.subscribe();
    }
  }
}

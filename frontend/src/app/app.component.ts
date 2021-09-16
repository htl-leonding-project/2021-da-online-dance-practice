import { Component } from '@angular/core';
import {ContentService, File} from './content.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent{
  title = 'frontend';
  videoSource = '';
  audioSource = '';
  audio: any;
  files: Array<File>;

  constructor(public contentService: ContentService) {
      this.files = [];

      contentService.getPath(32).subscribe(path => {
        console.log(path);
        this.videoSource = path;
      });

      contentService.getFiles().subscribe(files => {
      this.files = files;
    });

  }
}

import { Component } from '@angular/core';
import {ContentService} from './content.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent{
  title = 'frontend';
  videoSource = '';
  audioSource = '';

  constructor(public contentService: ContentService) {

      contentService.getPath(32).subscribe(path => {
        console.log(path);
        this.videoSource = path;
      });

      contentService.getPath(2).subscribe(path => {
        console.log(path);
        this.audioSource = path;
      });
  }
}

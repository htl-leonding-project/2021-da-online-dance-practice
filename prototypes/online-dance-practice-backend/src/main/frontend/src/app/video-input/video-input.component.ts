import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-video-input',
  templateUrl: './video-input.component.html',
  styleUrls: ['./video-input.component.css']
})
export class VideoInputComponent implements OnInit {
  @Input() pathMp4!: string;
  @Input() pathWebm!: string;

  pathM! : string;
  pathW!: string;

  constructor() { }

  ngOnInit(): void {
    this.pathM = "assets/"+this.pathMp4+".mp4";
    this.pathW = "assets/"+this.pathWebm+"webm";
  }

}

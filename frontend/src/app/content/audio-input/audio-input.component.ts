import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-audio-input',
  templateUrl: './audio-input.component.html',
  styleUrls: ['./audio-input.component.css']
})
export class AudioInputComponent implements OnInit {
  @Input() pathMp3!: string;


  pathM!: string;


  constructor() { }

  ngOnInit(): void {
    this.pathM = 'assets/' + this.pathMp3 + '.mp3';
  }

}

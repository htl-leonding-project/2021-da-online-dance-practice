import {Component, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {DFile} from '../../../../../models/models';
import {ActivatedRoute} from '@angular/router';
import {BackendService} from '../../../../../services/backend.service';

@Component({
  selector: 'app-video-input',
  templateUrl: './video-input.component.html',
  styleUrls: ['./video-input.component.scss']
})
export class VideoInputComponent implements OnInit, OnChanges {
  @Input() public video!: DFile;
  videoSource = '';


  constructor(private readonly route: ActivatedRoute,
              private readonly backend: BackendService) {
  }

  ngOnInit(): void {
  }

  ngOnChanges(changes: SimpleChanges): void {
    const url = 'http://localhost:8080/api/' + this.video.path + '/' + this.video.name;
    this.videoSource = url;

  }

}

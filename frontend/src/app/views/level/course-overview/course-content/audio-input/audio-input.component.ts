import {Component, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {BackendService} from '../../../../../services/backend.service';
import {DFile} from '../../../../../models/models';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-audio-input',
  templateUrl: './audio-input.component.html',
  styleUrls: ['./audio-input.component.scss']
})
export class AudioInputComponent implements OnInit, OnChanges {
  @Input() public audio!: DFile;
  audioSource = '';

  constructor(private readonly route: ActivatedRoute,
              private readonly backend: BackendService) {
  }

  ngOnInit(): void {
  }

  ngOnChanges(changes: SimpleChanges): void {
    const url = "http://localhost:8080/api/" + this.audio.path + "/" + this.audio.name;
    this.audioSource = url;

  }

}

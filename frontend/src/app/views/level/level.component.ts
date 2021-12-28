import {Component, OnInit} from '@angular/core';
import {BackendService} from "../../services/backend.service";
import {Level} from "../../models/models";

@Component({
  selector: 'app-level',
  templateUrl: './level.component.html',
  styleUrls: ['./level.component.scss']
})
export class LevelComponent implements OnInit {

  levels: Level[] | null;

  constructor(private readonly backend: BackendService) {
    this.levels = null;
  }

  ngOnInit(): void {
    this.backend.get('level').then(value => {
      this.levels = value as Level[];
    });
  }


}

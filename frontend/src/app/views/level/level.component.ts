import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {BackendService} from "../../services/backend.service";
import {Level} from "../../models/models";

@Component({
  selector: 'app-level',
  templateUrl: './level.component.html',
  styleUrls: ['./level.component.scss']
})
export class LevelComponent implements OnInit {

  @Output() levelSelected: EventEmitter<Object> = new EventEmitter<Object>();
  levels: Level[] | null;

  constructor(private readonly backend: BackendService) {
    this.levels = null;
  }

  ngOnInit(): void {
    this.backend.get('level').then(value => {
      this.levels = value as Level[];
      this.levelSelected.emit();
    });
  }


}

import {Component, Input, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {BackendService} from "../../../services/backend.service";
import {Course, Level} from '../../../models/models';

@Component({
  selector: 'app-course-overview',
  templateUrl: './course-overview.component.html',
  styleUrls: ['./course-overview.component.scss']
})
export class CourseOverviewComponent implements OnInit {
  courses: Course[] | null;
  @Input() courseSelected!: string | null;
  public levelSelected: string | null;


  constructor(private readonly route: ActivatedRoute,
              private readonly backend: BackendService) {
    this.courses = null;
    this.levelSelected = null;
  }

  ngOnInit(): void {
    this.route.params.subscribe(value => {
      this.backend.get(`course/findByLevel/${value["id"]}`).then(courses => {
        this.courses = courses as Course[];

      });
    });

    this.route.paramMap.subscribe(params => {
      this.levelSelected = params.get("id");
    });
  }

}

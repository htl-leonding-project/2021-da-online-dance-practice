import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {BackendService} from "../../../../services/backend.service";
import {DFile} from "../../../../models/models";

@Component({
  selector: 'app-course-content',
  templateUrl: './course-content.component.html',
  styleUrls: ['./course-content.component.scss']
})
export class CourseContentComponent implements OnInit {
  content: DFile[] | null;

  constructor(private readonly route: ActivatedRoute,
              private readonly backend: BackendService) {
    this.content = null;
  }

  ngOnInit(): void {
    this.route.params.subscribe(value => {
      this.backend.get(`course/filesByCourse/${value["courseId"]}`).then(content => {
        console.log(content)
        this.content = content as DFile[];
      })
    });
  }

}

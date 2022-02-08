import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {BackendService} from "../../../../services/backend.service";
import {Course, DFile} from '../../../../models/models';
import {AuthService} from "../../../../services/auth.service";

@Component({
  selector: 'app-course-content',
  templateUrl: './course-content.component.html',
  styleUrls: ['./course-content.component.scss']
})
export class CourseContentComponent implements OnInit {
  content: DFile[] | null;
  cards: ImyCard[];
  gridColumns = 4;
  public courseSelected: string | null;
  public levelSelected: string | null;


  constructor(private readonly route: ActivatedRoute,
              private readonly backend: BackendService,
              private readonly auth: AuthService) {
    this.content = null;
    this.cards = [{
      title: 'abc',
      text: 'cde'
    }];
    this.courseSelected = null;
    this.levelSelected = null;
  }

  ngOnInit(): void {
    this.route.params.subscribe(value => {
      let path;
      if (this.auth.user) {
        path = `course/filesByCourse/${value["courseId"]}/user`
      } else {
        path = `course/filesByCourse/${value["courseId"]}/token`
      }
      this.backend.get(path).then(content => {
        console.log(content)
        this.content = content as DFile[];
      })
    });
    this.route.paramMap.subscribe(params => {
      this.courseSelected = params.get("id");
      const courseId = params.get('courseId');
      this.backend.get(`course/${courseId}`).then(course => {
             this.courseSelected = (course as Course).title;
            console.log(course)
          }
        );
    });

    this.route.paramMap.subscribe(params => {
      this.levelSelected = params.get("id");
    });
  }

  toggleGridColumns(): any {
    this.gridColumns = this.gridColumns === 4 ? 5 : 4;
  }
}

export interface ImyCard {
  title: string;
  text: string;
}

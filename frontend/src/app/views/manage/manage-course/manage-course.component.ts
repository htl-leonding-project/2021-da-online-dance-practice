import {Component, OnInit} from '@angular/core';
import {AccessToken, Course, Level} from '../../../models/models';
import {BackendService} from '../../../services/backend.service';
import {MatDialog} from '@angular/material/dialog';
import {Clipboard} from '@angular/cdk/clipboard';
import {DetailedCourseComponent} from './detailed-course/detailed-course.component';
import {DetailedAccesstokenComponent} from '../manage-accesstoken/detailed-accesstoken/detailed-accesstoken.component';


@Component({
  selector: 'app-manage-course',
  templateUrl: './manage-course.component.html',
  styleUrls: ['./manage-course.component.scss']
})
export class ManageCourseComponent implements OnInit {

  courses: Course[] | null;
  levels: Level[] | null;

  constructor(private readonly backend: BackendService,  private readonly dialog: MatDialog,
              private readonly clipboard: Clipboard) {

    this.levels = null;
    this.courses = null;
  }

  ngOnInit(): void {
    this.backend.get('course').then(value => {
      this.courses = value as Course[];
    });
  }

  create(): void {
    this.dialog.open(DetailedCourseComponent).afterClosed().subscribe(value => {
      if (value) {
        this.backend.post('course', this.buildCourseObjectForServer(value as Course))
          .then(value => {
            this.courses?.push(value as Course);
          });
      }
    });
  }

  delete(course: Course) {
    this.backend.delete(`course/${course.id}`).then(() => {
      this.courses = this.courses!.filter(c => c.id !== course.id);
    })
  }

  edit(course: Course): void {
    this.dialog.open(DetailedCourseComponent, {
      data: {...course}
    }).afterClosed().subscribe(value => {
      if (value) {
        this.backend.put('course', this.buildCourseObjectForServer(value as Course))
          .then(value => {
            const course = value as Course;
            const index = this.courses!.findIndex(c => c.title === course.title);
            this.courses![index] = course;
          });
      }
    });
  }


  private buildCourseObjectForServer(course: Course) {
    return {
      title: course.title,
      description: course.description,
      level: course.level.description
    };
  }
}

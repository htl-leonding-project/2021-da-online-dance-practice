import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-dance-course',
  templateUrl: './dance-course.component.html',
  styleUrls: ['./dance-course.component.css']
})
export class DanceCourseComponent implements OnInit {

  @Input() courseSelected!: string | null;

  constructor() {
    this.courseSelected = null;
  }
  ngOnInit(): void {
  }

  // tslint:disable-next-line:typedef
  courses(s: string) {
    // @ts-ignore
    document.getElementById('lname').value = s;
  }

}

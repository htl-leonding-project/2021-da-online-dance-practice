import {Component, Inject, OnInit} from '@angular/core';
import {Course} from '../../../../models/models';
import {FormControl, Validators} from '@angular/forms';
import {BackendService} from '../../../../services/backend.service';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';

@Component({
  selector: 'app-detailed-course',
  templateUrl: './detailed-course.component.html',
  styleUrls: ['./detailed-course.component.scss']
})
export class DetailedCourseComponent implements OnInit {

  course: Course| null;
  courses: Course[] | null;
  courseControl: FormControl;

  constructor(private readonly backend: BackendService,
              private readonly dialogRef: MatDialogRef<DetailedCourseComponent>,
              @Inject(MAT_DIALOG_DATA) private readonly data: Course) {

    this.courses = null;
    this.course = data || {};
    this.courseControl = new FormControl('', [
      Validators.required
    ])
  }

  ngOnInit(): void {
    this.backend.get('course').then(value => {
      this.courses = value as Course[];
    })
  }

  cancel(): void {
    this.dialogRef.close(null);
  }

  save(): void {
    this.dialogRef.close(this.course);
  }
}

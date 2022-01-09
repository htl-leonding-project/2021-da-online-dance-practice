import {Component, Inject, OnInit} from '@angular/core';
import {AccessToken, Course, Usage} from "../../../../models/models";
import {BackendService} from "../../../../services/backend.service";
import {FormBuilder, FormGroup} from "@angular/forms";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";

@Component({
  selector: 'app-detailed-media',
  templateUrl: './detailed-media.component.html',
  styleUrls: ['./detailed-media.component.scss']
})
export class DetailedMediaComponent implements OnInit {
  usage : Usage | null;
  courses : Course [] |null;
  uploadForm: FormGroup;


  constructor(private readonly backend: BackendService,
              private formBuilder: FormBuilder,
              private readonly dialogRef: MatDialogRef<DetailedMediaComponent>,
              @Inject(MAT_DIALOG_DATA) private readonly data: Usage ) {
    this.usage = data || {};
    this.courses = null;
    this.uploadForm = this.formBuilder.group({
      file: ['']
    })
  }

  ngOnInit(): void {
    this.backend.get('course').then(value => {
      this.courses = value as Course[];

    });
  }

  //ausgewählter kurs soll auch noch ans backend geschickt werden mit dem hochgeladenen file
  submit() {
    const formData = new FormData();
    formData.append("file", this.uploadForm.get("file")?.value);
    this.backend.post("file", formData).then(console.log);
    alert("file is uploaded")

    this.dialogRef.close(this.usage);
  }

  onFileSelect(event: any) {
    if (event.target.files.length > 0) {
      this.uploadForm.get("file")?.setValue(event.target.files[0]);
    }
  }

}

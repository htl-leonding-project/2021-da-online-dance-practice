import {Component, Inject, OnInit} from '@angular/core';
import {Course, Usage} from "../../../../models/models";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {BackendService} from "../../../../services/backend.service";
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
  selectedCourse: Course | null;


  constructor(private readonly backend: BackendService,
              private formBuilder: FormBuilder,
              private readonly dialogRef: MatDialogRef<DetailedMediaComponent>,
              @Inject(MAT_DIALOG_DATA) private readonly data: Usage ) {
    this.usage = data || {};
    this.courses = null;
    this.uploadForm = this.formBuilder.group({
      file: [''],
      description: ['',Validators.required]
    })
    this.selectedCourse = null;
  }

  ngOnInit(): void {
    this.backend.get('course').then(value => {
      this.courses = value as Course[];
      this.selectedCourse = this.courses[0];
    });
  }

  //ausgewählter kurs soll auch noch ans backend geschickt werden mit dem hochgeladenen file
  //alter upload
/*  submit() {
    const formData = new FormData();
    formData.append("file", this.uploadForm.get("file")?.value);
    this.backend.post("file", formData).then(console.log);
    alert("file is uploaded")

    this.dialogRef.close(this.usage);
  }*/

  async submit() {
    const formData = new FormData();
    formData.append("file", this.uploadForm.get("file")?.value);
   // let fileToBlob = async (file:any) => new Blob([new Uint8Array(await file.arrayBuffer())], {type: file.type });

    if(this.uploadForm.get("file")){
      //const imagename = (this.uploadForm.get("file")!.value as HTMLInputElement).files[0].name;
      const imagename = this.uploadForm.get("file")?.value.name
      console.log("imagename "+JSON.stringify(imagename));

      let file = this.uploadForm.get("file")?.value;

      //überprüfen ob file zu groß
      if(file.size > 1024000000){
        alert("file to big")
      }

      console.log("File: ",file)

      const blobToUpload = await this.fileToBlob(file);
      console.log("file "+JSON.stringify(blobToUpload));
      console.log("blobToUpload", blobToUpload)
      await this.backend.postFile('', blobToUpload, imagename);

      //this.backend.postFile('', fileToBlob(this.uploadForm.get("file")?.value), imagename).then(console.log);
    }
    //this.dialogRef.close(this.usage);
  }

///
  async fileToBlob(file:File){
    let blobParts = new Uint8Array(await file.arrayBuffer());
    return new Blob([blobParts], {type: file.type })
  }


  onFileSelect(event: any) {
    if (event.target.files.length > 0) {
      this.uploadForm.get("file")?.setValue(event.target.files[0]);
    }
  }


}

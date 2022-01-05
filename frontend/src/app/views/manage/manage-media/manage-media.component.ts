import { Component, OnInit } from '@angular/core';
import {environment} from '../../../../environments/environment';
import {FormBuilder, FormGroup} from '@angular/forms';
import {BackendService} from '../../../services/backend.service';

@Component({
  selector: 'app-manage-media',
  templateUrl: './manage-media.component.html',
  styleUrls: ['./manage-media.component.scss']
})
export class ManageMediaComponent implements OnInit {
  public readonly baseUrl:string;
  uploadForm: FormGroup;

  constructor(private formbuilder: FormBuilder, private readonly backendservice: BackendService) {
    this.baseUrl = environment.baseUrl
    this.uploadForm = this.formbuilder.group({
      file: []
    })
  }

  ngOnInit(): void {

  }

  submit() {
    const formData = new FormData()
    formData.append("file",this.uploadForm.get("file")?.value)
    this.backendservice.post("file/upload",formData).then(console.log)
  }

  onFileSelect(event: any) {
    if(event.target.files.length > 0){
      this.uploadForm.get("file")?.setValue(event.target.files[0])
    }
  }
}

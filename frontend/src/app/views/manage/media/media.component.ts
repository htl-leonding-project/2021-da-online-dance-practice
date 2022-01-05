import {Component, OnInit} from '@angular/core';
import {environment} from '../../../../environments/environment';
import {FormBuilder, FormGroup} from '@angular/forms';
import {BackendService} from '../../../services/backend.service';

@Component({
  selector: 'app-media',
  templateUrl: './media.component.html',
  styleUrls: ['./media.component.scss']
})
export class MediaComponent implements OnInit {
  public readonly baseUrl: string;
  uploadForm: FormGroup;

  constructor(private formBuilder: FormBuilder, private readonly backendservice: BackendService) {
    this.baseUrl = environment.baseUrl
    this.uploadForm = this.formBuilder.group({
      file: ['']
    })
  }

  ngOnInit(): void {

  }

  submit() {
    const formData = new FormData();
    formData.append("file", this.uploadForm.get("file")?.value);
    this.backendservice.post("file", formData).then(console.log);
  }

  onFileSelect(event: any) {
    if (event.target.files.length > 0) {
      this.uploadForm.get("file")?.setValue(event.target.files[0]);
    }
  }
}

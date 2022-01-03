import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ManageComponent} from './manage.component';
import {MediaComponent} from './media/media.component';
import {RouterModule, Routes} from '@angular/router';
import {MatMenuModule} from '@angular/material/menu';
import {FormsModule} from '@angular/forms';
import {MatButtonModule} from '@angular/material/button';
import {ManageCourseComponent} from './manage-course/manage-course.component';
import {ManageAccesstokenComponent} from './manage-accesstoken/manage-accesstoken.component';
import {MatSelectModule} from "@angular/material/select";
import {MatInputModule} from "@angular/material/input";
import {MatDatepickerModule} from "@angular/material/datepicker";
import {MatNativeDateModule} from "@angular/material/core";
import {MatIconModule} from "@angular/material/icon";
import {DetailedAccesstokenComponent} from './manage-accesstoken/detailed-accesstoken/detailed-accesstoken.component';
import {MatDialogModule} from "@angular/material/dialog";
import {MatTooltipModule} from "@angular/material/tooltip";

const routes: Routes = [
  {
    path: '',
    component: ManageComponent
  },
  {
    path: 'media',
    component: MediaComponent
  },
  {
    path: 'manage-course',
    component: ManageCourseComponent
  },
  {
    path: 'manage-accesstoken',
    component: ManageAccesstokenComponent
  }
]

@NgModule({
  declarations: [
    ManageComponent,
    MediaComponent,
    ManageCourseComponent,
    ManageAccesstokenComponent,
    DetailedAccesstokenComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(routes),
    MatMenuModule,
    FormsModule,
    MatButtonModule,
    MatSelectModule,
    MatInputModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatIconModule,
    MatDialogModule,
    MatTooltipModule
  ]
})
export class ManageModule { }

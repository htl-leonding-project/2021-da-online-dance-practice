import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {LevelComponent} from './level.component';
import {RouterModule, Routes} from "@angular/router";
import {MatButtonModule} from "@angular/material/button";
import {MatListModule} from "@angular/material/list";
import {CourseOverviewComponent} from './course-overview/course-overview.component';
import {CourseContentComponent} from './course-overview/course-content/course-content.component';
import {AudioInputComponent} from './course-overview/course-content/audio-input/audio-input.component';
import {VideoInputComponent} from './course-overview/course-content/video-input/video-input.component';
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatSliderModule} from "@angular/material/slider";
import {MatCardModule} from "@angular/material/card";
import {MatIconModule} from "@angular/material/icon";
import {FormsModule} from "@angular/forms";
import {FlexModule} from "@angular/flex-layout";
import {MatMenuModule} from '@angular/material/menu';

const routes: Routes = [
  {
    path: '',
    component: LevelComponent
  },
  {
    path: ':id/courses',
    component: CourseOverviewComponent,
  },
  {
    path: ':id/courses/:courseId',
    component: CourseContentComponent,
  }
//   children: [
//   {
//     path: ':courseId',
//     component: CourseContentComponent
//   }
// ]
]

@NgModule({
  declarations: [
    LevelComponent,
    CourseOverviewComponent,
    CourseContentComponent,
    AudioInputComponent,
    VideoInputComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(routes),
    MatButtonModule,
    MatListModule,
    MatToolbarModule,
    MatSliderModule,
    MatCardModule,
    MatIconModule,
    FormsModule,
    FlexModule,
    MatMenuModule
  ]
})
export class LevelModule {
}

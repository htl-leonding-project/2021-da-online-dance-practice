import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {LevelComponent} from './level.component';
import {RouterModule, Routes} from "@angular/router";
import {MatButtonModule} from "@angular/material/button";
import {MatListModule} from "@angular/material/list";
import {CourseOverviewComponent} from './course-overview/course-overview.component';
import {CourseContentComponent} from './course-overview/course-content/course-content.component';

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
    CourseContentComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(routes),
    MatButtonModule,
    MatListModule
  ]
})
export class LevelModule {
}

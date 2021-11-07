import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AudioInputComponent } from './content/audio-input/audio-input.component';
import { VideoInputComponent } from './content/video-input/video-input.component';
import { DanceLevelComponent } from './dance-level/dance-level.component';
import { DanceCourseComponent } from './dance-course/dance-course.component';
import { ContentComponent } from './content/content.component';
import { RouterModule } from '@angular/router';
import {HttpClientModule} from '@angular/common/http';
import { LevelWrapperComponent } from './level-wrapper/level-wrapper.component';
import { CourseWrapperComponent } from './course-wrapper/course-wrapper.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

import {MaterialExampleModule} from '../../materialmodule';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MatNativeDateModule} from '@angular/material/core';


@NgModule({
  declarations: [
    AppComponent,
    AudioInputComponent,
    VideoInputComponent,
    DanceLevelComponent,
    DanceCourseComponent,
    ContentComponent,
    LevelWrapperComponent,
    CourseWrapperComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule.forRoot([
      {path: 'video-input', component: VideoInputComponent},
      {path: 'audio-input', component: AudioInputComponent},
      {path: '', component: DanceLevelComponent},
      {path: 'dance-course', component: DanceCourseComponent},
      {path: 'content', component: ContentComponent},
    ]),
    HttpClientModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule,
    MatNativeDateModule,
    MaterialExampleModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [DanceCourseComponent]
})
export class AppModule { }

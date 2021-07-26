import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AudioInputComponent } from './audio-input/audio-input.component';
import { VideoInputComponent } from './video-input/video-input.component';
import { DanceLevelComponent } from './dance-level/dance-level.component';
import { DanceCourseComponent } from './dance-course/dance-course.component';
import { ContentComponent } from './content/content.component';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [
    AppComponent,
    AudioInputComponent,
    VideoInputComponent,
    DanceLevelComponent,
    DanceCourseComponent,
    ContentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule.forRoot([
      {path: 'video-input', component: VideoInputComponent },
      {path: 'audio-input', component: AudioInputComponent },
      {path: '', component: DanceLevelComponent },
      {path: 'dance-course', component: DanceCourseComponent },
      {path: 'content', component: ContentComponent },

    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

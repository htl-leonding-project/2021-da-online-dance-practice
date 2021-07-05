import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AudioInputComponent } from './audio-input/audio-input.component';
import { VideoInputComponent } from './video-input/video-input.component';

@NgModule({
  declarations: [
    AppComponent,
    AudioInputComponent,
    VideoInputComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

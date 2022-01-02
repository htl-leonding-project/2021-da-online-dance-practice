import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ManageComponent } from './manage.component';
import { MediaComponent } from './media/media.component';
import {RouterModule, Routes} from '@angular/router';
import {MatMenuModule} from '@angular/material/menu';
import {FormsModule} from '@angular/forms';
import {MatButtonModule} from '@angular/material/button';

const routes: Routes = [
  {
    path: '',
    component: ManageComponent
  },
  {
    path: 'media',
    component: MediaComponent
  }
]

@NgModule({
  declarations: [
    ManageComponent,
    MediaComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(routes),
    MatMenuModule,
    FormsModule,
    MatButtonModule
  ]
})
export class ManageModule { }

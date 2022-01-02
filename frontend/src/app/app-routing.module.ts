import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

const routes: Routes = [
  {
    path: 'signin',
    loadChildren: () => import('./views/signin/signin.module').then(m => m.SigninModule)
  },
  {
    path: 'level',
    loadChildren: () => import('./views/level/level.module').then(m => m.LevelModule)
  },
  {
    path: 'manage',
    loadChildren: () => import('./views/manage/manage.module').then(m => m.ManageModule)
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

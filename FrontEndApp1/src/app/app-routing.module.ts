import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ResourceComponent} from "./componenents/resource/resource.component";
import {AuthGuard} from "./guards/auth.guard";

const routes: Routes = [

  {path : "resource" ,component : ResourceComponent , canActivate: [AuthGuard], data : {roles :['ADMIN']}},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

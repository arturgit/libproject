import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { ServerHttp } from './server-http.service';
import { AuthService } from './auth.service';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    HttpModule
  ],
  providers: [
    ServerHttp,
    AuthService
  ],
  exports: [
    FormsModule,
    HttpModule
  ]
})
export class CoreModule { }

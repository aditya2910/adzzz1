import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from "@angular/router";
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import {HttpModule} from "@angular/http";
import { RawmaterialListComponent } from './rawmaterial-list/rawmaterial-list.component';
import {RawmaterialService} from "./shared/rawmaterial/rawmaterial.service";
import { RawmaretialAddComponent } from './rawmaretial-add/rawmaretial-add.component';

@NgModule({
  declarations: [
    AppComponent,
    RawmaterialListComponent,
    RawmaretialAddComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot([
      {
        path: 'add',
        component: RawmaretialAddComponent
      },
      { path : "",
        redirectTo: "/",
        pathMatch: "full"
      },
      {
        path: 'view',
        component: RawmaterialListComponent
      }
    ])
  ],
  providers: [RawmaterialService],
  bootstrap: [AppComponent]
})
export class AppModule { }

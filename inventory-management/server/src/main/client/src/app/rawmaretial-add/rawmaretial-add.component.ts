import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-rawmaretial-add',
  templateUrl: './rawmaretial-add.component.html',
  styleUrls: ['./rawmaretial-add.component.css']
})
export class RawmaretialAddComponent implements OnInit {

  constructor() { }

  name:string;
  unit:string;
  type:string;

  ngOnInit() {
  }

  saveData() {
    console.log("hello......");
  }
}

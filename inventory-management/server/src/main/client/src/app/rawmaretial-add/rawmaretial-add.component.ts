import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-rawmaretial-add',
  templateUrl: './rawmaretial-add.component.html',
  styleUrls: ['./rawmaretial-add.component.css']
})
export class RawmaretialAddComponent implements OnInit {

  constructor() { }

  name: string;
  unit: string;
  type: string;
  message: string;
  isFormEmpty: boolean;

  ngOnInit() {
    this.isFormEmpty = true;
  }

  saveData() {
    console.log("name: " + this.name);
    console.log("unit: " + this.unit);
    console.log("type: " + this.type);
    if( this.name !== "" || this.unit !== "" || this.type  !== "" ){
      this.isFormEmpty = true;
    }
    this.name = "";
    this.unit = "";
    this.type = "";

    // make REST call and set message based on REST response
    this.message = "Data Saved";
  }
}

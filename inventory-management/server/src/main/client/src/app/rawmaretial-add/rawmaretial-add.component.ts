import { Component, OnInit } from '@angular/core';
import {RawmaterialService} from "../shared/rawmaterial/rawmaterial.service";

@Component({
  selector: 'app-rawmaretial-add',
  templateUrl: './rawmaretial-add.component.html',
  styleUrls: ['./rawmaretial-add.component.css']
})
export class RawmaretialAddComponent implements OnInit {

  response: Response;

  constructor(private rawmaterialService: RawmaterialService) { }

  name: string;
  unit: string;
  type: string;
  message: string;

  ngOnInit() { }

  saveData() {
    console.log("name: " + this.name);
    console.log("unit: " + this.unit);
    console.log("type: " + this.type);

    this.name = "";
    this.unit = "";
    this.type = "";
    //TODO: make REST call and set message based on REST response
    // this.rawmaterialService.save(this.name, this.unit, this.type).subscribe(
    //   data => {
    //     this.response = data;
    //   },
    //   error => console.error(error)
    // );

    this.message = "Data Saved";
  }
}

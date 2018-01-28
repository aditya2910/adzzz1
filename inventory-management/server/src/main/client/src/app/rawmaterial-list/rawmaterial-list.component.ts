import { Component, OnInit } from '@angular/core';
import {RawmaterialService} from "../shared/rawmaterial/rawmaterial.service";

@Component({
  selector: 'app-rawmaterial-list',
  templateUrl: './rawmaterial-list.component.html',
  styleUrls: ['./rawmaterial-list.component.css']
})
export class RawmaterialListComponent implements OnInit {
  rawmaterials: Array<any>;

  constructor(private rawmaterialService: RawmaterialService) { }

  ngOnInit() {
    this.rawmaterialService.getAll().subscribe(
      data => {
        this.rawmaterials = data;
      },
      error => console.error(error)
    );
  }

}

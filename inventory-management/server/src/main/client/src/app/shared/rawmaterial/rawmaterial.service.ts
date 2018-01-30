import { Injectable } from '@angular/core';
import {Http, RequestOptionsArgs, Response} from "@angular/http";
import {Observable} from "rxjs/Observable";
import 'rxjs/add/operator/map'
import { Headers, RequestOptions } from '@angular/http';
import { v4 as uuid } from 'uuid';

@Injectable()
export class RawmaterialService {

  constructor(private http: Http) { }

  getAll(): Observable<any> {
    return this.http.get('http://localhost:8082/rawMaterial')
      .map((respnse: Response) => respnse.json());
  }

  save(name:string, unit:string, type:string):Observable<any>{
    console.log("making rest post call.....name: " + name);
    const id: string = uuid();
    let rawMaterial = {
      
      name: name,
      unit: unit,
      type: type
    };
    let headers = new Headers();
    headers.append('Content-Type', 'application/json');


    const headerDict = {
      'Content-Type': 'application/json',
      'Accept': 'application/json',
      'Access-Control-Allow-Headers': 'Content-Type',
    }

    // let requestOptions : RequestOptionsArgs= {
    //   headers: headers,
    // };

    const data = JSON.stringify(rawMaterial);

    return this.http.post('http://localhost:8082/rawMaterial', data,  new RequestOptions({
      headers: new Headers({
        'Content-Type': 'application/json'
      })
    }));
  }
}

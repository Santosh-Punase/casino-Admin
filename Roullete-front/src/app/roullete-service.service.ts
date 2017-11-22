import { Injectable } from '@angular/core';
import {Http, RequestOptions, Headers, Response} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

@Injectable()
export class RoulleteServiceService {

  constructor(private http: Http) { }

  checkUuid(uuid: string): Observable<string> {
    console.log('logging uuid in service' + uuid);
    console.log('posting from services :: the uuid is :: ', uuid);
    const url = 'http://localhost:9090/user/' + uuid;
    return this.http.get(url)
      .map((res: Response) => {
        return <string>res.text();
      });
  }

  findGameResult(betdata: Object, id: String): Observable<any> {
    console.log('id is' + id);
    console.log(typeof id);
    console.log('betdata' ,  betdata);
    const url = 'http://localhost:9090/playGame/' + id;
    const headers = new Headers({'Content-Type': 'application/json'});
    const option = new RequestOptions({headers: headers});
    const body = betdata;

    return this.http.post(url, body, option)
      .map(function (res: Response) {
        return <string>res.text();
      })
      .catch(function (error: any) {
        console.error(error);
        return Observable.throw(error.statusText);
      });
  }
}

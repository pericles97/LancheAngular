import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import { Lanche } from './lanche.component';

@Injectable()
export class HttpLancheService {
  constructor(private _http: Http) { }

  getLanches(): Observable<Lanche[]> {
    return this._http.
      get('http://lanches.jelasticlw.com.br/rest/detalhelanche').
      map(this.extractData);
  }

  private extractData(res: Response) {
    return res.json()['lanche'];
  }

  addLanche(lanche: Lanche): Observable<string> {
    const json = JSON.stringify(lanche);
    const headers = new Headers({ 'Content-Type': 'application/json' });
    const options = new RequestOptions({ headers: headers });
    return this._http.
      post('http://lanches.jelasticlw.com.br/rest/detalhelanche',
      json, options).map(res => res.json());
  }
  deleteLanche(lanche: Lanche): Observable<string> {
    const json = JSON.stringify(lanche);
    const headers = new Headers({ 'Content-Type': 'application/json' });
    const options = new RequestOptions({ headers: headers });
    return this._http.
      post('http://lanches.jelasticlw.com.br/rest/detalhelanche/excluir',
      json, options).map(res => res.json());
  }

  updateLanche(lanche: Lanche): Observable<string> {
    const json = JSON.stringify(lanche);
    const headers = new Headers({ 'Content-Type': 'application/json' });
    const options = new RequestOptions({ headers: headers });
    return this._http.
      post('http://lanches.jelasticlw.com.br/rest/detalhelanche/alterar',
      json, options).map(res => res.json());
  }
}

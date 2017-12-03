import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import { Venda } from './venda.component';

@Injectable()
export class HttpVendaService {
  constructor(private _http: Http) { }

  getVendas(): Observable<Venda[]> {
    return this._http.
      get('http://lanches.jelasticlw.com.br/rest/detalhevenda').
      map(this.extractData);
  }

  private extractData(res: Response) {
    return res.json()['venda'];
  }

  addVenda(venda: Venda): Observable<string> {
    const json = JSON.stringify(venda);
    const headers = new Headers({ 'Content-Type': 'application/json' });
    const options = new RequestOptions({ headers: headers });
    return this._http.
      post('http://lanches.jelasticlw.com.br/rest/detalhevenda',
      json, options).map(res => res.json());
  }
  deleteVenda(venda: Venda): Observable<string> {
    const json = JSON.stringify(venda);
    const headers = new Headers({ 'Content-Type': 'application/json' });
    const options = new RequestOptions({ headers: headers });
    return this._http.
      post('http://lanches.jelasticlw.com.br/rest/detalhevenda/excluir',
      json, options).map(res => res.json());
  }

  updateVenda(venda: Venda): Observable<string> {
    const json = JSON.stringify(venda);
    const headers = new Headers({ 'Content-Type': 'application/json' });
    const options = new RequestOptions({ headers: headers });
    return this._http.
      post('http://lanches.jelasticlw.com.br/rest/detalhevenda/alterar',
      json, options).map(res => res.json());
  }
}

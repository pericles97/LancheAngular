import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import { Cliente } from './cliente.component';

@Injectable()
export class HttpClienteService {
  constructor(private _http: Http) { }

  getClientes(): Observable<Cliente[]> {
    return this._http.
      get('http://lanches.jelasticlw.com.br/rest/detalhecliente').
      map(this.extractData);
  }

  private extractData(res: Response) {
    return res.json()['cliente'];
  }

  addCliente(cliente: Cliente): Observable<string> {
    const json = JSON.stringify(cliente);
    const headers = new Headers({ 'Content-Type': 'application/json' });
    const options = new RequestOptions({ headers: headers });
    return this._http.
      post('http://lanches.jelasticlw.com.br/rest/detalhecliente',
      json, options).map(res => res.json());
  }

  deleteCliente(cliente: Cliente): Observable<string> {
    const json = JSON.stringify(cliente);
    const headers = new Headers({ 'Content-Type': 'application/json' });
    const options = new RequestOptions({ headers: headers });
    return this._http.
      post('http://lanches.jelasticlw.com.br/rest/detalhecliente/excluir',
      json, options).map(res => res.json());
  }

  updateCliente(cliente: Cliente): Observable<string> {
    const json = JSON.stringify(cliente);
    const headers = new Headers({ 'Content-Type': 'application/json' });
    const options = new RequestOptions({ headers: headers });
    return this._http.
      post('http://lanches.jelasticlw.com.br/rest/detalhecliente/alterar',
      json, options).map(res => res.json());
  }
}

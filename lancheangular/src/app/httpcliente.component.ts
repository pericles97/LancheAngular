import { Component } from '@angular/core';
import { HttpClienteService } from './httpcliente.service';
import { Cliente } from './cliente.component';

@Component({
  selector: 'app-cliente',
  templateUrl: './cliente.component.html',
  providers: [HttpClienteService]
})
export class HttpClienteComponent {
  clientes: Cliente[];
  cliente: Cliente;
  clientee: Cliente;

  constructor(private httpClienteS: HttpClienteService) {
    this.cliente = new Cliente();
    this.getClientes();
  }

  getClientes() {
    this.httpClienteS.getClientes().subscribe(
      clientes => this.clientes = clientes,
      error => alert(error),
      () => console.log('terminou')
    );
  }

  addCliente() {
    this.httpClienteS.addCliente(this.cliente).subscribe(
      data => data,
      error => alert(error),
      () => this.getClientes()
    );
  }

  carregarCliente(cliente: Cliente) {
    this.cliente = new Cliente();
    this.cliente.id = cliente.id;
    this.cliente.nome = cliente.nome;
    this.cliente.cpf = cliente.cpf;
  }

  deleteCliente() {
    this.httpClienteS.deleteCliente(this.cliente).subscribe(
      data => data,
      error => alert(error),
      () => this.getClientes()
    );
  }

  updateCliente(clientee: Cliente) {
    this.httpClienteS.updateCliente(clientee).subscribe(
      data => data,
      error => alert(error),
      () => { this.getClientes(); this.cliente = new Cliente(); }
    );
  }
}

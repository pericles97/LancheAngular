import { Component } from '@angular/core';
import { HttpVendaService } from './httpvenda.service';
import { Venda } from './venda.component';

@Component({
  selector: 'app-venda',
  templateUrl: './venda.component.html',
  providers: [HttpVendaService]
})
export class HttpVendaComponent {
  vendas: Venda[];
  venda: Venda;
  vendaa: Venda;

  constructor(private httpVendaS: HttpVendaService) {
    this.venda = new Venda();
    this.getVendas();
  }

  getVendas() {
    this.httpVendaS.getVendas().subscribe(
      vendas => this.vendas = vendas,
      error => alert(error),
      () => console.log('terminou')
    );
  }

  addVenda() {
    this.httpVendaS.addVenda(this.venda).subscribe(
      data => data,
      error => alert(error),
      () => this.getVendas()
    );
  }

  carregarVenda(venda: Venda) {
    this.venda = new Venda();
    this.venda.id = venda.id;
    this.venda.qtdItens = venda.qtdItens;
    this.venda.valorTotalVenda = venda.valorTotalVenda;
  }
  deleteVenda() {
    this.httpVendaS.deleteVenda(this.venda).subscribe(
      data => data,
      error => alert(error),
      () => this.getVendas()
    );
  }

  updateVenda(vendaa: Venda) {
    this.httpVendaS.updateVenda(vendaa).subscribe(
      data => data,
      error => alert(error),
      () => { this.getVendas(); this.venda = new Venda(); }
    );
  }
}

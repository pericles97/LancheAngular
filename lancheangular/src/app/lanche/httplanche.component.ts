import { Component } from '@angular/core';
import { HttpLancheService } from './httplanche.service';
import { Lanche } from './lanche.component';

@Component({
  selector: 'app-lanche',
  templateUrl: './lanche.component.html',
  providers: [HttpLancheService]
})
export class HttpLancheComponent {
  lanches: Lanche[];
  lanche: Lanche;
  lanchee: Lanche;

  constructor(private httpLancheS: HttpLancheService) {
    this.lanche = new Lanche();
    this.getLanches();
  }

  getLanches() {
    this.httpLancheS.getLanches().subscribe(
      lanches => this.lanches = lanches,
      error => alert(error),
      () => console.log('terminou')
    );
  }

  addLanche() {
    this.httpLancheS.addLanche(this.lanche).subscribe(
      data => data,
      error => alert(error),
      () => this.getLanches()
    );


  }

  carregarLanche(lanche: Lanche) {
    this.lanchee = lanche;
    this.lanche = new Lanche();
    this.lanche.id = lanche.id;
    this.lanche.nomeLanche = lanche.nomeLanche;
    this.lanche.valorLanche = lanche.valorLanche;
  }
  deleteLanche() {
    this.httpLancheS.deleteLanche(this.lanchee).subscribe(
      data => data,
      error => alert(error),
      () => this.getLanches()
    );
  }

  updateLanche(lanchee: Lanche) {
    this.httpLancheS.updateLanche(lanchee).subscribe(
      data => data,
      error => alert(error),
      () => { this.getLanches(); this.lanche = new Lanche(); }
    );
  }
}

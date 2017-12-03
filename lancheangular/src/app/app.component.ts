import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  template: `



<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" class="active" href="#" style="color: red">Lanchonete</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a routerLink="/home" routerLinkActive="active">Home</a></li>
      <li><a routerLink="/cliente" routerLinkActive="active">Cliente</a></li>
      <li><a routerLink="/lanche" routerLinkActive="active">Lanche</a></li>
      <li><a routerLink="/venda" routerLinkActive="active">Venda</a></li>
    </ul>
  </div>
</nav>
<router-outlet></router-outlet>

`
})
export class AppComponent {
}

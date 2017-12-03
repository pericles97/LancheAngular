import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { HttpClienteComponent } from './httpcliente.component';
import { HttpLancheComponent } from './lanche/httplanche.component';
import { HttpVendaComponent } from './venda/httpvenda.component';
import { HomeComponent } from './home/home.component';



@NgModule({
  declarations: [
    AppComponent,
    HttpClienteComponent,
    HttpLancheComponent,
    HttpVendaComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot([
  {
    path: 'cliente',
    component: HttpClienteComponent
  },
  {
    path: 'lanche',
    component: HttpLancheComponent
  },
  {
    path: 'venda',
    component: HttpVendaComponent
  },
  {
    path: 'home',
    component: HomeComponent
  }
])
  ],
  providers: [HttpClienteComponent, HttpLancheComponent, HttpVendaComponent],
  bootstrap: [AppComponent]
})
export class AppModule { }

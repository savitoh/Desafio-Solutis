import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { RespostaDesafioComponent } from './resposta-desafio/resposta-desafio.component';
import { ConfigService } from './service/config.service';
import { RespostaDesafioService } from './service/resposta-desafio.service';

@NgModule({
  declarations: [
    AppComponent,
    RespostaDesafioComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [ConfigService, RespostaDesafioService],
  bootstrap: [AppComponent]
})
export class AppModule { }

import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { RespostaDesafioService } from './service/resposta-desafio.service';
import { FormsModule, ReactiveFormsModule  } from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { RespostaDesafioComponent } from './resposta-desafio/resposta-desafio.component';

@NgModule({
  declarations: [
    AppComponent,
    RespostaDesafioComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [RespostaDesafioService],
  bootstrap: [AppComponent]
})
export class AppModule { }

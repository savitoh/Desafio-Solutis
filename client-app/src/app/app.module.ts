import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { RespostaDesafioService } from './service/resposta-desafio.service';
import { FormsModule, ReactiveFormsModule  } from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { RespostaDesafioComponent } from './resposta-desafio/resposta-desafio.component';
import { FooterComponent } from './ui/footer/footer.component';
import { Ng4LoadingSpinnerModule } from 'ng4-loading-spinner';


@NgModule({
  declarations: [
    AppComponent,
    RespostaDesafioComponent,
    FooterComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    Ng4LoadingSpinnerModule.forRoot()
  ],
  providers: [RespostaDesafioService],
  bootstrap: [AppComponent]
})
export class AppModule { }

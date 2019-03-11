import { Component, OnInit } from '@angular/core';
import { Requisicao } from '../models/Requisicao';
import { RespostaDesafioService } from '../service/resposta-desafio.service';
import { RespostaDesafio } from '../models/RespostaDesafio';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-resposta-desafio',
  templateUrl: './resposta-desafio.component.html',
  styleUrls: ['./resposta-desafio.component.css']
})
export class RespostaDesafioComponent implements OnInit {

  private title: String;
  private requisicao: Requisicao = new Requisicao();
  private respostaDesafio: RespostaDesafio;
  private form: FormGroup;
  private isShowTable = false;

  constructor(private repostaDesafio: RespostaDesafioService,
              private fb: FormBuilder) { }

  ngOnInit() {
    this.initValidationForm();
    this.title = 'Desafio Solutis';
  }

  private initValidationForm(): void {
    this.form = this.fb.group({
      palavra: ['', [Validators.required, Validators.pattern('^[a-zA-Z]+$')]]
    });
  }

  recuperaPrimeiraVogalAposCosoanteNaoRepetidaAntecedidaPorVogal(): void {
    this.isShowTable = false;
    this.repostaDesafio.recuperaPrimeiraVogalAposCosoanteNaoRepetidaAntecedidaPorVogal(this.requisicao).subscribe(response => {
       console.log('Response: ', response);
       this.respostaDesafio = response;
       this.exibeTabelaCasoRecupereVogal();
    },
    (erro) => {
      console.log(erro);
    });
  }

  private exibeTabelaCasoRecupereVogal(): void {
    if (this.respostaDesafio.messagem != null) {
      this.isShowTable = false;
      alert(this.respostaDesafio.messagem);
    } else {
      this.isShowTable = true;
    }
  }

  private MACAddressInput(e): void {
    const code = e.key.charCodeAt(0);
    if ((code >= 65 && code <= 90) || (code >= 97 && code <= 122)) {} else {
      e.preventDefault();
      return;
    }
  }

}

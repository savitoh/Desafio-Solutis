import { Component, OnInit } from '@angular/core';
import { Requisicao } from '../models/Requisicao';
import { RespostaDesafioService } from '../service/resposta-desafio.service';
import { RespostaDesafio } from '../models/RespostaDesafio';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { Ng4LoadingSpinnerService } from 'ng4-loading-spinner';


@Component({
  selector: 'app-resposta-desafio',
  templateUrl: './resposta-desafio.component.html',
  styleUrls: ['./resposta-desafio.component.css']
})

export class RespostaDesafioComponent implements OnInit {

  public title: String;
  public isShowTable = false;
  public form: FormGroup;
  public requisicao: Requisicao = new Requisicao();

  private respostaDesafio: RespostaDesafio;
  private apenasLetrasPatterns = new RegExp('^[a-zA-Z]+$');

  constructor(private repostaDesafioService: RespostaDesafioService,
              private fb: FormBuilder,
              private spinnerService: Ng4LoadingSpinnerService,
              ) { }

  ngOnInit() {
    this.initValidationForm();
    this.title = 'Desafio Solutis';
  }

  private initValidationForm(): void {
    this.form = this.fb.group({
      palavra: ['', [Validators.required, Validators.pattern(this.apenasLetrasPatterns)]]
    });
  }

  recuperaPrimeiraVogalAposCosoanteNaoRepetidaAntecedidaPorVogal(): void {
    this.isShowTable = false;
    this.spinnerService.show();
    this.repostaDesafioService.recuperaPrimeiraVogalAposCosoanteNaoRepetidaAntecedidaPorVogal(this.requisicao).subscribe(response => {
       console.log('Response: ', response);
       this.spinnerService.hide();
       this.respostaDesafio = response;
       this.exibeTabelaCasoRecupereVogal();
    },
    (erro) => {
      console.log(erro);
      this.spinnerService.hide();
    });
  }

  private exibeTabelaCasoRecupereVogal(): void {
    if (this.respostaDesafio.messagem) {
      this.isShowTable = false;
      alert(this.respostaDesafio.messagem);
    } else {
      this.isShowTable = true;
    }
  }

}

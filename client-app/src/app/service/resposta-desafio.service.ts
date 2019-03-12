import { environment } from './../../environments/environment';
import { Injectable } from '@angular/core';
import { Headers} from '@angular/http';
import { Requisicao } from '../models/Requisicao';
import { HttpClient } from '@angular/common/http';
import { RespostaDesafio } from '../models/RespostaDesafio';



@Injectable()
export class RespostaDesafioService {

    private baseUrlService: string;
    private headers: Headers;

    constructor(private http: HttpClient) {
        this.baseUrlService = environment.baseUrlService;
        this.headers = new Headers({ 'Content-Type': 'application/json;charset=UTF-8' });
    }

    recuperaPrimeiraVogalAposCosoanteNaoRepetidaAntecedidaPorVogal(requisicao: Requisicao) {
        console.log('Requisicão: ', requisicao);
        return this.http.post<RespostaDesafio>(this.baseUrlService, requisicao);
    }

}

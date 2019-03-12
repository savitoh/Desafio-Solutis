import { Injectable } from '@angular/core';
import { Headers} from '@angular/http';
import { RequestOptions } from '@angular/http';

import { ConfigService } from './config.service';
import { Requisicao } from '../models/Requisicao';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { RespostaDesafio } from '../models/RespostaDesafio';



@Injectable()
export class RespostaDesafioService {

    private baseUrlService: string;
    private headers: Headers;
    private options: RequestOptions;

    constructor(private http: HttpClient,
                private configService: ConfigService) {
        this.baseUrlService = configService.getUrlService();
        this.headers = new Headers({ 'Content-Type': 'application/json;charset=UTF-8' });
        this.options = new RequestOptions({ headers: this.headers });
    }

    recuperaPrimeiraVogalAposCosoanteNaoRepetidaAntecedidaPorVogal(requisicao: Requisicao) {
        console.log('Requisicão', requisicao);
        return this.http.post<RespostaDesafio>(this.baseUrlService, requisicao);
    }

}

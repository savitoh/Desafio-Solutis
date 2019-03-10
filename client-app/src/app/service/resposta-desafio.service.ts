import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Headers} from '@angular/http';
import { RequestOptions } from '@angular/http';

import { Observable } from 'rxjs/internal/Observable';
import { map } from 'rxjs/operators';

import { ConfigService } from './config.service';
import { Requisicao } from '../models/Requisicao';


@Injectable()
export class RespostaDesafioService {

    private baseUrlService: string;
    private headers: Headers;
    private options: RequestOptions;

    constructor(private http: Http,
                private configService: ConfigService) {
        this.baseUrlService = configService.getUrlService();
        this.headers = new Headers({ 'Content-Type': 'application/json;charset=UTF-8' });
        this.options = new RequestOptions({ headers: this.headers });
    }

    enviaPalavra(requisicao: Requisicao) {
        return this.http.post(this.baseUrlService, JSON.stringify(requisicao), this.options)
                    .pipe(map(res => res.json));
    }

}

package br.com.savitoh.demoapirestful.dto;

import br.com.savitoh.demoapirestful.model.RespostaDesafio;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class RespostaDesafioDTO {

    private String palavra;

    private Character vogal;

    private String tempoTotal;

    private String messagem;

    public static RespostaDesafioDTO transformaRespostaDesafioEmDTO(RespostaDesafio respostaDesafio){
        return new RespostaDesafioDTO(respostaDesafio.getPalavra(), 
                                      respostaDesafio.getVogal(), 
                                      respostaDesafio.getTempoTotal(), 
                                      respostaDesafio.getMessagem());
    }

}
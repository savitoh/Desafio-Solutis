package br.com.savitoh.demoapirestful.service;

import br.com.savitoh.demoapirestful.dto.RequisicaoDTO;
import br.com.savitoh.demoapirestful.model.RespostaDesafio;

public interface RespostaDesafioService {

   RespostaDesafio save(final RequisicaoDTO requisicaoDTO);

}

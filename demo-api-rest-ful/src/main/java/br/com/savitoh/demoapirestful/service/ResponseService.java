package br.com.savitoh.demoapirestful.service;

import br.com.savitoh.demoapirestful.model.Response;

public interface ResponseService {

   Response save(Response save);

   String recuperaPrimeiraVogalAposCosoanteAntecessoraDeVogalNaoRepetida(String palavra);


}

package br.com.savitoh.demoapirestful.businesslogic;

import br.com.savitoh.demoapirestful.exception.RecuperaVogalException;

import java.util.Optional;

public interface RecuperaVogal {

    Optional<Character> recuperaPrimeiraVogalAposCosoanteNaoRepetidaAntecedidaPorVogal(final String palavra)
            throws RecuperaVogalException;

    String getTempoProcessamento();

}

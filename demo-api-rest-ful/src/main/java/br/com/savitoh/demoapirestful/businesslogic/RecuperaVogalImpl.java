package br.com.savitoh.demoapirestful.businesslogic;

import br.com.savitoh.demoapirestful.exception.RecuperaVogalException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RecuperaVogalImpl implements RecuperaVogal {
    @Override
    public Optional<Character> recuperaPrimeiraVogalAposCosoanteNaoRepetidaAntecedidaPorVogal(String palavra)
            throws RecuperaVogalException {
        return Optional.empty();
    }

    @Override
    public String getTempoProcessamento() {
        return null;
    }
}

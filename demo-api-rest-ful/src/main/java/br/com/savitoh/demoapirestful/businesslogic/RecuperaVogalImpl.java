package br.com.savitoh.demoapirestful.businesslogic;

import br.com.savitoh.demoapirestful.exception.RecuperaVogalException;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class RecuperaVogalImpl implements RecuperaVogal {

    private long timeElapsed;

    @Override
    public Optional<Character> recuperaPrimeiraVogalAposCosoanteNaoRepetidaAntecedidaPorVogal(String palavra)
            throws RecuperaVogalException {
        Instant start = Instant.now();

        char [] array = palavra.toCharArray();
        Optional<Character> vogal = Optional.empty();
        for(int i=0; i<array.length; i++) {
            if(isVogal(array[i]) && naoUtrapassouArray(array.length, i)) {
                i+=1;
                if(!isVogal(array[i]) && naoUtrapassouArray(array.length, i)) {
                    i+=1;
                    if(vogalNaoRepetida(palavra, array[i])) {
                        vogal = Optional.of(array[i]);
                    }
                }
            }
        }

        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();

        if(! vogal.isPresent()) {
            throw new RecuperaVogalException();
        }
        return vogal;
    }

    @Override
    public String getTempoProcessamento() {
        return String.valueOf(timeElapsed).concat("ms");
    }

    private boolean naoUtrapassouArray(int tamanhoArray, int index) {
        return (index+1 < tamanhoArray) ? true : false;
    }

    private boolean vogalNaoRepetida(String palavra, char character) {
        Long countVezesRepetida = palavra.chars().filter(c -> c == character).count();
        boolean isVogal = isVogal(character);
        return (countVezesRepetida == 1L && isVogal) ? true : false;
    }

    private boolean isVogal(char character) {
        final List<String> vogais = Arrays.asList("a", "e", "i", "o", "u");
        return vogais.stream()
                      .anyMatch(v -> v.equalsIgnoreCase(String.valueOf(character)));
    }
}

package br.com.savitoh.demoapirestful;

import br.com.savitoh.demoapirestful.businesslogic.RecuperaVogalImpl;
import br.com.savitoh.demoapirestful.exception.RecuperaVogalException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RecuperaVogalUnitTests {

    private RecuperaVogalImpl recuperaVogalImpl;

    @Before
    public void init() {
        recuperaVogalImpl = new RecuperaVogalImpl();
    }

    @Test
    public void deveRetornarVogal() throws RecuperaVogalException {
        Optional<Character> vogal;
        vogal = recuperaVogalImpl.recuperaPrimeiraVogalAposCosoanteNaoRepetidaAntecedidaPorVogal("aAbBABacafe");
        Assert.assertEquals(vogal.get().charValue(), 'e');
    }

    @Test(expected = RecuperaVogalException.class)
    public void deveLancarExceptionRecuperaVogal() throws RecuperaVogalException{
        Optional<Character> vogal;
        vogal = recuperaVogalImpl.recuperaPrimeiraVogalAposCosoanteNaoRepetidaAntecedidaPorVogal("aaaa");
    }


    @Test
    public void deveCalcularTempoProcessamento() throws RecuperaVogalException {
        recuperaVogalImpl.recuperaPrimeiraVogalAposCosoanteNaoRepetidaAntecedidaPorVogal("aAbBABacafe");
        String tempoProcessamento = recuperaVogalImpl.getTempoProcessamento();
        Assert.assertNotNull(tempoProcessamento);
    }

}

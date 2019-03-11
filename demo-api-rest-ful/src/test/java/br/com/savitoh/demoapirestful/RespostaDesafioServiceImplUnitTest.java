package br.com.savitoh.demoapirestful;

import br.com.savitoh.demoapirestful.businesslogic.RecuperaVogal;
import br.com.savitoh.demoapirestful.exception.RecuperaVogalException;
import br.com.savitoh.demoapirestful.model.Requisicao;
import br.com.savitoh.demoapirestful.model.RespostaDesafio;
import br.com.savitoh.demoapirestful.repository.RespostaDesafioRepository;
import br.com.savitoh.demoapirestful.serviceimpl.RespostaDesafioServiceImpl;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class RespostaDesafioServiceImplUnitTest {

    @Mock
    private RecuperaVogal recuperaVogalMock;

    @Autowired
    private RespostaDesafioRepository respostaDesafioRepository;

    private RespostaDesafioServiceImpl respostaDesafioServiceImpl;

    @Before
    public  void init () {
        respostaDesafioServiceImpl = new RespostaDesafioServiceImpl();
        respostaDesafioServiceImpl.setRecuperaVogal(recuperaVogalMock);
        respostaDesafioServiceImpl.setRespostaDesafioRepository(respostaDesafioRepository);
    }

    @Test
    public void deveCriarRespostaDesafioSemVogal() throws RecuperaVogalException {
        String palavraTest = "rr";
        Requisicao requisicao = new Requisicao(palavraTest);
        Mockito.when(recuperaVogalMock.recuperaPrimeiraVogalAposCosoanteNaoRepetidaAntecedidaPorVogal(palavraTest))
                .thenThrow(RecuperaVogalException.class);

        RespostaDesafio respostaDesafio = respostaDesafioServiceImpl.save(requisicao);
        Assert.assertEquals("Não foi possivel recuperar vogal com as regras pedidas (:", 
                            respostaDesafio.getMessagem());
    }

    @Test
    public void deveCriarRepotaDesafioComVogal() throws RecuperaVogalException {

        String palavraTest = "aAbBABacafe";
        Requisicao requisicao = new Requisicao(palavraTest);
        Mockito.when(recuperaVogalMock.recuperaPrimeiraVogalAposCosoanteNaoRepetidaAntecedidaPorVogal(palavraTest))
                .thenReturn(Optional.of('e'));

        RespostaDesafio respostaDesafio = respostaDesafioServiceImpl.save(requisicao);
        Assert.assertSame('e', respostaDesafio.getVogal());
    }
}

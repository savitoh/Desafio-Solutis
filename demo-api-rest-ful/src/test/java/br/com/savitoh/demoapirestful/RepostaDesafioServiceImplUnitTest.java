package br.com.savitoh.demoapirestful;

import br.com.savitoh.demoapirestful.businesslogic.RecuperaVogal;
import br.com.savitoh.demoapirestful.exception.RecuperaVogalException;
import br.com.savitoh.demoapirestful.model.Requisicao;
import br.com.savitoh.demoapirestful.model.RespostaDesafio;
import br.com.savitoh.demoapirestful.serviceimpl.RespostaDesafioServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RepostaDesafioServiceImplUnitTest {

    @Mock
    private RecuperaVogal recuperaVogalMock;

    @Mock
    private Requisicao requisicaoMock;

    private RespostaDesafioServiceImpl respostaDesafioServiceImpl;

    @Before
    public  void init () {
        respostaDesafioServiceImpl = new RespostaDesafioServiceImpl();
        respostaDesafioServiceImpl.setRecuperaVogal(recuperaVogalMock);
    }

    @Test
    public void deveCriarRespostaSemVogal() throws RecuperaVogalException {
        /*String palavraTest = "rr";

        Mockito.when(recuperaVogalMock.recuperaPrimeiraVogalAposCosoanteNaoRepetidaAntecedidaPorVogal(palavraTest))
                .thenThrow(RecuperaVogalException.class);

        RespostaDesafio respostaDesafio = respostaDesafioServiceImpl.save(requisicaoMock);
        Assert.assertNotNull(respostaDesafio.getMessagem());*/
    }
}

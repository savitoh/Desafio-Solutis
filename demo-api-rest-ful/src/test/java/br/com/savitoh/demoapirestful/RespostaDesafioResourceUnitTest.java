package br.com.savitoh.demoapirestful;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import br.com.savitoh.demoapirestful.model.Requisicao;
import br.com.savitoh.demoapirestful.model.RespostaDesafio;
import br.com.savitoh.demoapirestful.rest.RespostaDesafioResource;
import br.com.savitoh.demoapirestful.service.RespostaDesafioService;
import br.com.savitoh.demoapirestful.util.JsonUtil;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;



@RunWith(SpringRunner.class)
@WebMvcTest(RespostaDesafioResource.class)
public class RespostaDesafioResourceUnitTest {

    @Autowired
    private MockMvc mvcMock;

    @MockBean
    private RespostaDesafioService respostaDesafioServiceMock;

    private Requisicao requisicao;

    @Before
    public void init () {
        requisicao = new Requisicao();
    }

    @Test
    public void deveCriarRespostaDesafioComVogal() throws Exception {

        RespostaDesafio respostaDesafioMock = new RespostaDesafio();
        respostaDesafioMock.setId(1L);
        respostaDesafioMock.setPalavra("aAbBABacafe");
        respostaDesafioMock.setVogal('e');
        respostaDesafioMock.setMessagem("");
        respostaDesafioMock.setTempoTotal("10ms");

        requisicao.setPalavra("aAbBABacafe");

        String requisicaoJson = JsonUtil.mapToJson(requisicao);

        Mockito.when(respostaDesafioServiceMock.save(Mockito.any(Requisicao.class)))
                .thenReturn(respostaDesafioMock);

        MvcResult mvcResult = mvcMock.perform(post("/api/v1/desafio-solutis")
                                      .accept("application/json").content(requisicaoJson)
                                      .contentType("application/json"))
                                      .andReturn();

        MockHttpServletResponse response = mvcResult.getResponse(); 
        String responseBody = response.getContentAsString();

        final String vogal = "\"vogal\":\"e\"";

        Assert.assertEquals(201, response.getStatus());
        Assert.assertTrue(responseBody.contains(vogal));
    }

    @Test
    public void deveCriarRespostaDesafioSemVogal() throws Exception {

        RespostaDesafio respostaDesafioMock = new RespostaDesafio();
        respostaDesafioMock.setId(1L);
        respostaDesafioMock.setPalavra("aAb");
        respostaDesafioMock.setMessagem("Não foi possivel recuperar vogal com as regras pedidas (:");
        respostaDesafioMock.setTempoTotal("10ms");

        requisicao.setPalavra("aAbBABacafe");

        String requisicaoJson = JsonUtil.mapToJson(requisicao);

        Mockito.when(respostaDesafioServiceMock.save(Mockito.any(Requisicao.class)))
                .thenReturn(respostaDesafioMock);

        MvcResult mvcResult = mvcMock.perform(post("/api/v1/desafio-solutis")
                                      .accept("application/json").content(requisicaoJson)
                                      .contentType("application/json"))
                                      .andReturn();

        MockHttpServletResponse response = mvcResult.getResponse(); 
        String responseBody = response.getContentAsString();

        final String mensagem = "\"messagem\":\"Não foi possivel recuperar vogal com as regras pedidas (:\"";

        Assert.assertEquals(201, response.getStatus());
        Assert.assertTrue(responseBody.contains(mensagem));
    }



    @Test
    public void deveRetornarStatus400_QuandoCampoPalavraNaoPossuirApenasLetras() throws Exception {

        requisicao.setPalavra("22rrt");

        String requisicaoJson = JsonUtil.mapToJson(requisicao);

        mvcMock.perform(post("/api/v1/desafio-solutis")
                .accept("application/json").content(requisicaoJson)
                .contentType("application/json"))
                .andExpect(status().isBadRequest());
    }

}
package br.com.savitoh.demoapirestful;

import br.com.savitoh.demoapirestful.dto.RespostaDesafioDTO;
import br.com.savitoh.demoapirestful.error.ErrorResponse;
import br.com.savitoh.demoapirestful.model.Requisicao;

import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestClientException;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestPropertySource("/test.properties")
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class RespostaDesafioResourceIntegrationTest {

    private final int port = 8080;

    private TestRestTemplate testRestTemplate;

    private HttpHeaders headers;

    private Requisicao requisicao;

    private final String basseURL = "http://localhost:" + port + "/api/v1/desafio-solutis";

    @Before
    public void init() throws URISyntaxException {
        testRestTemplate = new TestRestTemplate();
        headers = new HttpHeaders();
        requisicao = new Requisicao();
    }


    @Test
    public void deveCriarRespostaDesavioComVogal() {

        requisicao.setPalavra("aAbBABacafe");

        HttpEntity<Requisicao> request = new HttpEntity<Requisicao>(requisicao, headers);

        ResponseEntity<RespostaDesafioDTO> response = testRestTemplate.postForEntity(basseURL, request,
                                                                                     RespostaDesafioDTO.class);

        RespostaDesafioDTO respostaDesafioDTO = response.getBody();

        Assert.assertEquals(201, response.getStatusCodeValue());
        Assert.assertEquals(Character.valueOf('e'), respostaDesafioDTO.getVogal());
        Assert.assertNull(respostaDesafioDTO.getMessagem());
    }

    @Test
    public void deveCriarRespostaDesavioSemVogal() {

        requisicao.setPalavra("rr");

        HttpEntity<Requisicao> request = new HttpEntity<Requisicao>(requisicao, headers);

        ResponseEntity<RespostaDesafioDTO> response = testRestTemplate.postForEntity(basseURL, request,
                                                                                     RespostaDesafioDTO.class);

        RespostaDesafioDTO respostaDesafioDTO = response.getBody();

        Assert.assertEquals(201, response.getStatusCodeValue());
        Assert.assertNull(respostaDesafioDTO.getVogal());
        Assert.assertEquals("Não foi possivel recuperar vogal com as regras pedidas (:", respostaDesafioDTO.getMessagem());
    }


    @Test
    public void deveFalharRequisicao() throws RestClientException {

        requisicao.setPalavra("rr1");

        HttpEntity<Requisicao> request = new HttpEntity<Requisicao>(requisicao, headers);

        ResponseEntity<ErrorResponse> response = testRestTemplate.postForEntity(basseURL, request,
                                                                                ErrorResponse.class);

        ErrorResponse errorResponse = response.getBody();

        Assert.assertEquals(400, response.getStatusCodeValue());
        Assert.assertNotNull(errorResponse);
        Assert.assertEquals("Requisição possui campos inválidos", errorResponse.getMessage());
    }
    
}
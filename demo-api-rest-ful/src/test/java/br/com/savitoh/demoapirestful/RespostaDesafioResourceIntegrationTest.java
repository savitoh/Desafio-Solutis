package br.com.savitoh.demoapirestful;

import br.com.savitoh.demoapirestful.dto.RespostaDesafioDTO;
import br.com.savitoh.demoapirestful.error.ErrorResponse;
import br.com.savitoh.demoapirestful.dto.RequisicaoDTO;

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

    private RequisicaoDTO requisicaoDTO;

    private final String basseURL = "http://localhost:" + port + "/api/v1/desafio-solutis";

    @Before
    public void init() throws URISyntaxException {
        testRestTemplate = new TestRestTemplate();
        headers = new HttpHeaders();
        requisicaoDTO = new RequisicaoDTO();
    }


    @Test
    public void deveCriarRespostaDesavioComVogal() {

        requisicaoDTO.setPalavra("aAbBABacafe");

        final var request = new HttpEntity<RequisicaoDTO>(requisicaoDTO, headers);

        final var response = testRestTemplate.postForEntity(basseURL, request, RespostaDesafioDTO.class);

        final var respostaDesafioDTO = response.getBody();

        Assert.assertEquals(201, response.getStatusCodeValue());
        Assert.assertEquals(Character.valueOf('e'), respostaDesafioDTO.getVogal());
        Assert.assertNull(respostaDesafioDTO.getMessagem());
    }

    @Test
    public void deveCriarRespostaDesavioSemVogal() {

        requisicaoDTO.setPalavra("rr");

        final var request = new HttpEntity<RequisicaoDTO>(requisicaoDTO, headers);

        final var response = testRestTemplate.postForEntity(basseURL, request, RespostaDesafioDTO.class);

        final var respostaDesafioDTO = response.getBody();

        Assert.assertEquals(201, response.getStatusCodeValue());
        Assert.assertNull(respostaDesafioDTO.getVogal());
        Assert.assertEquals("Não foi possivel recuperar vogal com as regras pedidas (:",
                            respostaDesafioDTO.getMessagem());
    }


    @Test
    public void deveFalharRequisicao() throws RestClientException {

        requisicaoDTO.setPalavra("rr1");

        final var request = new HttpEntity<RequisicaoDTO>(requisicaoDTO, headers);

        final var response = testRestTemplate.postForEntity(basseURL, request, ErrorResponse.class);

        final var errorResponse = response.getBody();

        Assert.assertEquals(400, response.getStatusCodeValue());
        Assert.assertNotNull(errorResponse);
        Assert.assertEquals("Requisição possui campos inválidos", errorResponse.getMessage());
    }
    
}
package br.com.savitoh.demoapirestful;

import br.com.savitoh.demoapirestful.dto.RequisicaoDTO;
import br.com.savitoh.demoapirestful.util.JsonUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JsonUtilUnitTest {

    private RequisicaoDTO requisicaoDTO;

    @Before
    public  void init() {
        requisicaoDTO = new RequisicaoDTO();
    }

    @Test
    public void deveSerializarObjetoRequisicaoParaJson() throws Exception{
        requisicaoDTO.setPalavra("aAbBABacafe");
        final var jsonString = JsonUtil.mapToJson(requisicaoDTO);
        Assert.assertNotNull(jsonString);
        Assert.assertEquals("{\"palavra\":\"aAbBABacafe\"}", jsonString);
    }

    @Test
    public void deveDeserializarJsonParaObjetoRequisicao() throws Exception{
        final var jsonString = "{\"palavra\":\"aAbBABacafe\"}";
        requisicaoDTO = JsonUtil.mapFromJson(jsonString, RequisicaoDTO.class);
        Assert.assertNotNull(requisicaoDTO);
        Assert.assertEquals("aAbBABacafe", requisicaoDTO.getPalavra());
    }
}

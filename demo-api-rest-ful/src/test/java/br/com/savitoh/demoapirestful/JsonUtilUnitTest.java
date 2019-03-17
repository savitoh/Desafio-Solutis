package br.com.savitoh.demoapirestful;

import br.com.savitoh.demoapirestful.model.Requisicao;
import br.com.savitoh.demoapirestful.util.JsonUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JsonUtilUnitTest {

    @Test
    public void deveSerializarObjetoRequisicaoParaJson() throws Exception{
        Requisicao requisicao = new Requisicao();
        requisicao.setPalavra("aAbBABacafe");
        String jsonString = JsonUtil.mapToJson(requisicao);
        Assert.assertNotNull(jsonString);
        Assert.assertEquals("{\"palavra\":\"aAbBABacafe\"}", jsonString);
    }

    @Test
    public void deveDeserializarJsonParaObjetoRequisicao() throws Exception{
        String jsonString = "{\"palavra\":\"aAbBABacafe\"}";
        Requisicao requisicao = JsonUtil.mapFromJson(jsonString, Requisicao.class);
        Assert.assertNotNull(requisicao);
        Assert.assertEquals("aAbBABacafe", requisicao.getPalavra());
    }
}

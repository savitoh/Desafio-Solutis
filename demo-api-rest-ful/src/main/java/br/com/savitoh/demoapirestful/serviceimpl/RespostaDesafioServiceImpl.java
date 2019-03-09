package br.com.savitoh.demoapirestful.serviceimpl;

import br.com.savitoh.demoapirestful.businesslogic.RecuperaVogal;
import br.com.savitoh.demoapirestful.exception.RecuperaVogalException;
import br.com.savitoh.demoapirestful.model.Requisicao;
import br.com.savitoh.demoapirestful.model.RespostaDesafio;
import br.com.savitoh.demoapirestful.repository.RespostaDesafioRepository;
import br.com.savitoh.demoapirestful.service.RespostaDesafioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class RespostaDesafioServiceImpl implements RespostaDesafioService {

    private RespostaDesafioRepository respostaDesafioRepository;

    private RecuperaVogal recuperaVogal;

    @Autowired
    public void setRespostaDesafioRepository(RespostaDesafioRepository respostaDesafioRepository){
        this.respostaDesafioRepository = respostaDesafioRepository;
    }

    @Autowired
    public  void setRecuperaVogal(RecuperaVogal recuperaVogal) {
        this.recuperaVogal = recuperaVogal;
    }

    @Override
    public RespostaDesafio save(Requisicao requisicao) {
        final RespostaDesafio respostaDesafio = montaDesafioResposta(requisicao);
        return respostaDesafioRepository.save(respostaDesafio);
    }

    private RespostaDesafio montaDesafioResposta(Requisicao requisicao) {
        RespostaDesafio respostaDesafio = new RespostaDesafio();
        String palavra = requisicao.getPalavra();
        try {
            Optional<Character> vogal = recuperaVogal.
                                        recuperaPrimeiraVogalAposCosoanteNaoRepetidaAntecedidaPorVogal(palavra);
            String tempoProcessamento = recuperaVogal.getTempoProcessamento();
            respostaDesafio.setVogal(vogal.get());
            respostaDesafio.setTempoTotal(tempoProcessamento);
        } catch (RecuperaVogalException e) {
            respostaDesafio.setMessagem("Não foi possivel recuperar vogal com as regras pedidas (:");
        }
        respostaDesafio.setPalavra(palavra);
        return respostaDesafio;
    }

}

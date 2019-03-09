package br.com.savitoh.demoapirestful.serviceimpl;

import br.com.savitoh.demoapirestful.businesslogic.RecuperaVogal;
import br.com.savitoh.demoapirestful.model.RespostaDesafio;
import br.com.savitoh.demoapirestful.repository.RespostaDesafioRepository;
import br.com.savitoh.demoapirestful.service.RespostaDesafioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public RespostaDesafio save(RespostaDesafio respostaDesafio) {
        return respostaDesafioRepository.save(respostaDesafio);
    }

}

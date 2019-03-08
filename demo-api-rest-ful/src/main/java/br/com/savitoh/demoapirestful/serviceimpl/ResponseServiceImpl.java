package br.com.savitoh.demoapirestful.serviceimpl;

import br.com.savitoh.demoapirestful.model.Response;
import br.com.savitoh.demoapirestful.repository.ResponseRepository;
import br.com.savitoh.demoapirestful.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResponseServiceImpl implements ResponseService {

    private ResponseRepository responseRepository;

    @Autowired
    public void setResponseRepository(ResponseRepository responseRepository){
        this.responseRepository = responseRepository;
    }

    @Override
    public Response save(Response response) {
        return responseRepository.save(response);
    }

    @Override
    public String recuperaPrimeiraVogalAposCosoanteAntecessoraDeVogalNaoRepetida(String palavra) {
        return null;
    }
}

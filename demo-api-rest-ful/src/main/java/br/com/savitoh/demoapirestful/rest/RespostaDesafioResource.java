package br.com.savitoh.demoapirestful.rest;

import br.com.savitoh.demoapirestful.model.Requisicao;
import br.com.savitoh.demoapirestful.model.RespostaDesafio;
import br.com.savitoh.demoapirestful.service.RespostaDesafioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping({"/api/v1/desafio-solutis"})
public class RespostaDesafioResource {

    private RespostaDesafioService respostaDesafioService;

    @Autowired
    public void setRespostaDesafioService(RespostaDesafioService respostaDesafioService) {
        this.respostaDesafioService = respostaDesafioService;
    }

    @PostMapping
    public ResponseEntity<RespostaDesafio> criaResponse(@Valid @RequestBody Requisicao requisicao) {
        RespostaDesafio createdRespostaDesafio = respostaDesafioService.save(requisicao);
        return new ResponseEntity<>(createdRespostaDesafio, HttpStatus.CREATED);
    }
}

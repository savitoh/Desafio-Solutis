package br.com.savitoh.demoapirestful.rest;

import br.com.savitoh.demoapirestful.dto.RespostaDesafioDTO;
import br.com.savitoh.demoapirestful.model.Requisicao;
import br.com.savitoh.demoapirestful.model.RespostaDesafio;
import br.com.savitoh.demoapirestful.service.RespostaDesafioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.logging.Logger;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/api/v1/desafio-solutis"})
public class RespostaDesafioResource {

    private RespostaDesafioService respostaDesafioService;

    private final Logger LOGGER = Logger.getLogger(RespostaDesafio.class.getName());

    @Autowired
    public void setRespostaDesafioService(RespostaDesafioService respostaDesafioService) {
        this.respostaDesafioService = respostaDesafioService;
    }

    @PostMapping
    public ResponseEntity<RespostaDesafioDTO> criaResponse(@Valid @RequestBody Requisicao requisicao) {
        LOGGER.info("Requisicao " + requisicao);
        RespostaDesafio createdRespostaDesafio = respostaDesafioService.save(requisicao);
        RespostaDesafioDTO respostaDesafioDTO = RespostaDesafioDTO.transformaRespostaDesafioEmDTO(createdRespostaDesafio);
        return new ResponseEntity<>(respostaDesafioDTO, HttpStatus.CREATED);
    }
}

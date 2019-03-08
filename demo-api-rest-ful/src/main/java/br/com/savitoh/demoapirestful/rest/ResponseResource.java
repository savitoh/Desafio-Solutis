package br.com.savitoh.demoapirestful.rest;

import br.com.savitoh.demoapirestful.model.Response;
import br.com.savitoh.demoapirestful.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping({"/api/v1"})
public class ResponseResource {

    private ResponseService responseService;

    @Autowired
    public void setResponseService(ResponseService responseService) {
        this.responseService = responseService;
    }

    @PostMapping
    public ResponseEntity<Response> criaResponse(@Valid @RequestBody Response response) {
        Response createdResponse = responseService.save(response);
        return new ResponseEntity<>(createdResponse, HttpStatus.CREATED);
    }
}

package br.com.savitoh.demoapirestful.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
public class RespostaDesafio {

    @Id
    @GeneratedValue(generator =  "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    @NotBlank
    @Pattern(regexp = "[a-zA-Z]+")
    private String palavra;

    private Character vogal;

    private String tempoTotal;

    private String messagem;

}

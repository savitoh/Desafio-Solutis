package br.com.savitoh.demoapirestful.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Data
public class RespostaDesafio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Pattern(regexp = "[a-zA-Z]+")
    private String palavra;

    private Character vogal;

    @NotBlank
    private String tempoTotal;

    private String messagem;

}

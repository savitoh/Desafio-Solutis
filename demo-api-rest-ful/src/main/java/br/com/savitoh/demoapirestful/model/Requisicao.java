package br.com.savitoh.demoapirestful.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class Requisicao {
	
	@NotBlank
	@Pattern(regexp = "[a-zA-Z]+", message = "{Pattern.requisicao.palavra}")
	private String palavra;

}

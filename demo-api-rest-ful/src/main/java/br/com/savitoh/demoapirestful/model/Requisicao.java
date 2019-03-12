package br.com.savitoh.demoapirestful.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Requisicao {
	
	@NotBlank(message = "{NotBlank.requisicao.message}")
	@Pattern(regexp = "[a-zA-Z]+", message = "{Pattern.requisicao.palavra}")
	private String palavra;

}

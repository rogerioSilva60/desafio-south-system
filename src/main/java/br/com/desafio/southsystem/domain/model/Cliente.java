package br.com.desafio.southsystem.domain.model;

import lombok.Data;

@Data
public class Cliente {

	private Long id;
	private String nome;
	private String cnpj;
	private String areDeNegocio;
}

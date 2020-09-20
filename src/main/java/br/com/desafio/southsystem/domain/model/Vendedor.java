package br.com.desafio.southsystem.domain.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Vendedor {

	private Long id;
	private String nome;
	private String cpf;
	private BigDecimal salario;
}

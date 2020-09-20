package br.com.desafio.southsystem.domain.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ItemVenda {

	private Long id;
	private Long quantidade;
	private BigDecimal preco;
}

package br.com.desafio.southsystem.domain.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ItemVenda {

	private Long id;
	private Long quantidade;
	private BigDecimal preco;
	
	public ItemVenda(String[] valoresItens) {
		this.id = Long.valueOf(valoresItens[0]);
		this.quantidade = Long.valueOf(valoresItens[1]);
		this.preco = new BigDecimal(valoresItens[2]);
	}
}

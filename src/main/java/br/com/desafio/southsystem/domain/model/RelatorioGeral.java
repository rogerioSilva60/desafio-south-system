package br.com.desafio.southsystem.domain.model;

import lombok.Data;

@Data
public class RelatorioGeral {

	private Long quantidadeCliente;
	private Long quantidadeVendedor;
	private Long idVendaMaisCara;
	private String piorVendedor;
	
}

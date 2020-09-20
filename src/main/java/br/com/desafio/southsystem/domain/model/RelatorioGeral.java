package br.com.desafio.southsystem.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class RelatorioGeral {

	private Long quantidadeCliente;
	private Long quantidadeVendedor;
	private Long idVendaMaisCara;
	private String piorVendedor;
	
}

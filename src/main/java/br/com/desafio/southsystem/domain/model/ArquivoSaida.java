package br.com.desafio.southsystem.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ArquivoSaida {

	private Long quantidadeCliente;
	private Long quantidadeVendedor;
	private Long idVendaMaisCara;
	private String piorVendedor;
	
	public String conteudo() {
		String conteudo = quantidadeCliente + "ç" + quantidadeVendedor + "ç" + idVendaMaisCara + "ç" + piorVendedor;
		return conteudo;
	}

	public ArquivoSaida(String[] valores) {
		quantidadeCliente = Long.valueOf(valores[0]);
		quantidadeVendedor = Long.valueOf(valores[1]);
		idVendaMaisCara = Long.valueOf(valores[2]);
		piorVendedor = valores[3];
	}
	
}

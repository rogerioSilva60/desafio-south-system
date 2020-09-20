package br.com.desafio.southsystem.domain.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Venda {

	private Long idArquivo;
	private Long idVenda;	
	private List<ItemVenda> itens = new ArrayList<>();
	private String vendedor;

	public Venda(String[] valores) {
		this.idArquivo = Long.valueOf(valores[0]);
		this.idVenda = Long.valueOf(valores[1]);
		String[] listaItens = valores[2].replace("[", "").replace("]", "").split(",");
		for (int i = 0; i < listaItens.length; i++) {
			String[] valoresItens = listaItens[i].split("-");
			ItemVenda itemVenda = new ItemVenda(valoresItens);
			itens.add(itemVenda);
		}
		
		this.vendedor = valores[3];
	}
}

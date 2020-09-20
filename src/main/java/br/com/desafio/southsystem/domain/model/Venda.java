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
}

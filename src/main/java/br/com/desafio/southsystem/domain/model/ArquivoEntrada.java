package br.com.desafio.southsystem.domain.model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArquivoEntrada {

	private List<Cliente> clientes;
	private List<Vendedor> vendedores;
	private List<Venda> vendas;
	
	public Long obterIdVendaMaisCara() {
		Long idVendaMaisCara = null;
		BigDecimal valorResultado = new BigDecimal(0);
		for (Venda venda : vendas) {
			BigDecimal valor = new BigDecimal(0);
			for (ItemVenda item : venda.getItens()) {
				BigDecimal resultado = item.getPreco().multiply(new BigDecimal(item.getQuantidade()));
				valor = valor.add(resultado);
			}
			if(valorResultado.compareTo(valor) == -1) {
				valorResultado = valor;
				idVendaMaisCara = venda.getIdVenda();
			}
		}
		return idVendaMaisCara;
	}
	
	public String obterPiorVendedor() {
		HashMap<String, BigDecimal> map = new HashMap<String, BigDecimal>();
		for (Venda venda : vendas) {
			BigDecimal valor = new BigDecimal(0);
			for (ItemVenda item : venda.getItens()) {
				BigDecimal resultado = item.getPreco().multiply(new BigDecimal(item.getQuantidade())) ;
				valor = valor.add(resultado);
			}
			String vendedor = venda.getVendedor();
			if(!map.containsKey(vendedor)) {
				map.put(vendedor, valor);
			} else {
				BigDecimal novoValor = map.get(vendedor).add(valor);
				map.put(vendedor, novoValor);			}
		}
		BigDecimal valorTotalDoVendedor= null;
		String vendedor = null;		
		for (String chave : map.keySet()) {
			if(valorTotalDoVendedor == null) {
				valorTotalDoVendedor = map.get(chave);
				vendedor = chave;
			}
			if(map.get(chave).doubleValue() < valorTotalDoVendedor.doubleValue()) {
				valorTotalDoVendedor = map.get(chave);
				vendedor = chave;
			}
		}
		return vendedor;
	}
}

package br.com.desafio.southsystem.domain.service.impl;

import org.springframework.stereotype.Service;

import br.com.desafio.southsystem.domain.model.ArquivoEntrada;
import br.com.desafio.southsystem.domain.model.RelatorioGeral;
import br.com.desafio.southsystem.domain.service.ArquivoService;
import br.com.desafio.southsystem.domain.service.RelatorioService;

@Service
public class RelatorioServiceImpl implements RelatorioService {

	private ArquivoService arquivoService;
	
	public RelatorioServiceImpl(ArquivoService arquivoService) {
		this.arquivoService = arquivoService;
	}

	@Override
	public ArquivoEntrada arquivosDeEntrada() {		
		ArquivoEntrada entrada = arquivoService.entrada();
		return entrada;
	}

	@Override
	public RelatorioGeral relatorio() {
		ArquivoEntrada arquivosDeEntrada = arquivosDeEntrada();
		Long totalClientes = Long.valueOf(arquivosDeEntrada.getClientes().size());
		Long totalVendedores = Long.valueOf(arquivosDeEntrada.getVendedores().size());
		
		RelatorioGeral relatorio = RelatorioGeral.builder()
				.quantidadeCliente(totalClientes)
				.quantidadeVendedor(totalVendedores)
				.idVendaMaisCara(arquivosDeEntrada.obterIdVendaMaisCara())
				.piorVendedor(arquivosDeEntrada.obterPiorVendedor())
				.build();
		return relatorio;
	}
}

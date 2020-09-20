package br.com.desafio.southsystem.domain.service;

import br.com.desafio.southsystem.domain.model.ArquivoEntrada;
import br.com.desafio.southsystem.domain.model.RelatorioGeral;

public interface RelatorioService {

	ArquivoEntrada arquivosDeEntrada();
	
	RelatorioGeral relatorio();

}

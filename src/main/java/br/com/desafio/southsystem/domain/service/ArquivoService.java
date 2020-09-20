package br.com.desafio.southsystem.domain.service;

import br.com.desafio.southsystem.domain.model.ArquivoEntrada;
import br.com.desafio.southsystem.domain.model.ArquivoSaida;

public interface ArquivoService {

	
	ArquivoEntrada buscarArquivoEntrada();

	void transfere(ArquivoSaida arquivoSaida, String nomeArquivo);
	
	ArquivoSaida buscarArquivoSaida(String nomeArquivo);
	
	ArquivoSaida prepararArquivoSaida();
	
}

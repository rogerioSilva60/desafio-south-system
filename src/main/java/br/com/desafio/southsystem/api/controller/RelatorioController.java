package br.com.desafio.southsystem.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.southsystem.core.armazenar.AmazenarProperties;
import br.com.desafio.southsystem.domain.model.ArquivoEntrada;
import br.com.desafio.southsystem.domain.model.ArquivoSaida;
import br.com.desafio.southsystem.domain.service.ArquivoService;

@RestController
@RequestMapping("api/v1/relatorio")
public class RelatorioController {
	
	@Autowired
	private AmazenarProperties properties;
	
	private ArquivoService arquivoService;

	public RelatorioController(ArquivoService arquivoService) {
		this.arquivoService = arquivoService;
	}
	
	@GetMapping("arquivo-entrada")
	public ResponseEntity<ArquivoEntrada> buscarResumo() {
		ArquivoEntrada arquivos = arquivoService.buscarArquivoEntrada();
		return ResponseEntity.ok(arquivos);
	}
	
	@GetMapping("arquivo-saida")
	public ResponseEntity<ArquivoSaida> relatorioGeral(){
		ArquivoSaida arquivoSaida = arquivoService.prepararArquivoSaida();
		arquivoService.transfere(arquivoSaida, properties.getLocal().getArquivo());
		ArquivoSaida relatorio = arquivoService.buscarArquivoSaida(properties.getLocal().getArquivo());
		return ResponseEntity.ok(relatorio);
	}
}

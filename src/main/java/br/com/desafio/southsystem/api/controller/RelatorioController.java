package br.com.desafio.southsystem.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.southsystem.domain.model.ArquivoEntrada;
import br.com.desafio.southsystem.domain.model.ArquivoSaida;
import br.com.desafio.southsystem.domain.service.ArquivoService;

@RestController
@RequestMapping("api/v1/relatorio")
public class RelatorioController {

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
		arquivoService.transfere(arquivoSaida, "flat_file_name.done.dat");
		ArquivoSaida relatorio = arquivoService.buscarArquivoSaida("flat_file_name.done.dat");
		return ResponseEntity.ok(relatorio);
	}
}

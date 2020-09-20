package br.com.desafio.southsystem.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.southsystem.domain.model.ArquivoEntrada;
import br.com.desafio.southsystem.domain.model.RelatorioGeral;
import br.com.desafio.southsystem.domain.service.RelatorioService;

@RestController
@RequestMapping("api/v1/relatorio")
public class RelatorioController {

	private RelatorioService service;

	public RelatorioController(RelatorioService service) {
		this.service = service;
	}
	
	@GetMapping("arquivo-entrada")
	public ResponseEntity<ArquivoEntrada> buscarResumo() {
		ArquivoEntrada arquivos = service.arquivosDeEntrada();
		return ResponseEntity.ok(arquivos);
	}
	
	@GetMapping
	public ResponseEntity<RelatorioGeral> relatorioGeral(){
		RelatorioGeral relatorio = service.relatorio();
		return ResponseEntity.ok(relatorio);
	}
}

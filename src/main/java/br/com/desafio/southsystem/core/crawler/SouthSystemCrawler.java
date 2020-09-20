package br.com.desafio.southsystem.core.crawler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.desafio.southsystem.core.armazenar.AmazenarProperties;
import br.com.desafio.southsystem.domain.model.ArquivoSaida;
import br.com.desafio.southsystem.domain.service.ArquivoService;

@Component
public class SouthSystemCrawler {

	@Autowired
	private AmazenarProperties properties;
	
	private static final Logger log = LoggerFactory.getLogger(SouthSystemCrawler.class);
	
	private ArquivoService arquivoService;

	public SouthSystemCrawler(ArquivoService arquivoService) {
		this.arquivoService = arquivoService;
	}
	
	@Async
	@Scheduled(cron = "0 0/1 * ? * SUN,MON,TUE,WED,THU,FRI,SAT")
	public void transfere() {
		log.info("Executando a transferencia de arquivo "
				+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
		ArquivoSaida arquivoSaida = arquivoService.prepararArquivoSaida();
		arquivoService.transfere(arquivoSaida, properties.getLocal().getArquivo());
		log.info("Finalizando a execucao de transferencia.");
	}
}

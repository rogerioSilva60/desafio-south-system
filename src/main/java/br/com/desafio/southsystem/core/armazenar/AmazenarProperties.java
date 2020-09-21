package br.com.desafio.southsystem.core.armazenar;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@ConfigurationProperties("south-system.armazenamento")
public class AmazenarProperties {

	private Local local = new Local();
	
	@Getter
	@Setter
	public class Local {
		private String diretorioEntrada;
		private String diretorioSaida;
		private String arquivo;
		
		public String getDiretorioEntrada() {
			String variavelDeAmbiente = System.getenv("HOME_PATH");
			return  variavelDeAmbiente + diretorioEntrada;
		}
		
		public String getDiretorioSaida() {
			String variavelDeAmbiente = System.getenv("HOME_PATH");
			return variavelDeAmbiente + diretorioSaida;
		}
		
	}
}

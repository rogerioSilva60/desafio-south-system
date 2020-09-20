package br.com.desafio.southsystem.infrastructure;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.desafio.southsystem.domain.model.ArquivoEntrada;
import br.com.desafio.southsystem.domain.model.Cliente;
import br.com.desafio.southsystem.domain.model.Venda;
import br.com.desafio.southsystem.domain.model.Vendedor;
import br.com.desafio.southsystem.domain.service.ArquivoService;

@Service
public class LocalArquivoService implements ArquivoService{

	@Value("${south-system.armazenamento.local.diretorio}")
	private String diretorio;
	
	@Override
	public ArquivoEntrada entrada() {
		File file = new File(diretorio);
		File[] arquivos = file.listFiles();
		List<Vendedor> vendedores = new ArrayList<>();
		List<Cliente> clientes = new ArrayList<>();
		List<Venda> vendas = new ArrayList<>();
		for (File arquivo : arquivos) {
			String nome = arquivo.getAbsolutePath();
			if(nome.contains(".dat")) {
				try {
					List<String> linhasArquivo = Files.readAllLines(Path.of(arquivo.getAbsolutePath()));
					for (String linha : linhasArquivo) {
			            String[] valores = linha.split("ç");			            
			            if(valores != null && valores.length > 0) {
			            	if(valores[0].equals("001")) {
			            		Vendedor vendedor = new Vendedor(valores);
			            		if(!vendedores.contains(vendedor)) {
			            			vendedores.add(vendedor);
			            		}
			            	} else if(valores[0].equals("002")){
			            		Cliente cliente = new Cliente(valores);
			            		if(!clientes.contains(cliente)) {
			            			clientes.add(cliente);
			            		}
			            	} else if(valores[0].equals("003")) {
			            		Venda venda = new Venda(valores);
			            		vendas.add(venda);
			            	}
			            }
			        }
				} catch (IOException e) {
					e.printStackTrace();
				}
			}			
		}		
		ArquivoEntrada entrada = ArquivoEntrada.builder()
				.vendedores(vendedores)
				.clientes(clientes)
				.vendas(vendas)
				.build();
		return entrada;
	}

}

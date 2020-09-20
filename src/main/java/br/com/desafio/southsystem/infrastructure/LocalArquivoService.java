package br.com.desafio.southsystem.infrastructure;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.southsystem.core.armazenar.AmazenarProperties;
import br.com.desafio.southsystem.domain.model.ArquivoEntrada;
import br.com.desafio.southsystem.domain.model.ArquivoSaida;
import br.com.desafio.southsystem.domain.model.Cliente;
import br.com.desafio.southsystem.domain.model.Venda;
import br.com.desafio.southsystem.domain.model.Vendedor;
import br.com.desafio.southsystem.domain.service.ArquivoService;

@Service
public class LocalArquivoService implements ArquivoService {

	@Autowired
	private AmazenarProperties properties;

	@Override
	public ArquivoEntrada buscarArquivoEntrada() {
		String diretorioEntrada = properties.getLocal().getDiretorioEntrada();
		File file = new File(diretorioEntrada);
		File[] arquivos = file.listFiles();
		List<Vendedor> vendedores = new ArrayList<>();
		List<Cliente> clientes = new ArrayList<>();
		List<Venda> vendas = new ArrayList<>();
		for (File arquivo : arquivos) {
			String nome = arquivo.getAbsolutePath();
			if (nome.contains(".dat")) {
				try {
					List<String> linhasArquivo = Files.readAllLines(Path.of(arquivo.getAbsolutePath()));
					for (String linha : linhasArquivo) {
						String[] valores = linha.split("ç");
						if (valores != null && valores.length > 0) {
							if (valores[0].equals("001")) {
								Vendedor vendedor = new Vendedor(valores);
								if (!vendedores.contains(vendedor)) {
									vendedores.add(vendedor);
								}
							} else if (valores[0].equals("002")) {
								Cliente cliente = new Cliente(valores);
								if (!clientes.contains(cliente)) {
									clientes.add(cliente);
								}
							} else if (valores[0].equals("003")) {
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
		ArquivoEntrada entrada = ArquivoEntrada.builder().vendedores(vendedores).clientes(clientes).vendas(vendas)
				.build();
		return entrada;
	}

	@Override
	public void transfere(ArquivoSaida arquivoSaida, String nomeArquivo) {
		try {
			File diretorio = new File(properties.getLocal().getDiretorioSaida());
			if (!diretorio.exists())
				diretorio.mkdirs();
			File arquivo = new File(properties.getLocal().getDiretorioSaida(), nomeArquivo);
			Writer writer = new BufferedWriter(new FileWriter(arquivo));
			writer.write(arquivoSaida.conteudo());
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArquivoSaida buscarArquivoSaida(String nomeArquivo) {
		ArquivoSaida arquivoSaida = null;
		try {
			List<String> linhasArquivo = Files.readAllLines(Path.of(properties.getLocal().getDiretorioSaida() + "/" + nomeArquivo));
			String[] valores = linhasArquivo.get(0).split("ç");
			arquivoSaida = new ArquivoSaida(valores);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return arquivoSaida;
	}
	
	@Override
	public ArquivoSaida prepararArquivoSaida() {
		ArquivoEntrada arquivosDeEntrada = buscarArquivoEntrada();
		Long totalClientes = Long.valueOf(arquivosDeEntrada.getClientes().size());
		Long totalVendedores = Long.valueOf(arquivosDeEntrada.getVendedores().size());		
		ArquivoSaida arquivoSaida = ArquivoSaida.builder()
				.quantidadeCliente(totalClientes)
				.quantidadeVendedor(totalVendedores)
				.idVendaMaisCara(arquivosDeEntrada.obterIdVendaMaisCara())
				.piorVendedor(arquivosDeEntrada.obterPiorVendedor())
				.build();
		return arquivoSaida;
	}
}

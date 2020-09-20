package br.com.desafio.southsystem.domain.model;

import java.util.Objects;

import lombok.Data;

@Data
public class Cliente {

	private Long idArquivo;
	private String nome;
	private String cnpj;
	private String areDeNegocio;

	public Cliente(String[] valores) {
		this.idArquivo = Long.valueOf(valores[0]);
		this.nome = valores[2];
		this.cnpj = valores[1];
		this.areDeNegocio = valores[3];
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(cnpj, other.cnpj);
	}

	@Override
	public int hashCode() {
		return Objects.hash(cnpj);
	}

	@Override
	public String toString() {
		return "Cliente [id=" + idArquivo + ", nome=" + nome + ", cnpj=" + cnpj + ", areDeNegocio=" + areDeNegocio + "]";
	}
	
	
}

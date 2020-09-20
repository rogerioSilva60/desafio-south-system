package br.com.desafio.southsystem.domain.model;

import java.math.BigDecimal;
import java.util.Objects;

import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class Vendedor {

	private Long idArquivo;
	private String nome;
	private String cpf;
	private BigDecimal salario;

	public Vendedor(String[] valores) {
		this.idArquivo = Long.valueOf(valores[0]);
		this.nome = valores[2];
		this.cpf = valores[1];
		this.salario = new BigDecimal(valores[3]);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vendedor other = (Vendedor) obj;
		return Objects.equals(cpf, other.cpf);
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public String toString() {
		return "Vendedor [id=" + idArquivo + ", nome=" + nome + ", cpf=" + cpf + ", salario=" + salario + "]";
	}

	
}

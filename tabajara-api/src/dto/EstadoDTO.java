package dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class EstadoDTO implements Serializable {
	
	private String nome;
	private String sigla;

	public EstadoDTO(String nome, String sigla) {
		this.nome = nome;
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
}

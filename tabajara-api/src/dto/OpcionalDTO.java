package dto;

import model.Opcional;

public class OpcionalDTO extends AbstractDTO<Opcional> {

	private Integer id;
	
	private String nome;
	
	private String descricao;
	
	@Override
	public void setValues(Opcional o) {
		this.id = o.getId();
		this.nome = o.getNome();
		this.descricao = o.getDescricao();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
}

package model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="opcionais")
public class Opcional {
	
	
	@Id
	@Column(name="id")
	private Integer id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="desc")
	private String desc;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="opcionais")
	@JoinTable(name = "apartamento_opcionais", joinColumns = {
			@JoinColumn(name = "opcionais_id", nullable = false, updatable = false) },
			inverseJoinColumns = { 
					@JoinColumn(name = "apartamento_id",
					nullable = false, updatable = false)
			}
	)
	private List<Apartamento> apartamentos;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public List<Apartamento> getApartamentos() {
		return apartamentos;
	}

	public void setApartamentos(List<Apartamento> apartamentos) {
		this.apartamentos = apartamentos;
	}
	
}

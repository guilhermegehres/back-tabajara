package model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="opcionais")
@NamedQueries({
	@NamedQuery(name="Opcional.findById", query="select o from Opcional o where o.id = :id"),
	@NamedQuery(name="Opcional.getAll", query="select o from Opcional o")
})
public class Opcional extends AbstractModel<Opcional> {
	
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="descricao")
	private String descricao;

	@ManyToMany(mappedBy="opcionais")
	private List<Apartamento> apartamentos;

	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
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

	public void setDescricao(String desc) {
		this.descricao = desc;
	}

	public List<Apartamento> getApartamentos() {
		return apartamentos;
	}

	public void setApartamentos(List<Apartamento> apartamentos) {
		this.apartamentos = apartamentos;
	}
	
}

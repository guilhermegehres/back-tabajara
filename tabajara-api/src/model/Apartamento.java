package model;


import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
public class Apartamento implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Integer id;
	
	
	@Column(name = "tipo")
	private String tipo;
	
	@Column(name="valor_diaria")
	private Double valorDiaria;
	
	@OneToMany(mappedBy = "apartamento", fetch = FetchType.LAZY)
	private List<Aluguel> alugueis;
	
	@OneToMany(mappedBy = "apartamento", fetch = FetchType.LAZY)
	private List<Reserva> reserva;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="apartamentos")
	@JoinTable(name = "apartamento_opcionais", joinColumns = {
			@JoinColumn(name = "apartamento_id", nullable = false, updatable = false) },
			inverseJoinColumns = { 
					@JoinColumn(name = "opcional_id",
					nullable = false, updatable = false)
			}
	)
	private List<Opcional> opcionais;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Double getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(Double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	public List<Aluguel> getAlugueis() {
		return alugueis;
	}

	public void setAlugueis(List<Aluguel> alugueis) {
		this.alugueis = alugueis;
	}

	public List<Reserva> getReserva() {
		return reserva;
	}

	public void setReserva(List<Reserva> reserva) {
		this.reserva = reserva;
	}

	public List<Opcional> getOpcionais() {
		return opcionais;
	}

	public void setOpcionais(List<Opcional> opcionais) {
		this.opcionais = opcionais;
	}
	

}

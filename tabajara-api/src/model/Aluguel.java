package model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "aluguel")
public class Aluguel {

	@Id
	private Integer id;
	
	@Column(name="data_inicio")
	private Date dataInicio;
	
	@Column(name="data_fim")
	private Date dataFim;
	
	@Column(name = "valor")
	private Double valor;
	
	@ManyToOne
	@JoinColumn(name = "users_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "apartamento_id")
	private Apartamento apartamento;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Apartamento getApartamento() {
		return apartamento;
	}

	public void setApartamento(Apartamento apartamento) {
		this.apartamento = apartamento;
	}
	
	
}

package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="reserva")
@NamedQueries({
	@NamedQuery(name="Reserva.findById", query="select r from Reserva r where r.id = :id"),
	@NamedQuery(name="Reserva.getAll", query="select r from Reserva r")
})
public class Reserva extends AbstractModel<Reserva> implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="data_inicio")
	private Date dataInicio;
	
	@Column(name="data_fim")
	private Date dataFim;
	
	@Column(name = "valor")
	private Double valor;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "users_id")
	private User user;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "apartamento_id")
	private Apartamento apartamento;

	public Integer getId() {
		return id;
	}

	@Override
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

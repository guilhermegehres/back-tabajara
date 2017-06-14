package dto;

import java.util.Date;

import model.Reserva;

public class ReservaDTO extends AbstractDTO<Reserva>{

	private Integer id;
	
	private Date dataInicio;
	
	private Date dataFim;
	
	private Double valor;
	
	private UserDTO user;
	
	private ApartamentoDTO apartamento;
	
	@Override
	public void setValues(Reserva r){
		this.id = r.getId();
		this.dataInicio = r.getDataInicio();
		this.dataFim = r.getDataFim();
		this.valor = r.getValor();
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

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public ApartamentoDTO getApartamento() {
		return apartamento;
	}

	public void setApartamento(ApartamentoDTO apartamento) {
		this.apartamento = apartamento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}

package dto;

import java.util.Date;

public class ReservaDTO {

	private Date dataInicio;
	
	private Date dataFim;
	
	private Double valor;
	
	private UserDTO user;
	
	private ApartamentoDTO apartamento;

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
	
}

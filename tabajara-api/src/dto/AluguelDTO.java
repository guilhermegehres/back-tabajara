package dto;

import java.util.Date;
import model.Aluguel;

public class AluguelDTO extends AbstractDTO<Aluguel>{


	@Override
	public void setValues(Aluguel a) {
		this.id = a.getId();
		this.dataInicio = a.getDataInicio();
		this.dataFim = a.getDataFim();
		this.valor = a.getValor();
	}

	public Integer id;
	
	public Date dataInicio;
	
	public Date dataFim;
	
	public Double valor;
	
	public UserDTO user;
	
	public ApartamentoDTO apartamento;

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

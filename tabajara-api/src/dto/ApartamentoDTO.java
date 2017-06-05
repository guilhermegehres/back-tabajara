package dto;

import java.util.List;

import model.Apartamento;

public class ApartamentoDTO {
	
	private String tipo;
	
	private Double valorDiaria;
	
	private List<AluguelDTO> alugueis;
	
	private List<ReservaDTO> reservas;
	
	private List<OpcionalDTO> opcionais;
	
	public ApartamentoDTO(Apartamento ap) {
		this.tipo = ap.getTipo();
		this.valorDiaria = ap.getValorDiaria();
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

	public List<AluguelDTO> getAlugueis() {
		return alugueis;
	}

	public void setAlugueis(List<AluguelDTO> alugueis) {
		this.alugueis = alugueis;
	}

	public List<ReservaDTO> getReservas() {
		return reservas;
	}

	public void setReservas(List<ReservaDTO> reserva) {
		this.reservas = reserva;
	}
	
	public List<OpcionalDTO> getOpcionais() {
		return opcionais;
	}

	public void setOpcionais(List<OpcionalDTO> opcionais) {
		this.opcionais = opcionais;
	}

	
}

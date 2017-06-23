package dto;

import java.util.List;

import model.User;

public class UserDTO extends AbstractDTO<User> {

	private Integer id;
	
	private String nome;
	
	private String email;
	
	private String senha;
	
	private String token;
	
	private Integer tipo;
	
	private List<AluguelDTO> alugueis;
	
	private List<ReservaDTO> reservas;
	
	@Override
	public void setValues(User u) {
		this.id = u.getId();
		this.nome = u.getNome();
		this.email = u.getEmail();
		this.senha = u.getSenha();
		this.tipo = u.getTipo();
		this.token = u.getToken();
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
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

	public void setReservas(List<ReservaDTO> reservas) {
		this.reservas = reservas;
	}
	
}

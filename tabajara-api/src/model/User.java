package model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "users")
@NamedQueries({
	@NamedQuery(name="User.findById", query="select u from User u where u.id = :id"),
	@NamedQuery(name="User.getAll", query="select u from User u"),
	@NamedQuery(name="User.getByLogin", query="select u from User u where u.email = :email and u.senha = :senha"),
	@NamedQuery(name="User.getByEmail", query="select u from User u where u.email = :email")
})
public class User extends AbstractModel<User> implements Serializable{
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="token")
	private String token;
	
	@Column(name="tipo")
	private Integer tipo; 
	
	@Column(name="email")
	private String email;
	
	@Column(name="senha")
	private String senha;

	public int getId() {
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String password) {
		this.senha = password;
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
	
}

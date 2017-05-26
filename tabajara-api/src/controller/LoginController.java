package controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import entity.Usuario;
import service.UsuarioService;

@SuppressWarnings("serial")
@Named
@SessionScoped
public class LoginController implements Serializable {

	private Usuario usuario;
	
	private boolean logado;
	
	@PostConstruct
	public void init() {
		usuario = new Usuario();
	}
	
	@Inject
	private UsuarioService usuarioService;
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void login() {
		usuario = usuarioService.pesquisarPorNomeSenha(usuario);
		if (usuario!=null) {
			logado = true;
			FacesContext.getCurrentInstance()
			.getApplication().getNavigationHandler()
			.handleNavigation(FacesContext.getCurrentInstance(), 
					null, 
					"/cadastro/pessoa.xhtml");
		} else {
			usuario = new Usuario();
			logado = false;
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, 
	    			"Usuário ou senha inválidos!",  null);
	        FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}
	
	public void logout() {
		logado = false;
		usuario = new Usuario();
		FacesContext.getCurrentInstance()
		.getApplication().getNavigationHandler()
		.handleNavigation(FacesContext.getCurrentInstance(), 
				null, 
				"/login.xhtml");
	}

	public boolean isLogado() {
		return logado;
	}

}

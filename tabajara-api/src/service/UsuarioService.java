package service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.User;
import util.CritpoUtil;

@Named
@ApplicationScoped
public class UsuarioService {
	
	@Inject
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public User pesquisarPorNomeSenha(User usuario) {
		
		entityManager.
		
		Query q = entityManager.createNamedQuery(User.FIND_BY_USERNAME_SENHA);
		
		q.setParameter("username", usuario.getUsername());
		
		q.setParameter("senha", CritpoUtil.stringParaMd5(usuario.getSenha()));
		
		List<User> usuarios = q.getResultList();
		
		User usuarioRetorno = null;
		
		if (usuarios.size()==1) {
			usuarioRetorno = usuarios.get(0);
		}
		
		//return (Usuario) q.getSingleResult();
		
		return usuarioRetorno;
	}
	
}

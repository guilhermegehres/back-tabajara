package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.xml.bind.DatatypeConverter;

import dto.OpcionalDTO;
import dto.UserDTO;
import model.Opcional;
import model.User;

@RequestScoped
public class UserService extends AbstractService<User> {

	@Inject
	private EntityManager em;

	@Override
	public UserDTO get(Integer id){
		try{
			Query q = em.createNamedQuery("User.findById");
			q.setParameter("id", id);
			User u = (User)q.getSingleResult();
			UserDTO dto = new UserDTO();
			dto.setValues(u);
			return dto;
		}catch(Exception e){
			return new UserDTO();
		}
	}
	
	public User getByEmail(String email){
		try{
			Query q = em.createNamedQuery("User.getByEmail");
			q.setParameter("email", email);
			return (User)q.getSingleResult();
		}catch(Exception e){
			return new User();
		}
	}

	@Override
	public List<User> getList(){
		try{
			Query q = em.createNamedQuery("User.getAll");
			return q.getResultList();
		}catch(Exception e){
			return new ArrayList<User>();
		}
	}
	
	@Transactional
	public User getLogin(String email, String senha){
		 try {
            Query query = em.createNamedQuery("User.getByLogin");
            query.setParameter("email", email).setParameter("senha", senha);
            User userLogged = (User) query.getSingleResult();
            if (userLogged != null) {
                userLogged.setToken(DatatypeConverter.printBase64Binary(
                        (email + ":" + (new Date().getTime() + 1800)).getBytes())
                );
                em.persist(userLogged);

                return userLogged;
            }
            return null;
        } catch (Exception e) {
            return new User();
	    }
	}

	@Override
	public Class<User> myClass() {
		return User.class;
	}
	
	public boolean validaToken(String token){
		String[] tokenHeader = token.split(":");
		User u = this.getByEmail(tokenHeader[0]);
		String tokenBd = new String(DatatypeConverter.parseBase64Binary(u.getToken()));
		String[] tokenBdFormatted = tokenBd.split(":");
		if(Long.parseLong(tokenBdFormatted[1]) > Long.parseLong(tokenHeader[1])){
			return true;
		}
		
		return false;
	}

	@Override
	public String validator(User t) {
		// TODO Auto-generated method stub
		List<User> usuarios = null;
		try{
		// validar se o usuario cm este email j� existe
		Query query = em.createNamedQuery("User.getByEmail"); 
		query.setParameter("email", t.getEmail());
		
		
		usuarios =  query.getResultList();
		}
		catch (Exception e) {
			e.printStackTrace();
			return "{\"msg\":\"Erro ao inserir\"}";
		}
		
		if (usuarios.isEmpty()) {
			return null;
		} else{
		
		return "{\"msg\":\"Email j� existe\"}";
		}
		
	}
	
}

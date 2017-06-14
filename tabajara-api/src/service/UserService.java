package service;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.User;

@RequestScoped
public class UserService extends AbstractService<User> {

	@Inject
	private EntityManager em;

	@Override
	public User get(Integer id){
		Query q = em.createNamedQuery("User.findById");
		q.setParameter("id", id);
		return (User)q.getSingleResult(); 
	}

	@Override
	public List<User> getList(){
		Query q = em.createNamedQuery("User.getAll");
		return q.getResultList(); 
	}

	@Override
	public Class<User> myClass() {
		return User.class;
	}
}

package service;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Aluguel;

@RequestScoped
public class AluguelService extends AbstractService<Aluguel>{

	@Inject
	private EntityManager em;
	
	@Override
	public Aluguel get(Integer id){
		Query q = em.createNamedQuery("Aluguel.findById");
		q.setParameter("id", id);
		return (Aluguel)q.getSingleResult(); 
	}
	
	@Override
	public List<Aluguel> getList(){
		Query q = em.createNamedQuery("Aluguel.getAll");
		return q.getResultList(); 
	}
	
	@Override
	public Class<Aluguel> myClass() {
		// TODO Auto-generated method stub
		return Aluguel.class;
	}

}

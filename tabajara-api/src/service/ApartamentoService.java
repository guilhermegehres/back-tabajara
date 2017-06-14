package service;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.Query;
import javax.persistence.EntityManager;

import model.Apartamento;

@RequestScoped
public class ApartamentoService extends AbstractService<Apartamento> {
	
	@Inject
	private EntityManager em;
	
	public Apartamento get(Integer id){
		Query q = em.createNamedQuery("Apartamento.findById");
		q.setParameter("id", id);
		return (Apartamento)q.getSingleResult(); 
	}
	
	public List<Apartamento> getList(){
		Query q = em.createNamedQuery("Apartamento.getAll");
		return  q.getResultList(); 
	}

	@Override
	public Class<Apartamento> myClass() {
		return Apartamento.class;
	}

}

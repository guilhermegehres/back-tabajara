package service;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Opcional;

@RequestScoped
public class OpcionalService extends AbstractService<Opcional> {

	@Inject
	private EntityManager em;
	
	//private List<ApartamentoDTO> apartamentos;
	
	public Opcional get(Integer id){
		Query q = em.createNamedQuery("Opcional.findById");
		q.setParameter("id", id);
		return (Opcional)q.getSingleResult(); 
	}
	
	public List<Opcional> getList(){
		Query q = em.createNamedQuery("Opcional.getAll");
		return q.getResultList(); 
	}

	@Override
	public Class<Opcional> myClass() {
		return Opcional.class;
	}
}

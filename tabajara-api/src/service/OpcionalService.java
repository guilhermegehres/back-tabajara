package service;

import java.util.ArrayList;
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
		try{
			Query q = em.createNamedQuery("Opcional.findById");
			q.setParameter("id", id);
			return (Opcional)q.getSingleResult();
		}catch(Exception e){
			return new Opcional();
		}
	}
	
	public List<Opcional> getList(){
		try{
			Query q = em.createNamedQuery("Opcional.getAll");
			return q.getResultList();
		}catch(Exception e){
			return new ArrayList<Opcional>();
		}
	}

	@Override
	public Class<Opcional> myClass() {
		return Opcional.class;
	}
}

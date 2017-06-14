package service;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Reserva;

@RequestScoped
public class ReservaService extends AbstractService<Reserva>{
	
	@Inject
	private EntityManager em;
	
	//private List<ApartamentoDTO> apartamentos;
	
	public Reserva get(Integer id){
		Query q = em.createNamedQuery("Reserva.findById");
		q.setParameter("id", id);
		return (Reserva)q.getSingleResult(); 
	}
	
	public List<Reserva> getList(){
		Query q = em.createNamedQuery("Reserva.getAll");
		return q.getResultList(); 
	}

	@Override
	public Class myClass() {
		return Reserva.class;
	}

}

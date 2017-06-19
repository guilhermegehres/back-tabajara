package service;

import java.util.ArrayList;
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
		try{
			Query q = em.createNamedQuery("Reserva.findById");
			q.setParameter("id", id);
			return (Reserva)q.getSingleResult();
		}catch(Exception e){
			return new Reserva();
		}
	}
	
	public List<Reserva> getList(){
		try{
			Query q = em.createNamedQuery("Reserva.getAll");
			return q.getResultList();
		}catch(Exception e){
			return new ArrayList<Reserva>();
		}
	}

	@Override
	public Class myClass() {
		return Reserva.class;
	}

}

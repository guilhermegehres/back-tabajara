package service;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.Query;
import javax.persistence.EntityManager;

import dto.ApartamentoDTO;
import model.Apartamento;

@RequestScoped
public class ApartamentoService {

	@Inject
	private EntityManager em;
	
	//private List<ApartamentoDTO> apartamentos;
	
	public ApartamentoDTO getApartamento(){
		Query q = em.createNamedQuery("Apartamento.findById");
		q.setParameter("id", 1);
		return new ApartamentoDTO((Apartamento)q.getSingleResult()); 
	}
	

}

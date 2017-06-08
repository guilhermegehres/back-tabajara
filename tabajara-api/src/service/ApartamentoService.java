package service;


import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.persistence.EntityManager;

import dto.ApartamentoDTO;
import model.Apartamento;

@RequestScoped
public class ApartamentoService {

	@Inject
	private EntityManager em;
	
	//private List<ApartamentoDTO> apartamentos;
	
	public ApartamentoDTO getApartamento(Integer id){
		Query q = em.createNamedQuery("Apartamento.findById");
		q.setParameter("id", id);
		return new ApartamentoDTO((Apartamento)q.getSingleResult()); 
	}
	
	public List<ApartamentoDTO> getApartamentos(){
		Query q = em.createNamedQuery("Apartamento.getAll");
		List<ApartamentoDTO> aps = new ArrayList<ApartamentoDTO>();
		aps.addAll((ArrayList)q.getResultList());
		return aps; 
	}
	
	@Transactional
	public ApartamentoDTO createApartamento(Apartamento ap){
		em.persist(ap);
		return new ApartamentoDTO(ap);
	}
	
	@Transactional
	public ApartamentoDTO editApartamento(Apartamento ap){
		em.merge(ap);
		return new ApartamentoDTO(ap);
	}
	
	@Transactional
	public Boolean deleteApartamento(Apartamento ap){
		em.remove(em.getReference(Apartamento.class, ap.getId()));
		return true;
	}
	@Transactional
	public Boolean deleteApartamento(Integer id){
		em.remove(em.getReference(Apartamento.class, id));
		return true;
	}

}

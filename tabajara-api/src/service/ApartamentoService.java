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
public class ApartamentoService extends AbstractService<Apartamento> {

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
		List<Apartamento> rows = q.getResultList();
		List<ApartamentoDTO> result = new ArrayList<>(rows.size());
		for (Apartamento row : rows) {
		    result.add(new ApartamentoDTO(row));
		}
		return result; 
	}

	@Override
	public Class<Apartamento> myClass() {
		return Apartamento.class;
	}

}

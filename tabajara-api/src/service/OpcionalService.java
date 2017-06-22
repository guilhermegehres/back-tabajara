package service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import dto.ApartamentoDTO;
import dto.OpcionalDTO;
import model.Apartamento;
import model.Opcional;

@RequestScoped
public class OpcionalService extends AbstractService<Opcional> {

	@Inject
	private EntityManager em;
	
	//private List<ApartamentoDTO> apartamentos;
	
	public OpcionalDTO get(Integer id){
		try{
			Query q = em.createNamedQuery("Opcional.findById");
			q.setParameter("id", id);
			Opcional o = (Opcional)q.getSingleResult();
			OpcionalDTO dto = new OpcionalDTO();
			dto.setValues(o);
			return dto;
		}catch(Exception e){
			return new OpcionalDTO();
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

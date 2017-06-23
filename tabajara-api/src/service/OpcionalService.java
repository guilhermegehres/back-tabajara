package service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import dto.AbstractDTO;
import dto.OpcionalDTO;
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
	
	public List<AbstractDTO> getList(){
		try{
			Query q = em.createNamedQuery("Opcional.getAll");
			List<Opcional> list = q.getResultList();
			List<AbstractDTO> dtoList = new ArrayList<AbstractDTO>();
			for(int i = 0;i < list.size(); i++){
				Opcional o = (Opcional)list.get(i);
				OpcionalDTO dtoToInsert = new OpcionalDTO();
				//dtoToInsert = this.setAttrs(r.getUser(), r.getApartamento(), dtoToInsert);
				dtoToInsert.setValues(o);
				dtoList.add(dtoToInsert);
			}
			return dtoList;
		}catch(Exception e){
			return new ArrayList<AbstractDTO>();
		}
	}

	@Override
	public Class<Opcional> myClass() {
		return Opcional.class;
	}

	@Override
	public String validator(Opcional t) {
		// TODO Auto-generated method stub
		return "";
	}
}

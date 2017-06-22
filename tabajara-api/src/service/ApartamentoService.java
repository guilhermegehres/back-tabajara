package service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.Query;

import dto.AluguelDTO;
import dto.ApartamentoDTO;
import dto.OpcionalDTO;
import dto.UserDTO;

import javax.persistence.EntityManager;

import model.Aluguel;
import model.Apartamento;
import model.Opcional;
import model.User;

@RequestScoped
public class ApartamentoService extends AbstractService<Apartamento> {
	
	@Inject
	private EntityManager em;
	
	public ApartamentoDTO get(Integer id){
		try{
			Query q = em.createNamedQuery("Apartamento.findById");
			q.setParameter("id", id);
			Apartamento a = (Apartamento)q.getSingleResult();
			ApartamentoDTO dto = new ApartamentoDTO();
			dto = this.setAttrs(a.getOpcionais(), dto);
			dto.setValues(a);
			return dto;
		}catch(Exception e){
			return new ApartamentoDTO();
		}
	}
	
	public List<Apartamento> getList(){
		try{
			Query q = em.createNamedQuery("Apartamento.getAll");
			return  q.getResultList();
		}catch(Exception e){
			return new ArrayList<Apartamento>();
		}
	}
	
	@Override
	public Class<Apartamento> myClass() {
		return Apartamento.class;
	}
	
	private ApartamentoDTO setAttrs(List<Opcional> o, ApartamentoDTO a){
		if(o != null){
			List<OpcionalDTO> lista = new ArrayList<OpcionalDTO>();
			for(int i = 0;i < o.size(); i++){
				OpcionalDTO oDto = new OpcionalDTO();
				oDto.setValues(o.get(i));
				lista.add(oDto);
			}
			a.setOpcionais(lista);
			
		}
		return a;
	}

}

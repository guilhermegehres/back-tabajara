package service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.Query;

import dto.AbstractDTO;
import dto.AluguelDTO;
import dto.ApartamentoDTO;
import dto.OpcionalDTO;
import dto.ReservaDTO;
import dto.UserDTO;

import javax.persistence.EntityManager;

import model.Aluguel;
import model.Apartamento;
import model.Opcional;
import model.Reserva;
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
	
	public List<AbstractDTO> getList(){
		try{
			Query q = em.createNamedQuery("Apartamento.getAll");
			List<Apartamento> list = q.getResultList();
			List<AbstractDTO> dtoList = new ArrayList<AbstractDTO>();
			for(int i = 0;i < list.size(); i++){
				Apartamento a = (Apartamento)list.get(i);
				ApartamentoDTO dtoToInsert = new ApartamentoDTO();
				//dtoToInsert = this.setAttrs(r.getUser(), r.getApartamento(), dtoToInsert);
				dtoToInsert.setValues(a);
				dtoList.add(dtoToInsert);
			}
			return  dtoList;
		}catch(Exception e){
			return new ArrayList<AbstractDTO>();
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

	@Override
	public String validator(Apartamento t) {
		// TODO Auto-generated method stub
		return "";
	}

}

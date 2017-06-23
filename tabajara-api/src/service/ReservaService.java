package service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import dto.AbstractDTO;
import dto.ApartamentoDTO;
import dto.ReservaDTO;
import dto.UserDTO;
import model.Apartamento;
import model.Reserva;
import model.User;

@RequestScoped
public class ReservaService extends AbstractService<Reserva>{
	
	@Inject
	private EntityManager em;
	
	//private List<ApartamentoDTO> apartamentos;
	
	public ReservaDTO get(Integer id){
		try{
			Query q = em.createNamedQuery("Reserva.findById");
			q.setParameter("id", id);
			Reserva r = (Reserva)q.getSingleResult();
			ReservaDTO dto = new ReservaDTO();
			dto = this.setAttrs(r.getUser(), r.getApartamento(), dto);
			dto.setValues(r);
			return dto;
		}catch(Exception e){
			return new ReservaDTO();
		}
	}
	
	@Override
	public List<AbstractDTO> getList(){
		try{
			Query q = em.createNamedQuery("Reserva.getAll");
			List<Reserva> list = q.getResultList();
			List<AbstractDTO> dtoList = new ArrayList<AbstractDTO>();
			for(int i = 0;i < list.size(); i++){
				Reserva r = (Reserva)list.get(i);
				ReservaDTO dtoToInsert = new ReservaDTO();
				dtoToInsert = this.setAttrs(r.getUser(), r.getApartamento(), dtoToInsert);
				dtoToInsert.setValues(r);
				dtoList.add(dtoToInsert);
			}
			return dtoList;
		}catch(Exception e){
			return new ArrayList<AbstractDTO>();
		}
	}
	
	private ReservaDTO setAttrs(User u, Apartamento a, ReservaDTO r){
		if(u != null){
			UserDTO userDto = new UserDTO();
			userDto.setValues(u);
			r.setUser(userDto);
		}
		if(a != null){
			ApartamentoDTO apDto = new ApartamentoDTO();
			apDto.setValues(a);
			r.setApartamento(apDto);
		}
		
		return r;
	}

	@Override
	public Class myClass() {
		return Reserva.class;
	}

	@Override
	public String validator(Reserva t) {
		// TODO Auto-generated method stub
		// criar named query validando a data inicial e data final da reserva, nao pode existir nada entre elas para efetuar a reserva
		
		return "";
	}

}

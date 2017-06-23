package service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import dto.AbstractDTO;
import dto.AluguelDTO;
import dto.ApartamentoDTO;
import dto.UserDTO;
import model.Aluguel;
import model.Apartamento;
import model.User;

@RequestScoped
public class AluguelService extends AbstractService<Aluguel>{

	@Inject
	private EntityManager em;
	
	@Override
	public AluguelDTO get(Integer id){
		try{
			Query q = em.createNamedQuery("Aluguel.findById");
			q.setParameter("id", id);
			Aluguel a = (Aluguel)q.getSingleResult();
			AluguelDTO dto = new AluguelDTO();
			dto = this.setAttrs(a.getUser(), a.getApartamento(), dto);
			dto.setValues(a);
			return dto;
		}catch(Exception e){
			return new AluguelDTO();
		}
	}
	
	@Override
	public List<AbstractDTO> getList(){
		try{
			Query q = em.createNamedQuery("Aluguel.getAll");
			List<Aluguel> list = q.getResultList();
			List<AbstractDTO> dtoList = new ArrayList<AbstractDTO>();
			for(int i = 0;i < list.size(); i++){
				Aluguel a = (Aluguel)list.get(i);
				AluguelDTO dtoToInsert = new AluguelDTO();
				dtoToInsert = this.setAttrs(a.getUser(), a.getApartamento(), dtoToInsert);
				dtoToInsert.setValues(a);
				dtoList.add(dtoToInsert);
			}
			return dtoList;
		}catch(Exception e){
			return new ArrayList<AbstractDTO>();
		}
	}
	
	@Override
	public Class<Aluguel> myClass() {
		// TODO Auto-generated method stub
		return Aluguel.class;
	}
	
	private AluguelDTO setAttrs(User u, Apartamento a, AluguelDTO r){
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

}

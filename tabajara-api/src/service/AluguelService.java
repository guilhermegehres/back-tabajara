package service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import dto.AluguelDTO;
import dto.ApartamentoDTO;
import dto.ReservaDTO;
import dto.UserDTO;
import model.Aluguel;
import model.Apartamento;
import model.Reserva;
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
	public List<Aluguel> getList(){
		try{
			Query q = em.createNamedQuery("Aluguel.getAll");
			return q.getResultList();
		}catch(Exception e){
			return new ArrayList<Aluguel>();
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

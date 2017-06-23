package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.xml.bind.DatatypeConverter;

import dto.AbstractDTO;
import dto.AluguelDTO;
import dto.ApartamentoDTO;
import dto.OpcionalDTO;
import dto.ReservaDTO;
import dto.UserDTO;
import model.Aluguel;
import model.Apartamento;
import model.Opcional;
import model.Reserva;
import model.User;

@RequestScoped
public class UserService extends AbstractService<User> {

	@Inject
	private EntityManager em;

	@Override
	public UserDTO get(Integer id){
		try{
			Query q = em.createNamedQuery("User.findById");
			q.setParameter("id", id);
			User u = (User)q.getSingleResult();
			UserDTO dto = new UserDTO();
			dto.setValues(u);
			return dto;
		}catch(Exception e){
			return new UserDTO();
		}
	}
	
	public User getByEmail(String email){
		try{
			Query q = em.createNamedQuery("User.getByEmail");
			q.setParameter("email", email);
			return (User)q.getSingleResult();
		}catch(Exception e){
			return new User();
		}
	}

	@Override
	public List<AbstractDTO> getList(){
		//try{
			Query q = em.createNamedQuery("User.getAll");
			List<User> list = q.getResultList();
			List<AbstractDTO> dtoList = new ArrayList<AbstractDTO>();
			for(int i = 0;i < list.size(); i++){
				User u = (User)list.get(i);
				UserDTO dtoToInsert = new UserDTO();
				//dtoToInsert = this.setAttrs(u.getAlugueis(), u.getReserva(), dtoToInsert);
				dtoToInsert.setValues(u);
				dtoList.add(dtoToInsert);
			}
			return dtoList;
		//}catch(Exception e){
		//	return new ArrayList<AbstractDTO>();
		//}
	}
	
	public UserDTO setAttrs(List<Aluguel> a, List<Reserva> r, UserDTO dto){
		if(a != null && a.size() > 0){
			List<AluguelDTO> listDto = new ArrayList<AluguelDTO>();
			for(int i = 0;i < a.size(); i++){
				AluguelDTO al = new AluguelDTO();
				al.setValues(a.get(i));
				listDto.add(al);
			}
			dto.setAlugueis(listDto);
		}
		if(r != null && r.size() > 0){
			List<ReservaDTO> listDto = new ArrayList<ReservaDTO>();
			for(int i = 0;i < r.size(); i++){
				ReservaDTO al = new ReservaDTO();
				al.setValues(r.get(i));
				listDto.add(al);
			}
			dto.setReservas(listDto);
		}
		return dto;
	}
	
	@Transactional
	public User getLogin(String email, String senha){
		 try {
            Query query = em.createNamedQuery("User.getByLogin");
            query.setParameter("email", email).setParameter("senha", senha);
            User userLogged = (User) query.getSingleResult();
            if (userLogged != null) {
                userLogged.setToken(DatatypeConverter.printBase64Binary(
                        (email + ":" + (new Date().getTime() + 1800)).getBytes())
                );
                em.persist(userLogged);

                return userLogged;
            }
            return null;
        } catch (Exception e) {
            return new User();
	    }
	}

	@Override
	public Class<User> myClass() {
		return User.class;
	}
	
	public boolean validaToken(String token){
		String[] tokenHeader = token.split(":");
		User u = this.getByEmail(tokenHeader[0]);
		String tokenBd = new String(DatatypeConverter.parseBase64Binary(u.getToken()));
		String[] tokenBdFormatted = tokenBd.split(":");
		if(Long.parseLong(tokenBdFormatted[1]) > Long.parseLong(tokenHeader[1])){
			return true;
		}
		
		return false;
	}
	
}

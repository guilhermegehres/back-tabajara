package api;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import com.google.gson.Gson;
import dto.AbstractDTO;
import dto.UserDTO;
import model.User;
import service.AbstractService;
import service.UserService;

@RequestScoped
@Path("/user")
@Produces({"application/json;charset=UTF-8"})
public class UserResource extends AbstractResource<User>{
	
	@Inject
	private UserService uService; 

	@Override
	public Class<User> myClass() {
		// TODO Auto-generated method stub
		return User.class;
	}

	@Override
	public AbstractService<User> myService() {
		// TODO Auto-generated method stub
		return uService;
	}

	@Override
	public AbstractDTO<User> myDto() {
		// TODO Auto-generated method stub
		return new UserDTO();
	}
	
	@POST
	@Produces({ "application/json"})
	@Consumes({ "application/json"})
	@Path("/login")
	public UserDTO getLogin(String userJson){
		Gson gson = new Gson();
		User user = gson.fromJson(userJson, myClass());
		User userToken = uService.getLogin(user.getEmail(), user.getSenha());
		UserDTO dto = new UserDTO();
		dto.setValues(userToken);
		return dto;
	}

}

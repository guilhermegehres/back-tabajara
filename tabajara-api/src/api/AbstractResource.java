package api;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.google.gson.Gson;

import dto.AbstractDTO;
import model.AbstractModel;
import service.AbstractService;

public abstract class AbstractResource<T> {
	
	public abstract Class<T> myClass();
	
	public abstract AbstractService<T> myService();
	
	public abstract AbstractDTO<T> myDto();
	
	@GET
	@Produces({ "application/json"})
	@Path("/{id}")
	public List<AbstractDTO<T>> get(@PathParam("id") String id){
		AbstractDTO<T> dto = myDto();
		dto.setValues(myService().get(Integer.parseInt(id)));
		List gambiarra = new ArrayList<AbstractDTO<T>>();
		gambiarra.add(dto);
		return gambiarra;
	};
	
	@GET
	@Produces({ "application/json"})
	public List<AbstractDTO<T>> getList(){
		List<T> list = myService().getList();
		List dtoList = new ArrayList<AbstractDTO<T>>();
		for(int i = 0;i < list.size(); i++){
			AbstractDTO<T> dtoToInsert = myDto();
			dtoToInsert.setValues((T)list.get(i));
			dtoList.add(dtoToInsert);
		}
		return dtoList;
	};
	
	@POST
	@Produces({ "application/json"})
	@Consumes({ "application/json"})
	public String store(String jsonString){
		try{
			Gson gson = new Gson();
			T model = gson.fromJson(jsonString, myClass());
			return gson.toJson(myService().create(model), myClass());
		}catch(Exception e){
			return e.getMessage();
		}
	}
	
	@PUT
	@Produces({ "application/json"})
	@Consumes({ "application/json"})
	@Path("/{id}")
	public String editApartamento(String jsonString, @PathParam("id") String id){
		try{
			Gson gson = new Gson();
			AbstractModel<T> model = (AbstractModel<T>)gson.fromJson(jsonString, myClass());
			model.setId(Integer.parseInt(id));
			return gson.toJson(myService().edit(model), myClass());
		}catch(Exception e){
			return e.getMessage();
		}
	}
	
	@DELETE
	@Produces({ "application/json"})
	@Consumes({ "application/json"})
	@Path("/{id}")
	public String deleteApartamento(@PathParam("id") String id){
		
		try{
			Gson gson = new Gson();
			Boolean success = myService().delete(Integer.parseInt(id));
			String successJson = "{success : 'deletado com sucesso!'}";
			return gson.toJson(successJson);
		}catch(Exception e){
			return e.getMessage();
		}
	}

}

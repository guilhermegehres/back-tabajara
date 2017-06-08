package api;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import dto.ApartamentoDTO;
import dto.ReservaDTO;
import model.Apartamento;
import service.ApartamentoService;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;


@RequestScoped
@Path("/apartamento")
@Produces({"application/json;charset=UTF-8"})
//@Consumes(MediaType.APPLICATION_JSON)
public class ReservaResource {

	@Inject
	private ApartamentoService apService; 
	
	@GET
	@Produces({ "application/json"})
	public List<ReservaDTO> getApartamentos(){
		List<ReservaDTO> aps = apService.getApartamentos();
		return aps;
		
	}
	
	@GET
	@Produces({ "application/json"})
	@Path("/{id}")
	public ApartamentoDTO getApartamento(@PathParam("id") String id){
		ApartamentoDTO ap = apService.getApartamento(Integer.parseInt(id));
		return ap;
		
	}
	@POST
	@Produces({ "application/json"})
	@Consumes({ "application/json"})
	public String storeApartamento(String jsonString){
		
		try{
			Gson gson = new Gson();
			Apartamento ap = gson.fromJson(jsonString, Apartamento.class);
			ApartamentoDTO apReturn = apService.createApartamento(ap);
			return gson.toJson(apReturn, ApartamentoDTO.class);
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
			Apartamento ap = gson.fromJson(jsonString, Apartamento.class);
			ap.setId(Integer.parseInt(id));
			ApartamentoDTO apReturn = apService.editApartamento(ap);
			return gson.toJson(apReturn, ApartamentoDTO.class);
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
			Boolean success = apService.deleteApartamento(Integer.parseInt(id));
			String successJson = "{success : 'deletado com sucesso!'}";
			return gson.toJson(successJson);
		}catch(Exception e){
			return e.getMessage();
		}
	}
	
	
	
}
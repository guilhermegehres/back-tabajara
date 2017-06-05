package api;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import dto.ApartamentoDTO;
import service.ApartamentoService;

import javax.ws.rs.GET;

@RequestScoped
@Path("/apartamento")
@Produces({ "application/json", "text/plain" })
public class ApartmentoResource {

	@Inject
	private ApartamentoService apService; 
	
	@GET
	@Produces({ "application/json"})
	public ApartamentoDTO getApartamento(){
		ApartamentoDTO ap = apService.getApartamento();
		//return ap.
		return ap;
		
	}
	
	
}

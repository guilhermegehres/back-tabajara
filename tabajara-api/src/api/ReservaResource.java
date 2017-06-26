package api;


import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import dto.AbstractDTO;
import dto.ReservaDTO;
import model.Reserva;
import service.AbstractService;
import service.ReservaService;


@RequestScoped
@Path("/reserva")
@Produces({"application/json;charset=UTF-8"})
//@Consumes(MediaType.APPLICATION_JSON)
public class ReservaResource extends AbstractResource<Reserva>{

	@Inject
	private ReservaService resService; 

	@Override
	public Class<Reserva> myClass() {
		// TODO Auto-generated method stub
		return Reserva.class;
	}
	
	@GET
	@Path("/search")
	@Produces({ "application/json"})
	public List<ReservaDTO> filter(@QueryParam("search")String query){
		List<ReservaDTO> list = resService.getListSearch(query);
		return list;
	}

	@Override
	public AbstractService<Reserva> myService() {
		// TODO Auto-generated method stub
		return resService;
	}

	@Override
	public AbstractDTO<Reserva> myDto() {
		// TODO Auto-generated method stub
		return new ReservaDTO();
	}
	
}
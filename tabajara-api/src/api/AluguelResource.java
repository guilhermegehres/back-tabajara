package api;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import dto.AbstractDTO;
import dto.AluguelDTO;
import dto.ReservaDTO;
import model.Aluguel;
import service.AbstractService;
import service.AluguelService;

@RequestScoped
@Path("/aluguel")
@Produces({"application/json;charset=UTF-8"})
public class AluguelResource extends AbstractResource<Aluguel> {


	@Inject
	private AluguelService alService; 
	
	@Override
	public Class<Aluguel> myClass() {
		// TODO Auto-generated method stub
		return Aluguel.class;
	}
	
	@GET
	@Path("/search")
	@Produces({ "application/json"})
	public List<AluguelDTO> filter(@QueryParam("search")String query){
		List<AluguelDTO> list = alService.getListSearch(query);
		return list;
	}

	@Override
	public AbstractService<Aluguel> myService() {
		// TODO Auto-generated method stub
		return this.alService;
	}

	@Override
	public AbstractDTO<Aluguel> myDto() {
		// TODO Auto-generated method stub
		return new AluguelDTO();
	}

}

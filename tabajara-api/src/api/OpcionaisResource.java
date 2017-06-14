package api;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import dto.AbstractDTO;
import dto.OpcionalDTO;
import model.Opcional;
import service.AbstractService;
import service.OpcionalService;

@RequestScoped
@Path("/opcional")
@Produces({"application/json;charset=UTF-8"})
public class OpcionaisResource extends AbstractResource<Opcional> {
	
	@Inject
	private OpcionalService opService; 

	@Override
	public Class<Opcional> myClass() {
		// TODO Auto-generated method stub
		return Opcional.class;
	}

	@Override
	public AbstractService<Opcional> myService() {
		// TODO Auto-generated method stub
		return opService;
	}

	@Override
	public AbstractDTO<Opcional> myDto() {
		// TODO Auto-generated method stub
		return new OpcionalDTO();
	}

}

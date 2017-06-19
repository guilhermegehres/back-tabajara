package api;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import dto.AbstractDTO;
import dto.ApartamentoDTO;
import model.Apartamento;
import service.AbstractService;
import service.ApartamentoService;

@RequestScoped
@Path("/apartamento")
@Produces({"application/json;charset=UTF-8"})
//@Consumes(MediaType.APPLICATION_JSON)
public class ApartmentoResource extends AbstractResource<Apartamento> {

	@Inject
	private ApartamentoService apService; 
	
	@Override
	public Class<Apartamento> myClass() {
		// TODO Auto-generated method stub
		return Apartamento.class;
	}

	@Override
	public AbstractService<Apartamento> myService() {
		// TODO Auto-generated method stub
		return this.apService;
	}

	@Override
	public AbstractDTO<Apartamento> myDto() {
		// TODO Auto-generated method stub
		return new ApartamentoDTO();
	}
}

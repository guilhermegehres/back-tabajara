package converter;

import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;

import entity.Estado;
import service.EstadoService;

@Named
@FacesConverter(value = "estadoConverter")
@RequestScoped
public class EstadoConverter implements Converter {

	@Inject
	private EstadoService estadoService;
	
	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {

		if (value == null || value.isEmpty()) {
			return null;
		}

		try {
			Object obj = estadoService
					.pesquisarEstadoPorId(Integer.valueOf(value));
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent component, Object value) {

		if (!(value instanceof Estado)) {
			return null;
		}

		String s = String.valueOf(((Estado) value).getId());
		return s;

	}

}

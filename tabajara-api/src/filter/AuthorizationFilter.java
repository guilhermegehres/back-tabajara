package filter;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.xml.bind.DatatypeConverter;

import model.User;
import service.UserService;

public class AuthorizationFilter implements Filter {

	@Inject
	private UserService uService;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)throws IOException, ServletException {

	    chain.doFilter(request, response);
	    /*
		HttpServletRequest httpR = (HttpServletRequest) request;
		
		HttpServletResponse resp = (HttpServletResponse) response;
		
		String path = httpR.getRequestURI();
		
		if (path.startsWith("/tabajara-api/api/user/login")) {
		    chain.doFilter(request, response);
		}
		
		try{

			//pega o valor do header
			String auth = httpR.getHeader("Authorization");
			//converte o token do header pra binary e instancia uma nova string com esse binario
			String token = new String(DatatypeConverter.parseBase64Binary(auth));
			//da split na string que gerou gerando tokenheader[0] == email && tokenheadr[1] == segundos

			if(uService.validaToken(token)){
				resp.setStatus(401);
				resp.setContentType("application/json");
				resp.getWriter().write("{\"msg\" : \"token invalido\"}");
				resp.getWriter().flush();
				resp.getWriter().close();
				return;
			}

			chain.doFilter(request, response);
		}
		catch(Exception e){
			resp.setStatus(500);
			resp.setContentType("application/json");
			resp.getWriter().write("{\"msg\" : \"token invalido\"}");
			resp.getWriter().flush();
			resp.getWriter().close();
		}
		*/
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}

package endPoints;
 

import javax.ws.rs.GET;  
import javax.ws.rs.Path;  
  
@Path("ola")  
public class RecursoOla {  
  
   @GET 
   public String digaOla() {  
	   String alici = "<b>ai tomar no cu</b>";
      return "oi<br>"+alici;  
   }  
}  
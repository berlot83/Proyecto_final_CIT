package data_access_object;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/authentication")
public class AutenticarUsuario {

		//Esta clase debería ser estática y ser llamada antes del pedido de token.
		//En este caso será necesario un .html o .jsp con formulario>, si no se tiene cambiar anotación a @GET
	    @POST
	    @Produces("application/json")
	    @Consumes("application/x-www-form-urlencoded")
	    public Response authenticateUser(@FormParam("usuario") String username, 
	                                     @FormParam("pass") String password){
	    	Response resp= null;
	    	
		    	try{
		    	
		    		//Acá falta código
		    		//Falta un métedo para autenticar usuario y contraseña
		    		//Falta código de Token
		    		//Falta código de retorno Response.builter del Token
		    		
		    	resp = Response.status(200).build();
		    	}
		    	catch(Exception e)
		    	{
		    		System.out.println("No tiene autorización para ingresar.");
		    		resp= Response.status(401).build();
		    	}
	    	
	    	return resp;
	    }
	
}

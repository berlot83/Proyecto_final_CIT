package data_access_object;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/authentication")
public class AutenticarUsuario {

		//Esta clase deber�a ser est�tica y ser llamada antes del pedido de token.
		//En este caso ser� necesario un .html o .jsp con formulario>, si no se tiene cambiar anotaci�n a @GET
	    @POST
	    @Produces("application/json")
	    @Consumes("application/x-www-form-urlencoded")
	    public Response authenticateUser(@FormParam("usuario") String username, 
	                                     @FormParam("pass") String password){
	    	Response resp= null;
	    	
		    	try{
		    	
		    		//Ac� falta c�digo
		    		//Falta un m�tedo para autenticar usuario y contrase�a
		    		//Falta c�digo de Token
		    		//Falta c�digo de retorno Response.builter del Token
		    		
		    	resp = Response.status(200).build();
		    	}
		    	catch(Exception e)
		    	{
		    		System.out.println("No tiene autorizaci�n para ingresar.");
		    		resp= Response.status(401).build();
		    	}
	    	
	    	return resp;
	    }
	
}

package data_access_object;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.sun.research.ws.wadl.Request;

import aeropuerto_empleados.Administrador;

@Path("/validacion")
public class AutenticarUsuario {

		//Esta clase debería ser estática y ser llamada antes del pedido de token.
		//En este caso será necesario un .html o .jsp con formulario>, si no se tiene cambiar anotación a @GET
	    @GET
	    @Produces("application/json")
	    @Consumes("application/x-www-form-urlencoded")
	    public Response autenticarUsuario(@QueryParam("usuario") String usuario, @QueryParam("pass") String pass){
	    	
	    	Response resp= null;
	    	String str_usuario= null;
	    	String str_pass= null;
	    	
		    	try{
		    		
		    		ConexionAeropuerto c= new ConexionAeropuerto();
					Connection con= c.connectarAhora();
					
					if(con != null)
					{
						Statement st;
						st=con.createStatement();
						ResultSet rs= st.executeQuery("select usuario, pass from administradores where id=89");
						
						while(rs.next())
						{
							str_usuario= rs.getString("usuario"); 
							str_pass= rs.getString("pass");
									
						}
						
								if(usuario.equals(str_usuario) && pass.equals(str_pass))
								{
									System.out.println("Usuario: " + usuario + " Correcto.");
									System.out.println("Password: " + pass + " Correcta.");
								}
					 }
		    		
		    	
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
	    
	    
	    public void autenticar(String usuario, String pass){
	    	
	    }
	
}

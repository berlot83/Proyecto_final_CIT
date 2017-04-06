package org.comunidadIT.proyecto.accesoDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/validacionAdminVuelos")
public class AutenticarAdministradorVuelo {
	
	//Esta clase debería ser estática y ser llamada antes del pedido de token.
	//En este caso será necesario un .html o .jsp con formulario>, si no se tiene cambiar anotación a @GET
    @POST
    @Produces("application/json")
    @Consumes("application/x-www-form-urlencoded")
    public static boolean autenticarAdministradorVuelo(@FormParam("usuario") String usuario, @FormParam("pass") String pass){
    	
    	//Response resp= null;
    	String str_usuario= null;
    	String str_pass= null;
    	boolean autorizado= false;
    	
	    	try{
	    		
	    		ConexionAeropuerto c= new ConexionAeropuerto();
				Connection con= c.connectarAhora();
				
				if(con != null )
				{
					Statement st;
					st=con.createStatement();
					ResultSet rs= st.executeQuery("select usuario, pass from administradores where usuario= '" + usuario + "' and pass= '" + pass + "' and tipo_admin= 'adminVuelos' ");
					
					while(rs.next())
					{
						str_usuario= rs.getString("usuario"); 
						str_pass= rs.getString("pass");
								
					}
					
							if(usuario.equals(str_usuario) && pass.equals(str_pass))
							{
								System.out.println("Usuario: " + usuario + " Correcto.");
								System.out.println("Password: " + pass + " Correcta.");
								autorizado= true;
							}
				 }
	    		
	    	
	    		//Acá falta código
	    		//Falta un métedo para autenticar usuario y contraseña
	    		//Falta código de Token
	    		//Falta código de retorno Response.builter del Token
	    		
					Response.status(200).build();
	    	}
	    	catch(Exception e)
	    	{
	    		System.out.println("No tiene autorización para ingresar.");
	    		Response.status(401).build();
	    	}
    	
    	return autorizado;
    }

}


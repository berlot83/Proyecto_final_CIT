package org.comunidadIT.proyecto.accesoDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.comunidadIT.proyecto.validaciones.ValidarTokenSuperAdmin;

@Path("/validacionSuperAdmin")
public class AutenticarSuperAdministrador {
	
	
	//El 'token' funciona con el reloj de la máquina, hay que ingresar "yyyy-MM-dd-HH-mm" incluyendo los guiones centrales, Las HH expresadas en 24hs siempre, si son las 4 pm, colocar 16, y controlar que no cambie el minutero de la pc.
    @POST
    @Produces("application/json")
    @Consumes("application/x-www-form-urlencoded")
    public static boolean autenticarSuperAdministrador(@FormParam("usuario") String usuario, @FormParam("pass") String pass, @FormParam("token") String token){
    	
    	String str_usuario= null;
    	String str_pass= null;
    	int int_token=0;	//El token por DB está en deshuso y reemplazado por el dinamico por fechas que se encuentra en 'ValidarTokenSuperAdmin.java', momentaneamente la la llamada a la columna 'token' de la DB no se borrará pero quedó en deshuso.
    	boolean autorizado= false;
    	
	    	try{
	    		
	    		ConexionAeropuerto c= new ConexionAeropuerto();
				Connection con= c.connectarAhora();
				
				if(con != null)
				{
					Statement st;
					st=con.createStatement();
					ResultSet rs= st.executeQuery("SELECT * FROM super_administradores WHERE usuario= '" + usuario + "' and pass= '" + pass + "' ");
					
					while(rs.next())
					{
						str_usuario= rs.getString("usuario"); 
						str_pass= rs.getString("pass");
						int_token= rs.getInt("token");	//El token por DB está en deshuso y reemplazado por el dinamico por fechas que se encuentra en 'ValidarTokenSuperAdmin.java', momentaneamente la la llamada a la columna 'token' de la DB no se borrará pero quedó en deshuso.
								
					}
					
							if(usuario.equals(str_usuario) && pass.equals(str_pass) && ValidarTokenSuperAdmin.validarTokenSuperAdminFecha(token)==true)
							{
								System.out.println("Usuario: " + usuario + " Correcto.");
								System.out.println("Password: " + pass + " Correcta.");
								System.out.println("Token: " + token + " correcto.");
								autorizado= true;
							}
							
							else
							{
								System.out.println("no hay coincidencias");
							}
				 }
	    		
	    	
	    		//Acá falta código
	    		//Falta un métedo para autenticar usuario y contraseña
	    		//Falta código de Token
	    		
	    		
	    	}
	    	catch(Exception e)
	    	{
	    		System.out.println("No tiene autorización para ingresar.");
	    	}
    	
    	return autorizado;
    }

}

package org.comunidadIT.proyecto.controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.comunidadIT.proyecto.accesoDatos.AutenticarSuperAdministrador;
import org.comunidadIT.proyecto.accesoDatos.ConexionAeropuerto;

@Path("/superAdministrador")
public class SuperAdmin {

	@DELETE
	@Path("/deleteAdministrador")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String deleteAdministrador(@FormParam("usuario") String usuario, @FormParam("pass") String pass, @FormParam("token") int token, @FormParam("id") int id){
		
		String respuestaServidor=null;
		
		try{
			ConexionAeropuerto c= new ConexionAeropuerto();
			Connection con= c.connectarAhora();
			
			if(con != null && AutenticarSuperAdministrador.autenticarSuperAdministrador(usuario, pass, token)==true)
		
			{
				if(usuario.equalsIgnoreCase("") && pass.equalsIgnoreCase(""))
				
				{
					System.out.println("Algo falló y no se realizaron las consultas.");
					return "No se pudo borrar el registro seleccionado.\nPuede que las credenciales no sean correctas.";
				}
			else
				{
					PreparedStatement ps;
					String sql= "DELETE FROM administradores WHERE id=?";
					ps= con.prepareStatement(sql);
					ps.setInt(1, id);
					ps.executeUpdate();
					ps.close();
			
					System.out.println("Los datos del admin seleccionado junto con su BD se han borrado con éxito.");
					return respuestaServidor="El registro se ha eliminado con éxito.";
				}
			}
		else
			{
				return respuestaServidor="Esos campos no puede quedar en blanco o las credenciales no son correctas";
			}

		}
		catch(Exception e)
		{
			System.out.println("No se pudo conectar a la db o no tiene acceso");
		}
		 return respuestaServidor;
	}
	
	
	@POST
	@Path("/agregarAdministrador")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String agregarAdministrador(@FormParam("usuario") String usuario, @FormParam("pass") String pass, @FormParam("token") int token, @FormParam("tipoAdministrador") String tipoAdministrador, @FormParam("nombre") String nombre, @FormParam("apellido") String apellido, @FormParam("usuarioNuevoAdmin") String usuarioNuevoAdmin, @FormParam("passNuevoAdmin") String passNuevoAdmin, @FormParam("email") String email, @FormParam("direccion") String direccion){
		
		String respuestaServidor=null;
		
		try{
			ConexionAeropuerto c= new ConexionAeropuerto();
			Connection con= c.connectarAhora();
			
			if(con!=null && AutenticarSuperAdministrador.autenticarSuperAdministrador(usuario, pass, token)==true)
		
			{
				if(usuario.equalsIgnoreCase("") && pass.equalsIgnoreCase(""))
				
				{
					System.out.println("Algo falló y no se realizaron las consultas.");
					return "No se pudo insertar el registro seleccionado.\nPuede que las credenciales no sean correctas.";
				}
			else
				{
				PreparedStatement ps;
				String sql="INSERT INTO administradores(tipo_admin, nombre, apellido, usuario, pass, email, direccion) VALUES(?, ?, ?, ?, ?, ?, ?)";
				ps= con.prepareStatement(sql);
					ps.setString(1, tipoAdministrador);
					ps.setString(2, nombre);
					ps.setString(3, apellido);
					ps.setString(4, usuarioNuevoAdmin);
					ps.setString(5, passNuevoAdmin);
					ps.setString(6, email);
					ps.setString(7, direccion);
					ps.executeUpdate();
					ps.close();
			
					System.out.println("Los datos del admin seleccionado junto con su BD se han insertado con éxito.");
					return respuestaServidor="El registro se ha insertado con éxito.";
				}
			}
		else
			{
				return respuestaServidor="Esos campos no puede quedar en blanco o las credenciales no son correctas";
			}

	}
		catch(Exception e)
		{
			System.out.println("No se pudo conectar a la db o no tiene acceso.");
			e.printStackTrace();
		}
		 return respuestaServidor;
	}
	
	
}

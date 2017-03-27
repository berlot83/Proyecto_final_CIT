package org.comunidadIT.proyecto.controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.comunidadIT.proyecto.accesoDatos.AutenticarSuperAdministrador;
import org.comunidadIT.proyecto.accesoDatos.ConexionAeropuerto;
/*import org.comunidadIT.proyecto.accesoDatos.SeguridadToken;*/
import org.comunidadIT.proyecto.entidades.Administrador;
import org.comunidadIT.proyecto.entidades.SuperAdministrador;

import com.google.gson.Gson;

@Path("/superAdministrador")
public class AccionesSuperAdmin {

	@POST
	@Path("/deleteAdministrador")
	@Produces(MediaType.TEXT_HTML)
	public String deleteAdministrador(@FormParam("usuario") String usuario, @FormParam("pass") String pass, @FormParam("usuarioAdmin") String usuarioAdmin){
		
		Gson gson= new Gson();
		ArrayList<SuperAdministrador> listado= new ArrayList<>();
		String index= "index.jsp";
		String JsonToString= null;
		
		try{
			ConexionAeropuerto c= new ConexionAeropuerto();
			Connection con= c.connectarAhora();
			
			if(con!= null && usuario.equalsIgnoreCase("") && pass.equalsIgnoreCase("") && AutenticarSuperAdministrador.autenticarSuperAdministrador(usuario, pass))
		
			{
				PreparedStatement ps;
				String sql= "delete from administradores where usuario=?";
				ps= con.prepareStatement(sql);
				ps.setString(1, usuarioAdmin);
				ps.executeUpdate();
				ps.close();
				
				PreparedStatement dropTable = con.prepareStatement(
				String.format("DROP TABLE IF EXISTS empleados_"+usuarioAdmin, "features"));
				dropTable.execute();
		
				System.out.println("Los datos del admin seleccionado junto con su BD se han borrado con éxito.");
				
				
				listado.add(new SuperAdministrador(usuarioAdmin,index));
				JsonToString=  gson.toJson(listado);
				Response.status(200).build();
			}
			else
			{
				System.out.println("Algo falló y no se realizaron las consultas.");
				MetodosResponse.UNAUTHORIZED();	  //ResponseBuilder 401
				return "No se pudo borrar el registro seleccionado";
			}
			
		}
		catch(Exception e)
		{
			System.out.println("No se pudo conectar a la db o no tiene acceso");
			Response.status(401).build();
		}
		
		 return JsonToString;
	}
	
	
}

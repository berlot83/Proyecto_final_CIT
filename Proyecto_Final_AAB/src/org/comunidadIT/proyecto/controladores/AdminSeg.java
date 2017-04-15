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

import org.comunidadIT.proyecto.accesoDatos.AutenticarAdministradorSeguridad;
import org.comunidadIT.proyecto.accesoDatos.AutenticarAdministradorVuelo;
import org.comunidadIT.proyecto.accesoDatos.ConexionAeropuerto;

@Path("/adminSeg")
public class AdminSeg {
	
	@POST
	@Path("/verServicios")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String verServicios(@FormParam("usuario") String usuario, @FormParam("pass") String pass){
		
		return"";
	}
	
	@POST
	@Path("/agregarServicio")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String agregarServicio(@FormParam("usuario") String usuario, @FormParam("pass") String pass, @FormParam("nombre") String nombre, @FormParam("estadoServicio") int estadoServicio){
		
		String respuesta= null;
		
		try
		{
			ConexionAeropuerto c= new ConexionAeropuerto();
			Connection con= c.connectarAhora();
			
			if(con != null && AutenticarAdministradorSeguridad.autenticarAdministradorSeguridad(usuario, pass)==true){	
				PreparedStatement ps;
				String sql="INSERT INTO servicios(nombre, activo) values(?,?)";
				ps= con.prepareStatement(sql);
				ps.setString(1, nombre);
				ps.setInt(2, estadoServicio);
				ps.executeUpdate();
				ps.close();
				
				return respuesta="La insercción se realizó exitosamente.";
			}
			else
				{
					return respuesta="No se realizó la consulta, verifique su usuario y pass ingresados.";
				}
			}
		catch(Exception e)
		{
			respuesta="No es posible conectarse con la DB";
		}
		
		return respuesta;
	}
	
	@DELETE
	@Path("/eliminarServicio")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String eliminarServicio(@FormParam("usuario") String usuario, @FormParam("pass") String pass){
		
		return"";
	}
	
	@POST
	@Path("/verEventos")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String verEventos(@FormParam("usuario") String usuario, @FormParam("pass") String pass){
		
		return"";
	}
	
	@POST
	@Path("/agregarEventos")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String agregarEventos(@FormParam("usuario") String usuario, @FormParam("pass") String pass){
		
		return"";
	}
	
	@DELETE
	@Path("/eliminarEventos")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String eliminarEventos(@FormParam("usuario") String usuario, @FormParam("pass") String pass){
		
		return"";
	}
	
	@POST
	@Path("/verZonas")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String verZonas(@FormParam("usuario") String usuario, @FormParam("pass") String pass){
		
		return"";
	}
	
	@POST
	@Path("/agregarZonas")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String agregarZonas(@FormParam("usuario") String usuario, @FormParam("pass") String pass){
		
		return"";
	}
	
	@DELETE
	@Path("/deleteZonas")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String deleteZonas(@FormParam("usuario") String usuario, @FormParam("pass") String pass){
		
		return"";
	}
	
	

}

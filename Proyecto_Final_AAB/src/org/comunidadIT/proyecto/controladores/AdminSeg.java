package org.comunidadIT.proyecto.controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

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
import org.comunidadIT.proyecto.entidades.Evento;
import org.comunidadIT.proyecto.entidades.Servicio;

import com.google.gson.Gson;

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
	@Path("/agregarEvento")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String agregarEventos(@FormParam("usuario") String usuario, @FormParam("pass") String pass, @FormParam("nombre") String nombre, @FormParam("fecha") String fecha){
		
		
		String respuesta= null;
		
		try
		{
			ConexionAeropuerto c= new ConexionAeropuerto();
			Connection con= c.connectarAhora();
			
			if(con != null && AutenticarAdministradorSeguridad.autenticarAdministradorSeguridad(usuario, pass)==true){	
				PreparedStatement ps;
				String sql="INSERT INTO eventos(nombre, fecha) values(?,?)";
				ps= con.prepareStatement(sql);
				ps.setString(1, nombre);
				ps.setString(2, fecha);
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
	
	@POST
	@Path("/selectServicio")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String selectServicio(){
		
		Gson gson= new Gson();
		ArrayList<Servicio> listado= new ArrayList<>();
		
		String respuesta= gson.toJson(listado);
		int int_id_servicio= 0;
		String str_nombre= null;
		
		try
		{
			ConexionAeropuerto c= new ConexionAeropuerto();
			Connection con= c.connectarAhora();
			
			if(con != null)
			{
				Statement st;
				st= con.createStatement();
				String sql= "SELECT id_servicio, nombre FROM servicios";
				ResultSet rs= st.executeQuery(sql);
				
				while(rs.next())
				{
					int_id_servicio=rs.getInt("id_servicio");
					str_nombre= rs.getString("nombre");
					
					listado.add(new Servicio(int_id_servicio, str_nombre));
				}
				return respuesta= gson.toJson(listado);
			}
			
		}
		catch(Exception e)
		{
			respuesta= "No se pudo conectar a la DB.";
		}
		
		return respuesta;
	}
	
	
	@POST
	@Path("/selectEvento")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String selectEvento(){
		
		Gson gson= new Gson();
		ArrayList<Evento> listado= new ArrayList<>();
		
		String respuesta= gson.toJson(listado);
		int int_id_evento= 0;
		String str_nombre= null;
		
		try
		{
			ConexionAeropuerto c= new ConexionAeropuerto();
			Connection con= c.connectarAhora();
			
			if(con != null)
			{
				Statement st;
				st= con.createStatement();
				String sql= "SELECT id_evento, nombre FROM eventos";
				ResultSet rs= st.executeQuery(sql);
				
				while(rs.next())
				{
					int_id_evento= rs.getInt("id_evento");
					str_nombre= rs.getString("nombre");
					
					listado.add(new Evento(int_id_evento, str_nombre));
				}
				return respuesta= gson.toJson(listado);	
			}
			
		}
		catch(Exception e)
		{
			respuesta= "No se pudo conectar a la DB.";
		}
		
		return respuesta;
	}
	
	

}

package org.comunidadIT.proyecto.controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
import org.comunidadIT.proyecto.entidades.Vuelo;
import org.comunidadIT.proyecto.entidades.Zona;
import org.comunidadIT.proyecto.validaciones.ValidarFechaEvento;

import com.google.gson.Gson;

@Path("/adminSeg")
public class AdminSeg {
	
	@POST
	@Path("/verServicios")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String verServicios(@FormParam("usuario") String usuario, @FormParam("pass") String pass){
		
		List<Servicio> listado= new ArrayList<>();
		Gson gson= new Gson();
		String	respuesta_Json= gson.toJson(listado);	
		
		int int_id_servicio =0;
		String str_nombre= null;
		boolean bool_activo;
		
		try
		{
			ConexionAeropuerto c= new ConexionAeropuerto();
			Connection con= c.connectarAhora();
			
			if(con!=null && AutenticarAdministradorSeguridad.autenticarAdministradorSeguridad(usuario, pass)==true)
			{
				Statement st;
				st= con.createStatement();
				String sql="SELECT * FROM servicios";
				ResultSet rs= st.executeQuery(sql);
				
				while(rs.next())
				{
					int_id_servicio= rs.getInt("id_servicio");
					str_nombre= rs.getString("nombre");
					bool_activo= rs.getBoolean("activo");
					
					listado.add(new Servicio(int_id_servicio, str_nombre, bool_activo));
					respuesta_Json=  gson.toJson(listado);
				}
				return respuesta_Json;
			}
			else
			{
				respuesta_Json= "La consulta no pudo ser realizada con éxito.";
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			respuesta_Json= "No pudo conectarse a la DB.";
		}
		return respuesta_Json;
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
	public String eliminarServicio(@FormParam("usuario") String usuario, @FormParam("pass") String pass, @FormParam("id_servicio") int id_servicio){
		
		String respuesta= null;
		
		try
		{
			ConexionAeropuerto c= new ConexionAeropuerto();
			Connection con= c.connectarAhora();
			
			if(con!=null && AutenticarAdministradorSeguridad.autenticarAdministradorSeguridad(usuario, pass)==true)
				{
					PreparedStatement ps;
					String sql="DELETE FROM servicios WHERE id_servicio=?";
					ps= con.prepareStatement(sql);
					ps.setInt(1, id_servicio);
					ps.executeUpdate();
					ps.close();
					
					respuesta="El servicio se ha borrado de la DB.";
				}
			else
				{
					respuesta="No se pudo borrar el servicio de la DB.";
				}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			respuesta="No se pudo conectar a la DB.";
		}
		return respuesta;
	}
	
	
	@POST
	@Path("/verEventos")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String verEventos(@FormParam("usuario") String usuario, @FormParam("pass") String pass){
		
		
		List<Evento> listado= new ArrayList<>();
		Gson gson= new Gson();
		String	respuesta_Json= gson.toJson(listado);	
		
		int int_id_evento= 0;
		String str_nombre= null;
		String str_fecha;
		
		try
		{
			ConexionAeropuerto c= new ConexionAeropuerto();
			Connection con= c.connectarAhora();
			
			if(con!=null && AutenticarAdministradorSeguridad.autenticarAdministradorSeguridad(usuario, pass)==true)
			{
				Statement st;
				st= con.createStatement();
				String sql="SELECT * FROM eventos";
				ResultSet rs= st.executeQuery(sql);
				
				while(rs.next())
				{
					int_id_evento= rs.getInt("id_evento");
					str_nombre= rs.getString("nombre");
					str_fecha= rs.getString("fecha");
					
					listado.add(new Evento(int_id_evento, str_nombre, str_fecha));
					respuesta_Json=  gson.toJson(listado);
				}
				return respuesta_Json;
			}
			else
			{
				respuesta_Json= "La consulta no pudo ser realizada con éxito.";
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			respuesta_Json= "No pudo conectarse a la DB.";
		}
		return respuesta_Json;
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
				
				if(ValidarFechaEvento.validarFechaEvento(fecha)){
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
						respuesta= "La insercción no pudo realizarse, la fecha no puede ser igual ni anterior al día corriente.";
					}
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
	@Path("/eliminarEvento")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String eliminarEventos(@FormParam("usuario") String usuario, @FormParam("pass") String pass, @FormParam("id_evento") int id_evento){
		
		
		String respuesta= null;
		
		try
		{
			ConexionAeropuerto c= new ConexionAeropuerto();
			Connection con= c.connectarAhora();
			
			if(con!=null && AutenticarAdministradorSeguridad.autenticarAdministradorSeguridad(usuario, pass)==true)
				{
					PreparedStatement ps;
					String sql="DELETE FROM eventos WHERE id_evento=?";
					ps= con.prepareStatement(sql);
					ps.setInt(1, id_evento);
					ps.executeUpdate();
					ps.close();
					
					respuesta="El evento se ha borrado de la DB.";
				}
			else
				{
					respuesta="No se pudo borrar el servicio de la DB.";
				}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			respuesta="No se pudo conectar a la DB.";
		}
		return respuesta;
	}
	
	
	@POST
	@Path("/verZonas")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String verZonas(@FormParam("usuario") String usuario, @FormParam("pass") String pass){
		
		List<Zona> listado= new ArrayList<>();
		Gson gson= new Gson();
		String	respuesta_Json= gson.toJson(listado);	
		
		int int_id_zona= 0;
		String str_nombre= null;
		boolean bool_cubierta;
		
		try
		{
			ConexionAeropuerto c= new ConexionAeropuerto();
			Connection con= c.connectarAhora();
			
			if(con!=null && AutenticarAdministradorSeguridad.autenticarAdministradorSeguridad(usuario, pass)==true)
			{
				Statement st;
				st= con.createStatement();
				String sql="SELECT * FROM zonas";
				ResultSet rs= st.executeQuery(sql);
				
				while(rs.next())
				{
					int_id_zona= rs.getInt("id_zona");
					str_nombre= rs.getString("nombre");
					bool_cubierta= rs.getBoolean("cubierta");
					
					listado.add(new Zona(int_id_zona, str_nombre, bool_cubierta));
					respuesta_Json=  gson.toJson(listado);
				}
				return respuesta_Json;
			}
			else
			{
				respuesta_Json= "La consulta no pudo ser realizada con éxito.";
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			respuesta_Json= "No pudo conectarse a la DB.";
		}
		return respuesta_Json;
	}
	
	@POST
	@Path("/agregarZona")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String agregarZonas(@FormParam("usuario") String usuario, @FormParam("pass") String pass, @FormParam("nombre") String nombre, @FormParam("cubierta") int cubierta){
		
		String respuesta= null;
		
		try
		{
			ConexionAeropuerto c= new ConexionAeropuerto();
			Connection con= c.connectarAhora();
			
			if(con != null && AutenticarAdministradorSeguridad.autenticarAdministradorSeguridad(usuario, pass)==true){
				
				
					PreparedStatement ps;
					String sql="INSERT INTO zonas(nombre, cubierta) values(?,?)";
					ps= con.prepareStatement(sql);
					ps.setString(1, nombre);
					ps.setInt(2, cubierta);
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
	@Path("/eliminarZona")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String deleteZonas(@FormParam("usuario") String usuario, @FormParam("pass") String pass, @FormParam("id_zona") int id_zona){
		
		
		String respuesta= null;
		
		try
		{
			ConexionAeropuerto c= new ConexionAeropuerto();
			Connection con= c.connectarAhora();
			
			if(con!=null && AutenticarAdministradorSeguridad.autenticarAdministradorSeguridad(usuario, pass)==true)
				{
					PreparedStatement ps;
					String sql="DELETE FROM zonas WHERE id_zona=?";
					ps= con.prepareStatement(sql);
					ps.setInt(1, id_zona);
					ps.executeUpdate();
					ps.close();
					
					respuesta="La zona se ha borrado de la DB.";
				}
			else
				{
					respuesta="No se pudo borrar el servicio de la DB.";
				}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			respuesta="No se pudo conectar a la DB.";
		}
		return respuesta;
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
	
	
	@POST
	@Path("/selectZona")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String selectZona(){
		
		Gson gson= new Gson();
		ArrayList<Zona> listado= new ArrayList<>();
		
		String respuesta= gson.toJson(listado);
		int int_id_zona= 0;
		String str_nombre= null;
		
		try
		{
			ConexionAeropuerto c= new ConexionAeropuerto();
			Connection con= c.connectarAhora();
			
			if(con != null)
			{
				Statement st;
				st= con.createStatement();
				String sql= "SELECT id_zona, nombre FROM zonas";
				ResultSet rs= st.executeQuery(sql);
				
				while(rs.next())
				{
					int_id_zona= rs.getInt("id_zona");
					str_nombre= rs.getString("nombre");
					
					listado.add(new Zona(int_id_zona, str_nombre));
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

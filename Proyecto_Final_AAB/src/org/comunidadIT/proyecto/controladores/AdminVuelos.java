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
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.comunidadIT.proyecto.accesoDatos.AutenticarAdministradorVuelo;
import org.comunidadIT.proyecto.accesoDatos.AutenticarSuperAdministrador;
import org.comunidadIT.proyecto.accesoDatos.AutenticarUsuario;
import org.comunidadIT.proyecto.accesoDatos.ConexionAeropuerto;
import org.comunidadIT.proyecto.entidades.Administrador;
import org.comunidadIT.proyecto.entidades.Avion;
import org.comunidadIT.proyecto.entidades.Vuelo;

import com.google.gson.Gson;



@Path("/adminVuelos")
public class AdminVuelos {
	
	@POST
	@Path("/verVuelos")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String verVuelos(@FormParam("usuario") String usuario, @FormParam("pass") String pass){
	
	List<Vuelo> listado= new ArrayList<>();
	Gson gson= new Gson();
	String	respuesta_Json= gson.toJson(listado);	
	
	int int_id= 0;
	String str_empresa= null;
	String str_destino= null;
	int int_escalas= 0;
	int int_pasajes= 0;
	String str_fechaSalida= null;
	String str_horarioSalida= null;
	String str_fechaArribo= null;
	String str_horarioArribo= null;
	String str_pago= null;
	int int_precio= 0;
	
	try
	{
		ConexionAeropuerto c= new ConexionAeropuerto();
		Connection con= c.connectarAhora();
		if(con != null && AutenticarAdministradorVuelo.autenticarAdministradorVuelo(usuario, pass)==true)
		{
			Statement st;
			String sql= "SELECT * FROM vuelos";
			st= con.createStatement();
			ResultSet rs= st.executeQuery(sql);
			
			while(rs.next())
			{
				int_id= rs.getInt("id");
				str_empresa= rs.getString("empresa");
				str_destino= rs.getString("destino");
				int_escalas= rs.getInt("escalas");
				int_pasajes= rs.getInt("pasajes");
				str_fechaSalida= rs.getString("fechaSalida");
				str_horarioSalida= rs.getString("horarioSalida");
				str_fechaArribo= rs.getString("fechaArribo");
				str_horarioArribo= rs.getString("horarioArribo");
				str_pago= rs.getString("pago");
				int_precio= rs.getInt("precio");
			}
			
			listado.add(new Vuelo(int_id, str_empresa, str_destino, int_escalas, int_pasajes, str_fechaSalida, str_horarioSalida, str_fechaArribo, str_horarioArribo, str_pago, int_precio));
			return respuesta_Json= gson.toJson(listado);
		}
		else
		{
			return respuesta_Json="La consulta no pudo realizarse.";
		}
	}
	catch(Exception e)
	{
		
	}
		return respuesta_Json; 
	}
	
	
	@POST
	@Path("/agregarVuelo")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String agregarVuelo(@FormParam("usuario") String usuario, @FormParam("pass") String pass, @FormParam("empresa") String empresa, @FormParam("destino") String destino, @FormParam("escalas") int escalas, @FormParam("pasajes") int pasajes, @FormParam("fechaSalida") String fechaSalida, @FormParam("horarioSalida") String horarioSalida, @FormParam("fechaArribo") String fechaArribo, @FormParam("horarioArribo") String horarioArribo, @FormParam("pago") String pago, @FormParam("precio") int precio){
		
		Gson gson= new Gson();
		List<Vuelo> listado= new ArrayList<>();
		String  str_toJson= null;
		
		try{
			ConexionAeropuerto c= new ConexionAeropuerto();
			Connection con= c.connectarAhora();
			
			if(con !=null && AutenticarAdministradorVuelo.autenticarAdministradorVuelo(usuario, pass)==true){
				
				
				if(usuario.equalsIgnoreCase("")||pass.equalsIgnoreCase("")||empresa.equalsIgnoreCase("")||destino.equalsIgnoreCase("")||pasajes<0||fechaSalida.equalsIgnoreCase("")||horarioSalida.equalsIgnoreCase("")||fechaArribo.equalsIgnoreCase("")||horarioArribo.equalsIgnoreCase("")||pago.equalsIgnoreCase("")||precio<0)
					{
						//System.out.println("hay algun campo vacío");
					return str_toJson= "Hay algún campo del formulario puede haber quedado vacío.";
					}
				else
					{
				
						PreparedStatement ps;
						String sql="INSERT INTO vuelos(empresa, destino, escalas, pasajes, fechaSalida, horarioSalida, fechaArribo, horarioArribo, pago, precio, id_administradores) values(?,?,?,?,?,?,?,?,?,?,?)";
						ps= con.prepareStatement(sql);
						
						ps.setString(1, empresa);
						ps.setString(2, destino);
						ps.setInt(3, escalas);
						ps.setInt(4, pasajes);
						ps.setString(5, fechaSalida);
						ps.setString(6, horarioSalida);
						ps.setString(7, fechaArribo);
						ps.setString(8, horarioArribo);
						ps.setString(9, pago);
						ps.setInt(10, precio);
						ps.setString(11, usuario);
						
						ps.executeUpdate();
						ps.close();
						
						listado.add(new Vuelo(0,empresa,destino, escalas, pasajes, fechaSalida, horarioSalida,fechaArribo, horarioArribo, pago, precio));
						
						str_toJson= gson.toJson(listado);
						return str_toJson;
			
					}
				
			}
			else
				{
					return str_toJson= "No se pudo conectar a la DB o las credenciales no son correctas.";
				}
		}
		catch(Exception e)
		{
			System.out.println("No se pudo conectar a la DB.");
		}
		
		return str_toJson;
	}
	
	
	@POST
	@Path("modificarVuelo")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String modificarVuelo(@FormParam("usuario") String usuario, @FormParam("pass") String pass, @FormParam("empresa") String empresa, @FormParam("destino") String destino, @FormParam("escalas") int escalas, @FormParam("pasajes") int pasajes, @FormParam("fechaSalida") String fechaSalida, @FormParam("horarioSalida") String horarioSalida, @FormParam("fechaArribo") String fechaArribo, @FormParam("horarioArribo") String horarioArribo, @FormParam("pago") String pago, @FormParam("precio") int precio, @FormParam("id") int id){
		
		Gson gson= new Gson();
		ArrayList<Vuelo> listado=  new ArrayList<>();
		String jsonToString= null;
		
		try{
			ConexionAeropuerto c= new ConexionAeropuerto();
			Connection con= c.connectarAhora();
			
			if(con != null && AutenticarAdministradorVuelo.autenticarAdministradorVuelo(usuario, pass)==true){
				
				
				if(usuario.equalsIgnoreCase("")||pass.equalsIgnoreCase("")||empresa.equalsIgnoreCase("")||destino.equalsIgnoreCase("")||pasajes<0||fechaSalida.equalsIgnoreCase("")||horarioSalida.equalsIgnoreCase("")||fechaArribo.equalsIgnoreCase("")||horarioArribo.equalsIgnoreCase("")||pago.equalsIgnoreCase("")||precio<0||id<0)
				{
					//System.out.println("hay algun campo vacío");
				return jsonToString= "Hay algún campo del formulario puede haber quedado vacío.";
				}
			else
				{
				
				PreparedStatement ps;
				String sql= "UPDATE vuelos SET empresa=?, destino=?, escalas=?, pasajes=?, fechaSalida=?, horarioSalida=?, fechaArribo=?, horarioArribo=?, pago=?, precio=? WHERE id=?";
				ps= con.prepareStatement(sql);
				
				ps.setString(1, empresa);
				ps.setString(2, destino);
				ps.setInt(3, escalas);
				ps.setInt(4, pasajes);
				ps.setString(5, fechaSalida);
				ps.setString(6, horarioSalida);
				ps.setString(7, fechaArribo);
				ps.setString(8, horarioArribo);
				ps.setString(9, pago);
				ps.setInt(10, precio);
				ps.setInt(11, id);
				
				ps.executeUpdate();
				ps.close();
				
				
				listado.add(new Vuelo(0,empresa,destino, escalas, pasajes, fechaSalida, horarioSalida,fechaArribo, horarioArribo, pago, precio));
				return jsonToString= gson.toJson(listado);
				
				}
			}
			else
			{
				return jsonToString="Los datos no pudieron modificarse en la DB hubo un error o las credenciales no son correctas";
				
			}
			
		}
		catch(Exception e)
		{
			System.out.println("No se pudo conectar a la DB.");
		}
		
		return jsonToString;
	}
	
	
	@DELETE
	@Path("/deleteVuelo")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String deleteVuelo(@FormParam("usuario") String usuario, @FormParam("pass") String pass, @FormParam("id") int id){
		
		Gson gson= new Gson();
		ArrayList<Vuelo> listado= new ArrayList<>();
		String RespuestaToJson;
		
		
		try{
			ConexionAeropuerto c= new ConexionAeropuerto();
			Connection con= c.connectarAhora();
			
			if(con != null && AutenticarAdministradorVuelo.autenticarAdministradorVuelo(usuario, pass)==true)
			{
				Statement st;
				st= con.createStatement();			
				st.executeUpdate("DELETE FROM vuelos WHERE id="+id);
				st.close();
				
				
				listado.add(new Vuelo(id));
				RespuestaToJson= gson.toJson(listado);
				return "El vuelo "+ RespuestaToJson +" fue borrado de la DB.";
			}
			else
			{
				return "Controle su usuario y pass\nSi los mismos están bien puede que un error interno haya ocurrido.";
			}
		}
		catch(Exception e)
		{
			System.out.println("La conexión no fue posible.");
		}
		
		RespuestaToJson= gson.toJson(listado);
		return RespuestaToJson;
	}
	
	
	@POST
	@Path("/verTodosAviones")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String verTodosAviones(@FormParam("usuario") String usuario, @FormParam("pass") String pass){
	
	List<Avion> listado= new ArrayList<>();
	Gson gson= new Gson();
	String	respuesta_Json= gson.toJson(listado);	
	
	int int_id= 0;
	String str_tipo_avion= null;
	String str_matricula= null;
	int int_cantidad_pasajeros= 0;

	try
	{
		ConexionAeropuerto c= new ConexionAeropuerto();
		Connection con= c.connectarAhora();
		if(con != null && AutenticarAdministradorVuelo.autenticarAdministradorVuelo(usuario, pass)==true)
		{
			Statement st;
			String sql= "SELECT * FROM aviones";
			st= con.createStatement();
			ResultSet rs= st.executeQuery(sql);
			
			while(rs.next())
			{
				int_id= rs.getInt("id");
				str_tipo_avion= rs.getString("tipo_avion");
				str_matricula= rs.getString("matricula");
				int_cantidad_pasajeros= rs.getInt("cantidad_pasajeros");
				
			
				listado.add(new Avion(int_id, str_tipo_avion, str_matricula, int_cantidad_pasajeros));
				respuesta_Json= gson.toJson(listado);
			}
			return respuesta_Json;
		}
		else
		{
			return respuesta_Json="La consulta no pudo realizarse.";
		}
	}
	catch(Exception e)
	{
		
	}
		return respuesta_Json; 
	}
	
	
	@POST
	@Path("/agregarAvion")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String agregarAvion(@FormParam("usuario") String usuario, @FormParam("pass") String pass, @FormParam("tipo_avion") String tipo_avion, @FormParam("matricula") String matricula, @FormParam("cantidad_pasajeros") int cantidad_pasajeros){
		
		Gson gson= new Gson();
		List<Avion> listado= new ArrayList<>();
		String  str_toJson= null;
		
		try{
			ConexionAeropuerto c= new ConexionAeropuerto();
			Connection con= c.connectarAhora();
			
			if(con !=null && AutenticarAdministradorVuelo.autenticarAdministradorVuelo(usuario, pass)==true){
				
				
				if(usuario.equalsIgnoreCase("")||pass.equalsIgnoreCase("")||tipo_avion.equalsIgnoreCase("")||matricula.equalsIgnoreCase("")||cantidad_pasajeros<0)
					{
						//System.out.println("hay algun campo vacío");
					return str_toJson= "Hay algún campo del formulario puede haber quedado vacío.";
					}
				else
					{
				
						PreparedStatement ps;
						String sql="INSERT INTO aviones(tipo_avion, matricula, cantidad_pasajeros) values(?,?,?)";
						ps= con.prepareStatement(sql);
						
						ps.setString(1, tipo_avion);
						ps.setString(2, matricula);
						ps.setInt(3, cantidad_pasajeros);
						ps.executeUpdate();
						ps.close();
						
						listado.add(new Avion(tipo_avion, matricula, cantidad_pasajeros));
						
						str_toJson= gson.toJson(listado);
						return str_toJson;
			
					}
				
			}
			else
				{
					return str_toJson= "No se pudo conectar a la DB o las credenciales no son correctas.";
				}
		}
		catch(Exception e)
		{
			System.out.println("No se pudo conectar a la DB.");
		}
		
		return str_toJson;
	}
	
	@POST
	@Path("/rellenoSelectAviones")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String rellenoSelectAviones(){
	
	List<Avion> listado= new ArrayList<>();
	Gson gson= new Gson();
	String	respuesta_Json= gson.toJson(listado);	
	
	String str_matricula= null;
	

	try
	{
		ConexionAeropuerto c= new ConexionAeropuerto();
		Connection con= c.connectarAhora();
		if(con != null)
		{
			Statement st;
			String sql= "SELECT matricula FROM aviones";
			st= con.createStatement();
			ResultSet rs= st.executeQuery(sql);
			
			while(rs.next())
			{

				str_matricula= rs.getString("matricula");
				
				listado.add(new Avion(str_matricula));
				respuesta_Json= gson.toJson(listado);
			}
			return respuesta_Json;
		}
		else
		{
			return respuesta_Json="La consulta no pudo realizarse.";
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		return respuesta_Json; 
	}
	
}

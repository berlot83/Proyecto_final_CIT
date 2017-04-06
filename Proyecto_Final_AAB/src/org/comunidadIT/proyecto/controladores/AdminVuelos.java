package org.comunidadIT.proyecto.controladores;


import java.sql.Connection;
import java.sql.PreparedStatement;
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

import org.comunidadIT.proyecto.accesoDatos.AutenticarAdministradorVuelo;
import org.comunidadIT.proyecto.accesoDatos.AutenticarUsuario;
import org.comunidadIT.proyecto.accesoDatos.ConexionAeropuerto;
import org.comunidadIT.proyecto.entidades.Vuelo;

import com.google.gson.Gson;



@Path("/adminVuelos")
public class AdminVuelos {
	
	//Pendiente consulta todos los vuelos
	//@GET
	
	
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
	

}

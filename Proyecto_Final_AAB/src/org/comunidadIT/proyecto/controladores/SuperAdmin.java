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
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.comunidadIT.proyecto.accesoDatos.AutenticarSuperAdministrador;
import org.comunidadIT.proyecto.accesoDatos.ConexionAeropuerto;
import org.comunidadIT.proyecto.entidades.Administrador;

import com.google.gson.Gson;

@Path("/superAdministrador")
public class SuperAdmin {

	@POST
	@Path("/verAdministradores")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String verAdministradores(@FormParam("usuario") String usuario, @FormParam("pass") String pass, @FormParam("token") String token){
	
	List<Administrador> listado= new ArrayList<>();
	Gson gson= new Gson();
	String	respuesta_Json= gson.toJson(listado);	
	
	int int_id= 0;
	String str_nombre= null;
	String str_apellido= null;
	String str_usuario= null;
	String str_pass= null;
	String str_email= null;
	String str_direccion= null;
	
	try
	{
		ConexionAeropuerto c= new ConexionAeropuerto();
		Connection con= c.connectarAhora();
		if(con != null && AutenticarSuperAdministrador.autenticarSuperAdministrador(usuario, pass, token)==true)
		{
			Statement st;
			String sql= "SELECT * FROM administradores";
			st= con.createStatement();
			ResultSet rs= st.executeQuery(sql);
			
			while(rs.next())
			{
				int_id=rs.getInt("id_administrador");
				str_nombre= rs.getString("nombre");
				str_apellido= rs.getString("apellido");
				str_usuario= rs.getString("usuario");
				str_pass= rs.getString("pass");
				str_email= rs.getString("email");
				str_direccion= rs.getString("direccion");
				
				listado.add(new Administrador(int_id, str_nombre, str_apellido, str_usuario, str_pass, str_email, str_direccion));
				respuesta_Json= gson.toJson(listado);
			}
			
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
	
	
	@POST
	@Path("/verTipoAdministradores")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String verTipoAdministradores(@FormParam("usuario") String usuario, @FormParam("pass") String pass, @FormParam("token") String token, @FormParam("tipoAdmin") String tipoAdmin){
	
	List<Administrador> listado= new ArrayList<>();
	Gson gson= new Gson();
	String	respuesta_Json= gson.toJson(listado);
	
	int int_id= 0;
	String str_nombre= null;
	String str_apellido= null;
	String str_usuario= null;
	String str_pass= null;
	String str_email= null;
	String str_direccion= null;
	
	try
	{
		ConexionAeropuerto c= new ConexionAeropuerto();
		Connection con= c.connectarAhora();
		if(con != null && AutenticarSuperAdministrador.autenticarSuperAdministrador(usuario, pass, token)==true)
		{
			
			Statement st;
			String sql= "SELECT * FROM administradores WHERE tipo_admin='"+ tipoAdmin +"'";
			st= con.createStatement();
			ResultSet rs= st.executeQuery(sql);
			
			while(rs.next())
			{
				int_id=rs.getInt("id_administrador");
				str_nombre= rs.getString("nombre");
				str_apellido= rs.getString("apellido");
				str_usuario= rs.getString("usuario");
				str_pass= rs.getString("pass");
				str_email= rs.getString("email");
				str_direccion= rs.getString("direccion");
				
				listado.add(new Administrador(int_id, str_nombre, str_apellido, str_usuario, str_pass, str_email, str_direccion));
				respuesta_Json= gson.toJson(listado);
			}
			
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
	
	
	@DELETE
	@Path("/deleteAdministrador")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String deleteAdministrador(@FormParam("usuario") String usuario, @FormParam("pass") String pass, @FormParam("token") String token, @FormParam("id") int id){
		
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
					String sql= "DELETE FROM administradores WHERE id_administrador=?";
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
	public String agregarAdministrador(@FormParam("usuario") String usuario, @FormParam("pass") String pass, @FormParam("token") String token, @FormParam("tipoAdministrador") String tipoAdministrador, @FormParam("nombre") String nombre, @FormParam("apellido") String apellido, @FormParam("usuarioNuevoAdmin") String usuarioNuevoAdmin, @FormParam("passNuevoAdmin") String passNuevoAdmin, @FormParam("email") String email, @FormParam("direccion") String direccion){
		
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
	
	@PUT
	@Path("/reasignarAdmin")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String reasignarAdmin(@FormParam("usuario") String usuario, @FormParam("pass") String pass, @FormParam("token") String token, @FormParam("id_administrador") int id_administrador, @FormParam("id_administrador_cambiar") int id_administrador_cambiar){
		
		String respuesta= null;
		
		try{
			
			ConexionAeropuerto c= new ConexionAeropuerto();
			Connection con= c.connectarAhora();
			
			if(con!=null && AutenticarSuperAdministrador.autenticarSuperAdministrador(usuario, pass, token)==true)
				
			{
				//String sql= "UPDATE empleados SET id_administrador=? WHERE id_administrador=? and tipo_administrador='adminRH' ";
				PreparedStatement ps;
				String sql= "UPDATE empleados SET id_administrador=? WHERE id_administrador=? and tipo_administrador='adminRH' ";
				ps= con.prepareStatement(sql);
				ps.setInt(1, id_administrador_cambiar);
				ps.setInt(2, id_administrador);
				ps.executeUpdate();
				ps.close();
				
				return respuesta="La modificacion fue realizada con éxito.";
			}
			
			else
			{
				return respuesta= "Las credenciales no son correctas";
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return respuesta;
	}
	
	
	@PUT
	@Path("/reasignarAdminVuelos")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String reasignarAdminVuelos(@FormParam("usuario") String usuario, @FormParam("pass") String pass, @FormParam("token") String token, @FormParam("id_administrador") int id_administrador, @FormParam("id_administrador_cambiar") int id_administrador_cambiar){
		
		String respuesta= null;
		
		try{
			
			ConexionAeropuerto c= new ConexionAeropuerto();
			Connection con= c.connectarAhora();
			
			if(con!=null && AutenticarSuperAdministrador.autenticarSuperAdministrador(usuario, pass, token)==true)
				
			{
				//String sql= "UPDATE vuelos SET id_administrador=? WHERE id_administrador=? and tipo_administrador='adminVuelos' ";
				PreparedStatement ps;
				String sql= "UPDATE vuelos SET id_administrador=? WHERE id_administrador=? and tipo_administrador='adminVuelos' ";
				ps= con.prepareStatement(sql);
				ps.setInt(1, id_administrador_cambiar);
				ps.setInt(2, id_administrador);
				ps.executeUpdate();
				ps.close();
				
				return respuesta="La modificacion fue realizada con éxito.";
			}
			
			else
			{
				return respuesta= "Las credenciales no son correctas";
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return respuesta;
	}
	
	
	@POST
	@Path("/verIdAdmin")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String verIdAdmin(){
		
		List<Administrador> listado= new ArrayList<>();
		Gson gson= new Gson();
		String respuesta_json= gson.toJson(listado);
		
		String respuesta= null;
		int int_id_administrador= 0;
		String str_usuario= null;
		
		try
				{
					ConexionAeropuerto c= new ConexionAeropuerto();
					Connection con= c.connectarAhora();
					
					if(con != null)
						{
							Statement stmt;
							String sql= "SELECT id_administrador, usuario FROM administradores WHERE tipo_admin='adminRH' ";
							stmt= con.createStatement();
							ResultSet rs= stmt.executeQuery(sql);
							
							while(rs.next())
								{
									int_id_administrador= rs.getInt("id_administrador");
									str_usuario= rs.getString("usuario");
									
									listado.add(new Administrador(int_id_administrador, str_usuario));
									
									respuesta=  gson.toJson(listado);
								}
							return respuesta;
						
						}
					else
					{
						return respuesta="no se realizó la consulta.";
					}
				}
		catch(Exception e)
				{
					e.printStackTrace();
				}
		
		return respuesta;
		
	}
	
	
	@POST
	@Path("/verIdAdminVuelos")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String verIdAdminVuelos(){
		
		List<Administrador> listado= new ArrayList<>();
		Gson gson= new Gson();
		String respuesta_json= gson.toJson(listado);
		
		String respuesta= null;
		int int_id_administrador= 0;
		String str_usuario= null;
		
		try
				{
					ConexionAeropuerto c= new ConexionAeropuerto();
					Connection con= c.connectarAhora();
					
					if(con != null)
						{
							Statement stmt;
							String sql= "SELECT id_administrador, usuario FROM administradores WHERE tipo_admin='adminVuelos' ";
							stmt= con.createStatement();
							ResultSet rs= stmt.executeQuery(sql);
							
							while(rs.next())
								{
									int_id_administrador= rs.getInt("id_administrador");
									str_usuario= rs.getString("usuario");
									
									listado.add(new Administrador(int_id_administrador, str_usuario));
									
									respuesta=  gson.toJson(listado);
								}
							return respuesta;
						
						}
					else
					{
						return respuesta="no se realizó la consulta.";
					}
				}
		catch(Exception e)
				{
					e.printStackTrace();
				}
		
		return respuesta;
		
	}
	
	
	
}

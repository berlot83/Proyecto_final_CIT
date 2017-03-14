package org.comunidadIT.proyecto.controladores;

import javax.ws.rs.PathParam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.comunidadIT.proyecto.accesoDatos.AutenticarUsuario;
import org.comunidadIT.proyecto.accesoDatos.ConexionAeropuerto;
import org.comunidadIT.proyecto.entidades.Administrador;
import org.comunidadIT.proyecto.entidades.Empleado;

import com.google.gson.Gson;



@Path("/empleados")
public class Empleados {
	
	String numerosLetras= new String("[^a-zA-Z0-9]+");
	String soloLetras= new String("[^a-zA-Z]+");
	String soloEmail= new String("[^a-zA-Z0-9@._-]");
	
	//falta crear un jsp y prbarlo
	@POST
	@Path("/insertarEmpleado")
	@Produces(MediaType.APPLICATION_JSON)
	public String insertarEmpleado(@FormParam("usuario") String usuario, @FormParam("pass") String pass, @FormParam("nombre") String nombre, @FormParam("apellido") String apellido, @FormParam("direccion") String direccion, @FormParam("cargo") String cargo, @FormParam("sueldo_cargo") float sueldo_cargo, @FormParam("cargas_sociales") float cargas_sociales, @FormParam("vacaciones") float vacaciones, @FormParam("sueldo_neto") float sueldo_neto){
		
		
		try
			{
			//Probamos conectarnos
			ConexionAeropuerto c= new ConexionAeropuerto();
			Connection con= c.connectarAhora();
			
			//Si la conexión no es nula entonces realizar dos consultaa de insercción de datos y creación de tabla
			if(con!=null && AutenticarUsuario.autenticarUsuario(usuario, pass)==true)
					{
						PreparedStatement st;
						String sql="INSERT INTO empleados_"+usuario+"(nombre, apellido, direccion, cargo, sueldo_cargo, cargas_sociales, vacaciones, sueldo_neto) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
						st=con.prepareStatement(sql);
							st.setString(1, nombre.trim().replaceAll(soloLetras, ""));
							st.setString(2, apellido.trim().replaceAll(soloLetras, ""));
							st.setString(3, direccion.trim().replaceAll(numerosLetras, ""));
							st.setString(4, cargo.trim().replaceAll(numerosLetras, ""));
							st.setFloat(5, sueldo_cargo);
							st.setFloat(6, cargas_sociales);
							st.setFloat(7, vacaciones);
							st.setFloat(8, sueldo_neto);
							st.executeUpdate();
							
							st.close();
							System.out.println("Funciona el try and catch, los deberían haberse ingresado a la DB empleados_"+usuario);
				
						MetodosResponse.CREADO();	//ResponseBuilder 200
					} 
			else
					{
						System.out.println("Algo Salió mal no se pudo insertar los datos");
						MetodosResponse.UNAUTHORIZED();	//ResponseBuilder 401
						return "Algo Salió mal no se pudo insertar los datos a la base de datos";
					}
			}
			catch (SQLException e) 
		
					{
						e.printStackTrace();
					}
		
		//Creamos la lista y le ponemos las variables que a su vez están conectadas al construcctor de la Case Empleados
		List<Empleado> lista= new ArrayList<>();
			lista.add(new Empleado(nombre.trim().replaceAll(soloLetras, ""), apellido.trim().replaceAll(soloLetras, ""), direccion.trim().replaceAll(numerosLetras, ""), cargo.trim().replaceAll(numerosLetras, ""), sueldo_cargo, cargas_sociales, vacaciones, sueldo_neto ));
			
				//Creamos un object Gson() que nos permite usar el toJson()
				Gson gson = new Gson();
			
				//Creamos un String y al mismo le aplicamos el toJson(objeto list)
				String JsonToString= gson.toJson(lista);
				
				//Retornamos el String anterior
				return JsonToString;
	}
	
	
	
	//Consulta de empleados de la DB con nombre y apellido como parámetros
	@POST
	@Path("/consultaNombreEmpleado")
	@Produces(MediaType.APPLICATION_JSON)
	public String consultaNombreEmpleado(@FormParam("usuario") String usuario, @FormParam("pass") String pass, @FormParam("nombre") String nombre, @FormParam("apellido") String apellido){
		
	String str_nombre= null;
	String str_apellido= null;
	String str_direccion= null;
	String str_cargo= null;
	float str_sueldo_cargo= 0;
	float str_cargas_sociales= 0;
	float str_vacaciones= 0;
	float str_sueldo_neto= 0;
		
		//Este grupo de variables transforman a JSON y con el while de abajo itera a todos los elementos del ArrayList
		Gson gson= new Gson();
		List<Empleado> listado= new ArrayList<>();
		String stringJson= gson.toJson(listado);
		
		
		try
			{
		
			ConexionAeropuerto c= new ConexionAeropuerto();
			Connection con= c.connectarAhora();
			
			if(con!=null && AutenticarUsuario.autenticarUsuario(usuario, pass)==true)
					{
						System.out.println("Funciona el try and catch");
						
						String sql="select * from empleados_"+usuario+" where nombre='"+nombre+"' and apellido='"+apellido+"' ";
						
						Statement st= con.createStatement();
						
						ResultSet rs= st.executeQuery(sql);
						
						
						while(rs.next())
						{
							 str_nombre= rs.getString("nombre");
						     str_apellido= rs.getString("apellido");
							 str_direccion= rs.getString("direccion");
							 str_cargo= rs.getString("cargo");
							 str_sueldo_cargo= rs.getFloat("sueldo_cargo");
							 str_cargas_sociales= rs.getFloat("cargas_sociales");
							 str_vacaciones= rs.getFloat("vacaciones");
							 str_sueldo_neto= rs.getFloat("sueldo_neto");
							
							//Esta línea es sólo demostrativa de que funcionan las variables que toman datos de la DB
							System.out.println(str_nombre+" "+str_apellido+" "+str_direccion+" "+str_cargo+" "+str_sueldo_cargo+" "+str_cargas_sociales+" "+str_vacaciones+" "+str_sueldo_neto);
							
							//Adherimos a la lista una fila nueva con una columna nueva.
							listado.add(new Empleado(str_nombre, str_apellido, str_direccion, str_cargo, str_sueldo_cargo, str_cargas_sociales, str_vacaciones, str_sueldo_neto));
							
							//Actualizamos el String del Json sin crearlo nuevamente.
							stringJson= gson.toJson(listado);
							
							MetodosResponse.ACCEPTED();	//ResponseBuilder 200
						}
						
					} 
			else
					{
						System.out.println("Algo Salió mal no se pueden ver los datos de la consulta.");
						MetodosResponse.UNAUTHORIZED();	//ResponseBuilder 401
						return "Algo Salió mal no se pueden ver los datos de la consulta.";
					}
			}
			catch (Exception e) 
		
					{
						e.printStackTrace();
					}
		return stringJson;
		}
	
	
	
	//Consulta de todos los Empleados de la DB
		@POST
		@Path("/consultaTodosEmpleados")
		@Produces(MediaType.APPLICATION_JSON)
		public String consultaTodosEmpleados(@FormParam("usuario") String usuario, @FormParam("pass") String pass, @FormParam("nombre") String nombre, @FormParam("apellido") String apellido){
			
		String str_nombre= null;
		String str_apellido= null;
		String str_direccion= null;
		String str_cargo= null;
		float str_sueldo_cargo= 0;
		float str_cargas_sociales= 0;
		float str_vacaciones= 0;
		float str_sueldo_neto= 0;
			
			//Este grupo de variables transforman a JSON y con el while de abajo itera a todos los elementos del ArrayList
			Gson gson= new Gson();
			List<Empleado> listado= new ArrayList<>();
			String stringJson= gson.toJson(listado);
			
			
			try
				{
			
				ConexionAeropuerto c= new ConexionAeropuerto();
				Connection con= c.connectarAhora();
				
				if(con!=null && AutenticarUsuario.autenticarUsuario(usuario, pass)==true)
						{
							System.out.println("Funciona el try and catch");
							
							String sql="select * from empleados_"+usuario;
							
							Statement st= con.createStatement();
							
							ResultSet rs= st.executeQuery(sql);
							
							
							while(rs.next())
							{
								 str_nombre= rs.getString("nombre");
							     str_apellido= rs.getString("apellido");
								 str_direccion= rs.getString("direccion");
								 str_cargo= rs.getString("cargo");
								 str_sueldo_cargo= rs.getFloat("sueldo_cargo");
								 str_cargas_sociales= rs.getFloat("cargas_sociales");
								 str_vacaciones= rs.getFloat("vacaciones");
								 str_sueldo_neto= rs.getFloat("sueldo_neto");
								
								//Esta línea es sólo demostrativa de que funcionan las variables que toman datos de la DB
								System.out.println(str_nombre+" "+str_apellido+" "+str_direccion+" "+str_cargo+" "+str_sueldo_cargo+" "+str_cargas_sociales+" "+str_vacaciones+" "+str_sueldo_neto);
								
								//Adherimos a la lista una fila nueva con una columna nueva.
								listado.add(new Empleado(str_nombre, str_apellido, str_direccion, str_cargo, str_sueldo_cargo, str_cargas_sociales, str_vacaciones, str_sueldo_neto));
								
								//Actualizamos el String del Json sin crearlo nuevamente.
								stringJson= gson.toJson(listado);
								
								MetodosResponse.ACCEPTED();	//ResponseBuilder 200
							}
							
						} 
				else
						{
							System.out.println("Algo Salió mal no se pueden ver los datos de la consulta.");
							MetodosResponse.UNAUTHORIZED();	//ResponseBuilder 401
							return "Algo Salió mal no se pueden ver los datos de la consulta.";
						}
				}
				catch (Exception e) 
			
						{
							e.printStackTrace();
						}
			return stringJson;
			}
	
	

}

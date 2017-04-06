package org.comunidadIT.proyecto.controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.comunidadIT.proyecto.accesoDatos.AutenticarUsuario;
import org.comunidadIT.proyecto.accesoDatos.ConexionAeropuerto;
import org.comunidadIT.proyecto.entidades.Empleado;
import org.comunidadIT.proyecto.validaciones.ValidarCuit;
import org.comunidadIT.proyecto.validaciones.ValidarDni;

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
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		public String insertarEmpleado(@FormParam("usuario") String usuario, @FormParam("pass") String pass, @FormParam("dni") String dni, @FormParam("cuit") String cuit, @FormParam("nacimiento") String nacimiento, @FormParam("nombre") String nombre, @FormParam("apellido") String apellido, @FormParam("direccion") String direccion, @FormParam("cargo") String cargo, @FormParam("sueldo_cargo") float sueldo_cargo, @FormParam("cargas_sociales") float cargas_sociales, @FormParam("vacaciones") float vacaciones,  @FormParam("sueldo_neto") float sueldo_neto){
			
			int personaId=0;
			String JsonToString=null;
			
			try
				{
				//Probamos conectarnos
				ConexionAeropuerto c= new ConexionAeropuerto();
				Connection con= c.connectarAhora();
				
				//Si la conexión no es nula entonces realizar dos consultaa de insercción de datos y creación de tabla
				if(con!=null && AutenticarUsuario.autenticarUsuario(usuario, pass)==true && ValidarDni.validarCantidadCaracteresDni(dni)==false && ValidarCuit.validarCantidadCaracteresCuit(cuit)==false)
						
				{
					
					//Si los campos están vacíos tira error y no se ejecuta el statement
					if(nombre.equalsIgnoreCase("") || apellido.equalsIgnoreCase("") || direccion.equalsIgnoreCase("") || cargo.equalsIgnoreCase("") || sueldo_cargo<=0 || cargas_sociales<=0 || vacaciones<=0 || sueldo_neto<=0 ) 
						
							{
								System.out.println("Hay algun campo vacío.");
							}
					else
							{
						
							PreparedStatement st;
							String sql="INSERT INTO empleados(dni, cuit, nacimiento, nombre, apellido, direccion, cargo, sueldo_cargo, cargas_sociales, vacaciones, sueldo_neto, tipo_administrador, id_administradores) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
							st=con.prepareStatement(sql);
								st.setString(1, dni);
								st.setString(2, cuit);
								st.setString(3, nacimiento);
								st.setString(4, nombre.trim().replaceAll(soloLetras, ""));
								st.setString(5, apellido.trim().replaceAll(soloLetras, ""));
								st.setString(6, direccion.trim().replaceAll(numerosLetras, ""));
								st.setString(7, cargo.trim().replaceAll(numerosLetras, ""));
								st.setFloat(8, sueldo_cargo);
								st.setFloat(9, cargas_sociales);
								st.setFloat(10, vacaciones);
								st.setFloat(11, sueldo_neto);
								st.setString(12, "adminRH");
								st.setString(13, usuario);
								st.executeUpdate();
								st.close();
								
								//System.out.println("Funciona el try and catch, los deberían haberse ingresado a la DB empleados_"+usuario);
								return JsonToString= "El usuario se agregó con éxito";
							}
						} 
				else
						{
							//System.out.println("No se pudo insertar los datos, controle que el cuit debe tener 11 caracteres y el Dni 8");
							return JsonToString="No se pudo insertar los datos a la base de datos.\n\n• Controle que el cuit debe tener 11 caracteres\n• El Dni debe tener 8 caracteres\n• Si lo anterior se cumple puede ser que las credenciales no sean correctas.";
							
						}
				}
				catch (SQLException e) 
			
						{
							e.printStackTrace();
							return JsonToString="La insercción falló, controle que el dni y cuit estén correctamente igresados ya que no puede haber duplicados";
						}
			
			//Creamos la lista y le ponemos las variables que a su vez están conectadas al construcctor de la Case Empleados
			List<Empleado> lista= new ArrayList<>();
				lista.add(new Empleado(personaId, dni, cuit, nacimiento, nombre.trim().replaceAll(soloLetras, ""), apellido.trim().replaceAll(soloLetras, ""), direccion.trim().replaceAll(numerosLetras, ""), cargo.trim().replaceAll(numerosLetras, ""), sueldo_cargo, cargas_sociales, vacaciones, sueldo_neto ));
				
					//Creamos un object Gson() que nos permite usar el toJson()
					Gson gson = new Gson();
				
					//Creamos un String y al mismo le aplicamos el toJson(objeto list)
					JsonToString= gson.toJson(lista);
					
					//Retornamos el String anterior
					return JsonToString;
		}
		
		
		
		//Consulta de empleados de la DB con nombre y apellido como parámetros
		@GET
		@Path("/consultaNombreEmpleado")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		public String consultaNombreEmpleado(@QueryParam("usuario") String usuario, @QueryParam("pass") String pass, @QueryParam("nombre") String nombre, @QueryParam("apellido") String apellido){
		
			//Para los Resultset
			int str_personaId;
			String str_dni;
			String str_cuit;
			String str_nacimiento=null;
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
				
				if(con!=null) //&& AutenticarUsuario.autenticarUsuario(usuario, pass)==true)
						{
							System.out.println("Funciona el try and catch");
							
							String sql="select * from empleados_"+usuario+" where apellido='"+apellido+"' ";
							
							Statement st= con.createStatement();
							
							ResultSet rs= st.executeQuery(sql);
							
							
							while(rs.next())
							{	 str_personaId= rs.getInt("personaId");
								 str_dni= rs.getString("dni");
								 str_cuit= rs.getString("cuit");
								 str_nacimiento= rs.getString("nacimiento");
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
								listado.add(new Empleado(str_personaId, str_dni, str_cuit, str_nacimiento, str_nombre, str_apellido, str_direccion, str_cargo, str_sueldo_cargo, str_cargas_sociales, str_vacaciones, str_sueldo_neto));
								
								//Actualizamos el String del Json sin crearlo nuevamente.
								stringJson= gson.toJson(listado);
							}
							
						} 
				else
						{
							System.out.println("Algo Salió mal no se pueden ver los datos de la consulta.");
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
			public String consultaTodosEmpleados(@FormParam("usuario") String usuario, @FormParam("pass") String pass){
	
				
				//Este grupo de variables transforman a JSON y con el while de abajo itera a todos los elementos del ArrayList
				Gson gson= new Gson();
				List<Empleado> listado= new ArrayList<>();
				String stringJson= gson.toJson(listado);
				
				//Para los Resultset
				int str_personaId;
				String str_dni;
				String str_cuit;
				String str_nacimiento=null;
				String str_nombre= null;
				String str_apellido= null;
				String str_direccion= null;
				String str_cargo= null;
				float str_sueldo_cargo= 0;
				float str_cargas_sociales= 0;
				float str_vacaciones= 0;
				float str_sueldo_neto= 0;
				
				try
					{
				
					ConexionAeropuerto c= new ConexionAeropuerto();
					Connection con= c.connectarAhora();
					
					if(con!=null && AutenticarUsuario.autenticarUsuario(usuario, pass)==true)
							{
								System.out.println("Funciona el try and catch");
								
								String sql="select * from empleados where id_administradores='"+usuario+"' ";
								
								Statement st= con.createStatement();
								
								ResultSet rs= st.executeQuery(sql);
								
								
								while(rs.next())
								{
									 str_personaId= rs.getInt("personaId");
									 str_dni= rs.getString("dni");
									 str_cuit= rs.getString("cuit");
									 str_nacimiento= rs.getString("nacimiento");
									 str_nombre= rs.getString("nombre");
								     str_apellido= rs.getString("apellido");
									 str_direccion= rs.getString("direccion");
									 str_cargo= rs.getString("cargo");
									 str_sueldo_cargo= rs.getFloat("sueldo_cargo");
									 str_cargas_sociales= rs.getFloat("cargas_sociales");
									 str_vacaciones= rs.getFloat("vacaciones");
									 str_sueldo_neto= rs.getFloat("sueldo_neto");
									
									//Esta línea es sólo demostrativa de que funcionan las variables que toman datos de la DB
									System.out.println(str_personaId+" "+ str_nombre+" "+str_apellido+" "+str_direccion+" "+str_cargo+" "+str_sueldo_cargo+" "+str_cargas_sociales+" "+str_vacaciones+" "+str_sueldo_neto);
									
									//Adherimos a la lista una fila nueva con una columna nueva.
									listado.add(new Empleado(str_personaId, str_dni, str_cuit, str_nacimiento, str_nombre, str_apellido, str_direccion, str_cargo, str_sueldo_cargo, str_cargas_sociales, str_vacaciones, str_sueldo_neto));
									
									//Actualizamos el String del Json sin crearlo nuevamente.
									stringJson= gson.toJson(listado);
								}
								
							} 
					else
							{
								System.out.println("Algo Salió mal no se pueden ver los datos de la consulta.");
								return "Algo Salió mal no se pueden ver los datos de la consulta.";
							}
					}
					catch (Exception e) 
				
							{
								e.printStackTrace();
							}
				return stringJson;
				}
			
			
			//barrar empleado de la base de datos
			@DELETE
			@Path("/deleteEmpleado")
			@Produces(MediaType.APPLICATION_JSON)
			@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
			public String deleteEmpleado(@FormParam("usuario") String usuario, @FormParam("pass") String pass, @FormParam("personaId") int personaId){
				
				String respuesta= null;
				
				try
					{
					ConexionAeropuerto c= new ConexionAeropuerto();
					Connection con= c.connectarAhora();
			
					if(con!=null && AutenticarUsuario.autenticarUsuario(usuario, pass)==true)
							{
								Statement st;
								st=con.createStatement();
								st.executeUpdate("DELETE FROM empleados WHERE personaId="+personaId);
								st.close();
								
								System.out.println("Funciona el try and catch, admin: revisar la DB si se eleminó");
								return "El registro número "+personaId+" se borró de la DB.";
							
							} 
					else
							{
								System.out.println("Algo Salió mal no se pueden ver los datos, pue que el registro a borrar no exista o que no tenga acceso");
							
								return "No se pudo borrar el registro seleccionado";
							}
					}
					catch (Exception e) 
				
							{
								e.printStackTrace();
							}
				
				return respuesta;
				}
			
		
			@PUT
			@Path("/modificarEmpleado")
			@Produces(MediaType.APPLICATION_JSON)
			@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
			public String modificarEmpleado(@FormParam("usuario") String usuario, @FormParam("pass") String pass, @FormParam("nombre")String nombre, @FormParam("apellido") String apellido, @FormParam("direccion") String direccion, @FormParam("cargo") String cargo, @FormParam("sueldo_cargo") float sueldo_cargo, @FormParam("cargas_sociales") float cargas_sociales, @FormParam("vacaciones") float vacaciones, @FormParam("sueldo_neto") float sueldo_neto, @FormParam("personaId") int personaId){
				
				Gson gson= new Gson();
				List<Empleado> listado= new ArrayList<>();
				String toJson= null;
				
				
				try{
					
					ConexionAeropuerto c= new ConexionAeropuerto();
					Connection con= c.connectarAhora();
					
					if(con!=null && AutenticarUsuario.autenticarUsuario(usuario, pass)==true)
						{
						PreparedStatement ps;
						String sql= "update empleados set nombre=?, apellido=?, cargo=?, direccion=?, sueldo_cargo=?, cargas_sociales=?, vacaciones=?, sueldo_neto=? where personaId=?";
						ps= con.prepareStatement(sql);
						
						ps.setString(1, nombre);
						ps.setString(2, apellido);
						ps.setString(3, direccion);
						ps.setString(4, cargo);
						ps.setFloat(5, sueldo_cargo);
						ps.setFloat(6, cargas_sociales);
						ps.setFloat(7, vacaciones);
						ps.setFloat(8, sueldo_neto);
						ps.setInt(9, personaId);
						
						ps.executeUpdate();
						ps.close();
						
						listado.add(new Empleado(personaId, nombre, apellido, direccion, cargo, sueldo_cargo, cargas_sociales, vacaciones, sueldo_neto));
						toJson= "Se modificaron los siguientes campos: \n\n" +gson.toJson(listado);
						System.out.println("los datos deberían haberse modificado con éxito");
						
						}
					else
						{
							System.out.println("No se pudieron ingresar los datos requeridos");
							return toJson= "No fue posible la conexión o las credenciales no son correctas";
						}
					
				}
				
				catch(Exception e)
				{
					System.out.println("No fue posible la conexión o las credenciales no son correctas.");
					return toJson= "No fue posible la conexión o las credenciales no son correctas";
				}
				
			return toJson;
			}
			
		
}

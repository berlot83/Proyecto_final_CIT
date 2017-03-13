package aeropuerto_empleados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.google.gson.Gson;


import data_access_object.ConexionAeropuerto;


@Path("/administradores")
public class Administradores {
	
	//Al final están los métodos Response declarados.
	//Inserta administrador en mysql table 'administradores' y genera un dato JSON en texto o archivo
	@POST
	@Path("/addAdministrador")
	@Produces(MediaType.TEXT_HTML)
	public String insertarAdministrador(@FormParam("nombre") String nombre , @FormParam("apellido") String apellido, @FormParam("usuario") String usuario, @FormParam("pass") String pass, @FormParam("email") String email, @FormParam("direccion") String direccion){
		
	String numerosLetras= new String("[^a-zA-Z0-9]+");
	String soloLetras= new String("[^a-zA-Z]+");
	String soloEmail= new String("[^a-zA-Z0-9@._-]");
		
		try
			{
			//Probamos conectarnos
			ConexionAeropuerto c= new ConexionAeropuerto();
			Connection con= c.connectarAhora();
			
			//Si la conexión no es nula entonces realizar dos consultaa de insercción de datos y creación de tabla
			if(con!=null)
					{
						Statement st;
						st=con.createStatement();
						st.executeUpdate("INSERT INTO administradores(nombre,apellido,usuario,pass,email,direccion) VALUES('"+nombre.trim().replaceAll(soloLetras, "")+"','"+apellido.trim().replaceAll(soloLetras, "")+"','"+usuario.trim().replaceAll(numerosLetras, "")+"','"+pass.trim().replaceAll(numerosLetras, "")+"','"+email.trim().replaceAll(soloEmail, "")+"','"+direccion.trim().replaceAll(numerosLetras, "")+"')");
						st.close();
						System.out.println("Funciona el try and catch, los deberían haberse ingresado a la DB 'administradores'");
						
						Statement createSt;
						createSt=con.createStatement();
						createSt.executeUpdate("CREATE TABLE IF NOT EXISTS empleados_"+usuario+"(personaId int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY, nombre text(11), apellido text(11), direccion text(20), cargo text(20), sueldo_bruto double, cargas_sociales double, vacaciones double, sueldo_neto double)");
						createSt.close();
						System.out.println("Funciona el try and catch y debería haberse creado una tabla nueva");
						
						CREADO();	//ResponseBuilder 200
					} 
			else
					{
						System.out.println("Algo Salió mal no se pudo insertar los datos");
						UNAUTHORIZED();	//ResponseBuilder 401
					}
			}
			catch (SQLException e) 
		
					{
						e.printStackTrace();
					}
		
		//Creamos la lista y le ponemos las variables que a su vez están conectadas al construcctor de la Case Empleados
		List<Administrador> lista= new ArrayList<>();
			lista.add(new Administrador(nombre.trim().replaceAll(soloLetras, ""), apellido.trim().replaceAll(soloLetras, ""), usuario.trim().replaceAll(numerosLetras, ""), pass.trim().replaceAll(numerosLetras, ""), email.trim().replaceAll(soloEmail, ""), direccion.trim().replaceAll(numerosLetras, "") ));
			
				//Creamos un object Gson() que nos permite usar el toJson()
				Gson gson = new Gson();
			
				//Creamos un String y al mismo le aplicamos el toJson(objeto list)
				String JsonToString= gson.toJson(lista);
				
				//Retornamos el String anterior
				return JsonToString;
		}
	
	
	
	//Consulta de todos los administradores de la DB
	@GET
	@Path("/consultaAdministrador")
	@Produces(MediaType.APPLICATION_JSON)
	public String loginAdministrador(@QueryParam("usuario") String usuario, @QueryParam("pass") String pass){
		
		//Este grupo de variables transforman a JSON y con el while de abajo itera a todos los elementos del ArrayList
		Gson gson= new Gson();
		List<Administrador> listado= new ArrayList<>();
		String stringJson= gson.toJson(listado);
		
		
		try
			{
		
			ConexionAeropuerto c= new ConexionAeropuerto();
			Connection con= c.connectarAhora();
			
			if(con!=null /* && usuario.equalsIgnoreCase("") && pass.equalsIgnoreCase("") */ && usuario.equals("admin") && pass.equals("admin"))
					{
						System.out.println("Funciona el try and catch");
						
						String sql="select * from administradores";
						
						Statement st= con.createStatement();
						
						ResultSet rs= st.executeQuery(sql);
						
						
						while(rs.next())
						{
							String nombre= rs.getString("nombre");
							String apellido= rs.getString("apellido");
							String usuario1= rs.getString("usuario");
							String pass1= rs.getString("pass");
							String email= rs.getString("email");
							String direccion= rs.getString("direccion");
							
							//Esta línea es sólo demostrativa de que funcionan las variables que toman datos de la DB
							System.out.println(nombre+" "+apellido+" "+usuario1+" "+pass1+" "+email+" "+direccion);
							
							
							
							//Adherimos a la lista una fila nueva con una columna nueva.
							listado.add(new Administrador(nombre,apellido,usuario1,pass1,email,direccion));
							
							//Actualizamos el String del Json sin crearlo nuevamente.
							stringJson= gson.toJson(listado);
							
							ACCEPTED();	//ResponseBuilder 200
						}
						
					} 
			else
					{
						System.out.println("Algo Salió mal no se pueden ver los datos");
						UNAUTHORIZED();	//ResponseBuilder 401
					}
			}
			catch (Exception e) 
		
					{
						e.printStackTrace();
					}
		return stringJson;
		}
	
	
	//Consulta de administradores en la base de datos
	@POST
	@Path("/deleteAdministrador")
	@Produces(MediaType.TEXT_HTML)
	public String deleteAdministrador(@FormParam("usuario") String usuario){
		
		try
			{
		
			ConexionAeropuerto c= new ConexionAeropuerto();
			Connection con= c.connectarAhora();
			
			if(con!=null /*&& usuario.equalsIgnoreCase("") && pass.equalsIgnoreCase("")*/)
					{
				Statement st;
				st=con.createStatement();
				st.executeUpdate("DELETE FROM administradores WHERE usuario='"+usuario+"'");
				st.close();
				
						System.out.println("Funciona el try and catch, revisar la DB si se eleminó");
						CREADO();	//ResponseBuilder 200
					
					} 
			else
					{
						System.out.println("Algo Salió mal no se pueden ver los datos");
						UNAUTHORIZED();	  //ResponseBuilder 401
					}
			}
			catch (Exception e) 
		
					{
						e.printStackTrace();
						
					}
		
		return "Se borró el usuario: "+ usuario;
		}
	
	
	
	public static final ResponseBuilder ACCEPTED(){
		
		return Response.status(200);
	}
	
	
	public static final ResponseBuilder CREADO(){
		
		return Response.status(201);
	}
	
	public static final ResponseBuilder UNAUTHORIZED(){
		
		return Response.status(401);
	}


}

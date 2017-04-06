package org.comunidadIT.proyecto.controladores;


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
import org.comunidadIT.proyecto.accesoDatos.ConexionAeropuerto;
import org.comunidadIT.proyecto.entidades.Administrador;
import com.google.gson.Gson;



@Path("/administradores")
public class Administradores {
	
	String numerosLetras= new String("[^a-zA-Z0-9]+");
	String soloLetras= new String("[^a-zA-Z]+");
	String soloEmail= new String("[^a-zA-Z0-9@._-]");
	
	//Al final están los métodos Response declarados.
	//Inserta administrador en mysql table 'administradores' y genera un dato JSON en texto o archivo
	@POST
	@Path("/addAdministrador")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String insertarAdministrador(@FormParam("tablas") String tablas,@FormParam("nombre") String nombre , @FormParam("apellido") String apellido, @FormParam("usuario") String usuario, @FormParam("pass") String pass, @FormParam("email") String email, @FormParam("direccion") String direccion){
		
		//Creamos la lista y le ponemos las variables que a su vez están conectadas al construcctor de la Case Empleados
		List<Administrador> lista= new ArrayList<>();
			lista.add(new Administrador(nombre.trim().replaceAll(soloLetras, ""), apellido.trim().replaceAll(soloLetras, ""), usuario.trim().replaceAll(numerosLetras, ""), pass.trim().replaceAll(numerosLetras, ""), email.trim().replaceAll(soloEmail, ""), direccion.trim().replaceAll(numerosLetras, "") ));
			
				//Creamos un object Gson() que nos permite usar el toJson()
				Gson gson = new Gson();
			
				//Creamos un String y al mismo le aplicamos el toJson(objeto list)
				String JsonToString= gson.toJson(lista);
	
		try
			{
			//Probamos conectarnos
			ConexionAeropuerto c= new ConexionAeropuerto();
			Connection con= c.connectarAhora();
			
			//Si la conexión no es nula entonces realizar dos consultaa de insercción de datos y creación de tabla
			if(con==null || nombre.equalsIgnoreCase("") || apellido.equalsIgnoreCase("") || usuario.equalsIgnoreCase("") || pass.equalsIgnoreCase("") || email.equalsIgnoreCase("") || direccion.equalsIgnoreCase(""))
					{
				
						System.out.println("Algo Salió mal no se pudo insertar los datos");
						return "Algo Salió mal no se pudo insertar los datos";
						
					} 
			else
					{
						PreparedStatement ps;
						String sql="INSERT INTO administradores(tipo_admin, nombre, apellido, usuario, pass, email, direccion) VALUES(?, ?, ?, ?, ?, ?, ?)";
						ps= con.prepareStatement(sql);
						
						ps.setString(1, tablas);
						ps.setString(2, nombre.trim().replaceAll(soloLetras, ""));
						ps.setString(3, apellido.trim().replaceAll(soloLetras, ""));
						ps.setString(4, usuario.trim().replaceAll(numerosLetras, ""));
						ps.setString(5, pass.trim().replaceAll(numerosLetras, ""));
						ps.setString(6, email.trim().replaceAll(soloEmail, ""));
						ps.setString(7, direccion.trim().replaceAll(numerosLetras, ""));
						ps.executeUpdate();
						ps.close();
						System.out.println("Funciona el try and catch, los deberían haberse ingresado a la DB 'administradores'");
						return "Los datos del nuevo admin son:\n"+JsonToString;
					}
			}
			catch (SQLException e) 
		
					{
						e.printStackTrace();
					}
		
				//Retornamos el String anterior
				return JsonToString;
		}
	
	
}

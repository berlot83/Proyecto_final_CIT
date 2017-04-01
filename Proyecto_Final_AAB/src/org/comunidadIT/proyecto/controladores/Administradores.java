package org.comunidadIT.proyecto.controladores;


import java.sql.Connection;
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
	
	//Al final est�n los m�todos Response declarados.
	//Inserta administrador en mysql table 'administradores' y genera un dato JSON en texto o archivo
	@POST
	@Path("/addAdministrador")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String insertarAdministrador(@FormParam("tablas") String tablas,@FormParam("nombre") String nombre , @FormParam("apellido") String apellido, @FormParam("usuario") String usuario, @FormParam("pass") String pass, @FormParam("email") String email, @FormParam("direccion") String direccion){
		
	
		try
			{
			//Probamos conectarnos
			ConexionAeropuerto c= new ConexionAeropuerto();
			Connection con= c.connectarAhora();
			
			//Si la conexi�n no es nula entonces realizar dos consultaa de insercci�n de datos y creaci�n de tabla
			if(con==null || nombre.equalsIgnoreCase("") || apellido.equalsIgnoreCase("") || usuario.equalsIgnoreCase("") || pass.equalsIgnoreCase("") || email.equalsIgnoreCase("") || direccion.equalsIgnoreCase(""))
					{
				
						System.out.println("Algo Sali� mal no se pudo insertar los datos");
						return "Algo Sali� mal no se pudo insertar los datos";
						
					} 
			else
					{
						Statement st;
						st=con.createStatement();
						st.executeUpdate("INSERT INTO "+tablas+"(nombre,apellido,usuario,pass,email,direccion) VALUES('"+nombre.trim().replaceAll(soloLetras, "")+"','"+apellido.trim().replaceAll(soloLetras, "")+"','"+usuario.trim().replaceAll(numerosLetras, "")+"','"+pass.trim().replaceAll(numerosLetras, "")+"','"+email.trim().replaceAll(soloEmail, "")+"','"+direccion.trim().replaceAll(numerosLetras, "")+"')");
						st.close();
						System.out.println("Funciona el try and catch, los deber�an haberse ingresado a la DB 'administradores'");
						
						/*
						Statement createSt;
						createSt=con.createStatement();
						createSt.executeUpdate("CREATE TABLE IF NOT EXISTS empleados_"+usuario+"(personaId int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY, nombre text(11) NOT NULL, apellido text(11) NOT NULL, direccion text(20) NOT NULL, cargo text(20) NOT NULL, sueldo_cargo float NOT NULL, cargas_sociales float NOT NULL, vacaciones float NOT NULL, sueldo_neto float NOT NULL)");
						createSt.close();
						*/
						System.out.println("Funciona el try and catch y deber�a haberse creado una tabla nueva");
					}
			}
			catch (SQLException e) 
		
					{
						e.printStackTrace();
					}
		
		
		//Creamos la lista y le ponemos las variables que a su vez est�n conectadas al construcctor de la Case Empleados
		List<Administrador> lista= new ArrayList<>();
			lista.add(new Administrador(nombre.trim().replaceAll(soloLetras, ""), apellido.trim().replaceAll(soloLetras, ""), usuario.trim().replaceAll(numerosLetras, ""), pass.trim().replaceAll(numerosLetras, ""), email.trim().replaceAll(soloEmail, ""), direccion.trim().replaceAll(numerosLetras, "") ));
			
				//Creamos un object Gson() que nos permite usar el toJson()
				Gson gson = new Gson();
			
				//Creamos un String y al mismo le aplicamos el toJson(objeto list)
				String JsonToString= gson.toJson(lista);
				
				//Retornamos el String anterior
				return JsonToString;
		}
	
	
}

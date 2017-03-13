package aeropuerto_empleados;

import javax.ws.rs.PathParam;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

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

import data_access_object.ConexionAeropuerto;
import data_access_object.Insertar_Empleados;


@Path("/empleados")
public class Empleados {
	
		@GET
		@Path("/nombre/{nombre}")
		@Produces(MediaType.TEXT_HTML)
		public String agregarNombreEmpleados(@PathParam("nombre") String nombreEmpleado){
			
			return "<html>" + "<body><h3>" + "El nombre del empleado es: " + nombreEmpleado + "</h3></body>" + "</html>"; 
		}
		
		@GET
		@Path("/apellido/{apellido}")
		@Produces(MediaType.TEXT_HTML)
		public String agregarApellidoEmpleados(@PathParam("apellido") String apellidoEmpleado){
			
			return "<html>" + "<body><h3>" + "El apellido del empleado es: " + apellidoEmpleado + "</h3></body>" + "</html>";
		}
		
		@GET
		@Path("/direccion/{direccion}")
		@Produces(MediaType.TEXT_HTML)
		public String agregarDireccionEmpleados(@PathParam("direccion") String direccionEmpleado){
			
			return "<html>" + "<body><h3>" + "La direccion del empleado es: " + direccionEmpleado + "</h3></body>" + "</html>";
		}
		
		@GET
		@Path("/ocupacion/{ocupacion}")
		@Produces(MediaType.TEXT_HTML)
		public String agregarOcupacionEmpleados(@QueryParam("ocupacion") String ocupacionEmpleado){
			
			return "<html>" + "<body><h3>" + "La ocupacion del empleado es: " + ocupacionEmpleado + "</h3></body>" + "</html>";
		}
		
		@GET
		@Path("/nacionalidad/{nacionalidad}")
		@Produces(MediaType.TEXT_HTML)
		public String agregarNacionalidadEmpleados(@QueryParam("nacionalidad") String nacionalidadEmpleado){
			
			return "<html>" + "<body><h3>" + "La nacionalidad del empleado es: " + nacionalidadEmpleado + "</h3></body>" + "</html>";
		}
		
		@POST
		@Path("/insertarEmpleado")
		@Produces(MediaType.TEXT_HTML)
		public String insertarEmpleado(@FormParam("usuario") String usuario , @FormParam("pass") String pass){
			
			try
				{
			
				ConexionAeropuerto c= new ConexionAeropuerto();
				Connection con= c.connectarAhora();
				
				if(con!=null)
						{
							Statement st;
							st=con.createStatement();
							st.executeUpdate("INSERT INTO empleados(usuario,pass) VALUES('"+usuario+"','"+pass+"')");
							st.close();	
							System.out.println("Funciona el try and catch");
						} 
				else
						{
							System.out.println("Algo Salió mal no se pudo insertar los datos");
						}
				}
				catch (SQLException e) 
			
						{
							e.printStackTrace();
						}
			
			
				return "<html>" + "<body><h3>" + "El nombre del empleado es: "  + usuario + usuario + "<br>"+ "El apellido del empleado es: " + pass + "</h3></body>" + "</html>";
			}
		
		
		
		
		//Pruebas beta
		
		@GET
		@Path("/insertarEmpleado")
		@Produces(MediaType.TEXT_HTML)
		public boolean insertarEmpleadoBoolean(@QueryParam("usuario") String usuario , @QueryParam("pass") String pass, Administrador datos, ValidarUsuario datosDB){
			
			boolean insertado= false;
			
			try
				{
			
				ConexionAeropuerto c= new ConexionAeropuerto();
				Connection con= c.connectarAhora();
				
				if(con!=null)
						{
					 		ValidarUsuario.validarUsuario(datos);
							System.out.println("La validación se realizó correctamente");
							insertado= true;
							ACCEPTED();
							
						} 
				else
						{
							System.out.println("Algo Salió mal no se pudo insertar los datos");
							//insertado= false;
						}
				}
				catch (Exception e) 
			
						{
							e.printStackTrace();
						}
			
			
				return insertado;
			}
		
		
		public static final ResponseBuilder ACCEPTED(){
			
			return Response.status(200);
		}
		
		}

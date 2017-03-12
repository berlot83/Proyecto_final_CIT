//Esta clase queda en deshuso y reemplazada por "Autenticar Usuario.java"

package aeropuerto_empleados;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import data_access_object.ConexionAeropuerto;

public class ValidarUsuario {

	public static boolean validarUsuario(Empleado datos){
		
		boolean validado= false;

		try{
			
			ConexionAeropuerto c= new ConexionAeropuerto();
			Connection con= c.connectarAhora();
		
					if( con!=null)
					{
						Statement st;
						st=con.createStatement();
						ResultSet rs= st.executeQuery("select usuario, pass from administradores where id=89");
						
						while(rs.next())
						{
							String str_usuario= rs.getString("usuario");
							String str_pass= rs.getString("pass");
							
							
							
							if(str_pass.equals("hola") & str_pass.equals("mundo"))
							{
								System.out.println("debería funcionar la validación de:<br> Usuario:"+ str_usuario +"<br>"+ "Pass: "+ str_pass);
								validado=true;
							}
						}
						
						validado=true;
						
					}
		
			}
		catch(Exception e)
							{
								System.out.println("no se pudo validar");
							}
		
		
		return validado;
	}
	
}

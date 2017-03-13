//Esta clase está en deshuso en este proyecto, sólo sirve de ejemplo.

package data_access_object;

import java.sql.Connection;
import java.sql.Statement;

import aeropuerto_empleados.Administrador;

public class Insertar_Empleados {

	
	public static boolean insertarEmpleado(Administrador datos){
		
		boolean insertado= false;
		
		try{
			ConexionAeropuerto con= new ConexionAeropuerto();
			Connection c= con.connectarAhora();
			
			if(c!=null)
			{
				Statement st;
				st=c.createStatement();
				st.executeUpdate("INSERT INTO aeropuerto(nombre,apellido) VALUES('"+datos.getNombre()+"','"+datos.getApellido()+")'");
				insertado= true;
				st.close();
			}
			else
			{
				System.out.println("No se pudo conectar");
			}
		}
		catch(Exception e)
		{
			
		}
		return insertado;
	}
}

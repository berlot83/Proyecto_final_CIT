

/*Esta Clase está en completo deshuso en este proyecto, pero su código funciona bien*/
package data_access_object;

import java.sql.Connection;
import java.sql.Statement;

import aeropuerto_empleados.Empleado;

public class Insertar_Empleados {

	
	public static boolean insertarEmpleado(Empleado datos){
		
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

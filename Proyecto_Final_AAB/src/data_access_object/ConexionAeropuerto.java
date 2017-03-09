package data_access_object;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


//Forma de conexion sin clase est�tica ni m�todos booleanos.
public class ConexionAeropuerto {
	
	private Connection conexion=null;

	//Creamos el contructor para conectarnos.
	public ConexionAeropuerto(){
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conexion= DriverManager.getConnection("jdbc:mysql://localhost:3306/aeropuerto","root","");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	//Creamos el m�todo que nos devuelve la conexip�n
	public Connection connectarAhora(){
		return conexion;
	}
	
	//Creamos el m�todo que cierra la conecci�n.
	public void desconectarAhora(){
		try
		{
			conexion.close();
		}
		catch(SQLException e)
		{
			System.out.println("No se pudo cerrar la conexion");
		}
	}
}

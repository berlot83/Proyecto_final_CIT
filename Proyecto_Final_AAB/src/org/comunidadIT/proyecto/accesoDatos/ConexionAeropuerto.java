package org.comunidadIT.proyecto.accesoDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.comunidadIT.proyecto.entidades.Empleado;
import org.comunidadIT.proyecto.entidades.Persona;


//Forma de conexion sin clase estática ni métodos booleanos.
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
	
	//Creamos el método que nos devuelve la conexipón
	public Connection connectarAhora(){
		return conexion;
	}
	
	//Creamos el método que cierra la conección.
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

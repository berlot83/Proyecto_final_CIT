package org.comunidadIT.proyecto.validaciones;

import java.sql.Connection;

import org.comunidadIT.proyecto.accesoDatos.ConexionAeropuerto;

public class ValidarCantidadPasajeros {
	
	public static boolean validarCantidadPasajeros(int pasajes, int int_sql_pasajeros){
		
		boolean cantidadPasajeros= false;
		
		try
		{
			
			if(pasajes > int_sql_pasajeros)
			{
				System.out.println("Los pasajeros son mayores que la cantidad de asientos");
				cantidadPasajeros= false;
			}
			else
			{
				System.out.println("Los asientos alcanzan");
				cantidadPasajeros= true;
			}

		}
		catch(Exception e)
		{
			
		}
		return cantidadPasajeros;
	}

}
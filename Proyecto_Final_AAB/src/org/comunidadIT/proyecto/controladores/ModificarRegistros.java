package org.comunidadIT.proyecto.controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import org.comunidadIT.proyecto.accesoDatos.ConexionAeropuerto;
import org.comunidadIT.proyecto.entidades.Empleado;

import com.google.gson.Gson;

public class ModificarRegistros {
	
	public static void modificarRegistros(String usuarioAdmin, String nombre, String apellido, String direccion, String cargo, float sueldo_cargo, float cargas_sociales, float vacaciones, float sueldo_neto, String nombreRegistro){
		
		Gson gson= new Gson();
		ArrayList<Empleado> listado= new ArrayList<>();
		String stringToJson= null;
		
		try{
			ConexionAeropuerto c= new ConexionAeropuerto();
			Connection con= c.connectarAhora();
			
			if(con != null)
			{
				PreparedStatement ps;
				String sql= "update empleados_"+ usuarioAdmin +" set nombre=?, apellido=?, cargo=?, direccion=?, sueldo_cargo=?, cargas_sociales=?, vacaciones=?, sueldo_neto=? where id=1)";
				ps= con.prepareStatement(sql);
				
				ps.setString(1, nombre);
				ps.setString(2, apellido);
				ps.setString(3, direccion);
				ps.setString(4, cargo);
				ps.setFloat(5, sueldo_cargo);
				ps.setFloat(6, cargas_sociales);
				ps.setFloat(7, vacaciones);
				ps.setFloat(8, sueldo_neto);
				//ps.setString(9, nombreRegistro);
				
				listado.add(new Empleado(nombre, apellido, direccion, cargo, sueldo_cargo, cargas_sociales, vacaciones, sueldo_neto));
				stringToJson= gson.toJson(listado);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Algo salió mal, no se pudieron ingresar los datos.");
		}
	
	}

}

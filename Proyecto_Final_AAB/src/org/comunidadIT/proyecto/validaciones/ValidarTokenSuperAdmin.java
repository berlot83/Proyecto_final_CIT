package org.comunidadIT.proyecto.validaciones;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ValidarTokenSuperAdmin {
/*
	public static void main(String args[]){
		SimpleDateFormat formatoNuevo= new SimpleDateFormat("yyyy-MM-dd");
		Date fechaActual= new Date();
		
		String str_fechaActual= formatoNuevo.format(fechaActual);
		System.out.println(str_fechaActual);
	}
	*/
	public static boolean validarTokenSuperAdminFecha(String token){
		
		boolean validado= false;
		SimpleDateFormat formatoNuevo= new SimpleDateFormat("yyyy-MM-dd");
		Date fechaActual= new Date();
		
		String str_fechaActual= formatoNuevo.format(fechaActual);
		
			try
			{
				if(token.equals(str_fechaActual))
					{
						validado= true;
					}
				else
					{
						validado= false;
					}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return validado;
	}
	
}

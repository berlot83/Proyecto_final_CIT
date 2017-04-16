package org.comunidadIT.proyecto.validaciones;

import java.text.SimpleDateFormat;
import java.util.Date;

//Esta entrada de ejecución no debería ser eliminada, ya que sirve de 'test' por consola del Token que se usa en AutenticarSuperAdministrado.java.
public class ValidarTokenSuperAdmin {

	public static void main(String args[]){
		SimpleDateFormat formatoNuevo= new SimpleDateFormat("yyyy-MM-dd-HH-mm");
		Date fechaActual= new Date();
		
		String str_fechaActual= formatoNuevo.format(fechaActual);
		System.out.println(str_fechaActual);
	}
	
	
	//El 'token' funciona con el reloj de la máquina, hay que ingresar "yyyy-MM-dd-HH-mm" incluyendo los guiones centrales, Las HH expresadas en 24hs siempre, si son las 4 pm, colocar 16, y controlar que no cambie el minutero de la pc.
	public static boolean validarTokenSuperAdminFecha(String token){
		
		boolean validado= false;
		SimpleDateFormat formatoNuevo= new SimpleDateFormat("yyyy-MM-dd-HH-mm");
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

package org.comunidadIT.proyecto.validaciones;

public class ValidarDni {

public static boolean validarCantidadCaracteresDni(String dni){
		
		boolean dniVerificado= false;
		
		try{
			
			if(dni.length() != 8 )
					{
					System.out.println("La cantidad de caracteres para el cuit es distinta de 8");
					return dniVerificado= true;
					}
				else
					{
					System.out.println("La cantidad de caracteres es exactamente 8");
					return dniVerificado= false;
					}
		}
		catch(Exception e)
		{
			System.out.println("Hubo un error en el intento");
		}
		
		return dniVerificado;
	}
	
}

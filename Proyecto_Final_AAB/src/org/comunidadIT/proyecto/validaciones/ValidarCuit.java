package org.comunidadIT.proyecto.validaciones;


public class ValidarCuit {

	public static boolean validarCantidadCaracteresCuit(String cuit){
		
		boolean cuitVerificado= false;
		
		try{
			
			if(cuit.length() != 11 )
					{
					System.out.println("La cantidad de caracteres para el cuit es distinta de 11");
					return cuitVerificado= true;
					}
				else
					{
					System.out.println("La cantidad de caracteres es exactamente 11");
					return cuitVerificado= false;
					}
		}
		catch(Exception e)
		{
			System.out.println("Hubo un error en el intento");
		}
		
		return cuitVerificado;
	}
	
	
	//No funciona porque el cuit no soporta más de 10 caracteres, reverer o cambiar a otro tipo de dato.
	public static boolean validarNumerosCuit(String cuit){

	int numeros;
	
		try
			{
				numeros= Integer.parseInt(cuit);
				System.out.println("Son números");
				return true;
			}
	catch(Exception e)
		{
			System.out.println("no son números");
			return false;
		}
	
	}


}

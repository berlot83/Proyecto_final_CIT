package org.comunidadIT.proyecto.validaciones;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ValidarFechaEvento {
	
	public static boolean validarFechaEvento(String fecha){
		
	boolean validado=false;
	
	try{
		SimpleDateFormat formatoPretendido= new SimpleDateFormat("yyyy-MM-dd");
		Date fechaActual= new Date();
		
		Date fechaEvento= formatoPretendido.parse(fecha);
		String fechaActualFormato= formatoPretendido.format(fechaActual);
		Date fechaActualDate= formatoPretendido.parse(fechaActualFormato);
		
		
		
	if(fechaEvento.equals(fechaActualDate) || fechaEvento.before(fechaActualDate))
			{	
				System.out.println("Las dos fechas son iguales");
				return validado= false;
				
			}
			else
			{
				System.out.println("La fecha es posterior puede proseguir.");
				return validado= true;
			}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		return validado;
	}

	
}

package org.comunidadIT.proyecto.entidades;

import java.sql.Date;

public class Evento {

	protected int id_evento;
	protected String nombre;
	protected String fecha;
	
	public Evento(int id_evento, String nombre, String fecha){
		
		this.id_evento= id_evento;
		this.nombre= nombre;
		this.fecha= fecha;
	}
	
	public Evento(int id_evento, String nombre){
		
		this.id_evento= id_evento;
		this.nombre= nombre;
	}
}

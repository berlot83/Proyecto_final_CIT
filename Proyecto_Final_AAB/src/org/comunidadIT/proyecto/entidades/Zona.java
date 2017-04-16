package org.comunidadIT.proyecto.entidades;

public class Zona {

	protected int id_zona;
	protected String nombre;
	protected boolean cubierta;
	
	public Zona(int id_zona, String nombre, boolean cubierta){
		
		this.id_zona= id_zona;
		this.nombre= nombre;
		this.cubierta=cubierta;
	}
	
	public Zona(int id_zona, String nombre){
		
		this.id_zona= id_zona;
		this.nombre= nombre;
	}
}

package org.comunidadIT.proyecto.entidades;

public class Servicio {
	
	protected int id_servicio;
	protected String nombre;
	protected boolean estado;
	
	public Servicio(int id_servicio, String nombre){
		
		this.id_servicio= id_servicio;
		this.nombre= nombre;
	}
	
}

package org.comunidadIT.proyecto.entidades;

public class Servicio {
	
	protected int id_servicio;
	protected String nombre;
	protected boolean activo;
	
	public Servicio(int id_servicio, String nombre, boolean activo){
		
		this.id_servicio= id_servicio;
		this.nombre= nombre;
		this.activo= activo;
	}
	
	public Servicio(int id_servicio, String nombre){
		
		this.id_servicio= id_servicio;
		this.nombre= nombre;
	}
	
}

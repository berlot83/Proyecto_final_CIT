package org.comunidadIT.proyecto.entidades;

public class Avion {
	
	protected int id;
	protected String tipo_avion;
	protected String matricula;
	protected int cantidad_pasajeros;

	public Avion(int id, String tipo_avion, String matricula, int cantidad_pasajeros){
		
		this.id=id;
		this.tipo_avion=tipo_avion;
		this.matricula=matricula;
		this.cantidad_pasajeros=cantidad_pasajeros;
	}
	
	public Avion( String tipo_avion, String matricula, int cantidad_pasajeros){
		
		this.tipo_avion=tipo_avion;
		this.matricula=matricula;
		this.cantidad_pasajeros=cantidad_pasajeros;
	}
	
	public Avion(int id, String matricula, int cantidad_pasajeros){
		
		this.id=id;
		this.matricula=matricula;
		this.cantidad_pasajeros=cantidad_pasajeros;
	}
	
	public Avion( String matricula, int cantidad_pasajeros){
		
		this.matricula=matricula;
		this.cantidad_pasajeros=cantidad_pasajeros;
	}
	
	public Avion( String matricula){
		
		this.matricula=matricula;
	}
	
}

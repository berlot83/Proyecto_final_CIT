package org.comunidadIT.proyecto.entidades;

public class SuperAdministrador {
	
	private int id;
	private String redireccion;

	public SuperAdministrador(){
	
	}
	
	public SuperAdministrador(int id, String redireccion){
		this.id=id;
		this.redireccion=redireccion;
	}
	
				public void setRedireccion(String redireccion){
					this.redireccion=redireccion;
				}
				public String getRedireccion(){
					return redireccion;
				}
	
}

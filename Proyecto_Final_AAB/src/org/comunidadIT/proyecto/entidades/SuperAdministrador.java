package org.comunidadIT.proyecto.entidades;

public class SuperAdministrador {
	
	private String usuarioAdmin;
	private String redireccion;

	public SuperAdministrador(){
	
	}
	
	public SuperAdministrador(String usuarioAdmin, String redireccion){
		this.usuarioAdmin=usuarioAdmin;
		this.redireccion=redireccion;
	}
	
				public void setRedireccion(String redireccion){
					this.redireccion=redireccion;
				}
				public String getRedireccion(){
					return redireccion;
				}
	
}

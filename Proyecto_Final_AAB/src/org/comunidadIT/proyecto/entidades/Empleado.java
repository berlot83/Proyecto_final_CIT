package org.comunidadIT.proyecto.entidades;

public class Empleado {
	
	protected int personaId;
	protected String dni;
	protected String cuit;
	protected String nacimiento;
	protected String nombre;
	protected String apellido;
	protected String direccion;	
	protected String cargo;
	protected float sueldo_cargo;
	protected float cargas_sociales;
	protected float vacaciones;
	protected float sueldo_neto;
	
	
	public Empleado	(int personaId, String dni, String cuit, String nacimiento, String nombre, String apellido, String direccion, String cargo, float sueldo_cargo, float cargas_sociales, float vacaciones, float sueldo_neto){
		
		this.personaId= personaId;
		this.dni=dni;
		this.cuit=cuit;
		this.nacimiento=nacimiento;
		this.nombre=nombre;
		this.apellido=apellido;
		this.direccion=direccion;
		this.cargo=cargo;
		this.sueldo_cargo=sueldo_cargo;
		this.cargas_sociales=cargas_sociales;
		this.vacaciones=vacaciones;
		this.sueldo_neto=sueldo_neto;
	}
	
	public Empleado	(int personaId, String nombre, String apellido, String direccion, String cargo, float sueldo_cargo, float cargas_sociales, float vacaciones, float sueldo_neto){
		
		this.personaId= personaId;
		this.nombre=nombre;
		this.apellido=apellido;
		this.direccion=direccion;
		this.cargo=cargo;
		this.sueldo_cargo=sueldo_cargo;
		this.cargas_sociales=cargas_sociales;
		this.vacaciones=vacaciones;
		this.sueldo_neto=sueldo_neto;
		
	}
	
			
			public String getNombre() {
				return nombre;
			}
			public void setNombre(String nombre) {
				this.nombre = nombre;
			}
			public String getApellido() {
				return apellido;
			}
			public void setApellido(String apellido) {
				this.apellido = apellido;
			}
			public String getDireccion() {
				return direccion;
			}
			public void setDireccion(String direccion) {
				this.direccion = direccion;
			}
			public String getCargo() {
				return cargo;
			}
			public void setCargo(String cargo) {
				this.cargo = cargo;
			}
			public double getSueldo_cargo() {
				return sueldo_cargo;
			}
			public void setSueldo_cargo(float sueldo_cargo) {
				this.sueldo_cargo = sueldo_cargo;
			}
			public double getCargas_sociales() {
				return cargas_sociales;
			}
			public void setCargas_sociales(float cargas_sociales) {
				this.cargas_sociales = cargas_sociales;
			}
			public double getVacaciones() {
				return vacaciones;
			}
			public void setVacaciones(float vacaciones) {
				this.vacaciones = vacaciones;
			}
			public double getSueldo_neto() {
				return sueldo_neto;
			}
			public void setSueldo_neto(float sueldo_neto) {
				this.sueldo_neto = sueldo_neto;
			}

}

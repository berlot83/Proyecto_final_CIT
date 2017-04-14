package org.comunidadIT.proyecto.entidades;

public class Administrador {
	
	// Sobrecarga de constructores para insercción a DB de todos los datos y para validación de datos usuario y pass
	//protected int id;
	
	protected int id;
	protected String nombre;
	protected String apellido;
	protected String usuario;
	protected String pass;
	protected String email;
	protected String direccion;
	
	
			public Administrador(String nombre, String apellido, String usuario, String pass, String email, String direccion){
			
				this.nombre=nombre;
				this.apellido=apellido;
				this.usuario=usuario;
				this.pass=pass;
				this.email=email;
				this.direccion=direccion;
			}
			
			public Administrador(int id, String nombre, String apellido, String usuario, String pass, String email, String direccion){
				
				this.id=id;
				this.nombre=nombre;
				this.apellido=apellido;
				this.usuario=usuario;
				this.pass=pass;
				this.email=email;
				this.direccion=direccion;
			}
			
			
			public Administrador( String usuario, String pass){
				
				this.usuario= usuario;
				this.pass= pass;
			}
			
			public Administrador(int id, String usuario){
				
				this.id=id;
				this.usuario=usuario;
			}
			
			public Administrador(int id){
				
				this.id= id;
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
		
			public String getUsuario() {
				return usuario;
			}
		
			public void setUsuario(String usuario) {
				this.usuario = usuario;
			}
		
			public String getPass() {
				return pass;
			}
		
			public void setPass(String pass) {
				this.pass = pass;
			}
		
			public String getEmail() {
				return email;
			}
		
			public void setEmail(String email) {
				this.email = email;
			}
		
			public String getDireccion() {
				return direccion;
			}
		
			public void setDireccion(String direccion) {
				this.direccion = direccion;
			}

			
			//Por ahora el 'id' va a quedar inactivo hasta que se asigne a alguna consulta como parámetro para borrar datos.
		/*
			public int getId() {
				return id;
			}


			public void setId(int id) {
				this.id = id;
			}
			
		 */
		 
}


function agregarAdministrador(){
	
	var usuario= document.getElementById("usuario");
	var pass= document.getElementById("pass");
	var token= document.getElementById("token");
	var id= document.getElementById("inputId");
	var nombre= document.getElementById("nombre");
	var apellido= document.getElementById("apellido");
	var usuarioNuevoAdmin= document.getElementById("usuarioNuevoAdmin");
	var passNuevoAdmin= document.getElementById("passNuevoAdmin");
	var email= document.getElementById("email");
	var direccion= document.getElementById("direccion");
	var tipoAdministrador= document.getElementById("tipoAdministrador");
	
	var xhr= new XMLHttpRequest();
	var url= "/Proyecto_Final_AAB/rest/superAdministrador/agregarAdministrador";
	
	xhr.onreadystatechange= function(){
		if(this.readyState==4 && this.status==200){
		alert(xhr.responseText);	
			}	
		}
		xhr.open("POST", url, true);
		xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xhr.send("usuario="+usuario.value+"&pass="+pass.value+"&token="+token.value+"&nombre="+nombre.value+"&apellido="+apellido.value+"&usuarioNuevoAdmin="+usuarioNuevoAdmin.value+"&passNuevoAdmin="+passNuevoAdmin.value+"&email="+email.value+"&direccion="+direccion.value+"&tipoAdministrador="+tipoAdministrador.value);
}


function eliminarAdministrador(){
	
	var usuario= document.getElementById("usuario");
	var pass= document.getElementById("pass");
	var token= document.getElementById("token");
	var id= document.getElementById("inputId");
	
	var xhr= new XMLHttpRequest();
	var url= "/Proyecto_Final_AAB/rest/superAdministrador/deleteAdministrador";
	
	xhr.onreadystatechange= function(){
	if(this.readyState==4 && this.status==200){
	alert(xhr.responseText);	
		}	
	}
	xhr.open("DELETE", url, true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send("usuario="+usuario.value+"&pass="+pass.value+"&token="+token.value+"&id="+id.value);
}


function acciones(){
	
	var menu= document.getElementById("menu");
	
		if(menu.value=="seleccione"){
			//no deberia mostrar nada
		}
		
		if(menu.value=="consulta"){
			
			var tablaAgregarAdministrador= document.getElementById("agregarAdmin");
				tablaAgregarAdministrador.style.display= 'none';
	
	
			var tablaEliminarAdministrador= document.getElementById("eliminarAdmin");
				tablaEliminarAdministrador.style.display= 'none';
				
			var tablaVerAdministradores= document.getElementById("verAdministradores");
				tablaVerAdministradores.style.display= 'block';
			
		}
		
		if(menu.value=="agregar"){
			
			var tablaVerAdministradores= document.getElementById("verAdministradores");
			tablaVerAdministradores.style.display= 'none';
			
			var tablaAgregarAdministrador= document.getElementById("agregarAdmin");
				tablaAgregarAdministrador.style.display= 'block';
			
			
			var tablaEliminarAdministrador= document.getElementById("eliminarAdmin");
				tablaEliminarAdministrador.style.display= 'none';
		}
		
		if(menu.value=="eliminar"){
			
			var tablaVerAdministradores= document.getElementById("verAdministradores");
			tablaVerAdministradores.style.display= 'none';
			
			var tablaAgregarAdministrador= document.getElementById("agregarAdmin");
				tablaAgregarAdministrador.style.display= 'none';
		
		
			var tablaEliminarAdministrador= document.getElementById("eliminarAdmin");
				tablaEliminarAdministrador.style.display= 'block';
			
		}	
}



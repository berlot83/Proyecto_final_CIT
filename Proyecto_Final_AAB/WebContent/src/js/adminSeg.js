
function agregarServicio(){
	var usuario= document.getElementById("usuario");
	var pass= document.getElementById("pass");
	var nombre= document.getElementById("nombreServicio");
	var estadoServicio= document.getElementById("estadoServicio");
	var checkbox= document.getElementById("estadoServicio");
	

	
	if(checkbox.checked) {
		checkbox.value= 1;
		
	}
	else
		{
		checkbox.value=0;
		}
	
	

	
	var xmlhttp = new XMLHttpRequest();
	var url= "/Proyecto_Final_AAB/rest/adminSeg/agregarServicio";
	
	xmlhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {

			alert(xmlhttp.responseText);
			
			
		}
		
	}
	
	xmlhttp.open("POST", url, true);
	xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xmlhttp.send("usuario="+usuario.value+"&pass="+pass.value+"&nombre="+nombre.value+"&estadoServicio="+estadoServicio.value);

}
//TODO removeChild activo inactivo
function textoEstado(){
	var checkbox= document.getElementById("estadoServicio");
	
	var parrafo= document.createElement("p");
	var tdCheckbox= document.getElementById("tdCheckbox");
	var activo= document.createTextNode("Activo");
	var inactivo= document.createTextNode("Inactivo");
	
	if(checkbox.checked){
		
		tdCheckbox.appendChild(parrafo).style.color= 'green';
		parrafo.appendChild(activo);

		
	}
	else
		{
			tdCheckbox.appendChild(parrafo).style.color= 'red';
			parrafo.appendChild(inactivo);
	
	}
}

function acciones(){
	
	var menu= document.getElementById("menu");
	var divServicios= document.getElementById("divServicios");
	var divEventos= document.getElementById("divEventos");
	var divZonas= document.getElementById("divZonas");
	
	
	
	if(menu.value=="seleccione"){
		//Esconde todas las tablas.
		divServicios.style.display= 'none';
		divEventos.style.display= 'none';
		divZonas.style.display= 'none';
		
	}
	
	if(menu.value=="servicios"){
		divServicios.style.display= 'block';
		divEventos.style.display= 'none';
		divZonas.style.display= 'none';
	}
	
	if(menu.value=="eventos"){
		divServicios.style.display= 'none';
		divEventos.style.display= 'block';
		divZonas.style.display= 'none';
	}
	
	if(menu.value=="zonas"){
		divServicios.style.display= 'none';
		divEventos.style.display= 'none';
		divZonas.style.display= 'block';
	}
	
	
}


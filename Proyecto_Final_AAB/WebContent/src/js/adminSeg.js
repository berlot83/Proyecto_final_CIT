
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


function agregarEvento(){
	
	var usuario= document.getElementById("usuario");
	var pass= document.getElementById("pass");
	var nombre= document.getElementById("nombreEvento");
	var fecha= document.getElementById("fechaEvento");
	
	var xmlhttp = new XMLHttpRequest();
	var url= "/Proyecto_Final_AAB/rest/adminSeg/agregarEvento";
	
	xmlhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {

			alert(xmlhttp.responseText);
			
			
		}
		
	}
	
	xmlhttp.open("POST", url, true);
	xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xmlhttp.send("usuario="+usuario.value+"&pass="+pass.value+"&nombre="+nombre.value+"&fecha="+fecha.value);

}


function textoEstadoServicio(){
	var checkbox= document.getElementById("estadoServicio");
	var tdCheckbox= document.getElementById("tdCheckboxServicio");
	if (!tdCheckbox.childNodes[0]) tdCheckbox.appendChild(document.createTextNode(""));

	if(checkbox.checked){
		tdCheckbox.replaceChild(document.createTextNode("Activo"),tdCheckbox.childNodes[0]);
	    tdCheckbox.style.color= 'green';
	}
	else {
	    tdCheckbox.replaceChild(document.createTextNode("Inactivo"),tdCheckbox.childNodes[0]);
	    tdCheckbox.style.color= 'red';
		}

}


function textoEstadoZona(){

	var checkbox= document.getElementById("estadoZona");
	var tdCheckbox= document.getElementById("tdCheckboxZona");
	if (!tdCheckbox.childNodes[0]) tdCheckbox.appendChild(document.createTextNode(""));

	if(checkbox.checked){
		tdCheckbox.replaceChild(document.createTextNode("Cubierta"),tdCheckbox.childNodes[0]);
	    tdCheckbox.style.color= 'green';
	}
	else {
	    tdCheckbox.replaceChild(document.createTextNode("Descubierta"),tdCheckbox.childNodes[0]);
	    tdCheckbox.style.color= 'red';
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


function selectServicio(){
		
	var selectRellenar= document.getElementById("selectEliminarServicio");	
	
		var xmlhttp = new XMLHttpRequest();
		var url= "/Proyecto_Final_AAB/rest/adminSeg/selectServicio";
		
		xmlhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {	
				
				var datos= xmlhttp.responseText;
				
				parseJson= JSON.parse(xmlhttp.responseText);
				
				for(var i=0; i< xmlhttp.responseText.length; i++){
					
					var option = document.createElement("option");
						option.value= parseJson[i].id_servicio;
						option.appendChild(document.createTextNode(parseJson[i].nombre));
						selectRellenar.appendChild(option);
						
				}
			}
		}
		
		xmlhttp.open("POST", url, true);
		xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xmlhttp.send(null);
}


function selectEvento(){
	
	var selectRellenar= document.getElementById("selectEliminarEvento");	
	
		var xmlhttp = new XMLHttpRequest();
		var url= "/Proyecto_Final_AAB/rest/adminSeg/selectEvento";
		
		xmlhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {		
				
				alert(xmlhttp.responseText);
				
				var datos= xmlhttp.responseText;
				
				parseJson= JSON.parse(xmlhttp.responseText);
				
				for(var i=0; i< xmlhttp.responseText.length; i++){
					
					var option = document.createElement("option");
						option.value= parseJson[i].id_evento;
						option.appendChild(document.createTextNode(parseJson[i].nombre));
						selectRellenar.appendChild(option);
				}
				
			}
			
		}
		
		xmlhttp.open("POST", url, true);
		xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xmlhttp.send(null);
}


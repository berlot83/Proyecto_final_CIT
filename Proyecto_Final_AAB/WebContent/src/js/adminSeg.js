
function verServicios(){
	
	var usuario= document.getElementById("usuario");
	var pass= document.getElementById("pass");
	
	var xmlhttp = new XMLHttpRequest();
	var url= "/Proyecto_Final_AAB/rest/adminSeg/verServicios";
	
	if(usuario=="" && pass==""){
		
		alert("Los campos 'usuario' y 'pass' no pueden quedar en blanco.");

		}
	else
		{
						
			xmlhttp.onreadystatechange= function(){
				if(this.readyState==4 && this.status==200){
				
				
			//Creación de títulos
			//Elegimos el elemento donde Totos los 'td' van a ser adheridos
			var	tablaElegida= document.getElementById("tablaElegida");
			
			var cabecera = ["-ID-", "nombre", "Estado"];
			
			for( var i=0; i < cabecera.length; i++)
			{
					var	tablaElegida= document.getElementById("tablaElegida");
					
					var crearTitulos=document.createElement("td");
					
					var textoNombre= document.createTextNode(cabecera[i]);
					
					crearTitulos.appendChild(textoNombre);
					
					tablaElegida.appendChild(crearTitulos).style.border = "solid yellow";
			}

					
					//Esta es la respuesta del servidor, sobre esta recaen todas las acciones.
					var datos= xmlhttp.responseText;
					
					//Parseamos los datos
					var parseDatos= JSON.parse(datos);
					
			
					//Iteramos sobre la respuesta del JSON
					for(var i=0; i < xmlhttp.responseText.length; i++){
				
						
						//Creamos un renglon por cada elemento que iteramos
							var hilera= document.createElement("tr");
							var	tablaElegida= document.getElementById("tablaElegida");
								tablaElegida.appendChild(hilera);
					
								
						//id_servicio
							//Creamos los td  que contendrán los resultados
							var newtdId_servicio= document.createElement("td");
								
							//Adherimos los td a la tabla ya existente
							tablaElegida.appendChild(newtdId_servicio).style.border = "thin solid white";
								
							//Creamos el texto y aherimos las columnas parseadas
							var textoId_servicio= document.createTextNode(parseDatos[i].id_servicio);
								
							//Adherimos el texto ya creado a los td
							newtdId_servicio.appendChild(textoId_servicio);
								
						
						//Nombre
							//Creamos los td  que contendrán los resultados
							var newtdNombre= document.createElement("td");
							
							//Adherimos los td a la tabla ya existente
							tablaElegida.appendChild(newtdNombre).style.border = "thin solid white";
							
							//Creamos el texto y aherimos las columnas parseadas
							var textoNombre= document.createTextNode(parseDatos[i].nombre);
							
							//Adherimos el texto ya creado a los td
							newtdNombre.appendChild(textoNombre);	
							
							
						
							//TODO Revisar el cambio de colores en los true y false
							//Activo
								if(parseDatos[i].activo==true)
									{
										parseDatos[i].activo="Activo";
										//newtdActivo.style.color='green';
									}
								else
									{
										parseDatos[i].activo="Inactivo";
										//newtdActivo.style.color='red';
									}
							//Creamos los td  que contendrán los resultados
							var newtdActivo= document.createElement("td");
							
							//Adherimos los td a la tabla ya existente
							tablaElegida.appendChild(newtdActivo).style.border = "thin solid white";
							
							//Creamos el texto y aherimos las columnas parseadas
							var textoActivo= document.createTextNode(parseDatos[i].activo);
							
							//Adherimos el texto ya creado a los td
							newtdActivo.appendChild(textoActivo);
						}
					}
				}
			}
	xmlhttp.open("POST", url, true);
	xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xmlhttp.send("usuario="+usuario.value+"&pass="+pass.value);
}

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
	
	
	if(nombre.value=="")
			{
				alert("Algún campo pudo quedar en blanco, verifique los campos ingresados.")
			}
		else
			{
	
				var xmlhttp = new XMLHttpRequest();
				var url= "/Proyecto_Final_AAB/rest/adminSeg/agregarServicio";
				
				xmlhttp.onreadystatechange = function() {
					if (this.readyState == 4 && this.status == 200) {
			
						alert(xmlhttp.responseText);		
					}
				}
		
			}
	xmlhttp.open("POST", url, true);
	xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xmlhttp.send("usuario="+usuario.value+"&pass="+pass.value+"&nombre="+nombre.value+"&estadoServicio="+estadoServicio.value);

}

function eliminarServicio(){
	
	var usuario= document.getElementById("usuario");
	var pass= document.getElementById("pass");
	var id_servicio= document.getElementById("selectEliminarServicio");
	
	var xmlhttp = new XMLHttpRequest();
	var url= "/Proyecto_Final_AAB/rest/adminSeg/eliminarServicio";
	
	xmlhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {

			alert(xmlhttp.responseText);

		}
		
	}
	
	xmlhttp.open("DELETE", url, true);
	xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xmlhttp.send("usuario="+usuario.value+"&pass="+pass.value+"&id_servicio="+id_servicio.value);

}


function verEventos(){
	
	var usuario= document.getElementById("usuario");
	var pass= document.getElementById("pass");
	
	var xmlhttp = new XMLHttpRequest();
	var url= "/Proyecto_Final_AAB/rest/adminSeg/verEventos";
	
	if(usuario=="" && pass==""){
		
		alert("Los campos 'usuario' y 'pass' no pueden quedar en blanco.")

		}
	else
		{
						
			xmlhttp.onreadystatechange= function(){
				if(this.readyState==4 && this.status==200){
				
				
			//Creación de títulos
			//Elegimos el elemento donde Totos los 'td' van a ser adheridos
			var	tablaElegida= document.getElementById("tablaElegida");
			
			var cabecera = ["-ID-", "nombre", "Fecha"];
			
			for( var i=0; i < cabecera.length; i++)
			{
					var	tablaElegida= document.getElementById("tablaElegida");
					
					var crearTitulos=document.createElement("td");
					
					var textoNombre= document.createTextNode(cabecera[i]);
					
					crearTitulos.appendChild(textoNombre);
					
					tablaElegida.appendChild(crearTitulos).style.border = "solid yellow";
			}

					
					//Esta es la respuesta del servidor, sobre esta recaen todas las acciones.
					var datos= xmlhttp.responseText;
					
					//Parseamos los datos
					var parseDatos= JSON.parse(datos);
					
			
					//Iteramos sobre la respuesta del JSON
					for(var i=0; i < xmlhttp.responseText.length; i++){
				
						
						//Creamos un renglon por cada elemento que iteramos
							var hilera= document.createElement("tr");
							var	tablaElegida= document.getElementById("tablaElegida");
								tablaElegida.appendChild(hilera);
					
								
						//id_evento
							//Creamos los td  que contendrán los resultados
							var newtdId_evento= document.createElement("td");
								
							//Adherimos los td a la tabla ya existente
							tablaElegida.appendChild(newtdId_evento).style.border = "thin solid white";
								
							//Creamos el texto y aherimos las columnas parseadas
							var textoId_evento= document.createTextNode(parseDatos[i].id_evento);
								
							//Adherimos el texto ya creado a los td
							newtdId_evento.appendChild(textoId_evento);
								
						
						//Nombre
							//Creamos los td  que contendrán los resultados
							var newtdNombre= document.createElement("td");
							
							//Adherimos los td a la tabla ya existente
							tablaElegida.appendChild(newtdNombre).style.border = "thin solid white";
							
							//Creamos el texto y aherimos las columnas parseadas
							var textoNombre= document.createTextNode(parseDatos[i].nombre);
							
							//Adherimos el texto ya creado a los td
							newtdNombre.appendChild(textoNombre);	
							
							
						//Fecha
							//Creamos los td  que contendrán los resultados
							var newtdFecha= document.createElement("td");
							
							//Adherimos los td a la tabla ya existente
							tablaElegida.appendChild(newtdFecha).style.border = "thin solid white";
							
							//Creamos el texto y aherimos las columnas parseadas
							var textoFecha= document.createTextNode(parseDatos[i].fecha);
							
							//Adherimos el texto ya creado a los td
							newtdFecha.appendChild(textoFecha);
						}
					}
				}
			}
	xmlhttp.open("POST", url, true);
	xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xmlhttp.send("usuario="+usuario.value+"&pass="+pass.value);
}


function agregarEvento(){
	
	var usuario= document.getElementById("usuario");
	var pass= document.getElementById("pass");
	var nombre= document.getElementById("nombreEvento");
	var fecha= document.getElementById("fechaEvento");
	
	var xmlhttp = new XMLHttpRequest();
	var url= "/Proyecto_Final_AAB/rest/adminSeg/agregarEvento";
	
	if(nombre.value=="" && fecha.value=="")
		{
			alert("Algún campo pudo quedar en blanco, verifique los campos ingresados.")
		}
	else
		{
			xmlhttp.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
		
					alert(xmlhttp.responseText);
			
			}
		}
		
	}
	
	xmlhttp.open("POST", url, true);
	xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xmlhttp.send("usuario="+usuario.value+"&pass="+pass.value+"&nombre="+nombre.value+"&fecha="+fecha.value);

}

function eliminarEvento(){
	
	var usuario= document.getElementById("usuario");
	var pass= document.getElementById("pass");
	var id_evento= document.getElementById("selectEliminarEvento");
	
	var xmlhttp = new XMLHttpRequest();
	var url= "/Proyecto_Final_AAB/rest/adminSeg/eliminarEvento";
	
	xmlhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {

			alert(xmlhttp.responseText);

		}
		
	}
	
	xmlhttp.open("DELETE", url, true);
	xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xmlhttp.send("usuario="+usuario.value+"&pass="+pass.value+"&id_evento="+id_evento.value);

}


function verZonas(){
	
	var usuario= document.getElementById("usuario");
	var pass= document.getElementById("pass");
	
	var xmlhttp = new XMLHttpRequest();
	var url= "/Proyecto_Final_AAB/rest/adminSeg/verZonas";
	
	if(usuario=="" && pass==""){
		
		alert("Los campos 'usuario' y 'pass' no pueden quedar en blanco.")

		}
	else
		{
						
			xmlhttp.onreadystatechange= function(){
				if(this.readyState==4 && this.status==200){
				
				
			//Creación de títulos
			//Elegimos el elemento donde Totos los 'td' van a ser adheridos
			var	tablaElegida= document.getElementById("tablaElegida");
			
			var cabecera = ["-ID-", "nombre", "Cubierta"];
			
			for( var i=0; i < cabecera.length; i++)
			{
					var	tablaElegida= document.getElementById("tablaElegida");
					
					var crearTitulos=document.createElement("td");
					
					var textoNombre= document.createTextNode(cabecera[i]);
					
					crearTitulos.appendChild(textoNombre);
					
					tablaElegida.appendChild(crearTitulos).style.border = "solid yellow";
			}

					
					//Esta es la respuesta del servidor, sobre esta recaen todas las acciones.
					var datos= xmlhttp.responseText;
					
					//Parseamos los datos
					var parseDatos= JSON.parse(datos);
					
			
					//Iteramos sobre la respuesta del JSON
					for(var i=0; i < xmlhttp.responseText.length; i++){
				
						
						//Creamos un renglon por cada elemento que iteramos
							var hilera= document.createElement("tr");
							var	tablaElegida= document.getElementById("tablaElegida");
								tablaElegida.appendChild(hilera);
					
								
						//id_zona
							//Creamos los td  que contendrán los resultados
							var newtdId_zona= document.createElement("td");
								
							//Adherimos los td a la tabla ya existente
							tablaElegida.appendChild(newtdId_zona).style.border = "thin solid white";
								
							//Creamos el texto y aherimos las columnas parseadas
							var textoId_zona= document.createTextNode(parseDatos[i].id_zona);
								
							//Adherimos el texto ya creado a los td
							newtdId_zona.appendChild(textoId_zona);
								
						
						//Nombre
							//Creamos los td  que contendrán los resultados
							var newtdNombre= document.createElement("td");
							
							//Adherimos los td a la tabla ya existente
							tablaElegida.appendChild(newtdNombre).style.border = "thin solid white";
							
							//Creamos el texto y aherimos las columnas parseadas
							var textoNombre= document.createTextNode(parseDatos[i].nombre);
							
							//Adherimos el texto ya creado a los td
							newtdNombre.appendChild(textoNombre);	
						
							
						//TODO Revisar el cambio de colores en los true y false
						//Cubierta
							if(parseDatos[i].cubierta==true)
								{
									parseDatos[i].cubierta="Protegida";
									//newtdCubierta.style.color='green';
								}
							else
								{
									parseDatos[i].cubierta="Desprotegida";
									//newtdCubierta.style.color='red';
								}
							
							//Creamos los td  que contendrán los resultados
							var newtdCubierta= document.createElement("td");
							
							//Adherimos los td a la tabla ya existente
							tablaElegida.appendChild(newtdCubierta).style.border = "thin solid white";
							
							//Creamos el texto y aherimos las columnas parseadas
							var textoCubierta= document.createTextNode(parseDatos[i].cubierta);
							
							//Adherimos el texto ya creado a los td
							newtdCubierta.appendChild(textoCubierta);
						}
					}
				}
			}
	xmlhttp.open("POST", url, true);
	xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xmlhttp.send("usuario="+usuario.value+"&pass="+pass.value);
}


function agregarZona(){
	var usuario= document.getElementById("usuario");
	var pass= document.getElementById("pass");
	var nombre= document.getElementById("nombreZona");
	var checkbox= document.getElementById("estadoZona");
	
	if(checkbox.checked) {
		checkbox.value= 1;
		
	}
	else
		{
		checkbox.value=0;
		}
	
	var xmlhttp = new XMLHttpRequest();
	var url= "/Proyecto_Final_AAB/rest/adminSeg/agregarZona";
	
	xmlhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {

			alert(xmlhttp.responseText);
			
			
		}
		
	}
	
	xmlhttp.open("POST", url, true);
	xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xmlhttp.send("usuario="+usuario.value+"&pass="+pass.value+"&nombre="+nombre.value+"&cubierta="+checkbox.value);

}


function eliminarZona(){
	
	var usuario= document.getElementById("usuario");
	var pass= document.getElementById("pass");
	var id_zona= document.getElementById("selectEliminarZona");
	
	var xmlhttp = new XMLHttpRequest();
	var url= "/Proyecto_Final_AAB/rest/adminSeg/eliminarZona";
	
	xmlhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {

			alert(xmlhttp.responseText);

		}
		
	}
	
	xmlhttp.open("DELETE", url, true);
	xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xmlhttp.send("usuario="+usuario.value+"&pass="+pass.value+"&id_zona="+id_zona.value);

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


function selectZona(){
	
	var selectRellenar= document.getElementById("selectEliminarZona");	
	
		var xmlhttp = new XMLHttpRequest();
		var url= "/Proyecto_Final_AAB/rest/adminSeg/selectZona";
		
		xmlhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {		
				
				var datos= xmlhttp.responseText;
				
				parseJson= JSON.parse(xmlhttp.responseText);
				
				for(var i=0; i< xmlhttp.responseText.length; i++){
					
					var option = document.createElement("option");
						option.value= parseJson[i].id_zona;
						option.appendChild(document.createTextNode(parseJson[i].nombre));
						selectRellenar.appendChild(option);
				}
				
			}
			
		}
		
		xmlhttp.open("POST", url, true);
		xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xmlhttp.send(null);
}


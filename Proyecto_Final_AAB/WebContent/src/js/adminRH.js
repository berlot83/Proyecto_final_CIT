
function consultaNombreEmpleado(){
	var usuario= document.getElementById("usuario");
	var pass= document.getElementById("pass");
	var apellido= document.getElementById("apellido");
	
	var xmlhttp = new XMLHttpRequest();
	var url= "/Proyecto_Final_AAB/rest/empleados/consultaNombreEmpleado";
	
	xmlhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			 
			alert(xmlhttp.responseText);
		}
		
	}
	
	xmlhttp.open("GET", url, true);
	xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xmlhttp.send("?usuario="+usuario.value+"&pass="+pass.value+"&apellido="+apellido.value);
}


function insertarEmpleado(){
	
	var usuario= document.getElementById("usuario");
	var pass= document.getElementById("pass");
	var dni= document.getElementById("dni");
	var cuit= document.getElementById("cuit");
	var nacimiento= document.getElementById("nacimiento");
	var nombre= document.getElementById("nombre");
	var apellido= document.getElementById("apellido");
	var direccion= document.getElementById("direccion");
	var cargo= document.getElementById("cargo");
	var sueldo_cargo= document.getElementById("sueldo_cargo");
	var cargas_sociales= document.getElementById("cargas_sociales");
	var vacaciones= document.getElementById("vacaciones");
	var sueldo_neto= document.getElementById("sueldo_neto");
	
	var xmlhttp= new XMLHttpRequest();
	var url= "/Proyecto_Final_AAB/rest/empleados/insertarEmpleado";
	
	
	xmlhttp.onreadystatechange= function(){
		
		if(this.readyState == 4 && this.status == 200){
			
			if(usuario.value=="" || pass.value=="" || dni.value=="" || cuit.value=="" || nacimiento.value=="" || nombre.value=="" || apellido.value=="" || direccion.value=="" || cargo.value=="" || sueldo_cargo.value=="" || cargas_sociales.value=="" || vacaciones.value=="" || sueldo_neto.value==""){
				
					alert("Ningun campo puede quedar en blanco.")
				
				}
			else
				{
					alert(xmlhttp.responseText);		
				}
				
			}
		
	}
	
	xmlhttp.open("POST", url, true);
	xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xmlhttp.send("usuario="+usuario.value+"&pass="+pass.value+"&dni="+dni.value+"&cuit="+cuit.value+"&nacimiento="+nacimiento.value+"&nombre="+nombre.value+"&apellido="+apellido.value+"&direccion="+direccion.value+"&cargo="+cargo.value+"&sueldo_cargo="+sueldo_cargo.value+"&cargas_sociales="+cargas_sociales.value+"&vacaciones="+vacaciones.value+"&sueldo_neto="+sueldo_neto.value);
}


function verEmpleados(){
	
	var usuario= document.getElementById("usuario").value;
	var	pass= document.getElementById("pass").value;
	
	var xhr= new XMLHttpRequest();
	url= "/Proyecto_Final_AAB/rest/empleados/consultaTodosEmpleados";
	
	
	
	if(usuario=="" && pass==""){
		
			alert("Los campos 'usuario' y 'pass' no pueden quedar en blanco.")
	
		}
	else
		{
		
		xhr.onreadystatechange= function(){
		if(this.readyState==4 && this.status==200){
		
			
		//Creación de títulos
		//Elegimos el elemento donde Totos los 'td' van a ser adheridos
		var	ulElegido= document.getElementById("ulTabla");
		
		var cabecera = ["-ID-", "Dni", "CUIT", "Fecha nac.", "Nombre", "apellido", "direccion", "Cargo", "sueldo cargo", "Cargas sociales", "vacaciones", "Sueldo neto"];
		
		for( var i=0; i < cabecera.length; i++)
		{
				var	ulElegido= document.getElementById("ulTabla");
				
				var crearTitulos=document.createElement("td");
				
				var textoNombre= document.createTextNode(cabecera[i]);
				
				crearTitulos.appendChild(textoNombre);
				
				ulElegido.appendChild(crearTitulos).style.border = "solid yellow";
		}

				
				//Esta es la respuesta del servidor, sobre esta recaen todas las acciones.
				var datos= xhr.responseText;
				
				//Parseamos los datos
				var parseDatos= JSON.parse(datos);
				
		
				//Iteramos sobre la respuesta del JSON
				for(var i=0; i < xhr.responseText.length; i++){
			
					
					//Creamos un renglon por cada elemento que iteramos
						var hilera= document.createElement("tr");
						var	tablaElegida= document.getElementById("ulTabla");
							tablaElegida.appendChild(hilera);
				
							
					//personaId
						//Creamos los td  que contendrán los resultados
						var newtdpersonaId= document.createElement("td");
							
						//Adherimos los td a la tabla ya existente
						ulElegido.appendChild(newtdpersonaId).style.border = "thin solid white";
							
						//Creamos el texto y aherimos las columnas parseadas
						var textoPersonaId= document.createTextNode(parseDatos[i].personaId);
							
						//Adherimos el texto ya creado a los td
						newtdpersonaId.appendChild(textoPersonaId);
							
					
					//Dni
						//Creamos los td  que contendrán los resultados
						var newtdDni= document.createElement("td");
						
						//Adherimos los td a la tabla ya existente
						ulElegido.appendChild(newtdDni).style.border = "thin solid white";
						
						//Creamos el texto y aherimos las columnas parseadas
						var textoDni= document.createTextNode(parseDatos[i].dni);
						
						//Adherimos el texto ya creado a los td
						newtdDni.appendChild(textoDni);	
						
						
					//Cuit
						//Creamos los td  que contendrán los resultados
						var newtdCuit= document.createElement("td");
						
						//Adherimos los td a la tabla ya existente
						ulElegido.appendChild(newtdCuit).style.border = "thin solid white";
						
						//Creamos el texto y aherimos las columnas parseadas
						var textoCuit= document.createTextNode(parseDatos[i].cuit);
						
						//Adherimos el texto ya creado a los td
						newtdCuit.appendChild(textoCuit);
						
					//Nacimiento
						//Creamos los td  que contendrán los resultados
						var newtdNacimiento= document.createElement("td");
						
						//Adherimos los td a la tabla ya existente
						ulElegido.appendChild(newtdNacimiento).style.border = "thin solid white";
						
						//Creamos el texto y aherimos las columnas parseadas
						var textoNacimiento= document.createTextNode(parseDatos[i].nacimiento);
						
						//Adherimos el texto ya creado a los td
						newtdNacimiento.appendChild(textoNacimiento);
						
							
					//Nombre
						//Creamos los td  que contendrán los resultados
						var newtdNombre= document.createElement("td");
						
						//Adherimos los td a la tabla ya existente
						ulElegido.appendChild(newtdNombre).style.border = "thin solid white";
						
						//Creamos el texto y aherimos las columnas parseadas
						var textoNombre= document.createTextNode(parseDatos[i].nombre);
						
						//Adherimos el texto ya creado a los td
						newtdNombre.appendChild(textoNombre);
						
						
					//Apellido
						//Elegimos el elemento donde vamos a adherir los td nuevos
						
						//Creamos los td  que contendrán los resultados
						var newtdApellido= document.createElement("td");
						
						//Adherimos los td a la tabla ya existente
						ulElegido.appendChild(newtdApellido).style.border = "thin solid white";
						
						//Creamos el texto y aherimos las columnas parseadas
						var textoApellido= document.createTextNode(parseDatos[i].apellido);
						
						//Adherimos el texto ya creado a los td
						newtdApellido.appendChild(textoApellido);
						
						
					//Direccion
						//Elegimos el elemento donde vamos a adherir los td nuevos
						
						//Creamos los td  que contendrán los resultados
						var newtdDireccion= document.createElement("td");
						
						//Adherimos los td a la tabla ya existente
						ulElegido.appendChild(newtdDireccion).style.border = "thin solid white";
						
						//Creamos el texto y aherimos las columnas parseadas
						var textoDireccion= document.createTextNode(parseDatos[i].direccion);
						
						//Adherimos el texto ya creado a los td
						newtdDireccion.appendChild(textoDireccion);
										
						
					//Cargo
						//Elegimos el elemento donde vamos a adherir los td nuevos
						
						//Creamos los td  que contendrán los resultados
						var newtdCargo= document.createElement("td");
						
						//Adherimos los td a la tabla ya existente
						ulElegido.appendChild(newtdCargo).style.border = "thin solid white";
						
						//Creamos el texto y aherimos las columnas parseadas
						var textoCargo= document.createTextNode(parseDatos[i].cargo);
						
						//Adherimos el texto ya creado a los td
						newtdCargo.appendChild(textoCargo);
						
						
					//Sueldo_cargo
						//Elegimos el elemento donde vamos a adherir los td nuevos
						
						//Creamos los td  que contendrán los resultados
						var newtdSueldo_cargo= document.createElement("td");
						
						//Adherimos los td a la tabla ya existente
						ulElegido.appendChild(newtdSueldo_cargo).style.border = "thin solid white";
						
						//Creamos el texto y aherimos las columnas parseadas
						var textoSueldo_cargo= document.createTextNode(parseDatos[i].sueldo_cargo);
						
						//Adherimos el texto ya creado a los td
						newtdSueldo_cargo.appendChild(textoSueldo_cargo);
						
						
					//Cargas sociales
						//Elegimos el elemento donde vamos a adherir los td nuevos
						
						//Creamos los td  que contendrán los resultados
						var newtdCargas_sociales= document.createElement("td");
						
						//Adherimos los td a la tabla ya existente
						ulElegido.appendChild(newtdCargas_sociales).style.border = "thin solid white";
						
						//Creamos el texto y aherimos las columnas parseadas
						var textoCargas_sociales= document.createTextNode(parseDatos[i].cargas_sociales);
						
						//Adherimos el texto ya creado a los td
						newtdCargas_sociales.appendChild(textoCargas_sociales);
						
						
					//Vacaciones
						//Elegimos el elemento donde vamos a adherir los td nuevos
						
						//Creamos los td  que contendrán los resultados
						var newtdVacaciones= document.createElement("td");
						
						//Adherimos los td a la tabla ya existente
						ulElegido.appendChild(newtdVacaciones).style.border = "thin solid white";
						
						//Creamos el texto y aherimos las columnas parseadas
						var textoVacaciones= document.createTextNode(parseDatos[i].vacaciones);
						
						//Adherimos el texto ya creado a los td
						newtdVacaciones.appendChild(textoVacaciones);
						
						
					//Sueldo_neto
						//Elegimos el elemento donde vamos a adherir los td nuevos
						
						//Creamos los td  que contendrán los resultados
						var newtdSueldo_neto= document.createElement("td");
						
						//Adherimos los td a la tabla ya existente
						ulElegido.appendChild(newtdSueldo_neto).style.border = "thin solid white";
						
						//Creamos el texto y aherimos las columnas parseadas
						var textoSueldo_neto= document.createTextNode(parseDatos[i].sueldo_neto);
						
						//Adherimos el texto ya creado a los td
						newtdSueldo_neto.appendChild(textoSueldo_neto);
						
						
						//Reseteamos los campos
						document.getElementById("usuario").value="";
						document.getElementById("pass").value="";
					}
			
			}
			
		}
			
	}
	//Captamos el endpoint lo declaramos asincrono le decimos que se fije en los parametros que requiera y por último lo enviamos
	xhr.open("POST", url, false);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send("usuario="+usuario+"&pass="+pass);
	
}


//Borrar empleados de la Base de datos.
function borrarEmpleado(){
	
	var usuario= document.getElementById("usuario").value;
	var pass= document.getElementById("pass").value;
	var id_empleado= document.getElementById("deleteId").value;
	
	
						var xhr= new XMLHttpRequest();
						var url= "/Proyecto_Final_AAB/rest/empleados/deleteEmpleado";
						
						xhr.onreadystatechange= function(){
							if(this.readyState == 4 && this.status == 200){
								alert(xhr.responseText);
							}
						}
						
						xhr.open("DELETE", url, false);
						xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
						xhr.send("usuario="+usuario+"&pass="+pass+"&id_empleado="+id_empleado);
				
		}


function modificarEmpleado(){
	
	var usuario= document.getElementById("usuario").value;
	var pass= document.getElementById("pass").value;
	var nombre= document.getElementById("modificarNombre").value;
	var apellido= document.getElementById("modificarApellido").value;
	var direccion= document.getElementById("modificarDireccion").value;
	var cargo= document.getElementById("modificarCargo").value;
	var sueldo_cargo= document.getElementById("modificarSueldo_cargo").value;
	var cargas_sociales= document.getElementById("modificarCargas_sociales").value;
	var vacaciones= document.getElementById("modificarVacaciones").value;
	var sueldo_neto= document.getElementById("modificarSueldo_neto").value;
	var id_empleado= document.getElementById("personaId").value;
	
	var xhr= new XMLHttpRequest();
	var url= "/Proyecto_Final_AAB/rest/empleados/modificarEmpleado";
	
	xhr.onreadystatechange= function(){
		
		if(this.readyState==4 && this.status==200){
			alert(xhr.responseText);
		}
	}
	
	xhr.open("PUT", url, false);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send("usuario="+usuario+"&pass="+pass+"&nombre="+nombre+"&apellido="+apellido+"&direccion="+direccion+"&cargo="+cargo+"&sueldo_cargo="+sueldo_cargo+"&cargas_sociales="+cargas_sociales+"&vacaciones="+vacaciones+"&sueldo_neto="+sueldo_neto+"&id_empleado="+id_empleado);
	
}


function acciones(){

	var menu= document.getElementById("menu");
	
	if(menu.value=="seleccione"){
	//Este contenido está vacío, no pretende mostrarse nada.
	}
	
	if(menu.value=="consultas"){
				
			var botonVerEmpleados= document.getElementById("botonVerEmpleados");
				botonVerEmpleados.style.display= 'block';
				
			var tablaAgregarEmpleados= document.getElementById("botones");
				tablaAgregarEmpleados.style.display= 'none';
		
			var tablaBorrarEmpleado= document.getElementById("tablaBorrarEmpleado");
				tablaBorrarEmpleado.style.display= 'none';
				
			var tablaModificarEmpleado= document.getElementById("tablaModificarEmpleado");
				tablaModificarEmpleado.style.display='none';
				
	}
	
	
	if(menu.value=="ingresar"){
		
			var botonVerEmpleados= document.getElementById("botonVerEmpleados");
				botonVerEmpleados.style.display= 'none';
				
			var tablaAgregarEmpleados= document.getElementById("botones");
				tablaAgregarEmpleados.style.display= 'block';
				
			var tablaBorrarEmpleado= document.getElementById("tablaBorrarEmpleado");
				tablaBorrarEmpleado.style.display= 'none';
				
			var tablaModificarEmpleado= document.getElementById("tablaModificarEmpleado");
				tablaModificarEmpleado.style.display='none';
		
	}
	
	
	if(menu.value=="borrar"){
		
			var tablaAgregarEmpleados= document.getElementById("botones");
				tablaAgregarEmpleados.style.display= 'none';
			
			var tablaBorrarEmpleado= document.getElementById("tablaBorrarEmpleado");
				tablaBorrarEmpleado.style.display= 'block';
				
			var tablaModificarEmpleado= document.getElementById("tablaModificarEmpleado");
				tablaModificarEmpleado.style.display='none';
		
	}
	
	
	if(menu.value=="modificar"){
		
			var tablaModificarEmpleado= document.getElementById("tablaModificarEmpleado");
				tablaModificarEmpleado.style.display='block';
				
			var tablaBorrarEmpleado= document.getElementById("tablaBorrarEmpleado");
				tablaBorrarEmpleado.style.display= 'none';
				
			var tablaAgregarEmpleados= document.getElementById("botones");
				tablaAgregarEmpleados.style.display= 'none';
				
				alert("Los campos:\n\n ' ID ' , ' Dni ' , ' Cuit '\n\nNo puede ser modificados, si es necesario elimine el registro y vuelva a agregarlo.")
		;
	}
	
	
}


//Calcula las vacaciones, cargas sociales, del número ingresado en 'sueldo_bruto' las suma y luego las resta al bruto, resultando el sueldo neto
function calculosAutomaticos(){
	

	var sueldo_bruto= document.getElementById("sueldo_cargo");
	var cargas_sociales= document.getElementById("cargas_sociales");
	var vacaciones= document.getElementById("vacaciones");
	var sueldo_neto= document.getElementById("sueldo_neto");

	
	
	var resCs= sueldo_bruto.value * 0.17;
		cargas_sociales.value= resCs;
		
		var resVacas= sueldo_bruto.value / 25;
		vacaciones.value= resVacas;
		
	var resNeto= (sueldo_bruto.value - (resCs + resVacas));
		sueldo_neto.value= resNeto;
		

}

//Calcula las vacaciones customizadas, las cargas sociales customizadas y el sueldo neto por la diferencia con el sueldo bruto. 
function calculosTotal(){
	
	var sueldo_bruto= document.getElementById("sueldo_cargo");
	var dias= document.getElementById("dias");
	var sueldo_neto= document.getElementById("sueldo_neto");
	var cargas_sociales= document.getElementById("cargas_sociales");
	var tasaCs= document.getElementById("tasa_cs");
	var vacaciones= document.getElementById("vacaciones");

	//Calculamos la división del bruto por la cantidad de días trabajados y la asignamos a una variable temporal
	var resDias= sueldo_bruto.value / dias.value;
		vacaciones.value= resDias;
		
		
	//Calculamos la multiplicación de un número entre 0 y 1 y la asignamos a una variable temporal	
	var resCs= sueldo_bruto.value * tasaCs.value;
		cargas_sociales.value= resCs;
		

	//Sumamos las dos variables temporales y al resultado lo restamos al sueldo bruto
	var sueldoTotal= sueldo_bruto.value - (resDias + resCs);
		sueldo_neto.value= sueldoTotal;
	
}


	
			
	
	

			
	



	
	






function regAdminReq(){

	var nombre= document.getElementById("nombre").value;
	var apellido= document.getElementById("apellido").value;
	var usuario= document.getElementById("usuario").value;
	var pass= document.getElementById("pass").value;
	var email= document.getElementById("email").value;
	var direccion= document.getElementById("direccion").value;
	
	var xmlhttp = new XMLHttpRequest();
	var url = "/Proyecto_Final_AAB/rest/administradores/addAdministrador";

	
	if(nombre=="" || apellido=="" || usuario=="" || pass=="" || email=="" || direccion=="")
		
		{
		
			alert("Ningun campo debe quedar en blanco.");
			
		}
	
	else
			
	
		{
	
			xmlhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				 
				alert(xmlhttp.responseText);
				alert(xmlhttp.status);
				
				var tagElegido= document.getElementById("div2");
				var newul= document.createElement("ul");
				tagElegido.appendChild(newul);
				
				var datos= xmlhttp.responseText;
				
				newul.innerHTML="Los datos fueron ingresados con exito para realizar insercciones a su base de datos ingrese a: <br> <a href= 'adminRH.jsp'>Insertar Empleados</a>";
				
			    	}
			
				}
	
		}

	xmlhttp.open("POST", url, true);
	xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xmlhttp.send("nombre="+nombre+"&apellido="+apellido+"&usuario="+usuario+"&pass="+pass+"&email="+email+"&direccion="+direccion);
}


function insertarEmpleado(){
	
	var usuario= document.getElementById("usuario").value;
	var pass= document.getElementById("pass").value;
	var nombre= document.getElementById("nombre").value;
	var apellido= document.getElementById("apellido").value;
	var direccion= document.getElementById("direccion").value;
	var cargo= document.getElementById("cargo").value;
	var sueldo_cargo= document.getElementById("sueldo_cargo").value;
	var cargas_sociales= document.getElementById("cargas_sociales").value;
	var vacaciones= document.getElementById("vacaciones").value;
	var sueldo_neto= document.getElementById("sueldo_neto").value;
	
	var xmlhttp= new XMLHttpRequest();
	var url= "/Proyecto_Final_AAB/rest/empleados/insertarEmpleado";
	
	
	xmlhttp.onreadystatechange= function(){
		
		if(this.readyState == 4 && this.status == 200){
			
			if(usuario=="" || pass=="" || nombre=="" || apellido=="" || direccion=="" || cargo=="" || sueldo_cargo=="" || cargas_sociales=="" || vacaciones=="" || sueldo_neto==""){
				
					alert("Ningun campo puede quedar en blanco.")
				
				}
			else
				{

				//Recorremos el JSON de rspuesta del servidor
				for(var i=0; i < xmlhttp.responseText.length; i++){
						
						//Le hacemos un parse
						var j= JSON.parse(xmlhttp.responseText);
						
						alert("Un nuevo empleado fue agregado a la DB:  "+ j[i].nombre +" "+ j[i].apellido);
						
					}
				//No andan
				usuario= document.getElementById("usuario").value="";
				pass= document.getElementById("pass").value="";
				nombre= document.getElementById("nombre").value="";
				apellido= document.getElementById("apellido").value="";
				direccion= document.getElementById("direccion").value="";
				cargo= document.getElementById("cargo").value="";
				sueldo_cargo= document.getElementById("sueldo_cargo").value="";
				cargas_sociales= document.getElementById("cargas_sociales").value="";
				vacaciones= document.getElementById("vacaciones").value="";
				sueldo_neto= document.getElementById("sueldo_neto").value="";
				
				}
				
			}
		
	}
	
	xmlhttp.open("POST", url, false);
	xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xmlhttp.send("usuario="+usuario+"&pass="+pass+"&nombre="+nombre+"&apellido="+apellido+"&direccion="+direccion+"&cargo="+cargo+"&sueldo_cargo="+sueldo_cargo+"&cargas_sociales="+cargas_sociales+"&vacaciones="+vacaciones+"&sueldo_neto="+sueldo_neto);
}


function consultaEmpleados(){
	var usuario= document.getElementById("usuario").value;
	var	pass= document.getElementById("pass").value;
	
	var xhr= new XMLHttpRequest();
	url= "/Proyecto_Final_AAB/rest/empleados/consultaTodosEmpleados";
	
	xhr.onreadystatechange= function(){
	if(this.readyState==4 && this.status==200){
		alert(xhr.responseText);
		
		
		for(var i=0; i < xhr.responseText.length; i++){
		
				var datos= xhr.responseText;
		
				var parseDatos= JSON.parse(datos);
		
				var	ulElegido= document.getElementById("ulTabla");
				
				var newol= document.createElement("ol");
				
				ulElegido.appendChild(newol);
				
				var texto= document.createTextNode(parseDatos[i].nombre+ "  "+ parseDatos[i].apellido +"  "+ parseDatos[i].direccion );
				
				newol.appendChild(texto);
				
				document.getElementById("usuario").value="";
				document.getElementById("pass").value="";
				
			}
		}
	}
	
	//Captamos el endpoint lo declaramos asincrono le decimos que se fije en los parametros que requiera y por último lo enviamos
	xhr.open("POST", url, false);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send("usuario="+usuario+"&pass="+pass);
	
}


function verEmpleados(){
	
	var usuario= document.getElementById("usuario").value;
	var	pass= document.getElementById("pass").value;
	
	var xhr= new XMLHttpRequest();
	url= "/Proyecto_Final_AAB/rest/empleados/consultaTodosEmpleados";
	
	
	
	if(usuario=="" && pass==""){
		
			alert("Los campos 'usuario' y 'pass' no pueden quedar en blacnco.")
	
		}
	else
		{
		
		xhr.onreadystatechange= function(){
		if(this.readyState==4 && this.status==200){
		
			
		//Creación de títulos
		//Elegimos el elemento donde Totos los 'td' van a ser adheridos
		var	ulElegido= document.getElementById("ulTabla");
		
		var cabecera = ["Nombre", "apellido", "direccion", "Cargo", "sueldo cargo", "Cargas sociales", "vacaciones", "Sueldo neto"];
		
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
					
						
						//Crea los checkbox
						var chck= document.createElement("input");
							chck.type="checkbox";
							chck.id= "checkbox";
									
							ulElegido.appendChild(chck);
					}
			
			}
			
		}
			
	}
	//Captamos el endpoint lo declaramos asincrono le decimos que se fije en los parametros que requiera y por último lo enviamos
	xhr.open("POST", url, false);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send("usuario="+usuario+"&pass="+pass);
	
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


//Muestran los botones para agregar empleados.
function mostrarBotonesAgregarEmpleados(){
	
	var tablaAgregarEmpleados= document.getElementById("botones");
		tablaAgregarEmpleados.style.display= 'block';
		
	var tablaBorrarEmpleado= document.getElementById("tablaBorrarEmpleado");
		tablaBorrarEmpleado.style.display= 'none';
}


//Muestra los botones de borrar empleado.
function mostrarBotonesBorrarEmpleado(){
	
	var tablaAgregarEmpleados= document.getElementById("botones");
		tablaAgregarEmpleados.style.display= 'none';
	
	var tablaBorrarEmpleado= document.getElementById("tablaBorrarEmpleado");
		tablaBorrarEmpleado.style.display= 'block';
		
	var tablaModificarEmpleado= document.getElementById("tablaModificarEmpleado");
		tablaModificarEmpleado.style.display='none';
}

function ocultarBotonesVerEmpleados(){
	
	var tablaAgregarEmpleados= document.getElementById("botones");
		tablaAgregarEmpleados.style.display= 'none';

	var tablaBorrarEmpleado= document.getElementById("tablaBorrarEmpleado");
		tablaBorrarEmpleado.style.display= 'none';
		
	var tablaModificarEmpleado= document.getElementById("tablaModificarEmpleado");
		tablaModificarEmpleado.style.display='none';
}

function mostrarBotonesModificarEmpleado(){
	
	var tablaModificarEmpleado= document.getElementById("tablaModificarEmpleado");
		tablaModificarEmpleado.style.display='block';
		
	var tablaBorrarEmpleado= document.getElementById("tablaBorrarEmpleado");
		tablaBorrarEmpleado.style.display= 'none';
		
	var tablaAgregarEmpleados= document.getElementById("botones");
		tablaAgregarEmpleados.style.display= 'none';
	
}


//Borrar empleados de la Base de datos.
function borrarEmpleado(){
	
	var usuario= document.getElementById("usuario").value;
	var pass= document.getElementById("pass").value;
	var borrarNombre= document.getElementById("borrarNombre").value;
	var borrarApellido= document.getElementById("borrarApellido").value;
	
						var xhr= new XMLHttpRequest();
						var url= "/Proyecto_Final_AAB/rest/empleados/deleteEmpleado";
						
						xhr.onreadystatechange= function(){
							if(this.readyState == 4 && this.status == 200){
								alert(xhr.responseText);
							}
						}
						
						xhr.open("DELETE", url, false);
						xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
						xhr.send("usuario="+usuario+"&pass="+pass+"&borrarNombre="+borrarNombre+"&borrarApellido="+borrarApellido);
				
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
	var nombreRegistro= document.getElementById("modificarRegistro").value;
	
	var xhr= new XMLHttpRequest();
	var url= "/Proyecto_Final_AAB/rest/empleados/modificarEmpleado";
	
	xhr.onreadystatechange= function(){
		
		if(this.readyState==4 && this.status==200){
			alert(xhr.responseText);
		}
	}
	
	xhr.open("POST", url, false);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send("usuario="+usuario+"&pass="+pass+"&nombre="+nombre+"&apellido="+apellido+"&direccion="+direccion+"&cargo="+cargo+"&sueldo_cargo="+sueldo_cargo+"&cargas_sociales="+cargas_sociales+"&vacaciones="+vacaciones+"&sueldo_neto="+sueldo_neto+"&nombreRegistro="+nombreRegistro);
	
}






	
			
	
	

			
	



	
	



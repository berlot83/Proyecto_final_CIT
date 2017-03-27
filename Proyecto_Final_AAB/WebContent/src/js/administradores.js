


function regAdminReq(){

	var nombre= document.getElementById("nombre").value;
	var apellido= document.getElementById("apellido").value;
	var usuario= document.getElementById("usuario").value;
	var pass= document.getElementById("pass").value;
	var email= document.getElementById("email").value;
	var direccion= document.getElementById("direccion").value;
	
	var xmlhttp = new XMLHttpRequest();
	var url = "/Proyecto_Final_AAB/rest/administradores/addAdministrador";

	xmlhttp.onreadystatechange = function() {
	if (this.readyState == 4 && this.status == 200) {
		 
		alert(xmlhttp.responseText);
		alert(xmlhttp.status);
		
		var tagElegido= document.getElementById("div2");
		var newul= document.createElement("ul");
		tagElegido.appendChild(newul);
		
		var datos= xmlhttp.responseText;
		
		newul.innerHTML="Los datos fueron ingresados con éxito para realizar insercciones a su base de datos ingrese a: <br> <a href= 'insertarEmpleado.jsp'>Insertar Empleados</a>";
		
	    
	    }
	};

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
			
			if(usuario=="" && pass==""){
				
					alert("Los campos 'usuario' y 'pass' no pueden quedar en blacnco.")
				
				}
			else
				{
			
			var divElegido= document.getElementById("div2");
			var newul= document.createElement("ul");
				divElegido.appendChild(newul);
			
				for(var i=0; i < xmlhttp.responseText.length; i++){
						
						var j= JSON.parse(xmlhttp.responseText);
						
						var texto= document.createTextNode("Un nuevo empleado fue agregado a la BD:   "+j[i].nombre+ ", "+j[i].apellido);
				
						newul.appendChild(texto);
					}
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
	
	xhr.onreadystatechange= function(){
	if(this.readyState==4 && this.status==200){
		
		
		if(usuario=="" && pass==""){
			
			alert("Los campos 'usuario' y 'pass' no pueden quedar en blacnco.")
		
		}
	else
		{
		
		//Iteramos sobre la respuesta del JSON
		for(var i=0; i < xhr.responseText.length; i++){
			
			//Creamos un renglon por cada elemento
			var hilera= document.createElement("tr");
			var	tablaElegida= document.getElementById("ulTabla");
				tablaElegida.appendChild(hilera);
				
						
						var datos= xhr.responseText;
				
						//Parseamos los datos
						var parseDatos= JSON.parse(datos);
						
						//Elegimos el elemento donde vamos a adherir los td nuevos
						var	ulElegido= document.getElementById("ulTabla");
						
						//Creamos los td  que contendrán los resultados
						var newtd= document.createElement("td");
						
						//Adherimos los td a la tabla ya existente
						ulElegido.appendChild(newtd);
						
						//Creamos el texto y aherimos las columnas parseadas
						var texto= document.createTextNode("Empleado:   "+parseDatos[i].nombre+  "  " + parseDatos[i].apellido +"    Direccion: "+ parseDatos[i].direccion + "    Cargo: "+ parseDatos[i].cargo +"    Sueldo bruto: "+ parseDatos[i].sueldo_cargo +"    Cargas sociales: "+ parseDatos[i].cargas_sociales + "    Vacaciones: "+ parseDatos[i].vacaciones + "    Sueldo neto: "+ parseDatos[i].sueldo_neto );
						
						//Adherimos el texto ya creado a los td
						newtd.appendChild(texto);
						
						//Crea los checkbox
						var chck= document.createElement("input");
							chck.type="checkbox";
							chck.id= "checkbox";
									
							newtd.appendChild(chck);
										
						
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
						
						xhr.open("POST", url, false);
						xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
						xhr.send("usuario="+usuario+"&pass="+pass+"&borrarNombre="+borrarNombre+"&borrarApellido="+borrarApellido);
				
		}


//En deshuso momentaneamente sólo calcula las vacaciones y la diferencia con el bruto
function calculoVacaciones(){
	
	var sueldo_bruto= document.getElementById("sueldo_cargo");
	var dias= document.getElementById("dias");
	var sueldo_neto= document.getElementById("sueldo_neto");
	var vacaciones= document.getElementById("vacaciones");
	
	var resDias= sueldo_bruto.value / dias.value;
		vacaciones.value= resDias;
		
	var	resNeto= sueldo_bruto.value - vacaciones.value;
		sueldo_neto.value= resNeto;
		
}


//En deshuso momentaneamente sólo calcula las cargas sociales y la diferencia con el bruto
function calculoCargasSociales(){
	
	var sueldo_bruto= document.getElementById("sueldo_cargo");
	var cargas_sociales= document.getElementById("cargas_sociales");
	var tasaCs= document.getElementById("tasa_cs");
	var sueldo_neto= document.getElementById("sueldo_neto");
	
	var resCs= sueldo_bruto.value * tasaCs.value;
		cargas_sociales.value= resCs;
		
	var resNeto= sueldo_bruto.value - cargas_sociales.value;
		sueldo_neto.value= resNeto;
		
}







	
			
	
	

			
	



	
	



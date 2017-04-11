
function verVuelos(){

	var usuario= document.getElementById("usuario");
	var pass= document.getElementById("pass");
	
	var xhr= new XMLHttpRequest();
	url= "/Proyecto_Final_AAB/rest/adminVuelos/verVuelos";
	
	xhr.onreadystatechange= function(){
		if(this.readyState == 4 && this.status== 200 ){
			alert(xhr.responseText);
			
		}
	}
	xhr.open("POST", url, true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send("usuario="+usuario.value+"&pass="+pass.value);
}



function agregarVuelo(){
	
	var usuario= document.getElementById("usuario");
	var pass= document.getElementById("pass");
	var empresa= document.getElementById("empresa");
	var destino= document.getElementById("destino");
	var escalas= document.getElementById("escalas");
	var pasajes= document.getElementById("pasajes");
	var fechaSalida= document.getElementById("fechaSalida");
	var horarioSalida= document.getElementById("horarioSalida");
	var fechaArribo= document.getElementById("fechaArribo");
	var horarioArribo= document.getElementById("horarioArribo");
	var pago= document.getElementById("pago");
	var precio= document.getElementById("precio");
	
	var xhr= new XMLHttpRequest();
	url= "/Proyecto_Final_AAB/rest/adminVuelos/agregarVuelo";
	
	xhr.onreadystatechange= function(){
		if(this.readyState == 4 && this.status== 200 ){
			alert(xhr.responseText);
			
			empresa.value="";
			destino.value="";
			escalas.value="";
			pasajes.value="";
			fechaSalida.value="";
			horarioSalida.value="";
			fechaArribo.value="";
			horarioArribo.value="";
			pago.value="";
			precio.value="";	
		}
	}
	xhr.open("POST", url, true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send("usuario="+usuario.value+"&pass="+pass.value+"&empresa="+empresa.value+"&destino="+destino.value+"&pasajes="+pasajes.value+"&escalas="+escalas.value+"&fechaSalida="+fechaSalida.value+"&horarioSalida="+horarioSalida.value+"&fechaArribo="+fechaArribo.value+"&horarioArribo="+horarioArribo.value+"&pago="+pago.value+"&precio="+precio.value);
	
}


function modificarVuelo(){
	
	var usuario= document.getElementById("usuario");
	var pass= document.getElementById("pass");
	var empresa= document.getElementById("modificarEmpresa");
	var destino= document.getElementById("modificarDestino");
	var escalas= document.getElementById("modificarEscalas");
	var pasajes= document.getElementById("modificarPasajes");
	var fechaSalida= document.getElementById("modificarFechaSalida");
	var horarioSalida= document.getElementById("modificarHorarioSalida");
	var fechaArribo= document.getElementById("modificarFechaArribo");
	var horarioArribo= document.getElementById("modificarHorarioArribo");
	var pago= document.getElementById("modificarPago");
	var precio= document.getElementById("modificarPrecio");
	var id= document.getElementById("modificarId");
	
	var xhr= new XMLHttpRequest();
	url= "/Proyecto_Final_AAB/rest/adminVuelos/modificarVuelo";
	
	xhr.onreadystatechange= function(){
		if(this.readyState == 4 && this.status== 200 ){
			alert(xhr.responseText);
			
			empresa.value="";
			destino.value="";
			escalas.value="";
			pasajes.value="";
			fechaSalida.value="";
			horarioSalida.value="";
			fechaArribo.value="";
			horarioArribo.value="";
			pago.value="";
			precio.value="";
			id.value="";
		}
	}
	xhr.open("POST", url, true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send("usuario="+usuario.value+"&pass="+pass.value+"&empresa="+empresa.value+"&destino="+destino.value+"&pasajes="+pasajes.value+"&escalas="+escalas.value+"&fechaSalida="+fechaSalida.value+"&horarioSalida="+horarioSalida.value+"&fechaArribo="+fechaArribo.value+"&horarioArribo="+horarioArribo.value+"&pago="+pago.value+"&precio="+precio.value+"&id="+id.value);
}

function eliminarVuelo(){
	
	var usuario= document.getElementById("usuario");
	var pass= document.getElementById("pass");
	var id= document.getElementById("eliminarId");
	
	var xhr= new XMLHttpRequest();
	var url= "/Proyecto_Final_AAB/rest/adminVuelos/deleteVuelo";
	
	if(id.value=="")
		{
			alert("Ningún campo debe quedar vacío.");
		}
	else
		{
			xhr.onreadystatechange= function(){
				if(this.readyState==4 && this.status== 200){
					alert(xhr.responseText);
				}
			}
		}
	xhr.open("DELETE", url, true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send("usuario="+usuario.value+"&pass="+pass.value+"&id="+id.value);
}


function verTodosAviones(){
	
	var usuario= document.getElementById("usuario");
	var pass= document.getElementById("pass");
	
	var xhr= new XMLHttpRequest();
	var url= "/Proyecto_Final_AAB/rest/adminVuelos/verTodosAviones";

			xhr.onreadystatechange= function(){
				if(this.readyState==4 && this.status== 200){
					alert(xhr.responseText);
				}
			}
			
	xhr.open("POST", url, true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send("usuario="+usuario.value+"&pass="+pass.value);
}



function agregarAvion(){
	
	var usuario= document.getElementById("usuario");
	var pass= document.getElementById("pass");
	var tipo_avion= document.getElementById("tipo_avion");
	var matricula= document.getElementById("matricula");
	var cantidad_pasajeros= document.getElementById("cantidad_pasajeros");
	
	var xhr= new XMLHttpRequest();
	var url= "/Proyecto_Final_AAB/rest/adminVuelos/agregarAvion";
	
	if(tipo_avion.value=="" || matricula.value=="" || cantidad_pasajeros=="")
		{
			alert("Ningun campo debe quedar vacio.");
		}
	else
		{
			xhr.onreadystatechange= function(){
				if(this.readyState==4 && this.status== 200){
					alert(xhr.responseText);
				}
			}
		}
	xhr.open("POST", url, true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send("usuario="+usuario.value+"&pass="+pass.value+"&tipo_avion="+tipo_avion.value+"&matricula="+matricula.value+"&cantidad_pasajeros="+cantidad_pasajeros.value);
	
}


function acciones(){
	
	var menu= document.getElementById("menu");
	var tablaAgregarVuelo= document.getElementById("tablaAgregarVuelo");
	var tablaModificarVuelo= document.getElementById("tablaModificarVuelo");
	var tablaEliminarVuelo= document.getElementById("tablaEliminarVuelo");
	var tablaAgregarAvion= document.getElementById("tablaAgregarAvion");
	var tablaVerVuelos= document.getElementById("tablaVerVuelos");
	var tablaVerAviones= document.getElementById("tablaVerAviones");
	
	if(menu.value=="agregar"){
		tablaAgregarVuelo.style.display= 'block';
		tablaModificarVuelo.style.display= 'none';
		tablaEliminarVuelo.style.display= 'none';
		tablaAgregarAvion.style.display= 'none';
		tablaVerVuelos.style.display= 'none';
		tablaVerAviones.style.display='none';
	}
	
	if(menu.value=="modificar"){
		tablaModificarVuelo.style.display='block';
		tablaAgregarVuelo.style.display= 'none';
		tablaEliminarVuelo.style.display= 'none';
		tablaAgregarAvion.style.display= 'none';
		tablaVerVuelos.style.display= 'none';
		tablaVerAviones.style.display='none';
	}
	
	if(menu.value=="eliminar"){
		tablaModificarVuelo.style.display='none';
		tablaAgregarVuelo.style.display= 'none';
		tablaEliminarVuelo.style.display= 'block';
		tablaAgregarAvion.style.display= 'none';
		tablaVerVuelos.style.display= 'none';
		tablaVerAviones.style.display='none';
	}
	
	if(menu.value=="avion"){
		tablaAgregarAvion.style.display= 'block';
		tablaModificarVuelo.style.display='none';
		tablaAgregarVuelo.style.display= 'none';
		tablaEliminarVuelo.style.display= 'none';
		tablaVerVuelos.style.display= 'none';
		tablaVerAviones.style.display='none';
	}
	
	if(menu.value=="consultas"){
		tablaAgregarAvion.style.display= 'none';
		tablaModificarVuelo.style.display='none';
		tablaAgregarVuelo.style.display= 'none';
		tablaEliminarVuelo.style.display= 'none';
		tablaVerVuelos.style.display= 'block';
		tablaVerAviones.style.display='none';
	}	
	
	if(menu.value=="disponibilidad"){
		tablaVerAviones.style.display='block';
		tablaAgregarAvion.style.display= 'none';
		tablaModificarVuelo.style.display='none';
		tablaAgregarVuelo.style.display= 'none';
		tablaEliminarVuelo.style.display= 'none';
		tablaVerVuelos.style.display= 'none';
	}
	
}

//Revisar, el browser marca error en la linea del add value.
function selectAvionesDisponibles(){
	var selectRellenar= document.getElementById("selectAvionesDisponibles");
	var xhr= new XMLHttpRequest();
	var url= "/Proyecto_Final_AAB/rest/adminVuelos/rellenoSelectAviones";

			xhr.onreadystatechange= function(){
				if(this.readyState==4 && this.status== 200){
					var datos= xhr.responseText;
					
					parseJson= JSON.parse(xhr.responseText);
					
					for(var i=0; i< xhr.responseText.length; i++){
						
						var option = document.createElement("option");
							option.setAttribute("value", parseJson[i].matricula);
							option.appendChild(document.createTextNode(parseJson[i].matricula));
							selectRellenar.appendChild(option);
					}
				}
			}
			
	xhr.open("POST", url, true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(null);
	
}

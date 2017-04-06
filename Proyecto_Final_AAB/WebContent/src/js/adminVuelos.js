
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


function acciones(){
	
	var menu= document.getElementById("menu");
	var tablaAgregarVuelo= document.getElementById("tablaAgregarVuelo");
	var tablaModificarVuelo= document.getElementById("tablaModificarVuelo");
	var tablaEliminarVuelo= document.getElementById("tablaEliminarVuelo");
	
	if(menu.value=="agregar"){
		tablaAgregarVuelo.style.display= 'block';
		tablaModificarVuelo.style.display= 'none';
		tablaEliminarVuelo.style.display= 'none';
	}
	
	if(menu.value=="modificar"){
		tablaModificarVuelo.style.display='block';
		tablaAgregarVuelo.style.display= 'none';
		tablaEliminarVuelo.style.display= 'none';
	}
	
	if(menu.value=="eliminar"){
		tablaModificarVuelo.style.display='none';
		tablaAgregarVuelo.style.display= 'none';
		tablaEliminarVuelo.style.display= 'block';
	}
	
	
}


function acciones(){
	
	var menu= document.getElementById("menu");
	var servicios= document.getElementById("serviciosSeg");
	var eventos= document.getElementById("eventosSeg");
	var zonas= document.getElementById("zonasSeg");
	
	if(menu.value=="seleccione"){
		//Esconde todas las tablas.
		servicios.style.display= 'none';
		eventos.style.display= 'none';
		zonas.style.display= 'none';
	}
	
	if(menu.value=="servicios"){
		servicios.style.display= 'block';
		eventos.style.display= 'none';
		zonas.style.display= 'none';
	}
	
	if(menu.value=="eventos"){
		servicios.style.display= 'none';
		eventos.style.display= 'block';
		zonas.style.display= 'none';
	}
	
	if(menu.value=="zonas"){
		servicios.style.display= 'none';
		eventos.style.display= 'none';
		zonas.style.display= 'block';
	}
	
	
}


function selectServicios(){
	
	var selectServicios= document.getElementById("selectServicios");
	var agregarServicio= document.getElementById("agregarServicio");
	var eliminarServicio= document.getElementById("eliminarServicio");
	
	
	if(selectServicios.value=="seleccione"){
		//No se debería ver nada.
		agregarServicio.style.display= 'none';
		eliminarServicio.style.display= 'none';
	}
	
	if(selectServicios.value=="todos"){
		//Se deben ver todos los resultados de los servicios
		agregarServicio.style.display= 'none';
		eliminarServicio.style.display= 'none';
	}
	
	if(selectServicios.value=="agregar"){
		agregarServicio.style.display= 'block';
		eliminarServicio.style.display= 'none';
	}
	
	if(selectServicios.value=="eliminar"){
		agregarServicio.style.display= 'none';
		eliminarServicio.style.display= 'block';
	}
	
}

function selectEventos(){
	
	var selectEventos= document.getElementById("selectEventos");
	var agregarEvento= document.getElementById("agregarEvento");
	var eliminarEvento= document.getElementById("eliminarEvento");
	
	
	if(selectEventos.value=="seleccione"){
		//No se debería ver nada.
		agregarEvento.style.display= 'none';
		eliminarEvento.style.display= 'none';
	}
	
	if(selectEventos.value=="todos"){
		//Se deben ver todos los resultados de los servicios
		agregarEvento.style.display= 'none';
		eliminarEvento.style.display= 'none';
	}
	
	if(selectEventos.value=="agregar"){
		agregarEvento.style.display= 'block';
		eliminarEvento.style.display= 'none';
	}
	
	if(selectEventos.value=="eliminar"){
		agregarEvento.style.display= 'none';
		eliminarEvento.style.display= 'block';
	}
	
}
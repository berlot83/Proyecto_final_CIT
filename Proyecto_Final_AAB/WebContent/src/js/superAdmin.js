
function verAdministradores(){
	
	var usuario= document.getElementById("usuario");
	var pass= document.getElementById("pass");
	var token= document.getElementById("token");
	var divElegido= document.getElementById("resultSet");
	var newtd= document.createElement("td");
	
	var xhr= new XMLHttpRequest();
	var url= "/Proyecto_Final_AAB/rest/superAdministrador/verAdministradores";
	
	xhr.onreadystatechange= function(){
		if(this.readyState==4 && this.status==200){
			
			//Títulos
			var cabecera = ["-ID-", "Nombre", "Apellido", "Usuario", "Pass", "Email", "Direccion"];
			
			for(var i=0; i< cabecera.length; i++){
					var tablaElegida= document.getElementById("tablaResultSet");
					var cabeceraTd= document.createElement("td");
						tablaElegida.appendChild(cabeceraTd).style.border = "thin solid yellow";
					var textoCabecera= document.createTextNode(cabecera[i]);
						cabeceraTd.appendChild(textoCabecera);
			}
			
			//Respuesta de servidor en forma de Json
			parseJson= JSON.parse(xhr.responseText);
			
			for(var i=0; i<= xhr.responseText.length; i++){
				
				//Creamos las filas.
				var newtr= document.createElement("tr");
				var tablaElegida= document.getElementById("tablaResultSet");	
					tablaElegida.appendChild(newtr);
				
				//Creamos las celdas Id
				var newtdId= document.createElement("td");
					tablaElegida.appendChild(newtdId).style.border = "thin solid white";
				var textoId= document.createTextNode(parseJson[i].id);
					newtdId.appendChild(textoId);
					
				//Creamos las celdas nombre.
				var newtdNombre= document.createElement("td");
					tablaElegida.appendChild(newtdNombre).style.border = "thin solid white";
				var textoNombre= document.createTextNode(parseJson[i].nombre);
					newtdNombre.appendChild(textoNombre);
					
				//Creamos las celdas apellido.
				var newtdApellido= document.createElement("td");
					tablaElegida.appendChild(newtdApellido).style.border = "thin solid white";
				var textoApellido= document.createTextNode(parseJson[i].apellido);
					newtdApellido.appendChild(textoApellido);
				
				//Creamos las celdas usuario.
				var newtdUsuario= document.createElement("td");
					tablaElegida.appendChild(newtdUsuario).style.border= "thin solid white";
				var textoUsuario= document.createTextNode(parseJson[i].usuario);
					newtdUsuario.appendChild(textoUsuario);
					
				//Creamos las celdas pass.
				var newtdPass= document.createElement("td");
					tablaElegida.appendChild(newtdPass).style.border= "thin solid white";
				var textoPass= document.createTextNode(parseJson[i].pass);
					newtdPass.appendChild(textoPass);
					
					
				//Creamos las celdas email.
				var newtdEmail= document.createElement("td");
					tablaElegida.appendChild(newtdEmail).style.border= "thin solid white";
				var textoEmail= document.createTextNode(parseJson[i].email);
					newtdEmail.appendChild(textoEmail);
					
				//Creamos las celdas direccion.
				var newtdDireccion= document.createElement("td");
					tablaElegida.appendChild(newtdDireccion).style.border= "thin solid white";
				var textoDireccion= document.createTextNode(parseJson[i].direccion);
					newtdDireccion.appendChild(textoDireccion);
			}
		}
	}
	xhr.open("POST",url,true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send("usuario="+usuario.value+"&pass="+pass.value+"&token="+token.value);
}


function verTipoAdministradores(){
	
	var usuario= document.getElementById("usuario");
	var pass= document.getElementById("pass");
	var token= document.getElementById("token");
	var tipoAdmin= document.getElementById("tipoAdmin");
	var divElegido= document.getElementById("resultSet");
	var newtd= document.createElement("td");
	
		
	
	var xhr= new XMLHttpRequest();
	var url= "/Proyecto_Final_AAB/rest/superAdministrador/verTipoAdministradores";
	
	xhr.onreadystatechange= function(){
		if(this.readyState==4 && this.status==200){
			
			//Títulos
			var cabecera = ["-ID-", "Nombre", "Apellido", "Usuario", "Pass", "Email", "Direccion"];
			
			for(var i=0; i< cabecera.length; i++){
					var tablaElegida= document.getElementById("tablaResultSet");
					var cabeceraTd= document.createElement("td");
						tablaElegida.appendChild(cabeceraTd).style.border = "thin solid yellow";
					var textoCabecera= document.createTextNode(cabecera[i]);
						cabeceraTd.appendChild(textoCabecera);
			}
			
			//Respuesta de servidor en forma de Json
			parseJson= JSON.parse(xhr.responseText);
			
			for(var i=0; i< xhr.responseText.length; i++){
				
				//Creamos las filas.
				var newtr= document.createElement("tr");
				var tablaElegida= document.getElementById("tablaResultSet");	
					tablaElegida.appendChild(newtr);
				
				//Creamos las celdas Id
				var newtdId= document.createElement("td");
					tablaElegida.appendChild(newtdId).style.border = "thin solid white";
				var textoId= document.createTextNode(parseJson[i].id);
					newtdId.appendChild(textoId);
					
				//Creamos las celdas nombre.
				var newtdNombre= document.createElement("td");
					tablaElegida.appendChild(newtdNombre).style.border = "thin solid white";
				var textoNombre= document.createTextNode(parseJson[i].nombre);
					newtdNombre.appendChild(textoNombre);
					
				//Creamos las celdas apellido.
				var newtdApellido= document.createElement("td");
					tablaElegida.appendChild(newtdApellido).style.border = "thin solid white";
				var textoApellido= document.createTextNode(parseJson[i].apellido);
					newtdApellido.appendChild(textoApellido);
				
				//Creamos las celdas usuario.
				var newtdUsuario= document.createElement("td");
					tablaElegida.appendChild(newtdUsuario).style.border= "thin solid white";
				var textoUsuario= document.createTextNode(parseJson[i].usuario);
					newtdUsuario.appendChild(textoUsuario);
					
				//Creamos las celdas pass.
				var newtdPass= document.createElement("td");
					tablaElegida.appendChild(newtdPass).style.border= "thin solid white";
				var textoPass= document.createTextNode(parseJson[i].pass);
					newtdPass.appendChild(textoPass);
					
					
				//Creamos las celdas email.
				var newtdEmail= document.createElement("td");
					tablaElegida.appendChild(newtdEmail).style.border= "thin solid white";
				var textoEmail= document.createTextNode(parseJson[i].email);
					newtdEmail.appendChild(textoEmail);
					
				//Creamos las celdas direccion.
				var newtdDireccion= document.createElement("td");
					tablaElegida.appendChild(newtdDireccion).style.border= "thin solid white";
				var textoDireccion= document.createTextNode(parseJson[i].direccion);
					newtdDireccion.appendChild(textoDireccion);
					
			}
			
		}
	}
	var tipoAdmin= document.getElementById("tipoAdmin");
	xhr.open("POST",url,true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send("tipoAdmin="+tipoAdmin.value+"&usuario="+usuario.value+"&pass="+pass.value+"&token="+token.value);
}

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

function reasignarAdminRH(){
	var usuario= document.getElementById("usuario");
	var pass= document.getElementById("pass");
	var token= document.getElementById("token");
	var id_administrador= document.getElementById("idAdminOrigen");
	var id_administrador_cambiar= document.getElementById("selectIdAdmin");
	
	var xhr= new XMLHttpRequest();
	var url= "/Proyecto_Final_AAB/rest/superAdministrador/reasignarAdmin";
	
	xhr.onreadystatechange= function(){
	if(this.readyState==4 && this.status==200){
	alert(xhr.responseText);	
		}	
	}
	xhr.open("PUT", url, true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send("usuario="+usuario.value+"&pass="+pass.value+"&token="+token.value+"&id_administrador="+id_administrador.value+"&id_administrador_cambiar="+id_administrador_cambiar.value);
}


function reasignarAdminVuelos(){
	var usuario= document.getElementById("usuario");
	var pass= document.getElementById("pass");
	var token= document.getElementById("token");
	var id_administrador= document.getElementById("idAdminOrigenVuelos");
	var id_administrador_cambiar= document.getElementById("selectIdAdminVuelos");
	
	var xhr= new XMLHttpRequest();
	var url= "/Proyecto_Final_AAB/rest/superAdministrador/reasignarAdminVuelos";
	
	xhr.onreadystatechange= function(){
	if(this.readyState==4 && this.status==200){
	alert(xhr.responseText);	
		}	
	}
	xhr.open("PUT", url, true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send("usuario="+usuario.value+"&pass="+pass.value+"&token="+token.value+"&id_administrador="+id_administrador.value+"&id_administrador_cambiar="+id_administrador_cambiar.value);
}


function selectIdAdminRH(){
	
	var selectIdAdmin= document.getElementById("selectIdAdmin");
	
	var xhr= new XMLHttpRequest();
	var url= "/Proyecto_Final_AAB/rest/superAdministrador/verIdAdmin";

			xhr.onreadystatechange= function(){
				if(this.readyState==4 && this.status== 200){
					
					//Resultado en forma de Json
					var datos= xhr.responseText;
					
					parseJson= JSON.parse(xhr.responseText);
					
					for(var i=0; i< xhr.responseText.length; i++){
						
						var option = document.createElement("option");
							//option.setAttribute("value", parseJson[i].id_administrador);
							option.value= parseJson[i].id;
							option.appendChild(document.createTextNode(parseJson[i].id+", "+parseJson[i].usuario));
							selectIdAdmin.appendChild(option);
					}
					
				}
			}
			
	xhr.open("POST", url, true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(null);	
}

function selectIdAdminVuelos(){
	
	var selectIdAdmin= document.getElementById("selectIdAdminVuelos");
	
	var xhr= new XMLHttpRequest();
	var url= "/Proyecto_Final_AAB/rest/superAdministrador/verIdAdminVuelos";

			xhr.onreadystatechange= function(){
				if(this.readyState==4 && this.status== 200){
					
					//Resultado en forma de Json
					var datos= xhr.responseText;
					
					parseJson= JSON.parse(xhr.responseText);
					
					for(var i=0; i< xhr.responseText.length; i++){
						
						var option = document.createElement("option");
							//option.setAttribute("value", parseJson[i].id_administrador);
							option.value= parseJson[i].id;
							option.appendChild(document.createTextNode(parseJson[i].id+", "+parseJson[i].usuario));
							selectIdAdmin.appendChild(option);
					}
					
				}
			}
			
	xhr.open("POST", url, true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(null);	
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
				
				alert("Antes de eliminar un registro debe transferir:\n\nLos empleados de un adminRH a otro existente.\nLos vuelos de un adminVuelos a otro existente.\nLas zonas de cobertura de un adminSeg a otro existente.\n\nSi alguno de los registros no son transferidos la operacion no podrá realizarse, ya que para ser eliminados no tienen que tener registros a su cargo.")
			
		}	
}



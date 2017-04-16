

function loginSuperAdmin(){
	
	var usuario= document.getElementById("usuarioSuperAdmin").value;
	var pass= document.getElementById("passSuperAdmin").value;
	var token= document.getElementById("token").value;
	
	
	var xhr= new XMLHttpRequest();
	var url= "/Proyecto_Final_AAB/rest/validacionSuperAdmin";
	
	xhr.onreadystatechange= function(){
		
	
			if(this.readyState==4 && this.status== 200){
				
			if(xhr.responseText=="true"){
				var esconderTablaSuperAdmin= document.getElementById("soySuperadmin");
					esconderTablaSuperAdmin.style.display='none';
					
				var div= document.getElementById("super");
				
				var link2= document.getElementById("super").innerHTML= "Bienvenido siga el siguiente enlace:<br><a href='superAdmin.jsp'>Panel de Control</a>";
				
				div.appendChild(link2);
			}
			
			else
				{
					alert("El usuario y pass ingresados no son correctos, ingrese nuevamente.")	
				}
		}	
	}
	
	xhr.open("POST", url, true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send("usuario="+usuario+"&pass="+pass+"&token="+token);
}


function loginAdminRH(){
	
	var usuario= document.getElementById("usuarioAdminRH").value;
	var pass= document.getElementById("passAdminRH").value;
	
	
	var xhr= new XMLHttpRequest();
	var url= "/Proyecto_Final_AAB/rest/validacionAdminRH";
	
	
	xhr.onreadystatechange= function(){
		
		
		if(this.readyState==4 && this.status== 200){
			
		if(xhr.responseText=="true"){
			var esconderTablaAdminRH= document.getElementById("soyAdminRH");
			esconderTablaAdminRH.style.display='none';
				
			var div= document.getElementById("adminRH");
			
			var link= document.getElementById("adminRH").innerHTML= "Bienvenido siga el siguiente enlace:<br><a href='adminRH.jsp'>Panel de Control</a>";
			
			div.appendChild(link);
		}
		
		else
			{
				alert("El usuario y pass ingresados no son correctos, ingrese nuevamente.")	
			}
	}	
}

xhr.open("POST", url, true);
xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
xhr.send("usuario="+usuario+"&pass="+pass)
	
}


function loginAdminSeg(){
	
	var usuario= document.getElementById("usuarioAdminSeg").value;
	var pass= document.getElementById("passAdminSeg").value;
	
	
	var xhr= new XMLHttpRequest();
	var url= "/Proyecto_Final_AAB/rest/validacionAdminSeg";
	
	
	xhr.onreadystatechange= function(){
		
		
		if(this.readyState==4 && this.status== 200){
			
		if(xhr.responseText=="true"){
			var esconderTablaAdminRH= document.getElementById("soyAdminSeg");
			esconderTablaAdminRH.style.display='none';
				
			var div= document.getElementById("adminSeg");
			
			var link= document.getElementById("adminSeg").innerHTML= "Bienvenido siga el siguiente enlace:<br><a href='adminSeg.jsp'>Panel de Control</a>";
			
			div.appendChild(link);
		}
		
		else
			{
				alert("El usuario y pass ingresados no son correctos, ingrese nuevamente.")	
			}
	}	
}

xhr.open("POST", url, true);
xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
xhr.send("usuario="+usuario+"&pass="+pass)
	
}


function loginAdminVuelos(){
	
	var usuario= document.getElementById("usuarioAdminVuelos").value;
	var pass= document.getElementById("passAdminVuelos").value;
	
	
	var xhr= new XMLHttpRequest();
	var url= "/Proyecto_Final_AAB/rest/validacionAdminVuelos";
	
	
	xhr.onreadystatechange= function(){
		
		
		if(this.readyState==4 && this.status== 200){
			
		if(xhr.responseText=="true"){
			var esconderTablaAdminRH= document.getElementById("soyAdminVuelos");
			esconderTablaAdminRH.style.display='none';
				
			var div= document.getElementById("adminVuelos");
			
			var link= document.getElementById("adminVuelos").innerHTML= "Bienvenido siga el siguiente enlace:<br><a href='adminVuelos.jsp'>Panel de Control</a>";
			
			div.appendChild(link);
		}
		
		else
			{
				alert("La el usuario y pass ingresados no son correctos, ingrese nuevamente.")	
			}
	}	
}

xhr.open("POST", url, true);
xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
xhr.send("usuario="+usuario+"&pass="+pass)
	
}


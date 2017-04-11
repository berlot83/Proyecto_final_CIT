
function regAdminReq(){

	var tablas= document.getElementById("tablas");
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
				
						if(tablas.value=="adminVuelos")
								{
									newul.innerHTML="Los datos fueron ingresados con exito para realizar insercciones a su base de datos ingrese a: <br> <a href='adminVuelos.jsp'>Panel de control</a>";
								}
						if(tablas.value=="adminSeg")
								{
									newul.innerHTML="Los datos fueron ingresados con exito para realizar insercciones a su base de datos ingrese a: <br> <a href='adminSeg.jsp'>Panel de control</a>";
								}
						
						if(tablas.value=="adminRH")
								{
									newul.innerHTML="Los datos fueron ingresados con exito para realizar insercciones a su base de datos ingrese a: <br> <a href='adminRH.jsp'>Panel de control</a>";
								}
				
			    	}
			
				}
	
		}

	xmlhttp.open("POST", url, true);
	xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xmlhttp.send("tablas="+tablas.value+"&nombre="+nombre+"&apellido="+apellido+"&usuario="+usuario+"&pass="+pass+"&email="+email+"&direccion="+direccion);
}
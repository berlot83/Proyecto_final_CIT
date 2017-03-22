


function captarJson(){

	var xmlhttp = new XMLHttpRequest();
	var url = "http://localhost:8091/Proyecto_Final_AAB/rest/administradores/addAdministrador";

	xmlhttp.onreadystatechange = function() {
	if (this.readyState == 4 && this.status == 200) {
	    var myArr = JSON.parse(this.responseText);
	    
	    }
	};

	xmlhttp.open("GET", url, true);
	xmlhttp.send(null);
}
	
	



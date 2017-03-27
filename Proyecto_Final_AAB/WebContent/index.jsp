<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Administrador de Aeropuertos</title>
		<link rel="stylesheet" type="text/css" href="src/css/index.css">
		
</head>
	<body>
	
	<h1>Administrador de Aeropuertos 1.0</h1>
	<h2>El administrador de aeropuertos permite adminitrar los datos relacionados a todos los requerimientos de un aeropuerto modelo.</h2>
	<h3>Alcances:</h3>
				<li>Administración de personal</li>
				<li>Administración de existencias</li>
				<li>Administración de entradas y salidas de personal ajeno al aeropuerto</li>
				<li>Administración de arribos y partidas de vuelos</li>
				<li>Registro de emergencias</li>
				
		<br>
		<br>
					
							
			<form action= "/Proyecto_Final_AAB/rest/administradores/loginAdministrador" method="post" >
				<table>
					<tr>
						<td>
							<label name="usuario">Usuario:</label>
						</td>
					</tr>
				
					<tr>
						<td>
							<input name="usuario" type="text"><br/>
						</td>
					</tr>
				
					<tr>
						<td>
							<label name="pass">Pass:</label>
						</td>
					</tr>
				
					<tr>
						<td>
							<input name="pass" type="text"><br/>
						</td>
					</tr>
				
					<tr>
						<td>
							<input type="submit" value="Enviar">
						
						<a href="registro.jsp">No está registrado?</a>
						</td>
					</tr>
				
			</table>
		</form>
	</body>
</html>
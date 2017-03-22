<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Página de registro de Administrador de Aeropuertos 1.0</title>
		<link rel="stylesheet" type="text/css" href="src/css/registro.css">
		<script type="text/javascript" src="src/js/javascript.js"></script>
</head>
<body>

<h1>Registro de usuarios Administradores de Aeropuertos.</h1>
		<br>
		<br>
		<div id="div1">
	
		<form action="http://localhost:8091/Proyecto_Final_AAB/rest/administradores/addAdministrador" method="post" >
			<table>
				<tr>
					<td>	
						<label id="labelNombre" name="nombre">Nombre:</label>
					</td>
				</tr>
			
				<tr>
					<td>
						<input id="inputNombre" name="nombre" type="text"><br/>
					</td>
				</tr>
				
					<tr>
					<td>	
						<label id="labelApellido" name="apellido">Apellido:</label>
					</td>
				</tr>
			
				<tr>
					<td>
						<input id="inputApellido" name="apellido" type="text"><br/>
					</td>
				</tr>
			<!--  
				<tr>
					<td>	
						<label name="genero">Género:</label>
					</td>
				</tr>
			
				<tr>
					<td>
						<input name="genero" type="text"><br/>
					</td>
				</tr>
			-->	
				<tr>
					<td>
						<label id="labelUsuario" name="usuario">Usuario:</label>
					</td>
				</tr>
			
				<tr>
					<td>
						<input id="inputUsuario" name="usuario" type="text"><br/>
					</td>
				</tr>
			
				<tr>
					<td>
						<label id="labelPass" name="pass">Pass:</label>
					</td>
				</tr>
			
				<tr>
					<td>
						<input id="inputPass" name="pass" type="text"><br/>
					</td>
				</tr>
				
				<tr>
					<td>	
						<label id="labelEmail" name="email">E-mail:</label>
					</td>
				</tr>
			
				<tr>
					<td>
						<input id="inputEmail" name="email" type="text"><br/>
					</td>
				</tr>
				
				<tr>
					<td>	
						<label id="labelDireccion" name="direccion">Direccion:</label>
					</td>
				</tr>
			
				<tr>
					<td>
						<input id="inputDireccion" name="direccion" type="text"><br/>
					</td>
				</tr>
			
				<tr>
					<td>
						<input type="submit" value="Enviar" onclick="captarJson()">
					
					</td>
				</tr>
			</table>
		</form>
		</div>
		
		<div id="div2">
		
			<ul id="ul1"></ul>
		
		</div>
		

</body>
</html>
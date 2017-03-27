<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8/ISO-8859-1">
		<title>Página de registro de Administrador de Aeropuertos 1.0</title>
		<link rel="stylesheet" type="text/css" href="src/css/registro.css">
		<script type="text/javascript" src="src/js/administradores.js"></script>
</head>
<body>

<h1>Registro de usuarios Administradores de Aeropuertos.</h1>
		<br>
		<br>
		<div id="div1">
			<table>
				<tr>
					<td>	
						<label id="lnombre" name="nombre">Nombre:</label>
					</td>
				</tr>
			
				<tr>
					<td>
						<input id="nombre" name="nombre" type="text"><br/>
					</td>
				</tr>
				
					<tr>
					<td>	
						<label id="lapellido" name="apellido">Apellido:</label>
					</td>
				</tr>
			
				<tr>
					<td>
						<input id="apellido" name="apellido" type="text"><br/>
					</td>
				</tr>
			
				<tr>
					<td>
						<label id="lusuario" name="usuario">Usuario:</label>
					</td>
				</tr>
			
				<tr>
					<td>
						<input id="usuario" name="usuario" type="text"><br/>
					</td>
				</tr>
			
				<tr>
					<td>
						<label id="lpass" name="pass">Pass:</label>
					</td>
				</tr>
			
				<tr>
					<td>
						<input id="pass" name="pass" type="text"><br/>
					</td>
				</tr>
				
				<tr>
					<td>	
						<label id="lemail" name="email">E-mail:</label>
					</td>
				</tr>
			
				<tr>
					<td>
						<input id="email" name="email" type="text"><br/>
					</td>
				</tr>
				
				<tr>
					<td>	
						<label id="ldireccion" name="direccion">Direccion:</label>
					</td>
				</tr>
			
				<tr>
					<td>
						<input id="direccion" name="direccion" type="text"><br/>
					</td>
				</tr>
			
				<tr>
					<td>
						<input type="button" value="Enviar" onclick="regAdminReq()">
					</td>
				</tr>
			</table>
		</div>
		
		<div id="div2">
		
			<ul id="ul1"></ul>
		
		</div>
		

</body>
</html>
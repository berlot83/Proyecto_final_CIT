<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8/ISO-8859-1">
		<title>Página de registro de Administrador de Aeropuertos 1.0</title>
		<link rel="stylesheet" type="text/css" href="src/css/regAdmin.css">
		<script type="text/javascript" src="src/js/regAdmin.js"></script>
</head>
<body>

<a href="index.jsp">Inicio</a>

<h1>Registro de usuarios Administradores de Aeropuertos.</h1>
		<br>
		<br>
		<div id="div1">
			<table>
			<tr>
				<td>
					<select id="tablas">
						<option value="adminRH">Administrador de R.H</option>
						<option value="adminSeg">Adnministrador de Seguridad</option>
						<option value="adminVuelos">Administrador de vuelos</option> 
					</select>
				</td>
			</tr>
			
				<tr>
					<td>	
						<label id="lnombre" name="nombre">Nombre:</label>
					</td>
					
					<td>	
						<label id="lapellido" name="apellido">Apellido:</label>
					</td>
				</tr>
			
				<tr>
					<td>
						<input id="nombre" name="nombre" type="text"><br/>
					</td>
					
					<td>
						<input id="apellido" name="apellido" type="text"><br/>
					</td>
				</tr>
			
				<tr>
					<td>
						<label id="lusuario" name="usuario">Usuario:</label>
					</td>
					
					<td>
						<label id="lpass" name="pass">Pass:</label>
					</td>
				</tr>
			
				<tr>
					<td>
						<input id="usuario" name="usuario" type="text"><br/>
					</td>
					
					<td>
						<input id="pass" name="pass" type="password"><br/>
					</td>
				</tr>
				
				<tr>
					<td>	
						<label id="lemail" name="email">E-mail:</label>
					</td>
					
					<td>	
						<label id="ldireccion" name="direccion">Direccion:</label>
					</td>
				</tr>
			
				<tr>
					<td>
						<input id="email" name="email" type="text"><br/>
					</td>
					
					<td>
						<input id="direccion" name="direccion" type="text"><br/>
					</td>
				</tr>
			
				<tr>
					<td>
						<input type="button" value="Enviar nuevo registro" onclick="regAdminReq()">
					</td>
				</tr>
			</table>
		<a href="index.jsp">Ya tengo cuenta de administrador >></a>
	</div>
		
		<div id="div2">
		
			<ul id="ul1"></ul>
		
		</div>
		

</body>
</html>
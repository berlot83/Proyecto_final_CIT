<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<link href="https://fonts.googleapis.com/css?family=Titillium+Web" rel="stylesheet">
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Administrador de Aeropuertos</title>
		<link rel="stylesheet" type="text/css" href="src/css/index.css">
		<script type="text/javascript" src="src/js/index.js"></script>
		
</head>
	<body>
	
	<h1>Administrador de Aeropuertos 1.0</h1>
	<h2>Administre los recursos eficazmente con las siguientes utilidades.</h2>
	<h3>Alcances:</h3>
				<li>Administraci�n de personal</li>
				<li>Administraci�n de vuelos</li>
				<li>Administraci�n de seguridad</li>
				
		<br>
		<br>
					
	<hr>				
					
		<div id="super">
			<h3>Acceso SuperAdministrador</h3>
				<table id="soySuperadmin">
					<tr>
						<td>
							<label name="usuarioSuperAdmin">Usuario:</label>
						</td>
					</tr>
				
					<tr>
						<td>
							<input id="usuarioSuperAdmin" name="usuarioSuperAdmin" type="text"><br/>
						</td>
					</tr>
				
					<tr>
						<td>
							<label name="passSuperAdmin">Pass:</label>
						</td>
					</tr>
				
					<tr>
						<td>
							<input id="passSuperAdmin" name="passSuperAdmin" type="password"><br/>
						</td>
					</tr>
					
					<tr>
						<td>
							<input id="token" name="token" type="text" placeholder="- - - TOKEN - - - - - - - -" style='background-color:pink;'><br/>
						</td>
					</tr>
				
					<tr>
						<td>
							<input type="button" value="Entrar" onclick="loginSuperAdmin()">
							<a href="regAdmin.jsp">No est� registrado?</a>
						</td>
					</tr>
					
				
				</table>
	
		</div>
		
		<div id="adminRH">
			<h3>Soy Admin R.H.</h3>
				<table id="soyAdminRH">
					<tr>
						<td>
							<label name="usuarioAdminRH">Usuario:</label>
						</td>
					</tr>
				
					<tr>
						<td>
							<input id="usuarioAdminRH" name="usuarioAdminRH" type="text"><br/>
						</td>
					</tr>
				
					<tr>
						<td>
							<label name="passAdminRH">Pass:</label>
						</td>
					</tr>
				
					<tr>
						<td>
							<input id="passAdminRH" name="passAdminRH" type="password"><br/>
						</td>
					</tr>
				
					<tr>
						<td>
							<input type="button" value="Entrar" onclick="loginAdminRH()">
							<a href="regAdmin.jsp">No est� registrado?</a>
						</td>
					</tr>
			</table>
		</div>
		
		<div id="adminVuelos">
			<h3>Soy Admin de vuelos.</h3>
				<table id="soyAdminVuelos">
					<tr>
						<td>
							<label name="usuarioAdminVuelos">Usuario:</label>
						</td>
					</tr>
				
					<tr>
						<td>
							<input id="usuarioAdminVuelos" name="usuarioAdminVuelos" type="text"><br/>
						</td>
					</tr>
				
					<tr>
						<td>
							<label name="passAdminVuelos">Pass:</label>
						</td>
					</tr>
				
					<tr>
						<td>
							<input id="passAdminVuelos" name="passAdminVuelos" type="password"><br/>
						</td>
					</tr>
				
					<tr>
						<td>
							<input type="button" value="Entrar" onclick="loginAdminVuelos()">
							<a href="regAdmin.jsp">No est� registrado?</a>
						</td>
					</tr>
				</table>
			</div>
		
		<div id="adminSeg">
			<h3>Soy Admin de seguridad</h3>
				<table id="soyAdminSeg">
					<tr>
						<td>
							<label name="usuarioAdminSeg">Usuario:</label>
						</td>
					</tr>
				
					<tr>
						<td>
							<input id="usuarioAdminSeg" name="usuarioAdminSeg" type="text"><br/>
						</td>
					</tr>
				
					<tr>
						<td>
							<label name="passAdminSeg">Pass:</label>
						</td>
					</tr>
				
					<tr>
						<td>
							<input id="passAdminSeg" name="passAdminSeg" type="password"><br/>
						</td>
					</tr>
				
					<tr>
						<td>
							<input type="button" value="Entrar" onclick="loginAdminSeg()">
							<a href="regAdmin.jsp">No est� registrado?</a>
						</td>
					</tr>
				</table>
			</div>
	</body>
</html>
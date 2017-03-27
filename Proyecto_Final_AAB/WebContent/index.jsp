<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<link href="https://fonts.googleapis.com/css?family=Titillium+Web" rel="stylesheet">
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Administrador de Aeropuertos</title>
		<link rel="stylesheet" type="text/css" href="src/css/index.css">
		
</head>
	<body>
	
	<h1>Administrador de Aeropuertos 1.0</h1>
	<h2>Administre los recursos eficazmente con las siguientes utilidades.</h2>
	<h3>Alcances:</h3>
				<li>Administración de personal</li>
				<li>Administración de existencias</li>
				<li>Administración de entradas y salidas de personal ajeno al aeropuerto</li>
				<li>Administración de arribos y partidas de vuelos</li>
				<li>Registro de emergencias</li>
				
		<br>
		<br>
					
	<hr>				
					
		<div id="super">
			<h3>Soy SuperAdministrador</h3>
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
							<input type="submit" value="Entrar">
						
						<a href="regAdmin.jsp">No está registrado?</a>
						</td>
					</tr>
					
				
				</table>
			</form>
		</div>
		
		<div id="adminRH">
			<h3>Soy Admin R.H.</h3>
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
							<input type="submit" value="Entrar">
						
						<a href="regAdmin.jsp">No está registrado?</a>
						</td>
					</tr>
					
				
				</table>
			</form>
		</div>
		
		<div id="adminVuelos">
			<h3>Soy Admin de vuelos.</h3>
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
							<input type="submit" value="Entrar">
						
						<a href="regAdmin.jsp">No está registrado?</a>
						</td>
					</tr>
					
				
				</table>
			</form>
		</div>
		
		<div id="adminSeg">
			<h3>Soy Admin de seguridad</h3>
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
							<input type="submit" value="Entrar">
						
						<a href="regAdmin.jsp">No está registrado?</a>
						</td>
					</tr>
					
				
				</table>
			</form>
		</div>
	</body>
</html>
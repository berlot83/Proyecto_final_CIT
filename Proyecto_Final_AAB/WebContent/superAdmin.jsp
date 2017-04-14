<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<link href="https://fonts.googleapis.com/css?family=Titillium+Web" rel="stylesheet">
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="src/css/superAdmin.css">
		<script type="text/javascript" src="src/js/superAdmin.js"></script>
		<title>Super Administrador</title>

</head>
	
<body onload="selectIdAdminRH(), selectIdAdminVuelos()">
	<div id="menus">
	<a href="index.jsp">Inicio</a>
	
	<h2>Super Administrador</h2>
	
		<table>
		<tr>
			<td>
				<label>Usuario Admin:</label>
			</td>
		
			<td>
				<input id="usuario" type="text">
			</td>
		</tr>
		
		<tr>
		
			<td>
				<label>Pass admin:</label>
			</td>
		
			<td>
				<input id="pass" type="password">
			</td>
		</tr>
		
		<tr>
			<td>
				<label>Token:</label>
			</td>
		
			<td>
				<input id="token" name="token" type="text" placeholder=" - - - TOKEN - - - - - - - -" style='background-color:pink;'><br/>
			</td>
		</tr>
	</table>
	
	<hr>
	
	<!-- Inicio de tabla menu -->
	<table>
		<tr>
			<td>
				<label name="acciones">Seleccione una acción:</label>
			</td>
		</tr>
		
		<tr>
			<td>
				<select id="menu" onchange="acciones(this.value)">
					<option value="seleccione">Sin selección</option>
					<option value="consulta">Ver administradores</option>
					<option value="eliminar">Eliminar un administrador</option>
					<option value="agregar">Agregar un administrador</option>
				</select>
			</td>
		</tr>
	</table>
	<!-- Final de tabla menu -->
	<br>
	<!-- Inicio tabla ver administradores -->
	<table id="verAdministradores" style='display:none;'>
	<tr>
		<td>
			<label>Ver todos:</label>
		</td>
		
		<td>
			<label>Ver por tipo:</label>
		</td>
	</tr>
	
	<tr>
		<td>
			<input type="button" value="Ver todos los administradores" onclick="verAdministradores()">
		</td>
		
		<td>
			<select id="tipoAdmin" onchange="verTipoAdministradores()">
				<option value="sinSeleccion">Seleccione un tipo de Admin.</option>
				<option value="adminRH">Administrador R.H.</option>
				<option value="adminVuelos">Administrador de Vuelos</option>
				<option value="adminSeg">Administrador de Seguridad</option>
			</select>
		</td>
	</tr>
	</table>
	<!-- Final tabla ver administradores -->

	<!-- Inicio de tabla agregar administrador -->
				<table id="agregarAdmin" style='display:none;'>
				<tr>
					<td>
						<label name="tipo">Seleccione el tipo de administrador:</label>
					</td>
				</tr>
				
				<tr>
					<td>
						<select id="tipoAdministrador">
							<option value="adminRH">Administrador R.H.</option>
							<option value="adminVuelos">Administrador de Vuelos</option>
							<option value="adminSeg">Administrador de Seguridad</option>
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
						<input id="usuarioNuevoAdmin" name="usuario" type="text"><br/>
					</td>
					
					<td>
						<input id="passNuevoAdmin" name="pass" type="password"><br/>
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
						<input type="button" value="Agregar Administrador" onclick="agregarAdministrador()">
					</td>
				</tr>
	</table>
	<!-- Final de tabla agregar -->
	
	<!-- Inicio tabla eliminar administrador -->
	<table id="eliminarAdmin" style='display:none;'>
	<tr>
		<td>
			<label>Id de AdminRH origen</label>
		</td>

		<td>
			<label>Id de AdminRH destino</label>
		</td>
	</tr>
	
	<tr>
		<td>
			<input id="idAdminOrigen" type="number" min=0 max=200>
		</td>
		
		<td>
			<select id="selectIdAdmin">
				<!-- Acá se va a generar texto dinamicamente por Javascript -->
			</select>
		</td>
		
		<td>
			<input type="button" value="Transferir empleados" onclick="reasignarAdminRH()">
		</td>
	</tr>
	
	
	<tr>
		<td>
			<label>Id de AdminVuelos origen</label>
		</td>

		<td>
			<label>Id de AdminVuelos destino</label>
		</td>
	</tr>
	
	<tr>
		<td>
			<input id="idAdminOrigenVuelos" type="number" min=0 max=200>
		</td>
		
		<td>
			<select id="selectIdAdminVuelos">
				<!-- Acá se va a generar texto dinamicamente por Javascript -->
			</select>
		</td>
		
		<td>
			<input type="button" value="Transferir vuelos" onclick="reasignarAdminVuelos()">
		</td>
	</tr>
	
	<tr>
		<td>
			<label>ID del admin a eliminar:</label>
		</td>
	</tr>
	
	<tr>
		<td>
			<input id="inputId" type="number" placeholder="- - - - - id - - - - -">
		</td>
	</tr>
	
	<tr>
		<td>
			<input type="button" value="Eliminar administrador" onclick="eliminarAdministrador()">
		</td>
	</tr>
	</table>
	<!-- Final tabla elimiminar administrador -->
	
	<a href="regAdmin.jsp">No está registrado?</a>
	</div>
	
	<div id="resultSet">
		<table id="tablaResultSet">
		
		</table>
	</div>
</body>
	
</html>
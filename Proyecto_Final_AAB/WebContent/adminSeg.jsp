<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<link href="https://fonts.googleapis.com/css?family=Titillium+Web" rel="stylesheet">
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="src/css/adminSeg.css">
		<script type="text/javascript" src="src/js/adminSeg.js"></script>
<title>Administrador de Seguridad General</title>
</head>
<body>
<a href="index.jsp">Inicio</a>
	<div id="div1">
		<h3>Valide sus datos como admin:</h3>
		
		<table>
				<tr>
					<td>	
						<label>Usuario Admin:</label>
					</td>
				
					<td>
						<input id="usuario" name="usuario" type="text"><br/>
					</td>
				</tr>
				
				<tr>
					<td>	
						<label>Password admin:</label>
					</td>
				
					<td>
						<input id="pass" name="pass" type="password"><br/>
					</td>
				</tr>
			</table>
				
				<hr>
				
		
			<h3>Elija la accion a seguir:</h3>
			<table id="selector">
			<tr>
				<td>
					<select id="menu" onchange="acciones(this.value)">
					  <option value="seleccione">Seleccione una acción</option>
					  <option value="servicios">Servicios de seguridad</option>
					  <option value="eventos">Calendario de eventos</option>
					  <option value="zonas">Zonas aseguradas</option>
					</select>
				</td>
			</tr>
			</table>
		</div>
		
		
	<div id="divServicios" style='display:none;'>
		<table id="verTodosServicios">
		
		</table>
		
		<h3 style='color:turquoise;'>Agregar un servicio:</h3>
		<table id="agregarServicio">
			<tr>
				<td>
					<label>Descripción:</label>
				</td>
				
				<td>
					<label>Estado:</label>
				</td>
			</tr>
			
			<tr>
				<td>
					<input type="text" id="nombreServicio">
				</td>
				
				<td id="tdCheckbox">
					<input type="checkbox" id="estadoServicio" value=1 onchange="textoEstado()">
				</td>
			</tr>
			
			<tr>
				<td>
					<input type="button" value="Agregar servicio" onclick="agregarServicio()">
				</td>
			</tr>
		</table>
		
		
		<h3>Eliminar un servicio:</h3>
		<table id="eliminarServicio">
			<tr>
				<td>
					<label>Seleccione el servicio a eliminar:</label>
				</td>
				
				<td>
					<select id="selectEliminarServicio">
						<!-- Acá se muestra contenido de la base de datos dinámicamente por Javascript. -->
					</select>
				</td>
				
				<td>
					<input type="button" value="Eliminar servicio" onclick="eliminarServicio()">
				</td>
			</tr>
		</table>
	</div>
		
	<div id="divEventos" style='display:none;'>
		<table id="verTodosEventos">
		
		</table>
		<h3>Ingresar un evento:</h3>
		<table id="agregarEvento">
			<tr>
				<td>
					<label>Descripcción:</label>
				</td>
				
				<td>
					<label>Fecha:</label>
				</td>
			</tr>
			
			<tr>
				<td>
					<input type="text" id="nombreEvento">
				</td>
				
				<td>
					<input type="date" id="fechaEvento">
				</td>
			</tr>
			
			<tr>
				<td>
					<input type="button" value="Agregar evento" onclick="agregarEvento()">
				</td>
			</tr>
		</table>
		
		
		<h3>Eliminar un evento:</h3>
		<table id="eliminarEvento">
			<tr>
				<td>
					<label>Seleccione el evento a eliminar:</label>
				</td>
				
				<td>
					<select id="selectEliminarEvento">
						<!-- Acá se muestra contenido de la base de datos dinámicamente por Javascript. -->
					</select>
				</td>
				
				<td>
					<input type="button" value="Eliminar evento" onclick="eliminarEvento()">
				</td>
			</tr>
		</table>
	</div>
		
	<div id="divZonas" style='display:none;'>
		<table id="verTodasZonas">
		
		</table>
		
		<h3>Agregar una zona:</h3>
		<table id="agregarZona">
			<tr>
				<td>
					<label>Descripcción:</label>
				</td>
				
				<td>
					<label>Estado:</label>
				</td>
			</tr>
			
			<tr>
				<td>
					<input type="text" id="nombreZona">
				</td>
				
				<td>
					<input type="checkbox" id="estadoZona">
				</td>
			</tr>
			</table>
		
		<h3>Eliminar una zona:</h3>	
		<table id="eliminarZona">
			<tr>
				<td>
					<label>Seleccione la zona a eliminar:</label>
				</td>
				
				<td>
					<select id="selectEliminarZona">
						<!-- Acá se muestra contenido de la base de datos dinámicamente por Javascript. -->
					</select>
				</td>
				
				<td>
					<input type="button" value="Eliminar Zona" onclick="eliminarZona()">
				</td>
			</tr>
		</table>
	</div>
</body>
</html>
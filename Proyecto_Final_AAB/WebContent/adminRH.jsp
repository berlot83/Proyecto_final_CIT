<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<link href="https://fonts.googleapis.com/css?family=Titillium+Web" rel="stylesheet">
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="src/css/adminHR.css">
		<script type="text/javascript" src="src/js/adminRH.js"></script>
<title>Administrador de R.H.</title>
</head>
<body>

<a href="index.jsp">Inicio</a>
	<div id="div1"></div>
		<h3>Valide sus datos como admin:</h3>
		
		<table>
				<tr>
					<td>	
						<label name="usuario">Usuario Admin:</label>
					</td>
				
					<td>
						<input id="usuario" name="usuario" type="text"><br/>
					</td>
				</tr>
				
				<tr>
					<td>	
						<label name="pass">Password admin:</label>
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
					  <option value="consultas">Consultas</option>
					  <option value="ingresar">Ingresar empleado</option>
					  <option value="borrar">Borrar empleado</option>
					  <option value="modificar">Modificar empleado</option>
					</select>
				</td>
			</tr>
			
			<tr>
				<td>
						<input id="botonVerEmpleados" type="button" value="Ver Todos los empleados" onclick="verEmpleados()" style='display:none;'>
				</td>
			</tr>
				
			</table>
			
				
			<table id="botones" style='display:none;'>
				<tr>
					<td>	
						<label name="dni">D.N.I:</label>
					</td>
					
					<td>	
						<label name="cuit">CUIT:</label>
					</td>
					
					<td>	
						<label name="nacimiento">Fecha de nac.:</label>
					</td>
					
				</tr>
				
				<tr>
					<td>
						<input id="dni" name="dni" type="number" min=0 maxlength=11><br/>
					</td>
					
					<td>
						<input id="cuit" name="cuit" type="number" min=0 maxlength=11><br/>
					</td>
					
					<td>
						<input id="nacimiento" name="nacimiento" type="date"><br/>
					</td>
				
				</tr>
				
				
				<tr>
					<td>	
						<label name="nombre">Nombre:</label>
					</td>
					
					<td>	
						<label name="apellido">Apellido:</label>
					</td>
					
					<td>	
						<label name="direccion">Direccion:</label>
					</td>
				</tr>
			
				<tr>
				
					<td>
						<input id="nombre" name="nombre" type="text"><br/>
					</td>
					
					<td>
						<input id="apellido" name="apellido" type="text"><br/>
					</td>
					
					<td>
						<input id="direccion" name="direccion" type="text"><br/>
					</td>
					
				<tr>
					<td>
						<label name="cargo">Cargo en la Empresa:</label>
					</td>
					
					<td>
						<label name="sueldo_cargo">Sueldo bruto:</label>
					</td>
					
					<td>	
						<label name="cargas_sociales">Cargas sociales:</label>
					</td>
					
				</tr>
			
				<tr>
					<td>
						<input id="cargo" name="cargo" type="text"><br/>
					</td>
				
					<td>
						<input id="sueldo_cargo" name="sueldo_cargo" type="number" step="0.01" oninput="calculosAutomaticos()"><br/>
					</td>
					
					<td>
						<input id="cargas_sociales" name="cargas_sociales" type="number" step="0.01" placeholder="17% por defecto"><br/>
					</td>
				</tr>
				
				<tr>
					<td>	
						<label name="vacaciones">Vacaciones:</label>
					</td>
					
					<td>	
						<label name="dias">Dias trabajados:</label>
					</td>
					
					<td>	
						<label name="tasa_cs">Tasa de Cargas sociales:</label>
					</td>
				</tr>
			
				<tr>
					<td>
						<input id="vacaciones" name="vacaciones" type="number" step="0.01" placeholder="25 días por defecto"><br/>
					</td>
					
					<td>
						<input id="dias" name="dias" type="number" min="0" max="31" oninput="calculosTotal()" placeholder="Max:31" onkeydown="return false"><br/>
					</td>
					
					<td>
						<input id="tasa_cs" name="tasa_cs" type="number" min="0" max="1" step="0.01" oninput="calculosTotal()" placeholder="De 0 a 1" onkeydown="return false"><br/>
					</td>
				</tr>
			
			
				<tr>
					<td>	
						<label name="sueldo_neto">Sueldo neto:</label>
					</td>
				</tr>
			
				<tr>
					<td>
						<input id="sueldo_neto" name="sueldo_neto" type="number" step="0.01"><br/>
					</td>
				</tr>
				
				<tr>
					<td>
						<input type="button" value="Agregar empleado" onclick="insertarEmpleado()">
					</td>
				</tr>
			</table>
	
			<table id="tablaBorrarEmpleado" style='display:none;'>
				<tr>
					<td>	
						<label name="deleteId">Indique el 'ID' del registro a borrar:</label>
					</td>
				</tr>
					
				<tr>
					<td>
						<input id="deleteId" name="deleteId" type="number"><br/>
					</td>
				</tr>
				
				<tr>
					<td>
						<input type="button" value="Borrar empleado" onclick="borrarEmpleado()">
					</td>
				</tr>
			</table>
			
			<table id="tablaModificarEmpleado" style='display:none;'>
			
				<tr>
					<td>	
						<label name="modificarNombre">Nombre:</label>
					</td>
					
					<td>	
						<label name="modificarApellido">Apellido:</label>
					</td>
					
					<td>	
						<label name="modificarDireccion">Direccion:</label>
					</td>
				</tr>
			
				<tr>
					<td>
						<input id="modificarNombre" name="nombre" type="text"><br/>
					</td>
					
					<td>
						<input id="modificarApellido" name="apellido" type="text"><br/>
					</td>
					
					<td>
						<input id="modificarDireccion" name="direccion" type="text"><br/>
					</td>
					
				<tr>
					<td>
						<label name="modificarCargo">Cargo en la Empresa:</label>
					</td>
					
					<td>
						<label name="modificarSueldo_cargo">Sueldo bruto:</label>
					</td>
					
					<td>	
						<label name="modificarCargas_sociales">Cargas sociales:</label>
					</td>
					
				</tr>
			
				<tr>
					<td>
						<input id="modificarCargo" name="cargo" type="text"><br/>
					</td>
				
					<td>
						<input id="modificarSueldo_cargo" name="sueldo_cargo" type="number" step="0.01""><br/>
					</td>
					
					<td>
						<input id="modificarCargas_sociales" name="cargas_sociales" type="number" step="0.01"><br/>
					</td>
				</tr>
				
				<tr>
					<td>	
						<label name="modificarVacaciones">Vacaciones:</label>
					</td>
					
					<td>	
						<label name="modificarSueldo_neto">Sueldo neto:</label>
					</td>
					
					<td>	
						<label name="modificarRegistro">Registro a modificar:</label>
					</td>
				</tr>
			
				<tr>
					<td>
						<input id="modificarVacaciones" name="vacaciones" type="number" step="0.01"><br/>
					</td>
					
					<td>
						<input id="modificarSueldo_neto" name="sueldo_neto" type="number" step="0.01"><br/>
					</td>
					
					<td>
						<input id="personaId" name="personaId" type="number"><br/>
					</td>
				</tr>
				
				<tr>
					<td>
						<input type="button" value="Modificar empleado" onclick="modificarEmpleado()">
					</td>
				</tr>
			</table>
			
			<a href="regAdmin.jsp">No tengo cuenta de Administrador todavía</a>		
	<div id="div2"></div>
	
	<br>
	<hr>
	
	<div id="div3">
			<table id="ulTabla"></table>
	</div>

</body>
</html>
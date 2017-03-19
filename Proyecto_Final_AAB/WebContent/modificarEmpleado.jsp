<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


		<h3>Valide sus datos como admin:</h3>
		<form action="http://localhost:8091/Proyecto_Final_AAB/rest/empleados/modificarEmpleado" method="post" >
			<table>
			
				<tr>
					<td>	
						<label name="usuario">Usuario Admin:</label>
					</td>
				</tr>
			
				<tr>
					<td>
						<input name="usuario" type="text"><br/>
					</td>
				</tr>
				
				<tr>
					<td>	
						<label name="pass">Password admin:</label>
					</td>
				</tr>
			
				<tr>
					<td>
						<input name="pass" type="text"><br/>
					</td>
				</tr>
			
				<tr>
					<td>	
						<label name="nombre">Nombre:</label>
					</td>
				</tr>
			
				<tr>
					<td>
						<input name="nombre" type="text"><br/>
					</td>
				</tr>
				
					<tr>
					<td>	
						<label name="apellido">Apellido:</label>
					</td>
				</tr>
			
				<tr>
					<td>
						<input name="apellido" type="text"><br/>
					</td>
				</tr>
			  
				<tr>
					<td>	
						<label name="direccion">Direccion:</label>
					</td>
				</tr>
			
				<tr>
					<td>
						<input name="direccion" type="text"><br/>
					</td>
				</tr>
				
				<tr>
					<td>
						<label name="cargo">Cargo en la Empresa:</label>
					</td>
				</tr>
			
				<tr>
					<td>
						<input name="cargo" type="text"><br/>
					</td>
				</tr>
			
				<tr>
					<td>
						<label name="sueldo_cargo">Sueldo bruto:</label>
					</td>
				</tr>
			
				<tr>
					<td>
						<input name="sueldo_cargo" type="number" step="0.01"><br/>
					</td>
				</tr>
				
				<tr>
					<td>	
						<label name="cargas_sociales">Cargas sociales:</label>
					</td>
				</tr>
			
				<tr>
					<td>
						<input name="cargas_sociales" type="number" step="0.01"><br/>
					</td>
				</tr>
				
				<tr>
					<td>	
						<label name="vacaciones">Vacaciones:</label>
					</td>
				</tr>
			
				<tr>
					<td>
						<input name="vacaciones" type="number" step="0.01"><br/>
					</td>
				</tr>
			
				<tr>
					<td>
					
				<tr>
					<td>	
						<label name="sueldo_neto">Sueldo neto:</label>
					</td>
				</tr>
			
				<tr>
					<td>
						<input name="sueldo_neto" type="number" step="0.01"><br/>
					</td>
				</tr>
				
				<tr>
					<td>
						<label name="nombreRegistro">Nombre del regitro a modificar:</label>
					</td>
				</tr>
			
				<tr>
					<td>
						<input name="nombreRegistro" type="text"><br/>
					</td>
				</tr>
			
				<tr>
					<td>
						<input type="submit" value="modificar empleado">
					
					</td>
				</tr>
			</table>
		</form>
</body>
</html>
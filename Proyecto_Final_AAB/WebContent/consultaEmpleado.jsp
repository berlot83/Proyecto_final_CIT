<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

			<form action= "http://localhost:8091/Proyecto_Final_AAB/rest/empleados/consultaNombreEmpleado" method="post" >
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
							<label name="nombre">Nombre del empleado:</label>
						</td>
					</tr>
				
					<tr>
						<td>
							<input name="nombre" type="text"><br/>
						</td>
					</tr>
					
					<tr>
						<td>
							<label name="apellido">Apellido del empleado:</label>
						</td>
					</tr>
				
					<tr>
						<td>
							<input name="apellido" type="text"><br/>
						</td>
					</tr>
					
				
					<tr>
						<td>
							<input type="submit" value="consultar">
							
						<a href="registro.jsp">No está registrado?</a>
						</td>
					</tr>
				
			</table>
		</form>

</body>
</html>
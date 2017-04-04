<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="src/js/administradores.js"></script>
<title>Insert title here</title>
</head>
<body>
				<table id="tablaConsultaEmpleado">
					<tr>
						<td>
							<label name="usuario">Usuario:</label>
						</td>
					</tr>
				
					<tr>
						<td>
							<input id="usuario" name="usuario" type="text"><br/>
						</td>
					</tr>
				
					<tr>
						<td>
							<label name="pass">Pass:</label>
						</td>
					</tr>
				
					<tr>
						<td>
							<input id="pass" name="pass" type="text"><br/>
						</td>
					</tr>
					
					<tr>
						<td>
							<label name="apellido">Apellido del empleado:</label>
						</td>
					</tr>
				
					<tr>
						<td>
							<input id="apellido" name="apellido" type="text" oninput="consultaNombreEmpleado(this.value)"><br/>
						</td>
					</tr>
					
				
					<tr>
						<td>
						
							
						<a href="registro.jsp">No está registrado?</a>
						</td>
					</tr>
				
			</table>
		</form>

</body>
</html>
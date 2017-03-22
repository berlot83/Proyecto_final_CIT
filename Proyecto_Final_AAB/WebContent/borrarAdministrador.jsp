<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

			<form action= "http://localhost:8091/Proyecto_Final_AAB/rest/superAdministrador/deleteAdministrador" method="post" >
				<table>
					<tr>
						<td>
							<label name="usuario">Usuario del administrador:</label>
						</td>
					</tr>
				
					<tr>
						<td>
							<input name="usuario" type="text"><br/>
						</td>
					</tr>
				
					<tr>
						<td>
					<tr>
						<td>
							<label name="pass">Pass del administrador:</label>
						</td>
					</tr>
				
					<tr>
						<td>
							<input name="pass" type="text"><br/>
						</td>
					</tr>
				
				
					<tr>
						<td>
							<label name="usuarioAdmin">Indique usuario a borrar:</label>
						</td>
					</tr>
				
					<tr>
						<td>
							<input name="usuarioAdmin" type="text"><br/>
						</td>
					</tr>
					
					<tr>
						<td>
							<input type="submit" value="Borrar registro">
						
						</td>
					</tr>
				
			</table>
		</form>
</body>
</html>
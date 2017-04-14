<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<link href="https://fonts.googleapis.com/css?family=Titillium+Web" rel="stylesheet">
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="src/css/adminVuelos.css">
		<script type="text/javascript" src="src/js/adminVuelos.js"></script>
		<title>Administrador de Vuelos</title>
</head>

<body onload="selectAvionesDisponibles(), selectVuelosDisponibles(), selectAvionesDisponiblesModificar(), selectEliminarVuelosDisponibles()">
<a href="index.jsp">Inicio</a>
		<h3>Administración de vuelos: </h3>
		
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
	</table>
	
	<hr>
	
	<h3>Defina la acción a seguir:</h3>
	<table>
		<tr>
			<td>
				<select id="menu" onchange="acciones(this.value)">
					<option value="sinSeleccion">Seleccione una acción</option>
					<option value="consultas">Consultar vuelos</option>
					<option value="agregar">Agregar un vuelo</option>
					<option value="modificar">Modificar vuelo</option>
					<option value="eliminar">Eliminar un vuelo</option>
					<option value="disponibilidad">Ver aviones disponibles</option>
					<option value="avion">Agregar un avión</option>
				</select>
			</td>
		</tr>
	</table>
	
<br>	
	
<div id="menus">
<!-- Inicio tabla ver vuelos -->
	<table id="tablaVerVuelos" style='display:none;'>
		<tr>
			<td>
				<label>Ver vuelos activos:</label>
			</td>
		</tr>

		<tr>
			<td>
				<input type="button" value="Ver Vuelos" onclick="verVuelos()">
			</td>
		</tr>
	</table>
<!-- Final tabla ver vuelos -->
	
<!-- Inicio tabla agregar aviones -->
	<table id="tablaAgregarAvion" style='display:none;'>
		<tr>
			<td>
				<label>Tipo de avión:</label>
			</td>

			<td>
				<label>Matrícula:</label>
			</td>
		</tr>

		<tr>
			<td>
				<input type="text" id="tipo_avion">
			</td>

			<td>
				<input type="text" id="matricula">
			</td>
		</tr>
		
		<tr>
			<td>
				<label>Cantidad de pasajeros:</label>
			</td>
		</tr>
		
		<tr>
			<td>
				<input type="number" id="cantidad_pasajeros" min=0 max=600>
			</td>
		</tr>
		
		<tr>
			<td>
				<input type="button" value="Agregar Avión" onclick="agregarAvion()">
			</td>
		</tr>
	</table>
<!-- Final tabla agregar aviones -->

<!-- Inicio tabla ver aviones -->
<table id="tablaVerAviones" style='display:none;'>
	<tr>
		<td>
			<label>Ver todos-------</label>
		</td>
		
		<td>
			<label>Ver disponibles</label>
		</td>
	</tr>
	
	<tr>
		<td>
			<input type="button" value="Ver todos" onclick="verTodosAviones()">
		</td>
		
		<td>
			<input type="button" value="Solo disponibles">
		</td>
	</tr>
</table>
<!-- Final tabla ver aviones -->
	
<!-- Inicio tabla agregar vuelos -->
<table id="tablaAgregarVuelo" style='display:none;'>
	<tr>
		<td>
			<label name="empresa">Línea aérea:</label>
		</td>
	
		<td>
			<label name="destino">Destino del Vuelo:</label>
		</td>
		
		<td>
			<label>Aviones disponibles</label>
		</td>
	</tr>
	
	<tr>
		<td>
			<select id="empresa">
				<option value="empresa">Elija empresa</option>
				<option value="aerolineas">Aerolineas Argentinas</option>
				<option value="american">American Airlines</option>
				<option value="varig">Varig</option>
				<option value="lufthansa">Lufthansa</option>
				<option value="british">British Airways</option>
				<option value="latam">Latam</option>
				<option value="austral">Austral</option>
				<option value="klm">KLM</option>
				<option value="alitalia">Alitalia</option>
				<option value="qantas">Qantas Airlines</option>
				<option value="souther">Souther Winds</option>
				<option value="united">United Airlines</option>
				<option value="iberia">Iberia</option>
				<option value="air">Air France</option>
				<option value="blue">Blue Airelines</option>
			</select>
		</td>
		
		<td>
			<select id="destino" name="pais">
				<option value="AF">Afganistán</option>
				<option value="AL">Albania</option>
				<option value="DE">Alemania</option>
				<option value="AD">Andorra</option>
				<option value="AO">Angola</option>
				<option value="AI">Anguilla</option>
				<option value="AQ">Antártida</option>
				<option value="AG">Antigua y Barbuda</option>
				<option value="AN">Antillas Holandesas</option>
				<option value="SA">Arabia Saudí</option>
				<option value="DZ">Argelia</option>
				<option value="AR">Argentina</option>
				<option value="AM">Armenia</option>
				<option value="AW">Aruba</option>
				<option value="AU">Australia</option>
				<option value="AT">Austria</option>
				<option value="AZ">Azerbaiyán</option>
				<option value="BS">Bahamas</option>
				<option value="BH">Bahrein</option>
				<option value="BD">Bangladesh</option>
				<option value="BB">Barbados</option>
				<option value="BE">Bélgica</option>
				<option value="BZ">Belice</option>
				<option value="BJ">Benin</option>
				<option value="BM">Bermudas</option>
				<option value="BY">Bielorrusia</option>
				<option value="MM">Birmania</option>
				<option value="BO">Bolivia</option>
				<option value="BA">Bosnia y Herzegovina</option>
				<option value="BW">Botswana</option>
				<option value="BR">Brasil</option>
				<option value="BN">Brunei</option>
				<option value="BG">Bulgaria</option>
				<option value="BF">Burkina Faso</option>
				<option value="BI">Burundi</option>
				<option value="BT">Bután</option>
				<option value="CV">Cabo Verde</option>
				<option value="KH">Camboya</option>
				<option value="CM">Camerún</option>
				<option value="CA">Canadá</option>
				<option value="TD">Chad</option>
				<option value="CL">Chile</option>
				<option value="CN">China</option>
				<option value="CY">Chipre</option>
				<option value="CO">Colombia</option>
				<option value="KM">Comores</option>
				<option value="CG">Congo</option>
				<option value="KR">Corea</option>
				<option value="KP">Corea del Norte</option>
				<option value="CI">Costa de Marfíl</option>
				<option value="CR">Costa Rica</option>
				<option value="HR">Croacia (Hrvatska)</option>
				<option value="CU">Cuba</option>
				<option value="DK">Dinamarca</option>
				<option value="DJ">Djibouti</option>
				<option value="DM">Dominica</option>
				<option value="EC">Ecuador</option>
				<option value="EG">Egipto</option>
				<option value="SV">El Salvador</option>
				<option value="AE">Emiratos Árabes Unidos</option>
				<option value="ER">Eritrea</option>
				<option value="SI">Eslovenia</option>
				<option value="ES" selected>España</option>
				<option value="US">Estados Unidos</option>
				<option value="EE">Estonia</option>
				<option value="ET">Etiopía</option>
				<option value="FJ">Fiji</option>
				<option value="PH">Filipinas</option>
				<option value="FI">Finlandia</option>
				<option value="FR">Francia</option>
				<option value="GA">Gabón</option>
				<option value="GM">Gambia</option>
				<option value="GE">Georgia</option>
				<option value="GH">Ghana</option>
				<option value="GI">Gibraltar</option>
				<option value="GD">Granada</option>
				<option value="GR">Grecia</option>
				<option value="GL">Groenlandia</option>
				<option value="GP">Guadalupe</option>
				<option value="GU">Guam</option>
				<option value="GT">Guatemala</option>
				<option value="GY">Guayana</option>
				<option value="GF">Guayana Francesa</option>
				<option value="GN">Guinea</option>
				<option value="GQ">Guinea Ecuatorial</option>
				<option value="GW">Guinea-Bissau</option>
				<option value="HT">Haití</option>
				<option value="HN">Honduras</option>
				<option value="HU">Hungría</option>
				<option value="IN">India</option>
				<option value="ID">Indonesia</option>
				<option value="IQ">Irak</option>
				<option value="IR">Irán</option>
				<option value="IE">Irlanda</option>
				<option value="BV">Isla Bouvet</option>
				<option value="CX">Isla de Christmas</option>
				<option value="IS">Islandia</option>
				<option value="KY">Islas Caimán</option>
				<option value="CK">Islas Cook</option>
				<option value="CC">Islas de Cocos o Keeling</option>
				<option value="FO">Islas Faroe</option>
				<option value="HM">Islas Heard y McDonald</option>
				<option value="FK">Islas Malvinas</option>
				<option value="MH">Islas Marshall</option>
				<option value="PW">Islas Palau</option>
				<option value="SB">Islas Salomón</option>
				<option value="SJ">Islas Svalbard y Jan Mayen</option>
				<option value="TK">Islas Tokelau</option>
				<option value="TC">Islas Turks y Caicos</option>
				<option value="VI">Islas Vírgenes (EEUU)</option>
				<option value="WF">Islas Wallis y Futuna</option>
				<option value="IL">Israel</option>
				<option value="IT">Italia</option>
				<option value="JM">Jamaica</option>
				<option value="JP">Japón</option>
				<option value="JO">Jordania</option>
				<option value="KZ">Kazajistán</option>
				<option value="KE">Kenia</option>
				<option value="KG">Kirguizistán</option>
				<option value="KI">Kiribati</option>
				<option value="KW">Kuwait</option>
				<option value="LA">Laos</option>
				<option value="LS">Lesotho</option>
				<option value="LV">Letonia</option>
				<option value="LB">Líbano</option>
				<option value="LR">Liberia</option>
				<option value="LY">Libia</option>
				<option value="LI">Liechtenstein</option>
				<option value="LT">Lituania</option>
				<option value="LU">Luxemburgo</option>
				<option value="MG">Madagascar</option>
				<option value="MY">Malasia</option>
				<option value="MW">Malawi</option>
				<option value="MV">Maldivas</option>
				<option value="ML">Malí</option>
				<option value="MT">Malta</option>
				<option value="MA">Marruecos</option>
				<option value="MQ">Martinica</option>
				<option value="MU">Mauricio</option>
				<option value="MR">Mauritania</option>
				<option value="YT">Mayotte</option>
				<option value="MX">México</option>
				<option value="FM">Micronesia</option>
				<option value="MD">Moldavia</option>
				<option value="MC">Mónaco</option>
				<option value="MN">Mongolia</option>
				<option value="MS">Montserrat</option>
				<option value="MZ">Mozambique</option>
				<option value="NA">Namibia</option>
				<option value="NR">Nauru</option>
				<option value="NP">Nepal</option>
				<option value="NI">Nicaragua</option>
				<option value="NE">Níger</option>
				<option value="NG">Nigeria</option>
				<option value="NU">Niue</option>
				<option value="NF">Norfolk</option>
				<option value="NO">Noruega</option>
				<option value="NC">Nueva Caledonia</option>
				<option value="NZ">Nueva Zelanda</option>
				<option value="OM">Omán</option>
				<option value="NL">Países Bajos</option>
				<option value="PA">Panamá</option>
				<option value="PG">Papúa Nueva Guinea</option>
				<option value="PK">Paquistán</option>
				<option value="PY">Paraguay</option>
				<option value="PE">Perú</option>
				<option value="PN">Pitcairn</option>
				<option value="PF">Polinesia Francesa</option>
				<option value="PL">Polonia</option>
				<option value="PT">Portugal</option>
				<option value="PR">Puerto Rico</option>
				<option value="QA">Qatar</option>
				<option value="UK">Reino Unido</option>
				<option value="CF">República Centroafricana</option>
				<option value="CZ">República Checa</option>
				<option value="ZA">República de Sudáfrica</option>
				<option value="DO">República Dominicana</option>
				<option value="SK">República Eslovaca</option>
				<option value="RE">Reunión</option>
				<option value="RW">Ruanda</option>
				<option value="RO">Rumania</option>
				<option value="RU">Rusia</option>
				<option value="EH">Sahara Occidental</option>
				<option value="KN">Saint Kitts y Nevis</option>
				<option value="WS">Samoa</option>
				<option value="AS">Samoa Americana</option>
				<option value="SM">San Marino</option>
				<option value="VC">San Vicente y Granadinas</option>
				<option value="SH">Santa Helena</option>
				<option value="LC">Santa Lucía</option>
				<option value="ST">Santo Tomé y Príncipe</option>
				<option value="SN">Senegal</option>
				<option value="SC">Seychelles</option>
				<option value="SL">Sierra Leona</option>
				<option value="SG">Singapur</option>
				<option value="SY">Siria</option>
				<option value="SO">Somalia</option>
				<option value="LK">Sri Lanka</option>
				<option value="PM">St Pierre y Miquelon</option>
				<option value="SZ">Suazilandia</option>
				<option value="SD">Sudán</option>
				<option value="SE">Suecia</option>
				<option value="CH">Suiza</option>
				<option value="SR">Surinam</option>
				<option value="TH">Tailandia</option>
				<option value="TW">Taiwán</option>
				<option value="TZ">Tanzania</option>
				<option value="TJ">Tayikistán</option>
				<option value="TP">Timor Oriental</option>
				<option value="TG">Togo</option>
				<option value="TO">Tonga</option>
				<option value="TT">Trinidad y Tobago</option>
				<option value="TN">Túnez</option>
				<option value="TM">Turkmenistán</option>
				<option value="TR">Turquía</option>
				<option value="TV">Tuvalu</option>
				<option value="UA">Ucrania</option>
				<option value="UG">Uganda</option>
				<option value="UY">Uruguay</option>
				<option value="UZ">Uzbekistán</option>
				<option value="VU">Vanuatu</option>
				<option value="VE">Venezuela</option>
				<option value="VN">Vietnam</option>
				<option value="YE">Yemen</option>
				<option value="YU">Yugoslavia</option>
				<option value="ZM">Zambia</option>
				<option value="ZW">Zimbabue</option>
			</select>
		</td>
		
		<td>
			<select id="selectAvionesDisponibles">
				<!-- Acá sólo va texto creado dinamicamente desde la base de datos por medio de Javascript -->
			</select>
		</td>
	</tr>
	
	<tr>
		<td>
			<label name="fechaSalida">Fecha de salida:</label>
		</td>
		
		<td>
			<label name="tiempo">Horario de salida:</label>
		</td>
	
	</tr>
	
	<tr>
		<td>
			<input id="fechaSalida" type="date">
		</td>
	
		<td>
		 	<input id="horarioSalida" type="time" name="horarioSalida">
		</td>
	</tr>
	
	<tr>
		<td>
			<label name="fechaArribo">Fecha de arribo:</label>
		</td>
		
		<td>
			<label name="HorarioArribo">Horario de arribo:</label>
		</td>
	</tr>

	<tr>
	
		<td>
			<input id="fechaArribo" type="date">
		</td>
		
		<td>
		 	<input id="horarioArribo" type="time" name="horarioArribo">
		</td>
	</tr>
	
	<tr>
	
		<td>
			<label name="escalas">Escalas:</label>
		</td>
	
		<td>
			<label name="pasajes">Cantidad de pasajes:</label>
		</td>
		
		
	</tr>
	
	<tr>
		<td>
			<select id="escalas">
				<option value=0>Sin escalas</option>
				<option value=1>1</option>
				<option value=2>2</option>
				<option value=3>3</option>
				<option value=4>4</option>
			</select>
		</td>
	
		<td>
			<input id="pasajes" type="number" min=1 max="700">
		</td>
	</tr>
	
	<tr>
		<td>
			<label name="formasPago">Formas de pago:</label>
		</td>
	
		<td>
			<label name="precio">Precio:</label>
		</td>
	</tr>
	
	<tr>
		<td>
			<select id="pago">
				<option value="amex">American Express</option>
				<option value="Visa">Visa</option>
				<option value="master">Master Card</option>
				<option value="diners">Diners</option>
				<option value="nativa">Nativa</option>
				<option value="naranja">Naranja</option>
			</select>
		</td>
		
		<td>
			<input id="precio" type="number">
		</td>
	</tr>
	
	<tr>
		<td>
			<input type="button" id="agregar" value="Agregar vuelo" onclick="agregarVuelo()"> 
		</td>
	</tr>
	</table>
<!-- Final tabla agregar vuelos -->

<!-- Inicio tabla modificar vuelos -->
<table id="tablaModificarVuelo" style='display:none;'>
	<tr>
		<td>
			<label name="modificarEmpresa">Línea aérea:</label>
		</td>
	
		<td>
			<label name="modificarDestino">Destino del Vuelo:</label>
		</td>
		
	</tr>
	
	<tr>
		<td>
			<select id="modificarEmpresa">
				<option value="empresa">Elija empresa</option>
				<option value="aerolineas">Aerolineas Argentinas</option>
				<option value="american">American Airlines</option>
				<option value="varig">Varig</option>
				<option value="lufthansa">Lufthansa</option>
				<option value="british">British Airways</option>
				<option value="latam">Latam</option>
				<option value="austral">Austral</option>
				<option value="klm">KLM</option>
				<option value="alitalia">Alitalia</option>
				<option value="qantas">Qantas Airlines</option>
				<option value="souther">Souther Winds</option>
				<option value="united">United Airlines</option>
				<option value="iberia">Iberia</option>
				<option value="air">Air France</option>
				<option value="blue">Blue Airelines</option>
			</select>
		</td>
		
		<td>
			<select id="modificarDestino" name="pais">
				<option value="AF">Afganistán</option>
				<option value="AL">Albania</option>
				<option value="DE">Alemania</option>
				<option value="AD">Andorra</option>
				<option value="AO">Angola</option>
				<option value="AI">Anguilla</option>
				<option value="AQ">Antártida</option>
				<option value="AG">Antigua y Barbuda</option>
				<option value="AN">Antillas Holandesas</option>
				<option value="SA">Arabia Saudí</option>
				<option value="DZ">Argelia</option>
				<option value="AR">Argentina</option>
				<option value="AM">Armenia</option>
				<option value="AW">Aruba</option>
				<option value="AU">Australia</option>
				<option value="AT">Austria</option>
				<option value="AZ">Azerbaiyán</option>
				<option value="BS">Bahamas</option>
				<option value="BH">Bahrein</option>
				<option value="BD">Bangladesh</option>
				<option value="BB">Barbados</option>
				<option value="BE">Bélgica</option>
				<option value="BZ">Belice</option>
				<option value="BJ">Benin</option>
				<option value="BM">Bermudas</option>
				<option value="BY">Bielorrusia</option>
				<option value="MM">Birmania</option>
				<option value="BO">Bolivia</option>
				<option value="BA">Bosnia y Herzegovina</option>
				<option value="BW">Botswana</option>
				<option value="BR">Brasil</option>
				<option value="BN">Brunei</option>
				<option value="BG">Bulgaria</option>
				<option value="BF">Burkina Faso</option>
				<option value="BI">Burundi</option>
				<option value="BT">Bután</option>
				<option value="CV">Cabo Verde</option>
				<option value="KH">Camboya</option>
				<option value="CM">Camerún</option>
				<option value="CA">Canadá</option>
				<option value="TD">Chad</option>
				<option value="CL">Chile</option>
				<option value="CN">China</option>
				<option value="CY">Chipre</option>
				<option value="CO">Colombia</option>
				<option value="KM">Comores</option>
				<option value="CG">Congo</option>
				<option value="KR">Corea</option>
				<option value="KP">Corea del Norte</option>
				<option value="CI">Costa de Marfíl</option>
				<option value="CR">Costa Rica</option>
				<option value="HR">Croacia (Hrvatska)</option>
				<option value="CU">Cuba</option>
				<option value="DK">Dinamarca</option>
				<option value="DJ">Djibouti</option>
				<option value="DM">Dominica</option>
				<option value="EC">Ecuador</option>
				<option value="EG">Egipto</option>
				<option value="SV">El Salvador</option>
				<option value="AE">Emiratos Árabes Unidos</option>
				<option value="ER">Eritrea</option>
				<option value="SI">Eslovenia</option>
				<option value="ES" selected>España</option>
				<option value="US">Estados Unidos</option>
				<option value="EE">Estonia</option>
				<option value="ET">Etiopía</option>
				<option value="FJ">Fiji</option>
				<option value="PH">Filipinas</option>
				<option value="FI">Finlandia</option>
				<option value="FR">Francia</option>
				<option value="GA">Gabón</option>
				<option value="GM">Gambia</option>
				<option value="GE">Georgia</option>
				<option value="GH">Ghana</option>
				<option value="GI">Gibraltar</option>
				<option value="GD">Granada</option>
				<option value="GR">Grecia</option>
				<option value="GL">Groenlandia</option>
				<option value="GP">Guadalupe</option>
				<option value="GU">Guam</option>
				<option value="GT">Guatemala</option>
				<option value="GY">Guayana</option>
				<option value="GF">Guayana Francesa</option>
				<option value="GN">Guinea</option>
				<option value="GQ">Guinea Ecuatorial</option>
				<option value="GW">Guinea-Bissau</option>
				<option value="HT">Haití</option>
				<option value="HN">Honduras</option>
				<option value="HU">Hungría</option>
				<option value="IN">India</option>
				<option value="ID">Indonesia</option>
				<option value="IQ">Irak</option>
				<option value="IR">Irán</option>
				<option value="IE">Irlanda</option>
				<option value="BV">Isla Bouvet</option>
				<option value="CX">Isla de Christmas</option>
				<option value="IS">Islandia</option>
				<option value="KY">Islas Caimán</option>
				<option value="CK">Islas Cook</option>
				<option value="CC">Islas de Cocos o Keeling</option>
				<option value="FO">Islas Faroe</option>
				<option value="HM">Islas Heard y McDonald</option>
				<option value="FK">Islas Malvinas</option>
				<option value="MH">Islas Marshall</option>
				<option value="PW">Islas Palau</option>
				<option value="SB">Islas Salomón</option>
				<option value="SJ">Islas Svalbard y Jan Mayen</option>
				<option value="TK">Islas Tokelau</option>
				<option value="TC">Islas Turks y Caicos</option>
				<option value="VI">Islas Vírgenes (EEUU)</option>
				<option value="WF">Islas Wallis y Futuna</option>
				<option value="IL">Israel</option>
				<option value="IT">Italia</option>
				<option value="JM">Jamaica</option>
				<option value="JP">Japón</option>
				<option value="JO">Jordania</option>
				<option value="KZ">Kazajistán</option>
				<option value="KE">Kenia</option>
				<option value="KG">Kirguizistán</option>
				<option value="KI">Kiribati</option>
				<option value="KW">Kuwait</option>
				<option value="LA">Laos</option>
				<option value="LS">Lesotho</option>
				<option value="LV">Letonia</option>
				<option value="LB">Líbano</option>
				<option value="LR">Liberia</option>
				<option value="LY">Libia</option>
				<option value="LI">Liechtenstein</option>
				<option value="LT">Lituania</option>
				<option value="LU">Luxemburgo</option>
				<option value="MG">Madagascar</option>
				<option value="MY">Malasia</option>
				<option value="MW">Malawi</option>
				<option value="MV">Maldivas</option>
				<option value="ML">Malí</option>
				<option value="MT">Malta</option>
				<option value="MA">Marruecos</option>
				<option value="MQ">Martinica</option>
				<option value="MU">Mauricio</option>
				<option value="MR">Mauritania</option>
				<option value="YT">Mayotte</option>
				<option value="MX">México</option>
				<option value="FM">Micronesia</option>
				<option value="MD">Moldavia</option>
				<option value="MC">Mónaco</option>
				<option value="MN">Mongolia</option>
				<option value="MS">Montserrat</option>
				<option value="MZ">Mozambique</option>
				<option value="NA">Namibia</option>
				<option value="NR">Nauru</option>
				<option value="NP">Nepal</option>
				<option value="NI">Nicaragua</option>
				<option value="NE">Níger</option>
				<option value="NG">Nigeria</option>
				<option value="NU">Niue</option>
				<option value="NF">Norfolk</option>
				<option value="NO">Noruega</option>
				<option value="NC">Nueva Caledonia</option>
				<option value="NZ">Nueva Zelanda</option>
				<option value="OM">Omán</option>
				<option value="NL">Países Bajos</option>
				<option value="PA">Panamá</option>
				<option value="PG">Papúa Nueva Guinea</option>
				<option value="PK">Paquistán</option>
				<option value="PY">Paraguay</option>
				<option value="PE">Perú</option>
				<option value="PN">Pitcairn</option>
				<option value="PF">Polinesia Francesa</option>
				<option value="PL">Polonia</option>
				<option value="PT">Portugal</option>
				<option value="PR">Puerto Rico</option>
				<option value="QA">Qatar</option>
				<option value="UK">Reino Unido</option>
				<option value="CF">República Centroafricana</option>
				<option value="CZ">República Checa</option>
				<option value="ZA">República de Sudáfrica</option>
				<option value="DO">República Dominicana</option>
				<option value="SK">República Eslovaca</option>
				<option value="RE">Reunión</option>
				<option value="RW">Ruanda</option>
				<option value="RO">Rumania</option>
				<option value="RU">Rusia</option>
				<option value="EH">Sahara Occidental</option>
				<option value="KN">Saint Kitts y Nevis</option>
				<option value="WS">Samoa</option>
				<option value="AS">Samoa Americana</option>
				<option value="SM">San Marino</option>
				<option value="VC">San Vicente y Granadinas</option>
				<option value="SH">Santa Helena</option>
				<option value="LC">Santa Lucía</option>
				<option value="ST">Santo Tomé y Príncipe</option>
				<option value="SN">Senegal</option>
				<option value="SC">Seychelles</option>
				<option value="SL">Sierra Leona</option>
				<option value="SG">Singapur</option>
				<option value="SY">Siria</option>
				<option value="SO">Somalia</option>
				<option value="LK">Sri Lanka</option>
				<option value="PM">St Pierre y Miquelon</option>
				<option value="SZ">Suazilandia</option>
				<option value="SD">Sudán</option>
				<option value="SE">Suecia</option>
				<option value="CH">Suiza</option>
				<option value="SR">Surinam</option>
				<option value="TH">Tailandia</option>
				<option value="TW">Taiwán</option>
				<option value="TZ">Tanzania</option>
				<option value="TJ">Tayikistán</option>
				<option value="TP">Timor Oriental</option>
				<option value="TG">Togo</option>
				<option value="TO">Tonga</option>
				<option value="TT">Trinidad y Tobago</option>
				<option value="TN">Túnez</option>
				<option value="TM">Turkmenistán</option>
				<option value="TR">Turquía</option>
				<option value="TV">Tuvalu</option>
				<option value="UA">Ucrania</option>
				<option value="UG">Uganda</option>
				<option value="UY">Uruguay</option>
				<option value="UZ">Uzbekistán</option>
				<option value="VU">Vanuatu</option>
				<option value="VE">Venezuela</option>
				<option value="VN">Vietnam</option>
				<option value="YE">Yemen</option>
				<option value="YU">Yugoslavia</option>
				<option value="ZM">Zambia</option>
				<option value="ZW">Zimbabue</option>
			</select>
		</td>
	</tr>
	
	<tr>
		<td>
			<label name="modificarFechaSalida">Fecha de salida:</label>
		</td>
		
		<td>
			<label name="modificarHorarioSalida">Horario de salida:</label>
		</td>
	
	</tr>
	
	<tr>
		<td>
			<input id="modificarFechaSalida" type="date">
		</td>
		
		<td>
		 	<input id="modificarHorarioSalida" type="time" name="modificarHorarioSalida">
		</td>
	</tr>
	
	<tr>
		<td>
			<label name="modificarFechaArribo">Fecha de arribo:</label>
		</td>
		
		<td>
			<label name="modificarHorarioArribo">Horario de arribo:</label>
		</td>
	</tr>

	<tr>
		<td>
			<input id="modificarFechaArribo" type="date">
		</td>
		
		<td>
		 	<input id="modificarHorarioArribo" type="time" name="modificarHorarioArribo">
		</td>
	</tr>
	
	<tr>
	
		<td>
			<label name="modificarEscalas">Escalas:</label>
		</td>
	
		<td>
			<label name="modificarPasajes">Cantidad de pasajes:</label>
		</td>
		
		
	</tr>
	
	<tr>
		<td>
			<select id="modificarEscalas">
				<option value=0>Sin escalas</option>
				<option value=1>1</option>
				<option value=2>2</option>
				<option value=3>3</option>
				<option value=4>4</option>
			</select>
		</td>
	
		<td>
			<input id="modificarPasajes" type="number" min=1 max="700">
		</td>
	</tr>
	
	<tr>
		<td>
			<label name="modificarFormasPago">Formas de pago:</label>
		</td>
	
		<td>
			<label name="modificarPrecio">Precio:</label>
		</td>
	</tr>
	
	<tr>
		<td>
			<select id="modificarPago">
				<option value="amex">American Express</option>
				<option value="Visa">Visa</option>
				<option value="master">Master Card</option>
				<option value="diners">Diners</option>
				<option value="nativa">Nativa</option>
				<option value="naranja">Naranja</option>
			</select>
		</td>
		
		<td>
			<input id="modificarPrecio" type="number">
		</td>
	</tr>
	
	<tr>
		<td>
			<label>Aviones disponibles:</label>
		</td>
	
		<td>
			<label name="modificarId">Seleccione el vuelo a modficar:</label>
		</td>
	</tr>
	
	<tr>
		<td>
			<select id="modificarSelectAvionesDisponibles">
				<!-- Acá sólo va texto creado dinamicamente desde la base de datos por medio de Javascript -->
			</select>
		</td>
	
		<td>
			<select id="selectVuelosDisponibles">
				<!-- Acá se llena dinamicamente con un llamado de AJAX con evento body 'onload' -->
			</select>
		</td>
	</tr>
	
	<tr>
		<td>
			<input type="button" id="modificar" value="Modificar vuelo" onclick="modificarVuelo()"> 
		</td>
	</tr>
	</table>
<!-- Final tabla modificiar vuelos -->

<!-- Inicio tabla eliminar vuelo -->
	<table id="tablaEliminarVuelo" style='display:none;'>
		<tr>
			<td>
				<label name="">Ingrese el 'id' del vuelo a eliminar:</label>
			</td>
		</tr>
		
		<tr>
			<td>
				<select id="selectEliminarId">
					<!-- Acá se va a crear texto dinamicamente por Javascript -->
				</select>
			</td>
		</tr>
		
		<tr>
			<td>
				<input type="button" value="Eliminar vuelo" onclick="eliminarVuelo()">
			</td>
		</tr>
	</table>
<!-- Final de tabla eliminar vuelo -->

</div>

<div id="resultados">

<table id="tablaVerVuelos">

</table>

</div>

	</body>		
</html>
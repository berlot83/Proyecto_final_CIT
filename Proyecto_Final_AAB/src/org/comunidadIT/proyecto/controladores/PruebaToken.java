package org.comunidadIT.proyecto.controladores;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.comunidadIT.proyecto.accesoDatos.ValidarToken;

@Path("/validar")
public class PruebaToken {

	@GET
	@Path("/token")
	@Produces(MediaType.TEXT_HTML)
	public String validarToken(){
		ValidarToken v= new ValidarToken();
		return v.token();
	}
	
}

package org.comunidadIT.proyecto.controladores;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

public class MetodosResponse {

	public static final ResponseBuilder ACCEPTED(){
		
		return Response.status(200);
	}
	
	
	public static final ResponseBuilder CREADO(){
		
		return Response.status(201);
	}
	
	
	public static final ResponseBuilder UNAUTHORIZED(){
		
		return Response.status(401);
	}
	
}

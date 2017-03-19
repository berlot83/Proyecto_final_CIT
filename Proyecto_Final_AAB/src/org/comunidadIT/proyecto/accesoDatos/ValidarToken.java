package org.comunidadIT.proyecto.accesoDatos;

import java.security.Key;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

public class ValidarToken {

	public String token(){
		// We need a signing key, so we'll create one just for this example. Usually
		// the key would be read from your application configuration instead.
		Key key = MacProvider.generateKey();

		String compactJws = Jwts.builder()
		  .setSubject("Joe")
		  .signWith(SignatureAlgorithm.HS512, key)
		  .compact();
		
		return compactJws;
	}
	
}

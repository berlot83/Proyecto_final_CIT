package org.comunidadIT.proyecto.entidades;

public class Vuelo {
	
	protected int id;
	protected String empresa;
	protected String destino;
	protected int escalas;
	protected int pasajes;
	protected String salida;
	protected String horario;
	protected String arribo;
	protected String horarioArribo;
	protected String pago;
	protected int precio;
	
	public Vuelo(int id, String empresa, String destino, int escalas, int pasajes, String salida, String horario, String arribo, String horarioArribo, String pago, int precio){
	
		this.id=id;
		this.empresa=empresa;
		this.destino=destino;
		this.escalas=escalas;
		this.pasajes=pasajes;
		this.salida=salida;
		this.horario=horario;
		this.arribo=arribo;
		this.horarioArribo=horarioArribo;
		this.pago=pago;
		this.precio=precio;
	}
	
	public Vuelo(int id, String empresa, String destino, int escalas, int pasajes, String salida, String arribo){
		
		this.id=id;
		this.empresa=empresa;
		this.destino=destino;
		this.escalas=escalas;
		this.pasajes=pasajes;
		this.salida=salida;
		this.arribo=arribo;
	}
	
	
	public Vuelo(int id){
		
		this.id=id;
	}
	

}

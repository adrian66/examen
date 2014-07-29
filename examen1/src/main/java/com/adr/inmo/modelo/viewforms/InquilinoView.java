package com.adr.inmo.modelo.viewforms;

import com.adr.inmo.modelo.Inmueble;
import com.adr.inmo.modelo.Inquilino;

public class InquilinoView {

    private Integer idInquilino;
    private Integer idInmueble;
    private String dni;
    private String nombre;
    private Integer edad;
    private boolean trabaja;
    private double precio;
	
   

	public InquilinoView(Integer idInquilino, Integer idInmueble,
			String dni, String nombre, Integer edad, boolean trabaja,
			double precio) {
		super();
		this.idInquilino = idInquilino;
		this.idInmueble = idInmueble;
		this.dni = dni;
		this.nombre = nombre;
		this.edad = edad;
		this.trabaja = trabaja;
		this.precio = precio;
	}

	public Inquilino getInquilino(){
		
		Inquilino tp=new Inquilino();
		tp.setIdInquilino(idInquilino);
		tp.setNombre(nombre);
		tp.setDni(dni);
		tp.setEdad(edad);
		tp.setTrabaja(trabaja);
				
		Inmueble inm=new Inmueble();
		inm.setIdInmueble(idInmueble);
		tp.setInmueble(inm);
		
		return tp;
	}
	
	public void fromInquilino(Inquilino tp){
		idInquilino=tp.getIdInquilino();
		nombre=tp.getNombre();
		dni=tp.getDni(); 
		edad=tp.getEdad();
		trabaja=tp.getTrabaja();
		
		setIdInmueble(tp.getInmueble().getIdInmueble());
	
	public InquilinoView() {
			}
		
	}
	public Integer getidInquilino() {
		return idInquilino;
	}

	public void setIdInquilino(Integer idInquilino) {
		this.idInquilino = idInquilino;
	}

	public Integer getIdInmueble() {
		return idInmueble;
	}

	public void setIdInmueble(Integer idInmueble) {
		this.idInmueble = idInmueble;
	}

	public String getIdDni() {
		return dni;
	}

	public void setdni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public boolean getTrabaja() {
		return trabaja;
	}

	public void setTrabaja(boolean trabaja) {
		this.trabaja = trabaja;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Integer getIdInquilino() {
		return idInquilino;
	}
	   
	 
	
}

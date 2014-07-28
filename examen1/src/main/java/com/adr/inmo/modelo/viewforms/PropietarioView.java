package com.adr.inmo.modelo.viewforms;

import com.adr.inmo.modelo.Inmueble;
import com.adr.inmo.modelo.Propietario;

public class PropietarioView {
	

	     private Integer idPropietario;
	     private Integer idInmueble;
	     private String nombre;
	     private String dni;
	     private String direccion;
	     private double precio;
		public PropietarioView() {
		}
				
		public PropietarioView(Integer idPropietario, Integer idInmueble,
				String nombre, String dni, String direccion, double precio) {
			super();
			this.idPropietario = idPropietario;
			this.idInmueble = idInmueble;
			this.nombre = nombre;
			this.dni = dni;
			this.direccion = direccion;
			this.precio = precio;
		}
		
		public Propietario getPropietario(){
			
			Propietario tp=new Propietario();
			tp.setNombre(nombre);
			tp.setDni(dni);
	// 		tp.setDireccion(direccion);
	//		tp.setPrecio(precio);
			tp.setIdPropietario(idPropietario);
						
			Inmueble tc=new Inmueble();
			tc.setIdInmueble(idInmueble);
			
	//		tp.setInmueble(tc);
			
			return tp;
		}
		
		public void fromPropietario(Propietario tp){
			idPropietario=tp.getIdPropietario();
			nombre=tp.getNombre();
			dni=tp.getDni(); 
	//		direccion=tp.getDireccion();
		//	precio=tp.getPrecio();
	//		idInmueble=tp.getInmueble().getIdInmueble();
			
		}
		
		public Integer getIdInmueble() {
			return idInmueble;
		}
		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}
		public String getDni() {
			return dni;
		}
		public void setDni(String dni) {
			this.dni = dni;
		}
		public Integer getIdPropietario() {
			return idPropietario;
		}
		public void setIdPropietario(Integer idPropietario) {
			this.idPropietario = idPropietario;
		}
		public Integer getInmueble() {
			return idInmueble;
		}
		public void setIdInmueble(Integer idInmueble) {
			this.idInmueble = idInmueble;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		
		public String getDireccion() {
			return direccion;
		}
		public void setFoto(String direccion) {
			this.direccion = direccion;
		}
		public double getPrecio() {
			return precio;
		}
		public void setPrecio(double precio) {
			this.precio = precio;
		}

	     
	     
	     
}

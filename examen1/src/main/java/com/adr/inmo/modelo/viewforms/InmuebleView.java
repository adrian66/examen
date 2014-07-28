package com.adr.inmo.modelo.viewforms;

import com.adr.inmo.modelo.Inmueble;
import com.adr.inmo.modelo.Inquilino;
import com.adr.inmo.modelo.Propietario;

public class InmuebleView {
	
	  private Integer idInmueble;
	    private Integer idInquilino;
	    private Integer idPropietario;
	    private String direccion;
	    private double precio;
	    private Integer dni;
	    private String nombre;
	    private Integer edad;
	    private boolean trabaja;
		
	    
	    public Inmueble getInmueble(){
			
			Inmueble tp=new Inmueble();
			tp.setIdInmueble(idInmueble);
			tp.setDireccion(direccion);
			tp.setPrecio(precio);
			
			Inquilino inq=new Inquilino();
			inq.setIdInquilino(idInquilino);
			tp.setInquilino(inq);
			
			Propietario p=new Propietario();
			p.setIdPropietario(idPropietario);
			tp.setPropietario(p);
			
			
			return tp;
		}
		
		public void fromInmueble(Inmueble tp){
			idInmueble=tp.getIdInmueble();
			direccion=tp.getDireccion();
			precio=tp.getPrecio();
			
			setIdInquilino(tp.getInquilino().getIdInquilino());
			setIdPropietario(tp.getPropietario().getIdPropietario());
		//	dni=tp.getDni(); 
//			direccion=tp.getDireccion();
		
//			idInmueble=tp.getInmueble().getIdInmueble();
			
		}
	    public InmuebleView() {
		}

		public InmuebleView(Integer idInmueble, Integer idInquilino, Integer idPropietario,
				String direccion, double precio, Integer dni, String nombre,
				Integer edad, boolean trabaja) {
			super();
			this.idInmueble = idInmueble;
			this.idInquilino = idInquilino;
			this.idPropietario = idPropietario;
			this.direccion = direccion;
			this.precio = precio;
			this.dni = dni;
			this.nombre = nombre;
			this.edad = edad;
			this.trabaja = trabaja;
		}

		public Integer getIdInmueble() {
			return idInmueble;
		}

		public void setIdInmueble(Integer idInmueble) {
			this.idInmueble = idInmueble;
		}

		public Integer getIdInquilino() {
			return idInquilino;
		}

		public void setIdInquilino(Integer idInquilino) {
			this.idInquilino = idInquilino;
		}

		public String getDireccion() {
			return direccion;
		}

		public Integer getIdPropietario() {
			return idPropietario;
		}

		public void setIdPropietario(Integer idPropietario) {
			this.idPropietario = idPropietario;
		}

		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}

		public double getPrecio() {
			return precio;
		}

		public void setPrecio(double precio) {
			this.precio = precio;
		}

		public Integer getDni() {
			return dni;
		}

		public void setDni(Integer dni) {
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
	      
		  
	    

}

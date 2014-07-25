package com.adr.inmo.repositorio;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Hibernate;

import com.adr.inmo.modelo.Inmueble;
import com.adr.inmo.modelo.Inquilino;
import com.adr.inmo.modelo.Propietario;

public class RepositorioPropietario extends Repositorio<Propietario> {
 
	@Override
	public Propietario get(Class<Propietario> tipo, int id) {
		// TODO Auto-generated method stub
		Propietario e= super.get(tipo, id);
		
	
		Hibernate.initialize(e.getInmuebles());
		
		
		return e;
	}
}



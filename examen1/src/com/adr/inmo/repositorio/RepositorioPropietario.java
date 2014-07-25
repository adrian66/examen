package com.adr.inmo.repositorio;

import org.hibernate.Hibernate;

import com.adr.inmo.modelo.Inquilino;
import com.adr.inmo.modelo.Propietario;

public class RepositorioPropietario extends Repositorio<Propietario> {

	@Override
	public Propietario get(Class<Propietario> tipo, int id) {
		// TODO Auto-generated method stub
		Propietario e= super.get(tipo, id);
		
	//	Hibernate.initialize(e.getDepartamento());
	//	Hibernate.initialize(e.getPuesto());
	//	Hibernate.initialize(e.getIdiomas());
		
		return e;
	}
}

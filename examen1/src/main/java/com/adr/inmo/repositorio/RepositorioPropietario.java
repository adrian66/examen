package com.adr.inmo.repositorio;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Hibernate;

import com.adr.inmo.modelo.Inmueble;
import com.adr.inmo.modelo.Inquilino;
import com.adr.inmo.modelo.Propietario;

public class RepositorioPropietario extends Repositorio<Propietario> {
 
	//@Override
    //	public Propietario get(Class<Propietario> tipo, int id) {
	//	Propietario e= super.get(tipo, id);
	
		public Map<Integer, String> getMapaOptions(){
		List<Propietario> l=get(Propietario.class);
		Map<Integer, String> mapa=new HashMap<Integer, String>();
		for (Propietario propietario : l) {
			
			mapa.put(propietario.getIdPropietario(), propietario.getNombre());
		}
		
	
	//	Hibernate.initialize(e.getInmuebles());
		
				
	//	return e;
		return mapa;
	}
}



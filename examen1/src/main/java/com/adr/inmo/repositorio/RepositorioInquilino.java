package com.adr.inmo.repositorio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.adr.inmo.modelo.Inquilino;

public class RepositorioInquilino extends Repositorio<Inquilino>{

	public Map<Integer, String> getMapaOptions(){
		
		List<Inquilino> l=get(Inquilino.class);
		Map<Integer, String> mapa=new HashMap<Integer, String>();
		
		for (Inquilino inquilino : l) {
			
			mapa.put(inquilino.getIdInquilino(), inquilino.getNombre());
		}
		
		return mapa;
	}
}

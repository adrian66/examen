package com.adr.inmo.repositorio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.adr.inmo.modelo.Inmueble;


public class RepositorioInmueble 
				extends Repositorio<Inmueble>{

public Map<Integer, String> getMapaOptions(){
		
		List<Inmueble> l=get(Inmueble.class);
		Map<Integer, String> mapa=new HashMap<Integer, String>();
		
		for (Inmueble inmueble : l) {
			
			mapa.put(inmueble.getIdInmueble(),
					inmueble.getDireccion());
		}
		
		return mapa;
	}
}

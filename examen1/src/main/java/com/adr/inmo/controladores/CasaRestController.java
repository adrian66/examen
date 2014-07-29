package com.adr.inmo.controladores;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.adr.inmo.modelo.Inmueble;
import com.adr.inmo.repositorio.RepositorioInmueble;

@Controller
@RequestMapping(value="/inmueble")
public class CasaRestController {
	@Autowired
	RepositorioInmueble dao;
	
	@RequestMapping(method=RequestMethod.GET,value="/{id}")
	public @ResponseBody Inmueble inmueble(@PathVariable int id){
		
		Inmueble e=dao.get(Inmueble.class, id);
		
		return e;
			
	}
	@RequestMapping(method=RequestMethod.GET,
			value="/buscar/{texto}")
	public @ResponseBody List<Inmueble> 
				buscar(@PathVariable String texto){
	
		if(texto.equals("Sinbusqueda"))
			texto="";
		
		Map<String, Object> params=new HashMap();
		params.put("texto", "%"+texto+"%");
		List<Inmueble> l=dao.find("inmueble.buscador", params);
		return l;
		
		
	}
	@RequestMapping(method=RequestMethod.DELETE)
	public @ResponseBody String borrar(@RequestBody 
										Inmueble inmueble){
		
		dao.delete(inmueble);
		
		return "borrado";
	}
}










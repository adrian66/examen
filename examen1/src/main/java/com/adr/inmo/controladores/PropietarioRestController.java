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

import com.adr.inmo.modelo.Propietario;
import com.adr.inmo.repositorio.RepositorioPropietario;

@Controller
@RequestMapping(value="/propietario")
public class PropietarioRestController {

	@Autowired
	RepositorioPropietario dao;
	
	@RequestMapping(method=RequestMethod.GET,value="/{id}")
	public @ResponseBody Propietario propietario(@PathVariable int id){
		
		Propietario e=dao.get(Propietario.class, id);
		
		return e;
		
		
	}
	@RequestMapping(method=RequestMethod.GET,
			value="/buscar/{texto}")
	public @ResponseBody List<Propietario> 
				buscar(@PathVariable String texto){
	
		if(texto.equals("Sinbusqueda"))
			texto="";
		
		Map<String, Object> params=new HashMap();
		params.put("texto", "%"+texto+"%");
		List<Propietario> l=dao.find("propietario.buscador", params);
		return l;
		
		
	}
	@RequestMapping(method=RequestMethod.DELETE)
	public @ResponseBody String borrar(@RequestBody 
										Propietario propietario){
		
		dao.delete(propietario);
		
		return "borrado";
	}
}










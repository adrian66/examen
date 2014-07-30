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

import com.adr.inmo.modelo.Inquilino;
import com.adr.inmo.repositorio.RepositorioInquilino;

@Controller
@RequestMapping(value="/inquilino")
public class InquilinoRestController {
	
	@Autowired
	RepositorioInquilino dao;
	
	@RequestMapping(method=RequestMethod.GET,value="/{id}")
	public @ResponseBody Inquilino inquilino(@PathVariable int id){
		
		Inquilino e=dao.get(Inquilino.class, id);
		
		return e;
			
	}
	@RequestMapping(method=RequestMethod.GET,
			value="/buscar/{texto}")
	public @ResponseBody List<Inquilino> 
				buscar(@PathVariable String texto){
	
		if(texto.equals("SinBusqueda"))
			texto="";
		
		Map<String, Object> params=new HashMap();
		params.put("texto", "%"+texto+"%");
		List<Inquilino> l=dao.find("inquilino.buscador", params);
		return l;
		
		
	}
	@RequestMapping(method=RequestMethod.DELETE)
	public @ResponseBody String borrar(@RequestBody Inquilino inquilino){
		
		dao.delete(inquilino);
		
		return "borrado";
	}
}










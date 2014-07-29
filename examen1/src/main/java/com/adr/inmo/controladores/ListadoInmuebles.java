package com.adr.inmo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.adr.inmo.modelo.Inmueble;
import com.adr.inmo.repositorio.RepositorioInmueble;


public class ListadoInmuebles {

	@Autowired
	RepositorioInmueble dao;
	@RequestMapping(value="listadoCasa.html",method=RequestMethod.GET)
	public String listado(Model modelo) {
		
		List<Inmueble> inmuebles=dao.get(Inmueble.class);
		modelo.addAttribute("inmuebles", inmuebles);
		
		return "listadoCasa";
			
	}
	@RequestMapping(value="/detalleCasa_{id}.html")
	public String detalle(Model modelo,@PathVariable int id){
		
		Inmueble tp=dao.get(Inmueble.class,id);
		
		modelo.addAttribute("inmueble", tp);
		return "detalleInm";
		
	}
}



package com.adr.inmo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.adr.inmo.modelo.Propietario;
import com.adr.inmo.repositorio.RepositorioPropietario;

public class ListadoPropietarios {

	@Autowired
	RepositorioPropietario dao;
	@RequestMapping(value="listadoPro.html",method=RequestMethod.GET)
	public String listado(Model modelo) {
		
		List<Propietario> propietarios=dao.get(Propietario.class);
		modelo.addAttribute("propietarios", propietarios);
		
		return "listadoPro";
			
	}
	@RequestMapping(value="/detallePro_{id}.html")
	public String detalle(Model modelo,@PathVariable int id){
		
		Propietario tp=dao.get(Propietario.class,id);
		
		modelo.addAttribute("propietario", tp);
		return "detalle";
		
	}
}




	


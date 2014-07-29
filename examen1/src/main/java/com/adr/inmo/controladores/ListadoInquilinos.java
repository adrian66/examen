package com.adr.inmo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.adr.inmo.modelo.Inquilino;
import com.adr.inmo.repositorio.RepositorioInquilino;

public class ListadoInquilinos {

	@Autowired
	RepositorioInquilino dao;
	@RequestMapping(value="listadoInq.html",method=RequestMethod.GET)
	public String listado(Model modelo) {
		
		List<Inquilino> inquilinos=dao.get(Inquilino.class);
		modelo.addAttribute("inquilinos", inquilinos);
		
		return "listadoPro";
			
	}
	@RequestMapping(value="/detalleInq_{id}.html")
	public String detalle(Model modelo,@PathVariable int id){
		
		Inquilino tp=dao.get(Inquilino.class,id);
		
		modelo.addAttribute("inquilino", tp);
		return "detalle";
		
	}
}



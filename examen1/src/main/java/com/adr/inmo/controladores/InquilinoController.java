package com.adr.inmo.controladores;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.adr.inmo.modelo.Inquilino;
import com.adr.inmo.repositorio.RepositorioInquilino;

public class InquilinoController {

	@Autowired
	RepositorioInquilino daoInquilino;
	
	
	@RequestMapping(value="/listadoInq.html")
	public String listado(Model modelo){
		
		List<Inquilino> l=
				daoInquilino.get(Inquilino.class);
		
		modelo.addAttribute("inquilinos", l);
		return "listadoInq";
	}
	@RequestMapping(value="detalle.html",method=RequestMethod.GET)
	public String detalle(Model modelo,HttpServletRequest request){
		
		int id=Integer.parseInt(request.getParameter("id"));
		
		Inquilino e=daoInquilino.get(Inquilino.class, id);
		
		
		
		modelo.addAttribute("inquilino", e);
		
		return "detalle";
	}
	
	
	
}









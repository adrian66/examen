package com.adr.inmo.controladores;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.adr.inmo.modelo.Propietario;
import com.adr.inmo.repositorio.RepositorioPropietario;

@Controller
public class PropietarioController {

	@Autowired
	RepositorioPropietario daoPropietario;
	
	
	@RequestMapping(value="/listadoPro.html")
	public String listado(Model modelo){
		
		List<Propietario> l=
				daoPropietario.get(Propietario.class);
		
		modelo.addAttribute("propietarios", l);
		return "listadoPro";
	}
	@RequestMapping(value="detalle.html",method=RequestMethod.GET)
	public String detalle(Model modelo,HttpServletRequest request){
		
		int id=Integer.parseInt(request.getParameter("id"));
		
		Propietario e=daoPropietario.get(Propietario.class, id);
		
		
		
		modelo.addAttribute("propietario", e);
		
		return "detalle";
	}
	
	
	
}








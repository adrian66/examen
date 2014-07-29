package com.adr.inmo.controladores;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.adr.inmo.modelo.Inmueble;
import com.adr.inmo.repositorio.RepositorioInmueble;

@Controller
public class CasaController {

	@Autowired
	RepositorioInmueble daoInmueble;
	
	
	@RequestMapping(value="/listadoCasa.html")
	public String listado(Model modelo){
		
		List<Inmueble> l=
				daoInmueble.get(Inmueble.class);
		
		modelo.addAttribute("inmuebles", l);
		return "listadoCasa";
	}
	@RequestMapping(value="detalleCasa.html",method=RequestMethod.GET)
	public String detalle(Model modelo,HttpServletRequest request){
		
		int id=Integer.parseInt(request.getParameter("id"));
		
		Inmueble e=daoInmueble.get(Inmueble.class, id);
		
		
		
		modelo.addAttribute("inmueble", e);
		// aqui el nombre del JSP
		return "detalleCasa";
	}
	
	
	
}











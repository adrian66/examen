package com.adr.inmo.controladores;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.adr.inmo.modelo.viewforms.InmuebleView;
import com.adr.inmo.repositorio.RepositorioInmueble;
import com.adr.inmo.repositorio.RepositorioInquilino;
import com.adr.inmo.repositorio.RepositorioPropietario;

	
	@Controller
	@RequestMapping(value="altaInmueble.html")
	public class CasaAltaController {

		@Autowired
		RepositorioInmueble daoInm;
		@Autowired
		RepositorioInquilino daoC;
		@Autowired
		RepositorioPropietario daoP;
		
		
		@RequestMapping(method=RequestMethod.GET)
		public String alta(ModelMap modelo){
			
			InmuebleView p=new InmuebleView();
			
			modelo.addAttribute("inmueble",p);
			Map<Integer, String> in=daoC.getMapaOptions();
			Map<Integer, String> pr=daoP.getMapaOptions();
			
			modelo.addAttribute("inquilinos",in);
			modelo.addAttribute("propietarios",pr);
			
			return "altaInmueble";
		}
		@RequestMapping(method=RequestMethod.POST)
		public String doAlta(@ModelAttribute("inmueble") InmuebleView p,
				BindingResult result,
					HttpServletRequest req){
			
			if(result.hasErrors()){
				
				Map<Integer, String> in=daoC.getMapaOptions();
				Map<Integer, String> pr=daoP.getMapaOptions();
				req.setAttribute("inquilinos",in);
				req.setAttribute("propietarios",pr);
				
				return "altaInmueble";
			}
			
			daoInm.add(p.getInmueble());
			return "redirect:/listadoInm.html";
		}
		
		
	}





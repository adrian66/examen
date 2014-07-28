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

import com.adr.inmo.modelo.viewforms.InquilinoView;
import com.adr.inmo.repositorio.RepositorioInmueble;
import com.adr.inmo.repositorio.RepositorioInquilino;

	@Controller
	@RequestMapping(value="altaInquilino.html")
	public class InquilinoAltaController {

		@Autowired
		RepositorioInquilino daoP;
		@Autowired
		RepositorioInmueble daoC;
		
		
		@RequestMapping(method=RequestMethod.GET)
		public String alta(ModelMap modelo){
			
			InquilinoView p=new InquilinoView();
			
			modelo.addAttribute("inquilino",p);
			Map<Integer, String> in=daoC.getMapaOptions();
			modelo.addAttribute("inmuebles",in);
			
			return "altaInquilino";
		}
		@RequestMapping(method=RequestMethod.POST)
		public String doAlta(@ModelAttribute("inquilino") InquilinoView p,
				BindingResult result,
					HttpServletRequest req){
			
			if(result.hasErrors()){
				
				Map<Integer, String> in=daoC.getMapaOptions();
				req.setAttribute("inmuebles",in);
				return "altaInquilino";
			}
			
			daoP.add(p.getInquilino());
			return "redirect:/listadoInq.html";
		}
		
		
	}


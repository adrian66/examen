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

import com.adr.inmo.modelo.viewforms.PropietarioView;
import com.adr.inmo.repositorio.RepositorioInmueble;
import com.adr.inmo.repositorio.RepositorioPropietario;

@Controller
@RequestMapping(value="altaPropietario.html")
public class ProductosAltaController {

	@Autowired
	RepositorioPropietario daoP;
	@Autowired
	RepositorioInmueble daoC;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String alta(ModelMap modelo){
		
		PropietarioView p=new PropietarioView();
		
		modelo.addAttribute("propietario",p);
		Map<Integer, String> in=daoC.getMapaOptions();
		modelo.addAttribute("inmuebles",in);
		
		return "alta";
	}
	@RequestMapping(method=RequestMethod.POST)
	public String doAlta(@ModelAttribute("propietario") PropietarioView p,
			BindingResult result,
				HttpServletRequest req){
		
		if(result.hasErrors()){
			
			Map<Integer, String> in=daoC.getMapaOptions();
			req.setAttribute("inmuebles",in);
			return "alta";
		}
		
		daoP.add(p.getPropietario());
		return "redirect:/listado.html";
	}
	
	
}

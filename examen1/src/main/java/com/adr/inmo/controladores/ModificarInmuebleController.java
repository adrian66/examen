package com.adr.inmo.controladores;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.adr.inmo.modelo.Inmueble;
import com.adr.inmo.modelo.viewforms.InmuebleView;
import com.adr.inmo.repositorio.RepositorioInmueble;
import com.adr.inmo.repositorio.RepositorioInquilino;

@Controller
@RequestMapping(value="modificarInmueble.html")

public class ModificarInmuebleController {
	
	@Autowired
	RepositorioInmueble daoC;
	@Autowired
	RepositorioInquilino daoI;
	// es igual esta linea request a la que le sigue con la difernrecia del URL
	// si se siguiera este metodo habría que elminar el @Request de arriba: @RequestMapping(value="modificarProductos.html")
	// @RequestMapping(value="/modificarProductos_{id}.html",method=RequestMethod.GET)
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	
	public String modificar(ModelMap modelo, @PathVariable int id){
		
		Inmueble p=daoC.get(Inmueble.class, id);
		InmuebleView ev=new InmuebleView();
		ev.fromInmueble(p);
		
		modelo.addAttribute("inmueble",ev);
		Map<Integer, String> in=daoI.getMapaOptions();
		modelo.addAttribute("inquilinos",in);
		
		return "modificarCasa";
	}
	// igual que en el GET lo del RequestMappring
	@RequestMapping(value="/{id}",method=RequestMethod.POST)
	public String doModificar(@ModelAttribute("inmueble") InmuebleView p,
			BindingResult result,
				HttpServletRequest req){
		
		if(result.hasErrors()){
			
			Map<Integer, String> in=daoC.getMapaOptions();
			req.setAttribute("inmuebles",in);
			return "modificarCasa";
		}
		
		daoC.update(p.getInmueble());
		return "redirect:/listadoCasa.html";	}
	
	

}

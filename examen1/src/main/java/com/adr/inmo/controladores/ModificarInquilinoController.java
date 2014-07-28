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

import com.adr.inmo.modelo.Inquilino;
import com.adr.inmo.modelo.viewforms.InquilinoView;
import com.adr.inmo.repositorio.RepositorioInmueble;
import com.adr.inmo.repositorio.RepositorioInquilino;

@Controller
@RequestMapping(value="modificarInquilino.html")

public class ModificarInquilinoController {
	
	@Autowired
	RepositorioInquilino daoQ;
	@Autowired
	RepositorioInmueble daoC;
	// es igual esta linea request a la que le sigue con la difernrecia del URL
	// si se siguiera este metodo habría que elminar el @Request de arriba: @RequestMapping(value="modificarProductos.html")
	// @RequestMapping(value="/modificarProductos_{id}.html",method=RequestMethod.GET)
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	
	public String modificar(ModelMap modelo, @PathVariable int id){
		
		Inquilino p=daoQ.get(Inquilino.class, id);
		InquilinoView ev=new InquilinoView();
		ev.fromInquilino(p);
		
		modelo.addAttribute("propietario",ev);
		Map<Integer, String> in=daoC.getMapaOptions();
		modelo.addAttribute("inmuebles",in);
		
		return "modificar";
	}
	// igual que en el GET lo del RequestMappring
	@RequestMapping(value="/{id}",method=RequestMethod.POST)
	public String doModificar(@ModelAttribute("propetario") InquilinoView p,
			BindingResult result,
				HttpServletRequest req){
		
		if(result.hasErrors()){
			
			Map<Integer, String> in=daoC.getMapaOptions();
			req.setAttribute("inmuebles",in);
			return "modificar";
		}
		
		daoQ.update(p.getInquilino());
		return "redirect:/listadoInq.html";	}
	
	

}

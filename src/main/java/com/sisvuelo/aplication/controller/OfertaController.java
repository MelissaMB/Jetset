package com.sisvuelo.aplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sisvuelo.aplication.model.View_oferta_vuelos;

@Controller
@RequestMapping("/oferta/")
public class OfertaController {

	@GetMapping("/list")
	public ModelAndView create(View_oferta_vuelos oferta) {
		ModelAndView mv = new ModelAndView("aeropuerto/create");
		if (oferta.getId() == null) {
			mv.addObject("title", "Aeropuerto create");
			mv.addObject("btn", "Create");
		} else {
			mv.addObject("title", "Aeropuerto edit");
			mv.addObject("btn", "Edit");
		}
		mv.addObject(oferta);
	
		
		//mv.addObject("ofertaList",ofertaRepository.findAll());

		return mv;
	}
}

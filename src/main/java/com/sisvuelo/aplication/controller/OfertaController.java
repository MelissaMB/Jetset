package com.sisvuelo.aplication.controller;

import com.sisvuelo.aplication.model.View_oferta_vuelos;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/oferta/")
public class OfertaController {

	@GetMapping("/list")
	public ModelAndView create(View_oferta_vuelos oferta) {
		ModelAndView mv = new ModelAndView("view_oferta_vuelo/list");

		mv.addObject("oferta", oferta);
	
		
		//mv.addObject("ofertaList",ofertaRepository.findAll());

		return mv;
	}
}

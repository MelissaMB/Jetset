package com.sisvuelo.aplication.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sisvuelo.aplication.filter.EstadoVueloFilter;
import com.sisvuelo.aplication.model.EstadoVuelo;
import com.sisvuelo.aplication.repository.EstadoVueloRepository;
import com.sisvuelo.aplication.service.EstadoVueloService;


import com.sisvuelo.aplication.model.PageWrapper;

@Controller
@RequestMapping("/estadoVuelo/")
public class EstadoVueloController {

	@Autowired
	private EstadoVueloService estadoVueloService;
	
	@Autowired
	private EstadoVueloRepository estadoVueloRepository;

	private String msgDeleteSucesso = "EstadoVuelo deleted successfully !";

	private String msgDeleteError = "EstadoVuelo an error has occurred !";

	private String msgSucessoCriacao = "EstadoVuelo created successfully !";
	
	

	@GetMapping("/create")
	public ModelAndView create(EstadoVuelo estadoVuelo) {
		ModelAndView mv = new ModelAndView("estadoVuelo/create");
		if (estadoVuelo.getId() == null) {
			mv.addObject("title", "EstadoVuelo create");
			mv.addObject("btn", "Create");
		} else {
			mv.addObject("title", "EstadoVuelo edit");
			mv.addObject("btn", "Edit");
		}
		mv.addObject(estadoVuelo);
	
		
		

		return mv;
	}

	@PostMapping("/create")
	public ModelAndView save(@Validated EstadoVuelo estadoVuelo, Errors errors, RedirectAttributes attributes) {

		if (errors.hasErrors()) {
			return create(estadoVuelo);
		}

		estadoVueloService.save(estadoVuelo);
		attributes.addFlashAttribute("message", msgSucessoCriacao);
		return new ModelAndView("redirect:/estadoVuelo/create");

	}

	@GetMapping("/{code}")
	public ModelAndView edit(@PathVariable("code") Integer code) {
		EstadoVuelo estadoVuelo = new EstadoVuelo();
		estadoVuelo = estadoVueloRepository.findById(code).get();

		return create(estadoVuelo);

	}

	@GetMapping("/list")
	public ModelAndView search(EstadoVueloFilter estadoVueloFilter, BindingResult result,
			@PageableDefault(size = 10) Pageable pageable, HttpServletRequest httpServletRequest) {
		System.out.println(estadoVueloService);
		ModelAndView mv = new ModelAndView("estadoVuelo/list");
		mv.addObject("pagina", new PageWrapper<>(estadoVueloService.filter(estadoVueloFilter, pageable),httpServletRequest));
        
		
		return mv;
	}

	@DeleteMapping("/delete/{code}")
	public ModelAndView delete(@PathVariable("code") Integer code, RedirectAttributes attributes) {
		System.out.println(code);
		EstadoVuelo estadoVuelo = new EstadoVuelo();
		estadoVuelo.setId(code);
		try {
			estadoVueloService.delete(estadoVuelo);
			attributes.addFlashAttribute("message", msgDeleteSucesso);
		} catch (Exception e) {
			e.printStackTrace();
			attributes.addFlashAttribute("messageErro", msgDeleteError);
		}

		return new ModelAndView("redirect:/estadoVuelo/list");
	}

}

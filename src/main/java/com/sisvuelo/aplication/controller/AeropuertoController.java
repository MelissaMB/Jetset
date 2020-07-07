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

import com.sisvuelo.aplication.filter.AeropuertoFilter;
import com.sisvuelo.aplication.model.Aeropuerto;
import com.sisvuelo.aplication.repository.AeropuertoRepository;
import com.sisvuelo.aplication.repository.CiudadRepository;
import com.sisvuelo.aplication.service.AeropuertoService;


import com.sisvuelo.aplication.model.PageWrapper;

@Controller
@RequestMapping("/aeropuerto/")
public class AeropuertoController {

	@Autowired
	private AeropuertoService aeropuertoService;
	
	@Autowired
	private AeropuertoRepository aeropuertoRepository;

	private String msgDeleteSucesso = "Aeropuerto deleted successfully !";

	private String msgDeleteError = "Aeropuerto an error has occurred !";

	private String msgSucessoCriacao = "Aeropuerto created successfully !";
	
	@Autowired private CiudadRepository ciudadRepository;

	@GetMapping("/create")
	public ModelAndView create(Aeropuerto aeropuerto) {
		ModelAndView mv = new ModelAndView("aeropuerto/create");
		if (aeropuerto.getId() == null) {
			mv.addObject("title", "Aeropuerto create");
			mv.addObject("btn", "Create");
		} else {
			mv.addObject("title", "Aeropuerto edit");
			mv.addObject("btn", "Edit");
		}
		mv.addObject(aeropuerto);
	
		
		mv.addObject("ciudadList",ciudadRepository.findAll());

		return mv;
	}

	@PostMapping("/create")
	public ModelAndView save(@Validated Aeropuerto aeropuerto, Errors errors, RedirectAttributes attributes) {

		if (errors.hasErrors()) {
			return create(aeropuerto);
		}

		aeropuertoService.save(aeropuerto);
		attributes.addFlashAttribute("message", msgSucessoCriacao);
		return new ModelAndView("redirect:/aeropuerto/create");

	}

	@GetMapping("/{code}")
	public ModelAndView edit(@PathVariable("code") Integer code) {
		Aeropuerto aeropuerto = new Aeropuerto();
		aeropuerto = aeropuertoRepository.findById(code).get();

		return create(aeropuerto);

	}

	@GetMapping("/list")
	public ModelAndView search(AeropuertoFilter aeropuertoFilter, BindingResult result,
			@PageableDefault(size = 10) Pageable pageable, HttpServletRequest httpServletRequest) {
		System.out.println(aeropuertoService);
		ModelAndView mv = new ModelAndView("aeropuerto/list");
		mv.addObject("pagina", new PageWrapper<>(aeropuertoService.filter(aeropuertoFilter, pageable),httpServletRequest));
        
		mv.addObject("ciudadList",ciudadRepository.findAll());
		return mv;
	}

	@RequestMapping(value="/delete/{code}")
	public ModelAndView delete(@PathVariable("code") Integer code, RedirectAttributes attributes) {
		System.out.println(code);
		Aeropuerto aeropuerto = new Aeropuerto();
		aeropuerto.setId(code);
		try {
			aeropuertoService.delete(aeropuerto);
			attributes.addFlashAttribute("message", msgDeleteSucesso);
		} catch (Exception e) {
			e.printStackTrace();
			attributes.addFlashAttribute("messageErro", msgDeleteError);
		}

		return new ModelAndView("redirect:/aeropuerto/list");
	}

}

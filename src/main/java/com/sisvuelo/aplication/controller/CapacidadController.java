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

import com.sisvuelo.aplication.filter.CapacidadFilter;
import com.sisvuelo.aplication.model.Capacidad;
import com.sisvuelo.aplication.repository.CapacidadRepository;
import com.sisvuelo.aplication.service.CapacidadService;

import com.sisvuelo.aplication.repository.ClaseRepository;import com.sisvuelo.aplication.repository.AvionRepository;
import com.sisvuelo.aplication.model.PageWrapper;

@Controller
@RequestMapping("/capacidad/")
public class CapacidadController {

	@Autowired
	private CapacidadService capacidadService;
	
	@Autowired
	private CapacidadRepository capacidadRepository;

	private String msgDeleteSucesso = "Capacidad deleted successfully !";

	private String msgDeleteError = "Capacidad an error has occurred !";

	private String msgSucessoCriacao = "Capacidad created successfully !";
	
	@Autowired private ClaseRepository claseRepository;@Autowired private AvionRepository avionRepository;

	@GetMapping("/create")
	public ModelAndView create(Capacidad capacidad) {
		ModelAndView mv = new ModelAndView("capacidad/create");
		if (capacidad.getId() == null) {
			mv.addObject("title", "Capacidad create");
			mv.addObject("btn", "Create");
		} else {
			mv.addObject("title", "Capacidad edit");
			mv.addObject("btn", "Edit");
		}
		mv.addObject(capacidad);
	
		
		mv.addObject("claseList",claseRepository.findAll());mv.addObject("avionList",avionRepository.findAll());

		return mv;
	}

	@PostMapping("/create")
	public ModelAndView save(@Validated Capacidad capacidad, Errors errors, RedirectAttributes attributes) {

		if (errors.hasErrors()) {
			return create(capacidad);
		}

		capacidadService.save(capacidad);
		attributes.addFlashAttribute("message", msgSucessoCriacao);
		return new ModelAndView("redirect:/capacidad/create");

	}

	@GetMapping("/{code}")
	public ModelAndView edit(@PathVariable("code") Integer code) {
		Capacidad capacidad = new Capacidad();
		capacidad = capacidadRepository.findById(code).get();

		return create(capacidad);

	}

	@GetMapping("/list")
	public ModelAndView search(CapacidadFilter capacidadFilter, BindingResult result,
			@PageableDefault(size = 10) Pageable pageable, HttpServletRequest httpServletRequest) {
		System.out.println(capacidadService);
		ModelAndView mv = new ModelAndView("capacidad/list");
		mv.addObject("pagina", new PageWrapper<>(capacidadService.filter(capacidadFilter, pageable),httpServletRequest));
        
		mv.addObject("claseList",claseRepository.findAll());mv.addObject("avionList",avionRepository.findAll());
		return mv;
	}

	@DeleteMapping("/delete/{code}")
	public ModelAndView delete(@PathVariable("code") Integer code, RedirectAttributes attributes) {
		System.out.println(code);
		Capacidad capacidad = new Capacidad();
		capacidad.setId(code);
		try {
			capacidadService.delete(capacidad);
			attributes.addFlashAttribute("message", msgDeleteSucesso);
		} catch (Exception e) {
			e.printStackTrace();
			attributes.addFlashAttribute("messageErro", msgDeleteError);
		}

		return new ModelAndView("redirect:/capacidad/list");
	}

}

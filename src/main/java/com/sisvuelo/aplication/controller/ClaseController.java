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

import com.sisvuelo.aplication.filter.ClaseFilter;
import com.sisvuelo.aplication.model.Clase;
import com.sisvuelo.aplication.repository.ClaseRepository;
import com.sisvuelo.aplication.service.ClaseService;


import com.sisvuelo.aplication.model.PageWrapper;

@Controller
@RequestMapping("/clase/")
public class ClaseController {

	@Autowired
	private ClaseService claseService;
	
	@Autowired
	private ClaseRepository claseRepository;

	private String msgDeleteSucesso = "Clase deleted successfully !";

	private String msgDeleteError = "Clase an error has occurred !";

	private String msgSucessoCriacao = "Clase created successfully !";
	
	

	@GetMapping("/create")
	public ModelAndView create(Clase clase) {
		ModelAndView mv = new ModelAndView("clase/create");
		if (clase.getId() == null) {
			mv.addObject("title", "Clase create");
			mv.addObject("btn", "Create");
		} else {
			mv.addObject("title", "Clase edit");
			mv.addObject("btn", "Edit");
		}
		mv.addObject(clase);
	
		
		

		return mv;
	}

	@PostMapping("/create")
	public ModelAndView save(@Validated Clase clase, Errors errors, RedirectAttributes attributes) {

		if (errors.hasErrors()) {
			return create(clase);
		}

		claseService.save(clase);
		attributes.addFlashAttribute("message", msgSucessoCriacao);
		return new ModelAndView("redirect:/clase/create");

	}

	@GetMapping("/{code}")
	public ModelAndView edit(@PathVariable("code") Integer code) {
		Clase clase = new Clase();
		clase = claseRepository.findById(code).get();

		return create(clase);

	}

	@GetMapping("/list")
	public ModelAndView search(ClaseFilter claseFilter, BindingResult result,
			@PageableDefault(size = 10) Pageable pageable, HttpServletRequest httpServletRequest) {
		System.out.println(claseService);
		ModelAndView mv = new ModelAndView("clase/list");
		mv.addObject("pagina", new PageWrapper<>(claseService.filter(claseFilter, pageable),httpServletRequest));
        
		
		return mv;
	}

	@DeleteMapping("/delete/{code}")
	public ModelAndView delete(@PathVariable("code") Integer code, RedirectAttributes attributes) {
		System.out.println(code);
		Clase clase = new Clase();
		clase.setId(code);
		try {
			claseService.delete(clase);
			attributes.addFlashAttribute("message", msgDeleteSucesso);
		} catch (Exception e) {
			e.printStackTrace();
			attributes.addFlashAttribute("messageErro", msgDeleteError);
		}

		return new ModelAndView("redirect:/clase/list");
	}

}

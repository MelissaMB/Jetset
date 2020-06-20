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

import com.sisvuelo.aplication.filter.CiudadFilter;
import com.sisvuelo.aplication.model.Ciudad;
import com.sisvuelo.aplication.repository.CiudadRepository;
import com.sisvuelo.aplication.service.CiudadService;

import com.sisvuelo.aplication.repository.PaisRepository;
import com.sisvuelo.aplication.model.PageWrapper;

@Controller
@RequestMapping("/ciudad/")
public class CiudadController {

	@Autowired
	private CiudadService ciudadService;
	
	@Autowired
	private CiudadRepository ciudadRepository;

	private String msgDeleteSucesso = "Ciudad deleted successfully !";

	private String msgDeleteError = "Ciudad an error has occurred !";

	private String msgSucessoCriacao = "Ciudad created successfully !";
	
	@Autowired private PaisRepository paisRepository;

	@GetMapping("/create")
	public ModelAndView create(Ciudad ciudad) {
		ModelAndView mv = new ModelAndView("ciudad/create");
		if (ciudad.getId() == null) {
			mv.addObject("title", "Ciudad create");
			mv.addObject("btn", "Create");
		} else {
			mv.addObject("title", "Ciudad edit");
			mv.addObject("btn", "Edit");
		}
		mv.addObject(ciudad);
	
		
		mv.addObject("paisList",paisRepository.findAll());

		return mv;
	}

	@PostMapping("/create")
	public ModelAndView save(@Validated Ciudad ciudad, Errors errors, RedirectAttributes attributes) {

		if (errors.hasErrors()) {
			return create(ciudad);
		}

		ciudadService.save(ciudad);
		attributes.addFlashAttribute("message", msgSucessoCriacao);
		return new ModelAndView("redirect:/ciudad/create");

	}

	@GetMapping("/{code}")
	public ModelAndView edit(@PathVariable("code") Integer code) {
		Ciudad ciudad = new Ciudad();
		ciudad = ciudadRepository.findById(code).get();

		return create(ciudad);

	}

	@GetMapping("/list")
	public ModelAndView search(CiudadFilter ciudadFilter, BindingResult result,
			@PageableDefault(size = 10) Pageable pageable, HttpServletRequest httpServletRequest) {
		System.out.println(ciudadService);
		ModelAndView mv = new ModelAndView("ciudad/list");
		mv.addObject("pagina", new PageWrapper<>(ciudadService.filter(ciudadFilter, pageable),httpServletRequest));
        
		mv.addObject("paisList",paisRepository.findAll());
		return mv;
	}

	@DeleteMapping("/delete/{code}")
	public ModelAndView delete(@PathVariable("code") Integer code, RedirectAttributes attributes) {
		System.out.println(code);
		Ciudad ciudad = new Ciudad();
		ciudad.setId(code);
		try {
			ciudadService.delete(ciudad);
			attributes.addFlashAttribute("message", msgDeleteSucesso);
		} catch (Exception e) {
			e.printStackTrace();
			attributes.addFlashAttribute("messageErro", msgDeleteError);
		}

		return new ModelAndView("redirect:/ciudad/list");
	}

}

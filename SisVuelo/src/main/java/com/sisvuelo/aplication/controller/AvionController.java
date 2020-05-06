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

import com.sisvuelo.aplication.filter.AvionFilter;
import com.sisvuelo.aplication.model.Avion;
import com.sisvuelo.aplication.repository.AvionRepository;
import com.sisvuelo.aplication.service.AvionService;


import com.sisvuelo.aplication.model.PageWrapper;

@Controller
@RequestMapping("/avion/")
public class AvionController {

	@Autowired
	private AvionService avionService;
	
	@Autowired
	private AvionRepository avionRepository;

	private String msgDeleteSucesso = "Avion deleted successfully !";

	private String msgDeleteError = "Avion an error has occurred !";

	private String msgSucessoCriacao = "Avion created successfully !";
	
	

	@GetMapping("/create")
	public ModelAndView create(Avion avion) {
		ModelAndView mv = new ModelAndView("avion/create");
		if (avion.getId() == null) {
			mv.addObject("title", "Avion create");
			mv.addObject("btn", "Create");
		} else {
			mv.addObject("title", "Avion edit");
			mv.addObject("btn", "Edit");
		}
		mv.addObject(avion);
	
		
		

		return mv;
	}

	@PostMapping("/create")
	public ModelAndView save(@Validated Avion avion, Errors errors, RedirectAttributes attributes) {

		if (errors.hasErrors()) {
			return create(avion);
		}

		avionService.save(avion);
		attributes.addFlashAttribute("message", msgSucessoCriacao);
		return new ModelAndView("redirect:/avion/create");

	}

	@GetMapping("/{code}")
	public ModelAndView edit(@PathVariable("code") Integer code) {
		Avion avion = new Avion();
		avion = avionRepository.findById(code).get();
		System.out.println(avion);

		return create(avion);

	}

	@GetMapping("/list")
	public ModelAndView search(AvionFilter avionFilter, BindingResult result,
			@PageableDefault(size = 10) Pageable pageable, HttpServletRequest httpServletRequest) {
		System.out.println(avionService);
		ModelAndView mv = new ModelAndView("avion/list");
		mv.addObject("pagina", new PageWrapper<>(avionService.filter(avionFilter, pageable),httpServletRequest));
        
		
		return mv;
	}

	@DeleteMapping("/delete/{code}")
	public ModelAndView delete(@PathVariable("code") Integer code, RedirectAttributes attributes) {
		System.out.println(code);
		Avion avion = new Avion();
		avion.setId(code);
		try {
			avionService.delete(avion);
			attributes.addFlashAttribute("message", msgDeleteSucesso);
		} catch (Exception e) {
			e.printStackTrace();
			attributes.addFlashAttribute("messageErro", msgDeleteError);
		}

		return new ModelAndView("redirect:/avion/list");
	}

}

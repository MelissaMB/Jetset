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

import com.sisvuelo.aplication.filter.MarcaFilter;
import com.sisvuelo.aplication.model.Marca;
import com.sisvuelo.aplication.repository.MarcaRepository;
import com.sisvuelo.aplication.service.MarcaService;


import com.sisvuelo.aplication.model.PageWrapper;

@Controller
@RequestMapping("/marca/")
public class MarcaController {

	@Autowired
	private MarcaService marcaService;
	
	@Autowired
	private MarcaRepository marcaRepository;

	private String msgDeleteSucesso = "Marca deleted successfully !";

	private String msgDeleteError = "Marca an error has occurred !";

	private String msgSucessoCriacao = "Marca created successfully !";
	
	

	@GetMapping("/create")
	public ModelAndView create(Marca marca) {
		ModelAndView mv = new ModelAndView("marca/create");
		if (marca.getId() == null) {
			mv.addObject("title", "Marca create");
			mv.addObject("btn", "Create");
		} else {
			mv.addObject("title", "Marca edit");
			mv.addObject("btn", "Edit");
		}
		mv.addObject(marca);
	
		
		

		return mv;
	}

	@PostMapping("/create")
	public ModelAndView save(@Validated Marca marca, Errors errors, RedirectAttributes attributes) {

		if (errors.hasErrors()) {
			return create(marca);
		}

		marcaService.save(marca);
		attributes.addFlashAttribute("message", msgSucessoCriacao);
		return new ModelAndView("redirect:/marca/create");

	}

	@GetMapping("/{code}")
	public ModelAndView edit(@PathVariable("code") Integer code) {
		Marca marca = new Marca();
		marca = marcaRepository.findById(code).get();

		return create(marca);

	}

	@GetMapping("/list")
	public ModelAndView search(MarcaFilter marcaFilter, BindingResult result,
			@PageableDefault(size = 10) Pageable pageable, HttpServletRequest httpServletRequest) {
		System.out.println(marcaService);
		ModelAndView mv = new ModelAndView("marca/list");
		mv.addObject("pagina", new PageWrapper<>(marcaService.filter(marcaFilter, pageable),httpServletRequest));
        
		
		return mv;
	}

	@RequestMapping(value="/delete/{code}")
	public ModelAndView delete(@PathVariable("code") Integer code, RedirectAttributes attributes) {
		System.out.println(code);
		Marca marca = new Marca();
		marca.setId(code);
		try {
			marcaService.delete(marca);
			attributes.addFlashAttribute("message", msgDeleteSucesso);
		} catch (Exception e) {
			e.printStackTrace();
			attributes.addFlashAttribute("messageErro", msgDeleteError);
		}

		return new ModelAndView("redirect:/marca/list");
	}

}

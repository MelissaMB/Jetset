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

import com.sisvuelo.aplication.filter.PaisFilter;
import com.sisvuelo.aplication.model.Pais;
import com.sisvuelo.aplication.repository.PaisRepository;
import com.sisvuelo.aplication.service.PaisService;


import com.sisvuelo.aplication.model.PageWrapper;

@Controller
@RequestMapping("/pais/")
public class PaisController {

	@Autowired
	private PaisService paisService;
	
	@Autowired
	private PaisRepository paisRepository;

	private String msgDeleteSucesso = "Pais deleted successfully !";

	private String msgDeleteError = "Pais an error has occurred !";

	private String msgSucessoCriacao = "Pais created successfully !";
	
	

	@GetMapping("/create")
	public ModelAndView create(Pais pais) {
		ModelAndView mv = new ModelAndView("pais/create");
		if (pais.getId() == null) {
			mv.addObject("title", "Pais create");
			mv.addObject("btn", "Create");
		} else {
			mv.addObject("title", "Pais edit");
			mv.addObject("btn", "Edit");
		}
		mv.addObject(pais);
	
		
		

		return mv;
	}

	@PostMapping("/create")
	public ModelAndView save(@Validated Pais pais, Errors errors, RedirectAttributes attributes) {

		if (errors.hasErrors()) {
			return create(pais);
		}

		paisService.save(pais);
		attributes.addFlashAttribute("message", msgSucessoCriacao);
		return new ModelAndView("redirect:/pais/create");

	}

	@GetMapping("/{code}")
	public ModelAndView edit(@PathVariable("code") Integer code) {
		Pais pais = new Pais();
		pais = paisRepository.findById(code).get();

		return create(pais);

	}

	@GetMapping("/list")
	public ModelAndView search(PaisFilter paisFilter, BindingResult result,
			@PageableDefault(size = 10) Pageable pageable, HttpServletRequest httpServletRequest) {
		System.out.println(paisService);
		ModelAndView mv = new ModelAndView("pais/list");
		mv.addObject("pagina", new PageWrapper<>(paisService.filter(paisFilter, pageable),httpServletRequest));
        
		
		return mv;
	}

	@RequestMapping(value="/delete/{code}")
	public ModelAndView delete(@PathVariable("code") Integer code, RedirectAttributes attributes) {
		System.out.println(code);
		Pais pais = new Pais();
		pais.setId(code);
		try {
			paisService.delete(pais);
			attributes.addFlashAttribute("message", msgDeleteSucesso);
		} catch (Exception e) {
			e.printStackTrace();
			attributes.addFlashAttribute("messageErro", msgDeleteError);
		}

		return new ModelAndView("redirect:/pais/list");
	}

}

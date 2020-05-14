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

import com.sisvuelo.aplication.filter.HangarFilter;
import com.sisvuelo.aplication.model.Hangar;
import com.sisvuelo.aplication.repository.HangarRepository;
import com.sisvuelo.aplication.service.HangarService;

import com.sisvuelo.aplication.repository.AeropuertoRepository;
import com.sisvuelo.aplication.model.PageWrapper;

@Controller
@RequestMapping("/hangar/")
public class HangarController {

	@Autowired
	private HangarService hangarService;
	
	@Autowired
	private HangarRepository hangarRepository;

	private String msgDeleteSucesso = "Hangar deleted successfully !";

	private String msgDeleteError = "Hangar an error has occurred !";

	private String msgSucessoCriacao = "Hangar created successfully !";
	
	@Autowired private AeropuertoRepository aeropuertoRepository;

	@GetMapping("/create")
	public ModelAndView create(Hangar hangar) {
		ModelAndView mv = new ModelAndView("hangar/create");
		if (hangar.getId() == null) {
			mv.addObject("title", "Hangar create");
			mv.addObject("btn", "Create");
		} else {
			mv.addObject("title", "Hangar edit");
			mv.addObject("btn", "Edit");
		}
		mv.addObject(hangar);
	
		
		mv.addObject("aeropuertoList",aeropuertoRepository.findAll());

		return mv;
	}

	@PostMapping("/create")
	public ModelAndView save(@Validated Hangar hangar, Errors errors, RedirectAttributes attributes) {

		if (errors.hasErrors()) {
			return create(hangar);
		}

		hangarService.save(hangar);
		attributes.addFlashAttribute("message", msgSucessoCriacao);
		return new ModelAndView("redirect:/hangar/create");

	}

	@GetMapping("/{code}")
	public ModelAndView edit(@PathVariable("code") Integer code) {
		Hangar hangar = new Hangar();
		hangar = hangarRepository.findById(code).get();

		return create(hangar);

	}

	@GetMapping("/list")
	public ModelAndView search(HangarFilter hangarFilter, BindingResult result,
			@PageableDefault(size = 10) Pageable pageable, HttpServletRequest httpServletRequest) {
		System.out.println(hangarService);
		ModelAndView mv = new ModelAndView("hangar/list");
		mv.addObject("pagina", new PageWrapper<>(hangarService.filter(hangarFilter, pageable),httpServletRequest));
        
		mv.addObject("aeropuertoList",aeropuertoRepository.findAll());
		return mv;
	}

	@DeleteMapping("/delete/{code}")
	public ModelAndView delete(@PathVariable("code") Integer code, RedirectAttributes attributes) {
		System.out.println(code);
		Hangar hangar = new Hangar();
		hangar.setId(code);
		try {
			hangarService.delete(hangar);
			attributes.addFlashAttribute("message", msgDeleteSucesso);
		} catch (Exception e) {
			e.printStackTrace();
			attributes.addFlashAttribute("messageErro", msgDeleteError);
		}

		return new ModelAndView("redirect:/hangar/list");
	}

}

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

import com.sisvuelo.aplication.filter.EstatusReservaFilter;
import com.sisvuelo.aplication.model.EstatusReserva;
import com.sisvuelo.aplication.repository.EstatusReservaRepository;
import com.sisvuelo.aplication.service.EstatusReservaService;


import com.sisvuelo.aplication.model.PageWrapper;

@Controller
@RequestMapping("/estatusReserva/")
public class EstatusReservaController {

	@Autowired
	private EstatusReservaService estatusReservaService;
	
	@Autowired
	private EstatusReservaRepository estatusReservaRepository;

	private String msgDeleteSucesso = "EstatusReserva deleted successfully !";

	private String msgDeleteError = "EstatusReserva an error has occurred !";

	private String msgSucessoCriacao = "EstatusReserva created successfully !";
	
	

	@GetMapping("/create")
	public ModelAndView create(EstatusReserva estatusReserva) {
		ModelAndView mv = new ModelAndView("estatusReserva/create");
		if (estatusReserva.getId() == null) {
			mv.addObject("title", "EstatusReserva create");
			mv.addObject("btn", "Create");
		} else {
			mv.addObject("title", "EstatusReserva edit");
			mv.addObject("btn", "Edit");
		}
		mv.addObject(estatusReserva);
	
		
		

		return mv;
	}

	@PostMapping("/create")
	public ModelAndView save(@Validated EstatusReserva estatusReserva, Errors errors, RedirectAttributes attributes) {

		if (errors.hasErrors()) {
			return create(estatusReserva);
		}

		estatusReservaService.save(estatusReserva);
		attributes.addFlashAttribute("message", msgSucessoCriacao);
		return new ModelAndView("redirect:/estatusReserva/create");

	}

	@GetMapping("/{code}")
	public ModelAndView edit(@PathVariable("code") Integer code) {
		EstatusReserva estatusReserva = new EstatusReserva();
		estatusReserva = estatusReservaRepository.findById(code).get();

		return create(estatusReserva);

	}

	@GetMapping("/list")
	public ModelAndView search(EstatusReservaFilter estatusReservaFilter, BindingResult result,
			@PageableDefault(size = 10) Pageable pageable, HttpServletRequest httpServletRequest) {
		System.out.println(estatusReservaService);
		ModelAndView mv = new ModelAndView("estatusReserva/list");
		mv.addObject("pagina", new PageWrapper<>(estatusReservaService.filter(estatusReservaFilter, pageable),httpServletRequest));
        
		
		return mv;
	}

	@RequestMapping(value="/delete/{code}")
	public ModelAndView delete(@PathVariable("code") Integer code, RedirectAttributes attributes) {
		System.out.println(code);
		EstatusReserva estatusReserva = new EstatusReserva();
		estatusReserva.setId(code);
		try {
			estatusReservaService.delete(estatusReserva);
			attributes.addFlashAttribute("message", msgDeleteSucesso);
		} catch (Exception e) {
			e.printStackTrace();
			attributes.addFlashAttribute("messageErro", msgDeleteError);
		}

		return new ModelAndView("redirect:/estatusReserva/list");
	}

}

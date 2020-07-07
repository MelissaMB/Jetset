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

import com.sisvuelo.aplication.filter.DestinoFilter;
import com.sisvuelo.aplication.model.Destino;
import com.sisvuelo.aplication.repository.DestinoRepository;
import com.sisvuelo.aplication.service.DestinoService;

import com.sisvuelo.aplication.repository.AerolineaRepository;import com.sisvuelo.aplication.repository.AeropuertoRepository;
import com.sisvuelo.aplication.model.PageWrapper;

@Controller
@RequestMapping("/destino/")
public class DestinoController {

	@Autowired
	private DestinoService destinoService;
	
	@Autowired
	private DestinoRepository destinoRepository;

	private String msgDeleteSucesso = "Destino deleted successfully !";

	private String msgDeleteError = "Destino an error has occurred !";

	private String msgSucessoCriacao = "Destino created successfully !";
	
	@Autowired private AerolineaRepository aerolineaRepository;@Autowired private AeropuertoRepository aeropuertoRepository;

	@GetMapping("/create")
	public ModelAndView create(Destino destino) {
		ModelAndView mv = new ModelAndView("destino/create");
		if (destino.getId() == null) {
			mv.addObject("title", "Destino create");
			mv.addObject("btn", "Create");
		} else {
			mv.addObject("title", "Destino edit");
			mv.addObject("btn", "Edit");
		}
		mv.addObject(destino);
	
		
		mv.addObject("aerolineaList",aerolineaRepository.findAll());mv.addObject("aeropuertoList",aeropuertoRepository.findAll());

		return mv;
	}

	@PostMapping("/create")
	public ModelAndView save(@Validated Destino destino, Errors errors, RedirectAttributes attributes) {

		if (errors.hasErrors()) {
			return create(destino);
		}

		destinoService.save(destino);
		attributes.addFlashAttribute("message", msgSucessoCriacao);
		return new ModelAndView("redirect:/destino/create");

	}

	@GetMapping("/{code}")
	public ModelAndView edit(@PathVariable("code") Integer code) {
		Destino destino = new Destino();
		destino = destinoRepository.findById(code).get();

		return create(destino);

	}

	@GetMapping("/list")
	public ModelAndView search(DestinoFilter destinoFilter, BindingResult result,
			@PageableDefault(size = 10) Pageable pageable, HttpServletRequest httpServletRequest) {
		System.out.println(destinoService);
		ModelAndView mv = new ModelAndView("destino/list");
		mv.addObject("pagina", new PageWrapper<>(destinoService.filter(destinoFilter, pageable),httpServletRequest));
        
		mv.addObject("aerolineaList",aerolineaRepository.findAll());mv.addObject("aeropuertoList",aeropuertoRepository.findAll());
		return mv;
	}

	@RequestMapping(value="/delete/{code}")
	public ModelAndView delete(@PathVariable("code") Integer code, RedirectAttributes attributes) {
		System.out.println(code);
		Destino destino = new Destino();
		destino.setId(code);
		try {
			destinoService.delete(destino);
			attributes.addFlashAttribute("message", msgDeleteSucesso);
		} catch (Exception e) {
			e.printStackTrace();
			attributes.addFlashAttribute("messageErro", msgDeleteError);
		}

		return new ModelAndView("redirect:/destino/list");
	}

}

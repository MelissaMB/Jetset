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

import com.sisvuelo.aplication.filter.AerolineaFilter;
import com.sisvuelo.aplication.model.Aerolinea;
import com.sisvuelo.aplication.repository.AerolineaRepository;
import com.sisvuelo.aplication.service.AerolineaService;

import com.sisvuelo.aplication.repository.PaisRepository;
import com.sisvuelo.aplication.model.PageWrapper;

@Controller
@RequestMapping("/aerolinea/")
public class AerolineaController {

	@Autowired
	private AerolineaService aerolineaService;
	
	
	@Autowired
	private AerolineaRepository aerolineaRepository;

	private String msgDeleteSucess = "Aerolinea deleted successfully !";

	private String msgDeleteError = "Aerolinea an error has occurred !";

	private String msgSucessoCreate = "Aerolinea created successfully !";
	
	@Autowired private PaisRepository paisRepository;

	@GetMapping("/create")
	public ModelAndView create(Aerolinea aerolinea) {
		ModelAndView mv = new ModelAndView("aerolinea/create");
		if (aerolinea.getId() == null) {
			mv.addObject("title", "Aerolinea create");
			mv.addObject("btn", "Create");
		} else {
			mv.addObject("title", "Aerolinea edit");
			mv.addObject("btn", "Edit");
		}
		System.out.println(aerolinea);

		mv.addObject(aerolinea);
	
		
		mv.addObject("paisList",paisRepository.findAll());

		return mv;
	}

	@PostMapping("/create")
	public ModelAndView save(@Validated Aerolinea aerolinea, Errors errors, RedirectAttributes attributes) {

		if (errors.hasErrors()) {
			return create(aerolinea);
		}

		aerolineaService.save(aerolinea);
		attributes.addFlashAttribute("message", msgSucessoCreate);
		return new ModelAndView("redirect:/aerolinea/create");

	}

	@GetMapping("/{code}")
	public ModelAndView edit(@PathVariable("code") Integer code) {
		Aerolinea aerolinea = new Aerolinea();
		aerolinea = aerolineaRepository.findById(code).get();

		return create(aerolinea);

	}

	@GetMapping("/list")
	public ModelAndView search(AerolineaFilter aerolineaFilter, BindingResult result,
			@PageableDefault(size = 10) Pageable pageable, HttpServletRequest httpServletRequest) {
		System.out.println(aerolineaService);
		ModelAndView mv = new ModelAndView("aerolinea/list");
		mv.addObject("pagina", new PageWrapper<>(aerolineaService.filter(aerolineaFilter, pageable),httpServletRequest));
        
		mv.addObject("paisList",paisRepository.findAll());
		return mv;
	}

	@DeleteMapping("/delete/{code}")
	public ModelAndView delete(@PathVariable("code") Integer code, RedirectAttributes attributes) {
		System.out.println(code);
		Aerolinea aerolinea = new Aerolinea();
		aerolinea.setId(code);
		try {
			aerolineaService.delete(aerolinea);
			attributes.addFlashAttribute("message", msgDeleteSucess);
		} catch (Exception e) {
			e.printStackTrace();
			attributes.addFlashAttribute("messageErro", msgDeleteError);
		}

		return new ModelAndView("redirect:/aerolinea/list");
	}

}

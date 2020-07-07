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

import com.sisvuelo.aplication.filter.PrecioFilter;
import com.sisvuelo.aplication.model.Precio;
import com.sisvuelo.aplication.repository.PrecioRepository;
import com.sisvuelo.aplication.service.PrecioService;

import com.sisvuelo.aplication.repository.ClaseRepository;import com.sisvuelo.aplication.repository.VueloRepository;
import com.sisvuelo.aplication.model.PageWrapper;

@Controller
@RequestMapping("/precio/")
public class PrecioController {

	@Autowired
	private PrecioService precioService;
	
	@Autowired
	private PrecioRepository precioRepository;

	private String msgDeleteSucesso = "Precio deleted successfully !";

	private String msgDeleteError = "Precio an error has occurred !";

	private String msgSucessoCriacao = "Precio created successfully !";
	
	@Autowired private ClaseRepository claseRepository;@Autowired private VueloRepository vueloRepository;

	@GetMapping("/create")
	public ModelAndView create(Precio precio) {
		ModelAndView mv = new ModelAndView("precio/create");
		if (precio.getId() == null) {
			mv.addObject("title", "Precio create");
			mv.addObject("btn", "Create");
		} else {
			mv.addObject("title", "Precio edit");
			mv.addObject("btn", "Edit");
		}
		mv.addObject(precio);
	
		
		mv.addObject("claseList",claseRepository.findAll());mv.addObject("vueloList",vueloRepository.findAll());

		return mv;
	}

	@PostMapping("/create")
	public ModelAndView save(@Validated Precio precio, Errors errors, RedirectAttributes attributes) {

		if (errors.hasErrors()) {
			return create(precio);
		}

		precioService.save(precio);
		attributes.addFlashAttribute("message", msgSucessoCriacao);
		return new ModelAndView("redirect:/precio/create");

	}

	@GetMapping("/{code}")
	public ModelAndView edit(@PathVariable("code") Integer code) {
		Precio precio = new Precio();
		precio = precioRepository.findById(code).get();

		return create(precio);

	}

	@GetMapping("/list")
	public ModelAndView search(PrecioFilter precioFilter, BindingResult result,
			@PageableDefault(size = 10) Pageable pageable, HttpServletRequest httpServletRequest) {
		System.out.println(precioService);
		ModelAndView mv = new ModelAndView("precio/list");
		mv.addObject("pagina", new PageWrapper<>(precioService.filter(precioFilter, pageable),httpServletRequest));
        
		mv.addObject("claseList",claseRepository.findAll());mv.addObject("vueloList",vueloRepository.findAll());
		return mv;
	}

	@RequestMapping(value="/delete/{code}")
	public ModelAndView delete(@PathVariable("code") Integer code, RedirectAttributes attributes) {
		System.out.println(code);
		Precio precio = new Precio();
		precio.setId(code);
		try {
			precioService.delete(precio);
			attributes.addFlashAttribute("message", msgDeleteSucesso);
		} catch (Exception e) {
			e.printStackTrace();
			attributes.addFlashAttribute("messageErro", msgDeleteError);
		}

		return new ModelAndView("redirect:/precio/list");
	}

}

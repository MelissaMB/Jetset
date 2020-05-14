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

import com.sisvuelo.aplication.filter.VueloFilter;
import com.sisvuelo.aplication.model.Vuelo;
import com.sisvuelo.aplication.repository.VueloRepository;
import com.sisvuelo.aplication.service.VueloService;

import com.sisvuelo.aplication.repository.DestinoRepository;import com.sisvuelo.aplication.repository.DestinoRepository;import com.sisvuelo.aplication.repository.AerolineaRepository;
import com.sisvuelo.aplication.model.PageWrapper;

@Controller
@RequestMapping("/vuelo/")
public class VueloController {

	@Autowired
	private VueloService vueloService;
	
	@Autowired
	private VueloRepository vueloRepository;

	private String msgDeleteSucesso = "Vuelo deleted successfully !";

	private String msgDeleteError = "Vuelo an error has occurred !";

	private String msgSucessoCriacao = "Vuelo created successfully !";
	
	@Autowired private DestinoRepository origenRepository;
	@Autowired private DestinoRepository destinoRepository;
	@Autowired private AerolineaRepository aerolineaRepository;

	@GetMapping("/create")
	public ModelAndView create(Vuelo vuelo) {
		System.out.println(vuelo.getHoraAterrizaje());
		ModelAndView mv = new ModelAndView("vuelo/create");
		if (vuelo.getId() == null) {
			mv.addObject("title", "Vuelo create");
			mv.addObject("btn", "Create");
		} else {
			mv.addObject("title", "Vuelo edit");
			mv.addObject("btn", "Edit");
		}
		mv.addObject(vuelo);
	
		
		mv.addObject("origenList",origenRepository.findAll());
		mv.addObject("destinoList",destinoRepository.findAll());
		mv.addObject("aerolineaList",aerolineaRepository.findAll());

		return mv;
	}

	@PostMapping("/create")
	public ModelAndView save(@Validated Vuelo vuelo, Errors errors, RedirectAttributes attributes) {
		
		System.out.println(errors);
		System.out.println("hola");

		if (errors.hasErrors()) {
			return create(vuelo);
		}

		vueloService.save(vuelo);
		attributes.addFlashAttribute("message", msgSucessoCriacao);
		return new ModelAndView("redirect:/vuelo/create");

	}

	@GetMapping("/{code}")
	public ModelAndView edit(@PathVariable("code") Integer code) {
		Vuelo vuelo = new Vuelo();
		vuelo = vueloRepository.findById(code).get();

		return create(vuelo);

	}

	@GetMapping("/list")
	public ModelAndView search(VueloFilter vueloFilter, BindingResult result,
			@PageableDefault(size = 10) Pageable pageable, HttpServletRequest httpServletRequest) {
		System.out.println(vueloService);
		ModelAndView mv = new ModelAndView("vuelo/list");
		mv.addObject("pagina", new PageWrapper<>(vueloService.filter(vueloFilter, pageable),httpServletRequest));
        
		mv.addObject("origenList",origenRepository.findAll());mv.addObject("destinoList",destinoRepository.findAll());mv.addObject("aerolineaList",aerolineaRepository.findAll());
		return mv;
	}

	@DeleteMapping("/delete/{code}")
	public ModelAndView delete(@PathVariable("code") Integer code, RedirectAttributes attributes) {
		System.out.println(code);
		Vuelo vuelo = new Vuelo();
		vuelo.setId(code);
		try {
			vueloService.delete(vuelo);
			attributes.addFlashAttribute("message", msgDeleteSucesso);
		} catch (Exception e) {
			e.printStackTrace();
			attributes.addFlashAttribute("messageErro", msgDeleteError);
		}

		return new ModelAndView("redirect:/vuelo/list");
	}

}

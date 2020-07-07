package com.sisvuelo.aplication.controller;

import javax.servlet.http.HttpServletRequest;

import com.sisvuelo.aplication.model.*;
import com.sisvuelo.aplication.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sisvuelo.aplication.filter.VueloFilter;
import com.sisvuelo.aplication.service.VueloService;

import com.sisvuelo.aplication.repository.DestinoRepository;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RestController
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
	@Autowired private AvionRepository avionRepository;
	@Autowired private EstadoVueloRepository estadoVueloRepository;

	@GetMapping("/create")
	public ModelAndView create(Vuelo vuelo, @RequestParam (required = false) Integer aerolinea) {

		System.out.println(vuelo.getHoraAterrizaje());

		ModelAndView mv = new ModelAndView("vuelo/create");
		boolean tieneAerolinea=false;

		List<Destino> destinos= Collections.<Destino>emptyList();
		List<Avion> aviones= Collections.<Avion>emptyList();


		if(aerolinea!=null){
			 Optional<Aerolinea> aerolinaObj= aerolineaRepository.findById(aerolinea);
			 destinos=destinoRepository.findDestinoByAerolinea(aerolinaObj);
			 aviones=avionRepository.findAvionByAerolinea(aerolinaObj);
			tieneAerolinea=true;
		}

		mv.addObject(vuelo);
		mv.addObject("title", "Vuelo create");
		mv.addObject("btn", "Create");
		mv.addObject("origenList",destinos);
		mv.addObject("destinoList",destinos);
		mv.addObject("avionesList",aviones);
		mv.addObject("aerolineaList",aerolineaRepository.findAll());
		mv.addObject("estadoVueloList",estadoVueloRepository.findAll());
		mv.addObject("aerolinea",aerolinea);
		mv.addObject("tieneAerolinea",tieneAerolinea);

		return mv;
	}

	@PostMapping("/create")
	public ModelAndView save(@Validated Vuelo vuelo, Errors errors, RedirectAttributes attributes) {
		
		System.out.println(errors);
		System.out.println(vuelo);

		if (errors.hasErrors()) {
			return create(vuelo,1);
		}

		vueloService.save(vuelo);
		attributes.addFlashAttribute("message", msgSucessoCriacao);
		return new ModelAndView("redirect:/vuelo/create");

	}

	@RequestMapping(value = "/edit/{code}",  method = {RequestMethod.GET, RequestMethod.PUT})
	public ModelAndView edit(@PathVariable("code") Integer code ) {
		//@RequestParam(required = false) Integer aerolinea

		boolean tieneAerolinea=true;
		List<Destino> destinos= Collections.<Destino>emptyList();
		List<Avion> aviones= Collections.<Avion>emptyList();

		Vuelo vuelo = vueloRepository.findById(code).get();
		ModelAndView mv = new ModelAndView("vuelo/edit");
		Optional<Aerolinea> aerolinea = Optional.of(vuelo.getAerolinea());
		destinos=destinoRepository.findDestinoByAerolinea(aerolinea);
		aviones=avionRepository.findAvionByAerolinea(aerolinea);

		//Obtener destinos en base a aerolinea del vuelo o parámetro aerolinea

		mv.addObject(vuelo);
		mv.addObject("title", "Vuelo edit");
		mv.addObject("btn", "Edit");
		mv.addObject("origenList",destinos);
		mv.addObject("destinoList",destinos);
		mv.addObject("avionList",aviones);
		mv.addObject("aerolineaList",aerolineaRepository.findAll());
		mv.addObject("estadoVueloList",estadoVueloRepository.findAll());
		mv.addObject("aerolinea",aerolinea);
		mv.addObject("tieneAerolinea",tieneAerolinea);

		return mv;

	}

	@RequestMapping(value = "/{id}",  method = {RequestMethod.GET, RequestMethod.PUT})
	public Void update(@PathVariable("id") Integer id , Vuelo vuelo){
		System.out.println(id);
		System.out.println(vuelo);
		return null;
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


	@RequestMapping(value="/delete/{code}")
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

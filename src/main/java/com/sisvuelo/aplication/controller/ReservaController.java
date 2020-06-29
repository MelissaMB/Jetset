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

import com.sisvuelo.aplication.filter.ReservaFilter;
import com.sisvuelo.aplication.model.Reserva;
import com.sisvuelo.aplication.repository.ReservaRepository;
import com.sisvuelo.aplication.service.ReservaService;

import com.sisvuelo.aplication.repository.PasajeroRepository;import com.sisvuelo.aplication.repository.EstatusReservaRepository;import com.sisvuelo.aplication.repository.VueloRepository;import com.sisvuelo.aplication.repository.ClaseRepository;
import com.sisvuelo.aplication.model.PageWrapper;

@Controller
@RequestMapping("/reserva/")
public class ReservaController {

	@Autowired
	private ReservaService reservaService;
	
	@Autowired
	private ReservaRepository reservaRepository;

	private String msgDeleteSucesso = "Reserva deleted successfully !";

	private String msgDeleteError = "Reserva an error has occurred !";

	private String msgSucessoCriacao = "Reserva created successfully !";
	
	@Autowired private PasajeroRepository pasajeroRepository;@Autowired private EstatusReservaRepository estatusReservaRepository;@Autowired private VueloRepository vueloRepository;@Autowired private ClaseRepository claseRepository;

	@GetMapping("/create")
	public ModelAndView create(Reserva reserva) {
		ModelAndView mv = new ModelAndView("reserva/create");
		if (reserva.getId() == null) {
			mv.addObject("title", "Reserva create");
			mv.addObject("btn", "Create");
		} else {
			mv.addObject("title", "Reserva edit");
			mv.addObject("btn", "Edit");
		}
		mv.addObject(reserva);
	
		
		mv.addObject("pasajeroList",pasajeroRepository.findAll());mv.addObject("estatusReservaList",estatusReservaRepository.findAll());mv.addObject("vueloList",vueloRepository.findAll());mv.addObject("claseList",claseRepository.findAll());

		return mv;
	}

	@PostMapping("/create")
	public ModelAndView save(@Validated Reserva reserva, Errors errors, RedirectAttributes attributes) {

		if (errors.hasErrors()) {
			return create(reserva);
		}

		reservaService.save(reserva);
		attributes.addFlashAttribute("message", msgSucessoCriacao);
		return new ModelAndView("redirect:/reserva/create");

	}

	@GetMapping("/{code}")
	public ModelAndView edit(@PathVariable("code") Integer code) {
		Reserva reserva = new Reserva();
		reserva = reservaRepository.findById(code).get();

		return create(reserva);

	}

	@GetMapping("/list")
	public ModelAndView search(ReservaFilter reservaFilter, BindingResult result,
			@PageableDefault(size = 10) Pageable pageable, HttpServletRequest httpServletRequest) {
		System.out.println(reservaService);
		ModelAndView mv = new ModelAndView("reserva/list");
		mv.addObject("pagina", new PageWrapper<>(reservaService.filter(reservaFilter, pageable),httpServletRequest));
        
		mv.addObject("pasajeroList",pasajeroRepository.findAll());mv.addObject("estatusReservaList",estatusReservaRepository.findAll());mv.addObject("vueloList",vueloRepository.findAll());mv.addObject("claseList",claseRepository.findAll());
		return mv;
	}

	@DeleteMapping("/delete/{code}")
	public ModelAndView delete(@PathVariable("code") Integer code, RedirectAttributes attributes) {
		System.out.println(code);
		Reserva reserva = new Reserva();
		reserva.setId(code);
		try {
			reservaService.delete(reserva);
			attributes.addFlashAttribute("message", msgDeleteSucesso);
		} catch (Exception e) {
			e.printStackTrace();
			attributes.addFlashAttribute("messageErro", msgDeleteError);
		}

		return new ModelAndView("redirect:/reserva/list");
	}

}

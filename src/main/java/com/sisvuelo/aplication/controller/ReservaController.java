package com.sisvuelo.aplication.controller;

import javax.servlet.http.HttpServletRequest;

import com.sisvuelo.aplication.model.*;
import com.sisvuelo.aplication.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
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
import com.sisvuelo.aplication.service.ReservaService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

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


	@Autowired private PasajeroRepository pasajeroRepository;
	@Autowired private EstatusReservaRepository estatusReservaRepository;
	@Autowired private VueloRepository vueloRepository;
	@Autowired private ClaseRepository claseRepository;
	@Autowired private UsuarioRepository usuarioRepository;
	@Autowired private ClienteNaturalRepository clienteNaturalRepository;
	@Autowired private ClienteEmpresaRepository clienteEmpresaRepository;

	@GetMapping("/create/{vuelo}/{clase}/{usuario}")
	public String create(@PathVariable("vuelo") Integer idvuelo, @PathVariable("clase") Integer idclase, @PathVariable("usuario") Integer idusuario ) {

		System.out.println(idclase);
		System.out.println(idvuelo);
		System.out.println(idusuario);

		Optional<Vuelo> optionalVuelo =vueloRepository.findById(idvuelo);
		Vuelo vuelo = optionalVuelo.get();
		System.out.println(vuelo);

		Optional <Clase> optionalClase =claseRepository.findById(idclase);
		Clase clase = optionalClase.get();
		System.out.println(optionalClase);

		Optional <Usuario> optionalUsuario =usuarioRepository.findById(idusuario);
		Usuario usuario = optionalUsuario.get();
		System.out.println("hola");
		System.out.println(usuario);

		Optional <EstatusReserva> estatusReservaOptional =estatusReservaRepository.findById(1);
		EstatusReserva estatusReserva= estatusReservaOptional.get();
		System.out.println(estatusReserva);

		Pasajero pasajero = pasajeroRepository.findByUsuario(usuario);
		System.out.println(pasajero);


		Reserva reserva = new Reserva();
		reserva.setClase(clase);
	    reserva.setPasajero(pasajero);
		reserva.setVuelo(vuelo);
		reserva.setEstatusReserva(estatusReserva);

		reserva.setCantidad(1);
		reserva.setNumeroEquipaje(1);

		reservaService.save(reserva);

		return "redirect:/oferta/vuelo/list";

	}



	@GetMapping("/list/sinusar")
	public ModelAndView search(ReservaFilter reservaFilter, BindingResult result,
			@PageableDefault(size = 10) Pageable pageable, HttpServletRequest httpServletRequest) {
		System.out.println(reservaService);
		ModelAndView mv = new ModelAndView("reserva/list");
		mv.addObject("pagina", new PageWrapper<>(reservaService.filter(reservaFilter, pageable),httpServletRequest));
        
		mv.addObject("pasajeroList",pasajeroRepository.findAll());
		mv.addObject("estatusReservaList",estatusReservaRepository.findAll());
		mv.addObject("vueloList",vueloRepository.findAll());
		mv.addObject("claseList",claseRepository.findAll());
		return mv;
	}

	@GetMapping("/list/pasajero")
	public ModelAndView searchPasajero(ReservaFilter reservaFilter, BindingResult result,
							   @PageableDefault(size = 10) Pageable pageable, HttpServletRequest httpServletRequest) {
		System.out.println(reservaService);
		ModelAndView mv = new ModelAndView("reserva/pasajeroList");
		mv.addObject("pagina", new PageWrapper<>(reservaService.filter(reservaFilter, pageable),httpServletRequest));

		mv.addObject("pasajeroList",clienteNaturalRepository.findAll());
		mv.addObject("estatusReservaList",estatusReservaRepository.findAll());
		mv.addObject("vueloList",vueloRepository.findAll());
		mv.addObject("claseList",claseRepository.findAll());
		return mv;
	}

	@GetMapping("/list/empresa")
	public ModelAndView searchEmpresa(ReservaFilter reservaFilter, BindingResult result,
									   @PageableDefault(size = 10) Pageable pageable, HttpServletRequest httpServletRequest) {
		System.out.println(reservaService);
		ModelAndView mv = new ModelAndView("reserva/empresaList");
		mv.addObject("pagina", new PageWrapper<>(reservaService.filter(reservaFilter, pageable),httpServletRequest));
		mv.addObject("reservaList", reservaRepository.findAll());
		mv.addObject("empresaList",clienteEmpresaRepository.findAll());
		mv.addObject("estatusReservaList",estatusReservaRepository.findAll());
		mv.addObject("vueloList",vueloRepository.findAll());
		mv.addObject("claseList",claseRepository.findAll());
		return mv;
	}

	@GetMapping("/list")
	public ModelAndView MisReservaciones(Authentication auth) {

		String username = auth.getName();
		System.out.println(username);

		ModelAndView mv = new ModelAndView("reserva/misReservas");
		Usuario usuario = usuarioRepository.findByUsername(username);
	//	Optional<Usuario> usuarioOpcional = usuarioRepository.fin(12);
		//Usuario usuario =usuarioOpcional.get();

		ClienteNatural clienteNatural= clienteNaturalRepository.findByUsuario(usuario);
		ClienteEmpresa clienteEmpresa= clienteEmpresaRepository.findByUsuario(usuario);

	 	if(clienteNatural!=null){
			Pasajero pasajero = pasajeroRepository.findByUsuario(clienteNatural.getUsuario());
			mv.addObject("reservaList",reservaRepository.findByPasajero(pasajero));


	     }else {
			Pasajero pasajero = pasajeroRepository.findByUsuario(clienteEmpresa.getUsuario());
			mv.addObject("reservaList",reservaRepository.findByPasajero(pasajero));
		}


		return mv;
	}




	@RequestMapping(value="/delete/{code}")
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

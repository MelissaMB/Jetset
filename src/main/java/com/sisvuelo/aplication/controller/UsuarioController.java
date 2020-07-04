package com.sisvuelo.aplication.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.crypto.password.PasswordEncoder;
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
import java.util.Optional;

import com.sisvuelo.aplication.filter.UsuarioFilter;
import com.sisvuelo.aplication.model.Usuario;
import com.sisvuelo.aplication.repository.UsuarioRepository;
import com.sisvuelo.aplication.service.UsuarioService;

import com.sisvuelo.aplication.repository.RolRepository;
import com.sisvuelo.aplication.model.PageWrapper;

@Controller
@RequestMapping("/usuario/")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

    @Autowired
	PasswordEncoder passwordEncoder;





	private String msgDeleteSucesso = "Usuario deleted successfully !";

	private String msgDeleteError = "Usuario an error has occurred !";

	private String msgSucessoCriacao = "Usuario created successfully !";
	
	@Autowired private RolRepository rolRepository;

	@GetMapping("/create")
	public ModelAndView create(Usuario usuario) {


		ModelAndView mv = new ModelAndView("usuario/create");
		if (usuario.getId() == null) {
			mv.addObject("title", "Usuario create");
			mv.addObject("btn", "Create");
		} else {
			mv.addObject("title", "Usuario edit");
			mv.addObject("btn", "Edit");
		}
		mv.addObject(usuario);
	
		
		mv.addObject("rolList",rolRepository.findAll());

		return mv;
	}

	@PostMapping("/create")
	public ModelAndView save(@Validated Usuario usuario, Errors errors, RedirectAttributes attributes) {

		if (errors.hasErrors()) {
			return create(usuario);
		}
        System.out.println(usuario);
        String password = usuario.getPassword();
        String encriptado = passwordEncoder.encode(password);
        usuario.setPassword(encriptado);
		usuarioService.save(usuario);
		attributes.addFlashAttribute("message", msgSucessoCriacao);
		return new ModelAndView("redirect:/usuario/create");

	}

	@GetMapping("/{code}")
	public ModelAndView edit(@PathVariable("code") Integer code) {
		Usuario usuario = new Usuario();
		usuario = usuarioRepository.findById(code).get();
		return create(usuario);

	}

	@GetMapping("/list")
	public ModelAndView search(UsuarioFilter usuarioFilter, BindingResult result,
			@PageableDefault(size = 10) Pageable pageable, HttpServletRequest httpServletRequest) {
		System.out.println(usuarioService);
		ModelAndView mv = new ModelAndView("usuario/list");
		mv.addObject("pagina", new PageWrapper<>(usuarioService.filter(usuarioFilter, pageable),httpServletRequest));
        
		mv.addObject("rolList",rolRepository.findAll());
		return mv;
	}


    @RequestMapping(value="/delete/{code}")
	public ModelAndView delete(@PathVariable("code") Integer code, RedirectAttributes attributes) {
		System.out.println(code);
		Usuario usuario = new Usuario();
		usuario.setId(code);
		try {
			usuarioService.delete(usuario);
			attributes.addFlashAttribute("message", msgDeleteSucesso);
		} catch (Exception e) {
			e.printStackTrace();
			attributes.addFlashAttribute("messageErro", msgDeleteError);
		}

		return new ModelAndView("redirect:/usuario/list");
	}

}

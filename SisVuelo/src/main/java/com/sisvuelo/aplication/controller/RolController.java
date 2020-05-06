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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sisvuelo.aplication.filter.RolFilter;
import com.sisvuelo.aplication.model.Rol;
import com.sisvuelo.aplication.repository.RolRepository;
import com.sisvuelo.aplication.service.RolService;


import com.sisvuelo.aplication.model.PageWrapper;

@Controller
@RequestMapping("/rol/")
public class RolController {

	@Autowired
	private RolService rolService;
	
	@Autowired
	private RolRepository rolRepository;

	private String msgDeleteSucesso = "Rol deleted successfully !";

	private String msgDeleteError = "Rol an error has occurred !";

	private String msgSucessoCriacao = "Rol created successfully !";
	
	

	@GetMapping("/create")
	public ModelAndView create(Rol rol) {
		ModelAndView mv = new ModelAndView("rol/create");
		if (rol.getId() == null) {
			mv.addObject("title", "Rol create");
			mv.addObject("btn", "Create");
		} else {
			mv.addObject("title", "Rol edit");
			mv.addObject("btn", "Edit");
		}
		mv.addObject(rol);
	
		
		

		return mv;
	}

	@PostMapping("/create")
	public ModelAndView save(@Validated Rol rol, Errors errors, RedirectAttributes attributes) {

		if (errors.hasErrors()) {
			return create(rol);
		}

		rolService.save(rol);
		attributes.addFlashAttribute("message", msgSucessoCriacao);
		return new ModelAndView("redirect:/rol/create");

	}

  @GetMapping("/{code}")
	public ModelAndView edit(@PathVariable("code") Integer code) {
		Rol rol = new Rol();
		rol = rolRepository.findById(code).get();

		return create(rol);

	}

	@GetMapping("/list")
	public ModelAndView search(RolFilter rolFilter, BindingResult result,
			@PageableDefault(size = 10) Pageable pageable, HttpServletRequest httpServletRequest) {
		System.out.println(rolService);
		ModelAndView mv = new ModelAndView("rol/list");
		mv.addObject("pagina", new PageWrapper<>(rolService.filter(rolFilter, pageable),httpServletRequest));
        
		
		return mv;
	}

	@DeleteMapping(value="/delete/{code}")
	public ModelAndView delete(@PathVariable("code") Integer code, RedirectAttributes attributes) {
		System.out.println(code);
		Rol rol = new Rol();
		rol.setId(code);
		try {
			rolService.delete(rol);
			attributes.addFlashAttribute("message", msgDeleteSucesso);
		} catch (Exception e) {
			e.printStackTrace();
			attributes.addFlashAttribute("messageErro", msgDeleteError);
		}

		return new ModelAndView("redirect:/rol/list");
	}

}

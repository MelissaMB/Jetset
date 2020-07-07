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

import com.sisvuelo.aplication.filter.ModeloFilter;
import com.sisvuelo.aplication.model.Modelo;
import com.sisvuelo.aplication.repository.ModeloRepository;
import com.sisvuelo.aplication.service.ModeloService;

import com.sisvuelo.aplication.repository.MarcaRepository;
import com.sisvuelo.aplication.model.PageWrapper;

@Controller
@RequestMapping("/modelo/")
public class ModeloController {

	@Autowired
	private ModeloService modeloService;
	
	@Autowired
	private ModeloRepository modeloRepository;

	private String msgDeleteSucesso = "Modelo deleted successfully !";

	private String msgDeleteError = "Modelo an error has occurred !";

	private String msgSucessoCriacao = "Modelo created successfully !";
	
	@Autowired private MarcaRepository marcaRepository;

	@GetMapping("/create")
	public ModelAndView create(Modelo modelo) {
		ModelAndView mv = new ModelAndView("modelo/create");
		if (modelo.getId() == null) {
			mv.addObject("title", "Modelo create");
			mv.addObject("btn", "Create");
		} else {
			mv.addObject("title", "Modelo edit");
			mv.addObject("btn", "Edit");
		}
		mv.addObject(modelo);
	
		
		mv.addObject("marcaList",marcaRepository.findAll());

		return mv;
	}

	@PostMapping("/create")
	public ModelAndView save(@Validated Modelo modelo, Errors errors, RedirectAttributes attributes) {

		if (errors.hasErrors()) {
			return create(modelo);
		}

		modeloService.save(modelo);
		attributes.addFlashAttribute("message", msgSucessoCriacao);
		return new ModelAndView("redirect:/modelo/create");

	}

	@GetMapping("/{code}")
	public ModelAndView edit(@PathVariable("code") Integer code) {
		Modelo modelo = new Modelo();
		modelo = modeloRepository.findById(code).get();
		return create(modelo);

	}


	@GetMapping("/list")
	public ModelAndView search(ModeloFilter modeloFilter, BindingResult result,
			@PageableDefault(size = 10) Pageable pageable, HttpServletRequest httpServletRequest) {
		System.out.println(modeloService);
		ModelAndView mv = new ModelAndView("modelo/list");
		mv.addObject("pagina", new PageWrapper<>(modeloService.filter(modeloFilter, pageable),httpServletRequest));
        
		mv.addObject("marcaList",marcaRepository.findAll());
		return mv;
	}

	@RequestMapping(value="/delete/{code}")
	public ModelAndView delete(@PathVariable("code") Integer code, RedirectAttributes attributes) {
		System.out.println(code);
		Modelo modelo = new Modelo();
		modelo.setId(code);
		try {
			modeloService.delete(modelo);
			attributes.addFlashAttribute("message", msgDeleteSucesso);
		} catch (Exception e) {
			e.printStackTrace();
			attributes.addFlashAttribute("messageErro", msgDeleteError);
		}

		return new ModelAndView("redirect:/modelo/list");
	}

}

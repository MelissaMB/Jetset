package com.sisvuelo.aplication.controller;

import com.sisvuelo.aplication.model.ClienteEmpresa;
import com.sisvuelo.aplication.model.ClienteNatural;
import com.sisvuelo.aplication.repository.ClienteEmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@RequestMapping("/cliente/empresa")
public class ClienteEmpresaController {

    @Autowired
    private ClienteEmpresaRepository clienteEmpresaRepository;
    private String msgSucessCreate= "Pasajero empresa creado con éxito";


  @GetMapping("/create")
    public ModelAndView create(ClienteEmpresa clienteEmpresa) {
        ModelAndView mv = new ModelAndView("clienteEmpresa/create");
        mv.addObject(clienteEmpresa);
        mv.addObject("title", "Registro Empresa");
        mv.addObject("btn", "Save");

      return mv;

    }
    @PostMapping("/create")
    public ModelAndView save(@Validated ClienteEmpresa clienteEmpresa, Errors errors, RedirectAttributes attributes){
      if(errors.hasErrors()){
          return create(clienteEmpresa);
      }
      clienteEmpresaRepository.save(clienteEmpresa);
      attributes.addFlashAttribute("message",msgSucessCreate );
      return new ModelAndView("redirect:/cliente/empresa/create");
    }
}

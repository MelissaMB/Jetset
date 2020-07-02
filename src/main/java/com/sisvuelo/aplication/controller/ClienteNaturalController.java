package com.sisvuelo.aplication.controller;


import com.sisvuelo.aplication.model.ClienteNatural;
import com.sisvuelo.aplication.model.Rol;
import com.sisvuelo.aplication.model.Usuario;
import com.sisvuelo.aplication.repository.*;
import com.sisvuelo.aplication.service.RegistroUsuarioService;
import com.sisvuelo.aplication.service.RolService;
import com.sisvuelo.aplication.service.email.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@RestController
@RequestMapping("/cliente/natural")
public class ClienteNaturalController {

    @Autowired
    ClienteNaturalRepository clienteNaturalRepository;
    @Autowired
    TipoDocumentoRepository tipoDocumentoRepository;
    @Autowired
    GeneroRepository generoRepository;
    @Autowired
    EstadoCivilRepository estadoCivilRepository;

    @Autowired
    RolRepository rolRepository;

    @Autowired
    MailService mailService;
    @Autowired
    RegistroUsuarioService registroUsuarioService;
    @Autowired
    RolService rolService;

    private Rol rol;

    private String msgSucessCreate= "Pasajero creado con éxito. Se ha enviado un correo electronico con sus credenciales.";

   @GetMapping("/create")
    public ModelAndView create(ClienteNatural clienteNatural) {
        ModelAndView mv = new ModelAndView("clienteNatural/create");
        mv.addObject(clienteNatural);
        mv.addObject("tipoDocumentList",tipoDocumentoRepository.findAll());
        mv.addObject("generoList", generoRepository.findAll());
        mv.addObject("estadoCivilList", estadoCivilRepository.findAll());
        mv.addObject("title", "Registro Pasajero");
        mv.addObject("btn", "Save");
        return mv;

    }
    @PostMapping("/create")
    public ModelAndView save(@Validated ClienteNatural clienteNatural, Errors errors, RedirectAttributes attributes){

       Rol rol = new Rol();
       rol = rolRepository.findById(1).get();
       String from = clienteNatural.getEmail();
       String to = "vuelo@jetset.com";
       String subject = "Creación de usuario" + clienteNatural.getPrimerNombre()+ " "+clienteNatural.getPrimerApellido();
       String body = "\n\nSu usuario es: "+ clienteNatural.getEmail()+"\nPassword temporal: Jetset$";


       if(errors.hasErrors()){
           return create(clienteNatural);
       }

       mailService.sendMail(from, to, subject, body);
       Usuario usuario=registroUsuarioService.RegistrarUsuario(from,rol);
       clienteNatural.setUsuario(usuario);
       clienteNaturalRepository.save(clienteNatural);
       attributes.addFlashAttribute("message", msgSucessCreate);
       return new ModelAndView("redirect:/cliente/natural/create");
    }

}

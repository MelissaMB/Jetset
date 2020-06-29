package com.sisvuelo.aplication.controller;

import com.sisvuelo.aplication.model.ClienteEmpresa;
import com.sisvuelo.aplication.model.ClienteNatural;
import com.sisvuelo.aplication.model.Rol;
import com.sisvuelo.aplication.model.Usuario;
import com.sisvuelo.aplication.repository.ClienteEmpresaRepository;
import com.sisvuelo.aplication.repository.RolRepository;
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

@RestController
@RequestMapping("/cliente/empresa")
public class ClienteEmpresaController {

    @Autowired
    ClienteEmpresaRepository clienteEmpresaRepository;
    @Autowired
    MailService mailService;
    @Autowired
    RegistroUsuarioService registroUsuarioService;
    @Autowired
    RolRepository rolRepository;
    @Autowired
    RolService rolService;

    private String msgSucessCreate= "Pasajero empresa creado con éxito.Se ha enviado a la cuenta de correo electronico sus credenciales";


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
        Rol rol = new Rol();
        rol = rolRepository.findById(3).get();
        String from = clienteEmpresa.getEmail();
        String to = "vuelo@jetset.com";
        String subject = "Creación de usuario" + clienteEmpresa.getNombreEmpresa();
        String body = "\n\nSu usuario es: "+ clienteEmpresa.getEmail()+"\nPassword temporal: Jetset$";

        if(errors.hasErrors()){
          return create(clienteEmpresa);
      }

        mailService.sendMail(from, to, subject, body);
        Usuario usuario=  registroUsuarioService.RegistrarUsuario(from,rol);
        clienteEmpresa.setUsuario(usuario);
        clienteEmpresaRepository.save(clienteEmpresa);
        attributes.addFlashAttribute("message",msgSucessCreate );
        return new ModelAndView("redirect:/cliente/empresa/create");
    }
}

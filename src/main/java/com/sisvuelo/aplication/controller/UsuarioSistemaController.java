package com.sisvuelo.aplication.controller;

import com.sisvuelo.aplication.filter.AeropuertoFilter;
import com.sisvuelo.aplication.filter.UsuarioSistemaFilter;
import com.sisvuelo.aplication.model.*;
import com.sisvuelo.aplication.repository.*;
import com.sisvuelo.aplication.service.AeropuertoService;
import com.sisvuelo.aplication.service.UsuarioSistemaService;
import com.sisvuelo.aplication.service.email.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/usuario/sistema/")
public class UsuarioSistemaController {
    @Autowired
    private UsuarioSistemaService usuarioSistemaService;
    @Autowired
    private UsuarioSistemaRepository usuarioSistemaRepository;
    @Autowired
    private RolRepository rolRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    MailService mailService;

    private String msgDeleteSucesso = "Registro deleted successfully !";

    private String msgDeleteError = "Registro an error has occurred !";

    private String msgSucessoCriacao = "Su solicitud de acceso al sistema ha sido ingresada. Espere su aprobación por correo eléctronico !";


    @GetMapping("/create")
    public ModelAndView create(UsuarioSistema usuarioSistema) {
        ModelAndView mv = new ModelAndView("usuarioSistema/create");
        if (usuarioSistema.getId() == null) {
            mv.addObject("title", "Solicitud de acceso al sistema");
            mv.addObject("btn", "Send");
        } else {
            mv.addObject("title", "Registro edit");
            mv.addObject("btn", "Edit");
        }
        mv.addObject(usuarioSistema);


        mv.addObject("usuarioList", usuarioSistemaRepository.findAll());

        return mv;
    }

    @PostMapping("/create")
    public ModelAndView save(@Validated UsuarioSistema usuarioSistema, Errors errors, RedirectAttributes attributes) {
        System.out.println(usuarioSistema);
        String emailAdmin = "sysmteadmin@jetset.com.sv";
        String subject = "Solicitud de acceso";
        String body = "Se ha registrado una solicitud de acceso nueva  \n"
                     + "Solicitante: "+ usuarioSistema.getPrimerNombre() + " " + usuarioSistema.getSegundoApellido();
        if (errors.hasErrors()) {
            return create(usuarioSistema);
        }

        mailService.sendMail(usuarioSistema.getEmail(), emailAdmin, subject, body);
        usuarioSistemaService.save(usuarioSistema);
        attributes.addFlashAttribute("message", msgSucessoCriacao);
        return new ModelAndView("redirect:/usuario/sistema/create");

    }

    @GetMapping("/{code}")
    public ModelAndView edit(@PathVariable("code") Integer code) {
        UsuarioSistema usuarioSistema = new UsuarioSistema();
        usuarioSistema = usuarioSistemaRepository.findById(code).get();

        return create(usuarioSistema);

    }

    @GetMapping("/list")
    public ModelAndView search(UsuarioSistemaFilter usuarioSistemaFilter, BindingResult result,
                               @PageableDefault(size = 10) Pageable pageable, HttpServletRequest httpServletRequest) {
        System.out.println(usuarioSistemaService);
        ModelAndView mv = new ModelAndView("usuarioSistema/list");
        mv.addObject("pagina", new PageWrapper<>(usuarioSistemaService.filter(usuarioSistemaFilter, pageable), httpServletRequest));

        mv.addObject("usuarioList", usuarioRepository.findAll());
        return mv;
    }

    @RequestMapping(value = "/delete/{code}")
    public ModelAndView delete(@PathVariable("code") Integer code, RedirectAttributes attributes) {
        System.out.println(code);
        UsuarioSistema usuarioSistema = new UsuarioSistema();
        usuarioSistema.setId(code);
        try {
            usuarioSistemaService.delete(usuarioSistema);
            attributes.addFlashAttribute("message", msgDeleteSucesso);
        } catch (Exception e) {
            e.printStackTrace();
            attributes.addFlashAttribute("messageErro", msgDeleteError);
        }

        return new ModelAndView("redirect:/usuario/sistema/list");
    }

}

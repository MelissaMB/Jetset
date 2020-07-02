package com.sisvuelo.aplication.controller;

import com.sisvuelo.aplication.filter.UsuarioFilter;
import com.sisvuelo.aplication.filter.ViewOfertaVueloFilter;
import com.sisvuelo.aplication.model.PageWrapper;
import com.sisvuelo.aplication.model.ViewOfertaVuelo;
import com.sisvuelo.aplication.repository.ViewOfertaVueloRepository;
import com.sisvuelo.aplication.service.ViewOfertaVueloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("oferta/vuelo")
public class ViewOfertaVueloController {


    @Autowired
    ViewOfertaVueloRepository viewOfertaVueloRepository;
    @Autowired
    ViewOfertaVueloService viewOfertaVueloService;

    @GetMapping("/list")
    public ModelAndView search(ViewOfertaVueloFilter viewOfertaVueloFilter, BindingResult result,
                               @PageableDefault(size = 10) Pageable pageable, HttpServletRequest httpServletRequest) {
        System.out.println(viewOfertaVueloService);
        ModelAndView mv = new ModelAndView("viewOfertaVuelo/list");
        mv.addObject("pagina", new PageWrapper<>(viewOfertaVueloService.filter(viewOfertaVueloFilter, pageable), httpServletRequest));

        return mv;
    }

}

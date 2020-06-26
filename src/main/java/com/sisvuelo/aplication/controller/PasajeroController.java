package com.sisvuelo.aplication.controller;

import com.sisvuelo.aplication.model.ClienteEmpresa;
import com.sisvuelo.aplication.model.ClienteNatural;
import com.sisvuelo.aplication.model.Pasajero;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/pasajero")
public class PasajeroController {

    private String msgSucessCreate= "Pasajero creado con éxito";



    @GetMapping("/create")
    public ModelAndView create(Pasajero pasajero) {
        ModelAndView mv = new ModelAndView("pasajero/create");
        mv.addObject(pasajero);
        mv.addObject("title", "Creación pasajero");

        return mv;

    }



}

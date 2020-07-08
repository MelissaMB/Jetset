package com.sisvuelo.aplication.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GenerarUsuarioService {

    public String GenerarUsuario(String primerNombre, String primerApellido) {

        Random random = new Random();

        char letraNombre = primerNombre.charAt(0);
        char letraApellido = primerApellido.charAt(0);
        int digitos = (int) (100000 * Math.random());
        String letras =Character.toString(letraNombre).concat(Character.toString(letraApellido));
        String usuario = letras.concat(Integer.toString(digitos));


        return usuario;


    }


}

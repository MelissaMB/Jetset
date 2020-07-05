package com.sisvuelo.aplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class LoginController {


    @GetMapping("/login")
    public String login(){

        return"login/login";
    }

    @GetMapping("/logout")
    public RedirectView logout(){

        return new RedirectView("/login");
    }

   /* @GetMapping("/forgot/password")
    public String forgotPassword(){

        return ""
    }*/
}

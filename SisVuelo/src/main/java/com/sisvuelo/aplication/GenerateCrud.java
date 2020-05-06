package com.sisvuelo.aplication;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class GenerateCrud {

	 @RequestMapping("/") 
	 public ModelAndView  home() {
         
			ModelAndView mv = new ModelAndView("layout/index");
	     
	        return mv;
	    }
}

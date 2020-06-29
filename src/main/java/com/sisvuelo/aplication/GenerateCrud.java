package com.sisvuelo.aplication;

import com.sisvuelo.aplication.model.ClienteNatural;
import com.sisvuelo.aplication.model.Pasajero;
import com.sisvuelo.aplication.model.Usuario;
import com.sisvuelo.aplication.repository.ClienteNaturalRepository;
import com.sisvuelo.aplication.repository.PasajeroRepository;
import com.sisvuelo.aplication.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RestController
public class GenerateCrud {


	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	PasajeroRepository pasajeroRepository;

	@Autowired
	ClienteNaturalRepository clienteNaturalRepository;


	 @RequestMapping("/") 
	 public ModelAndView  home(Authentication auth, HttpSession session) {
	 	    String username = auth.getName();
		 if(session.getAttribute("username")==null){
			 Usuario usuario = usuarioRepository.findByUsername(username);
			 ClienteNatural clienteNatural= clienteNaturalRepository.findByUsuario(usuario);
			 usuario.setPassword(null);
			 session.setAttribute("usuario",usuario);

		 }



		 for(GrantedAuthority rol: auth.getAuthorities()){
	 	    	System.out.println("Rol:"+ rol.getAuthority());
			}
			ModelAndView mv = new ModelAndView("layout/index");

	        return mv;
	    }
}

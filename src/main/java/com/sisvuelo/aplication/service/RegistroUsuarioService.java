package com.sisvuelo.aplication.service;

import com.sisvuelo.aplication.model.Rol;
import com.sisvuelo.aplication.model.Usuario;
import com.sisvuelo.aplication.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;

@Service
public class RegistroUsuarioService {


     @Autowired
     UsuarioRepository usuarioRepository;
     @Autowired
     PasswordEncoder passwordEncoder;

     @Transactional
     public Usuario RegistrarUsuario(String email, Rol rol){
         Usuario usuario= new Usuario();
         usuario.setUsername(email);
         usuario.setRol(rol);
         usuario.setPassword(passwordEncoder.encode("jetset2020"));
         usuario.setEstado(1);
         usuarioRepository.save(usuario);

         return usuario;
     }


}

package com.sisvuelo.aplication.repository.helper;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sisvuelo.aplication.filter.UsuarioFilter;
import com.sisvuelo.aplication.model.Usuario;



public interface UsuarioHelper {

	public Page<Usuario> filtrar(UsuarioFilter usuarioFilter, Pageable pageable);

}

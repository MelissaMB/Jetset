package com.sisvuelo.aplication.service;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sisvuelo.aplication.model.Usuario;
import com.sisvuelo.aplication.repository.UsuarioRepository;
import com.sisvuelo.aplication.filter.UsuarioFilter;

@Service
public class UsuarioService {

	private String errorDelete = "this record is related to other tables.";

    @Autowired
	private UsuarioRepository usuarioRepository;

	@Transactional
	public void save(Usuario usuario) {
		usuarioRepository.save(usuario);
	}
	
	public Page<Usuario> filter(UsuarioFilter usuarioFilter, Pageable pageable) {
		return usuarioRepository.filtrar(usuarioFilter, pageable);
	}

	@Transactional
	public void delete(Usuario usuario) {
		try {
			usuarioRepository.delete(usuario);
		} catch (Exception e) {
			if (e instanceof org.hibernate.exception.ConstraintViolationException
					|| e instanceof DataIntegrityViolationException) {
				throw new IllegalArgumentException(errorDelete);
			}
			throw e;
		}

	}

}

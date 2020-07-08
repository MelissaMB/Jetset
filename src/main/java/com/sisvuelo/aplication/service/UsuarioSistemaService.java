package com.sisvuelo.aplication.service;


import com.sisvuelo.aplication.filter.AeropuertoFilter;
import com.sisvuelo.aplication.filter.UsuarioSistemaFilter;
import com.sisvuelo.aplication.model.Aeropuerto;
import com.sisvuelo.aplication.model.UsuarioSistema;
import com.sisvuelo.aplication.repository.AeropuertoRepository;
import com.sisvuelo.aplication.repository.UsuarioSistemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UsuarioSistemaService {
    private String errorDelete = "this record is related to other tables.";

    @Autowired
    private UsuarioSistemaRepository usuarioSistemaRepository;

    @Transactional
    public void save(UsuarioSistema usuarioSistema) {
        usuarioSistemaRepository.save(usuarioSistema);
    }

    public Page<UsuarioSistema> filter(UsuarioSistemaFilter usuarioSistemaFilter, Pageable pageable) {
        return usuarioSistemaRepository.filtrar(usuarioSistemaFilter, pageable);
    }

    @Transactional
    public void delete(UsuarioSistema usuarioSistema) {
        try {
            usuarioSistemaRepository.delete(usuarioSistema);
        } catch (Exception e) {
            if (e instanceof org.hibernate.exception.ConstraintViolationException
                    || e instanceof DataIntegrityViolationException) {
                throw new IllegalArgumentException(errorDelete);
            }
            throw e;
        }

    }

}
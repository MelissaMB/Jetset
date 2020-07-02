package com.sisvuelo.aplication.service;

import com.sisvuelo.aplication.filter.UsuarioFilter;
import com.sisvuelo.aplication.filter.ViewOfertaVueloFilter;
import com.sisvuelo.aplication.model.Usuario;
import com.sisvuelo.aplication.model.ViewOfertaVuelo;
import com.sisvuelo.aplication.repository.ViewOfertaVueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ViewOfertaVueloService {

    @Autowired
    private ViewOfertaVueloRepository viewOfertaVueloRepository;

    public Page<ViewOfertaVuelo> filter(ViewOfertaVueloFilter viewOfertaVueloFilter, Pageable pageable) {
        return viewOfertaVueloRepository.filtrar(viewOfertaVueloFilter, pageable);
    }
}

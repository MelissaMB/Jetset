package com.sisvuelo.aplication.service;

import com.sisvuelo.aplication.filter.UsuarioFilter;
import com.sisvuelo.aplication.filter.View_itinerarioFilter;
import com.sisvuelo.aplication.model.Usuario;
import com.sisvuelo.aplication.model.View_itinerario;
import com.sisvuelo.aplication.repository.View_itinerarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class View_itinerarioService {

    @Autowired
    private View_itinerarioRepository viewOfertaVueloRepository;

    public Page<View_itinerario> filter(View_itinerarioFilter viewitinerarioFilter, Pageable pageable) {
        return View_itinerarioRepository.filtrar(viewitinerarioFilter, pageable);
    }
}

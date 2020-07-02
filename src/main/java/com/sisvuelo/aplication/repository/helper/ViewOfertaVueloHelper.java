package com.sisvuelo.aplication.repository.helper;

import com.sisvuelo.aplication.filter.AerolineaFilter;
import com.sisvuelo.aplication.filter.ViewOfertaVueloFilter;
import com.sisvuelo.aplication.model.Aerolinea;
import com.sisvuelo.aplication.model.ViewOfertaVuelo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ViewOfertaVueloHelper {

    public Page<ViewOfertaVuelo> filtrar(ViewOfertaVueloFilter viewOfertaVueloFilter, Pageable pageable);

}

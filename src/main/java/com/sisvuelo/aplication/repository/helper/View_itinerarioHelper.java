package com.sisvuelo.aplication.repository.helper;

import com.sisvuelo.aplication.filter.AerolineaFilter;
import com.sisvuelo.aplication.filter.View_itinerarioFilter;
import com.sisvuelo.aplication.model.Aerolinea;
import com.sisvuelo.aplication.model.View_itinerario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface View_itinerarioHelper {

    public Page<View_itinerario> filtrar(View_itinerarioFilter viewitinerarioFilter, Pageable pageable);

}

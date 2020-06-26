package com.sisvuelo.aplication.repository.helper;

import com.sisvuelo.aplication.filter.PasajeroFilter;
import com.sisvuelo.aplication.model.Pasajero;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PasajeroHelper {
    public Page<Pasajero> filtrar(PasajeroFilter pasajeroFilter, Pageable pageable);
}

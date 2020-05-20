package com.sisvuelo.aplication.repository.helper;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sisvuelo.aplication.filter.AerolineaFilter;
import com.sisvuelo.aplication.model.Aerolinea;



public interface AerolineaHelper {

	public Page<Aerolinea> filtrar(AerolineaFilter aerolineaFilter, Pageable pageable);

}

package com.sisvuelo.aplication.repository.helper;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sisvuelo.aplication.filter.DestinoFilter;
import com.sisvuelo.aplication.model.Destino;



public interface DestinoHelper {

	public Page<Destino> filtrar(DestinoFilter destinoFilter, Pageable pageable);

}

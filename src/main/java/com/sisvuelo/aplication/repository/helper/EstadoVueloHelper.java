package com.sisvuelo.aplication.repository.helper;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sisvuelo.aplication.filter.EstadoVueloFilter;
import com.sisvuelo.aplication.model.EstadoVuelo;



public interface EstadoVueloHelper {

	public Page<EstadoVuelo> filtrar(EstadoVueloFilter estadoVueloFilter, Pageable pageable);

}

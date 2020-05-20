package com.sisvuelo.aplication.repository.helper;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sisvuelo.aplication.filter.PaisFilter;
import com.sisvuelo.aplication.model.Pais;



public interface PaisHelper {

	public Page<Pais> filtrar(PaisFilter paisFilter, Pageable pageable);

}

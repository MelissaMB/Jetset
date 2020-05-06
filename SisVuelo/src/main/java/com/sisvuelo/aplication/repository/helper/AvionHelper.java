package com.sisvuelo.aplication.repository.helper;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sisvuelo.aplication.filter.AvionFilter;
import com.sisvuelo.aplication.model.Avion;



public interface AvionHelper {

	public Page<Avion> filtrar(AvionFilter avionFilter, Pageable pageable);

}

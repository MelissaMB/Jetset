package com.sisvuelo.aplication.repository.helper;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sisvuelo.aplication.filter.AeropuertoFilter;
import com.sisvuelo.aplication.model.Aeropuerto;



public interface AeropuertoHelper {

	public Page<Aeropuerto> filtrar(AeropuertoFilter aeropuertoFilter, Pageable pageable);

}

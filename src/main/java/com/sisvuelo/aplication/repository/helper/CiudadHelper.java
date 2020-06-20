package com.sisvuelo.aplication.repository.helper;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sisvuelo.aplication.filter.CiudadFilter;
import com.sisvuelo.aplication.model.Ciudad;



public interface CiudadHelper {

	public Page<Ciudad> filtrar(CiudadFilter ciudadFilter, Pageable pageable);

}

package com.sisvuelo.aplication.repository.helper;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sisvuelo.aplication.filter.ClaseFilter;
import com.sisvuelo.aplication.model.Clase;



public interface ClaseHelper {

	public Page<Clase> filtrar(ClaseFilter claseFilter, Pageable pageable);

}

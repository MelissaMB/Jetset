package com.sisvuelo.aplication.repository.helper;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sisvuelo.aplication.filter.ModeloFilter;
import com.sisvuelo.aplication.model.Modelo;



public interface ModeloHelper {

	public Page<Modelo> filtrar(ModeloFilter modeloFilter, Pageable pageable);

}

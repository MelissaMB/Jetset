package com.sisvuelo.aplication.repository.helper;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sisvuelo.aplication.filter.VueloFilter;
import com.sisvuelo.aplication.model.Vuelo;



public interface VueloHelper {

	public Page<Vuelo> filtrar(VueloFilter vueloFilter, Pageable pageable);

}

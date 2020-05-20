package com.sisvuelo.aplication.repository.helper;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sisvuelo.aplication.filter.MarcaFilter;
import com.sisvuelo.aplication.model.Marca;



public interface MarcaHelper {

	public Page<Marca> filtrar(MarcaFilter marcaFilter, Pageable pageable);

}

package com.sisvuelo.aplication.repository.helper;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sisvuelo.aplication.filter.PrecioFilter;
import com.sisvuelo.aplication.model.Precio;



public interface PrecioHelper {

	public Page<Precio> filtrar(PrecioFilter precioFilter, Pageable pageable);

}

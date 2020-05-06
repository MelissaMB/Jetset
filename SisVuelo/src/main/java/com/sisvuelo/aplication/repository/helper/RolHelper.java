package com.sisvuelo.aplication.repository.helper;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sisvuelo.aplication.filter.RolFilter;
import com.sisvuelo.aplication.model.Rol;



public interface RolHelper {

	public Page<Rol> filtrar(RolFilter rolFilter, Pageable pageable);

}

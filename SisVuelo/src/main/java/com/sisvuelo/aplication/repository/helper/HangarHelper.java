package com.sisvuelo.aplication.repository.helper;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sisvuelo.aplication.filter.HangarFilter;
import com.sisvuelo.aplication.model.Hangar;



public interface HangarHelper {

	public Page<Hangar> filtrar(HangarFilter hangarFilter, Pageable pageable);

}

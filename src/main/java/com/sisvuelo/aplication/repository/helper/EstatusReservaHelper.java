package com.sisvuelo.aplication.repository.helper;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sisvuelo.aplication.filter.EstatusReservaFilter;
import com.sisvuelo.aplication.model.EstatusReserva;



public interface EstatusReservaHelper {

	public Page<EstatusReserva> filtrar(EstatusReservaFilter estatusReservaFilter, Pageable pageable);

}

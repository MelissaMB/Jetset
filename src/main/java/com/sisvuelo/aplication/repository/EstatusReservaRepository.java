package com.sisvuelo.aplication.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sisvuelo.aplication.model.EstatusReserva;
import com.sisvuelo.aplication.repository.helper.EstatusReservaHelper;



@Repository
public interface EstatusReservaRepository extends JpaRepository<EstatusReserva, Integer>,EstatusReservaHelper {

	

}


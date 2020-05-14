package com.sisvuelo.aplication.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sisvuelo.aplication.model.Aerolinea;
import com.sisvuelo.aplication.repository.helper.AerolineaHelper;



@Repository
public interface AerolineaRepository extends JpaRepository<Aerolinea, Integer>,AerolineaHelper {

	

}


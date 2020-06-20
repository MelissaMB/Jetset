package com.sisvuelo.aplication.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sisvuelo.aplication.model.Aeropuerto;
import com.sisvuelo.aplication.repository.helper.AeropuertoHelper;



@Repository
public interface AeropuertoRepository extends JpaRepository<Aeropuerto, Integer>,AeropuertoHelper {

	

}


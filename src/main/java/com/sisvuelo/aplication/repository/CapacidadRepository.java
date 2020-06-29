package com.sisvuelo.aplication.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sisvuelo.aplication.model.Capacidad;
import com.sisvuelo.aplication.repository.helper.CapacidadHelper;



@Repository
public interface CapacidadRepository extends JpaRepository<Capacidad, Integer>,CapacidadHelper {

	

}


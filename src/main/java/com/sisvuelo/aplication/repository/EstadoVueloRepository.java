package com.sisvuelo.aplication.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sisvuelo.aplication.model.EstadoVuelo;
import com.sisvuelo.aplication.repository.helper.EstadoVueloHelper;



@Repository
public interface EstadoVueloRepository extends JpaRepository<EstadoVuelo, Integer>,EstadoVueloHelper {

	

}


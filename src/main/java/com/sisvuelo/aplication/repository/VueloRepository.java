package com.sisvuelo.aplication.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sisvuelo.aplication.model.Vuelo;
import com.sisvuelo.aplication.repository.helper.VueloHelper;



@Repository
public interface VueloRepository extends JpaRepository<Vuelo, Integer>,VueloHelper {

	

}


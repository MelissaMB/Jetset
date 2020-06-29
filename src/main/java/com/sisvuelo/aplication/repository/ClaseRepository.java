package com.sisvuelo.aplication.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sisvuelo.aplication.model.Clase;
import com.sisvuelo.aplication.repository.helper.ClaseHelper;



@Repository
public interface ClaseRepository extends JpaRepository<Clase, Integer>,ClaseHelper {

	

}


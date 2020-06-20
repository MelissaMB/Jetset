package com.sisvuelo.aplication.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sisvuelo.aplication.model.Pais;
import com.sisvuelo.aplication.repository.helper.PaisHelper;



@Repository
public interface PaisRepository extends JpaRepository<Pais, Integer>,PaisHelper {

	

}


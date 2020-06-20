package com.sisvuelo.aplication.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sisvuelo.aplication.model.Ciudad;
import com.sisvuelo.aplication.repository.helper.CiudadHelper;



@Repository
public interface CiudadRepository extends JpaRepository<Ciudad, Integer>,CiudadHelper {

	

}


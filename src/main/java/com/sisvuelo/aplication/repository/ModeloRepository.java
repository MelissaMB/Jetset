package com.sisvuelo.aplication.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sisvuelo.aplication.model.Modelo;
import com.sisvuelo.aplication.repository.helper.ModeloHelper;



@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Integer>,ModeloHelper {

	

}


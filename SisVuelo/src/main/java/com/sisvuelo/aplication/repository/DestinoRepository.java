package com.sisvuelo.aplication.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sisvuelo.aplication.model.Destino;
import com.sisvuelo.aplication.repository.helper.DestinoHelper;



@Repository
public interface DestinoRepository extends JpaRepository<Destino, Integer>,DestinoHelper {

	

}


package com.sisvuelo.aplication.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sisvuelo.aplication.model.Avion;
import com.sisvuelo.aplication.repository.helper.AvionHelper;



@Repository
public interface AvionRepository extends JpaRepository<Avion, Integer>,AvionHelper {

	

}


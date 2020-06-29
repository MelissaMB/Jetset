package com.sisvuelo.aplication.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sisvuelo.aplication.model.Precio;
import com.sisvuelo.aplication.repository.helper.PrecioHelper;



@Repository
public interface PrecioRepository extends JpaRepository<Precio, Integer>,PrecioHelper {

	

}


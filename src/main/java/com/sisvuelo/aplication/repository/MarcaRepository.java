package com.sisvuelo.aplication.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sisvuelo.aplication.model.Marca;
import com.sisvuelo.aplication.repository.helper.MarcaHelper;



@Repository
public interface MarcaRepository extends JpaRepository<Marca, Integer>,MarcaHelper {

	

}


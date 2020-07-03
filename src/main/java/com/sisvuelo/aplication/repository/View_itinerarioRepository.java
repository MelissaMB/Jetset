package com.sisvuelo.aplication.repository;

import com.sisvuelo.aplication.model.View_itinerario;
import com.sisvuelo.aplication.repository.helper.View_itinerarioHelper;

import org.springframework.data.jpa.repository.JpaRepository;

public interface View_itinerarioRepository extends JpaRepository<View_itinerarioRepository, Integer>, View_itinerarioHelper {
}

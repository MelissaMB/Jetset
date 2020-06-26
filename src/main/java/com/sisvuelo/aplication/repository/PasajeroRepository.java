package com.sisvuelo.aplication.repository;

import com.sisvuelo.aplication.model.Pasajero;
import com.sisvuelo.aplication.repository.helper.PasajeroHelper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PasajeroRepository extends JpaRepository<Pasajero, Integer>, PasajeroHelper {


}

package com.sisvuelo.aplication.repository;

import com.sisvuelo.aplication.model.Pasajero;
import com.sisvuelo.aplication.model.Usuario;
import com.sisvuelo.aplication.repository.helper.PasajeroHelper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PasajeroRepository extends JpaRepository<Pasajero, Integer>, PasajeroHelper {

   Pasajero findByUsuario( Usuario usuario);
}

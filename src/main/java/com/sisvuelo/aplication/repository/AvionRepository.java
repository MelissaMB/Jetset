package com.sisvuelo.aplication.repository;



import com.sisvuelo.aplication.model.Aerolinea;
import com.sisvuelo.aplication.model.Destino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sisvuelo.aplication.model.Avion;
import com.sisvuelo.aplication.repository.helper.AvionHelper;

import java.util.List;
import java.util.Optional;


@Repository
public interface AvionRepository extends JpaRepository<Avion, Integer>,AvionHelper {

    List<Avion> findAvionByAerolinea(Optional<Aerolinea> aerolinea);

}


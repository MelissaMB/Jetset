package com.sisvuelo.aplication.repository;



import com.sisvuelo.aplication.model.Aerolinea;
import com.sisvuelo.aplication.model.Aeropuerto;
import com.sisvuelo.aplication.model.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sisvuelo.aplication.model.Destino;
import com.sisvuelo.aplication.repository.helper.DestinoHelper;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


@Repository
public interface DestinoRepository extends JpaRepository<Destino, Integer>,DestinoHelper {



    List<Destino>findDestinoByAerolinea(Optional<Aerolinea> aerolinea);

}


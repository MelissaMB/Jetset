package com.sisvuelo.aplication.repository;

import com.sisvuelo.aplication.model.ViewOfertaVuelo;
import com.sisvuelo.aplication.repository.helper.ViewOfertaVueloHelper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViewOfertaVueloRepository extends JpaRepository<ViewOfertaVuelo, Integer>, ViewOfertaVueloHelper {
}

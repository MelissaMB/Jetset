package com.sisvuelo.aplication.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sisvuelo.aplication.model.Hangar;
import com.sisvuelo.aplication.repository.helper.HangarHelper;



@Repository
public interface HangarRepository extends JpaRepository<Hangar, Integer>,HangarHelper {

	

}


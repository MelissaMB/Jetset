package com.sisvuelo.aplication.repository;



import com.sisvuelo.aplication.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sisvuelo.aplication.model.Rol;
import com.sisvuelo.aplication.repository.helper.RolHelper;



@Repository
public interface RolRepository extends JpaRepository<Rol, Integer>,RolHelper {

    Rol findByNombre(String nombre);


}


package com.sisvuelo.aplication.repository;

import com.sisvuelo.aplication.model.ClienteNatural;
import com.sisvuelo.aplication.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteNaturalRepository extends JpaRepository<ClienteNatural, Integer> {

    ClienteNatural findByUsuario(Usuario usuario);
}

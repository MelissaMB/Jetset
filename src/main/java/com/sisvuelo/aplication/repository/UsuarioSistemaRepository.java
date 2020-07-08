package com.sisvuelo.aplication.repository;


import com.sisvuelo.aplication.model.UsuarioSistema;
import com.sisvuelo.aplication.repository.helper.UsuarioSistemaHelper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioSistemaRepository extends JpaRepository<UsuarioSistema, Integer>, UsuarioSistemaHelper {
}

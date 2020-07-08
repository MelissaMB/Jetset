package com.sisvuelo.aplication.repository;


import com.sisvuelo.aplication.model.UsuarioSistema;
import com.sisvuelo.aplication.repository.helper.UsuarioSistemaHelper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public interface UsuarioSistemaRepository extends JpaRepository<UsuarioSistema, Integer>, UsuarioSistemaHelper {

    List<UsuarioSistema> findByUsuario_RolIsNull();

}

package com.sisvuelo.aplication.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sisvuelo.aplication.model.Usuario;
import com.sisvuelo.aplication.repository.helper.UsuarioHelper;



@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>,UsuarioHelper {

	Usuario findByUsername(String username);


}


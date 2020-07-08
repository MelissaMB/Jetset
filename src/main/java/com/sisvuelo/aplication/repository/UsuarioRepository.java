package com.sisvuelo.aplication.repository;
import com.sisvuelo.aplication.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sisvuelo.aplication.model.Usuario;
import com.sisvuelo.aplication.repository.helper.UsuarioHelper;

import java.util.List;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>,UsuarioHelper {

	Usuario findByUsername(String username);
	List<Usuario> findTopByRol(Rol rol);


}


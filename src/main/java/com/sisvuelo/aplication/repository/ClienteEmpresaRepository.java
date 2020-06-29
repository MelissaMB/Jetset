package com.sisvuelo.aplication.repository;

import com.sisvuelo.aplication.model.ClienteEmpresa;
import com.sisvuelo.aplication.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteEmpresaRepository extends JpaRepository<ClienteEmpresa, Integer> {
    ClienteEmpresa findByUsuario(Usuario usuario);
}

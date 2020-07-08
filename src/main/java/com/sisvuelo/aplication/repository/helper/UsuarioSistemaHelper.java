package com.sisvuelo.aplication.repository.helper;

import com.sisvuelo.aplication.filter.UsuarioSistemaFilter;
import com.sisvuelo.aplication.model.UsuarioSistema;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UsuarioSistemaHelper {
    public Page<UsuarioSistema> filtrar(UsuarioSistemaFilter usuarioSistemaFilter, Pageable pageable);
}

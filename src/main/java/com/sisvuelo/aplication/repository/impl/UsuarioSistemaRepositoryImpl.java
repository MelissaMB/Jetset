package com.sisvuelo.aplication.repository.impl;

import com.sisvuelo.aplication.filter.AeropuertoFilter;
import com.sisvuelo.aplication.filter.UsuarioSistemaFilter;
import com.sisvuelo.aplication.model.Aeropuerto;
import com.sisvuelo.aplication.model.UsuarioSistema;
import com.sisvuelo.aplication.repository.helper.UsuarioSistemaHelper;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class UsuarioSistemaRepositoryImpl implements UsuarioSistemaHelper {
    @PersistenceContext
    private EntityManager manager;

   @SuppressWarnings("unchecked")
    public Page<UsuarioSistema> filtrar(UsuarioSistemaFilter usuarioSistemaFilter, Pageable pageable) {
        Criteria criteria = manager.unwrap(Session.class).createCriteria(UsuarioSistema.class);

        int paginaAtual = pageable.getPageNumber();
        int totalRegistrosPorPagina = pageable.getPageSize();
        int primeiroRegistro = paginaAtual * totalRegistrosPorPagina;

        criteria.setFirstResult(primeiroRegistro);
        criteria.setMaxResults(totalRegistrosPorPagina);

        addFilter(usuarioSistemaFilter, criteria);

        return new PageImpl<>(criteria.list(), pageable, total(usuarioSistemaFilter));
    }

    private Long total(UsuarioSistemaFilter usuarioSistemaFilter) {

        Criteria criteria = manager.unwrap(Session.class).createCriteria(UsuarioSistema.class);
        addFilter(usuarioSistemaFilter, criteria);
        criteria.setProjection(Projections.rowCount());
        return (Long) criteria.uniqueResult();
    }

    private void addFilter(UsuarioSistemaFilter usuarioSistemaFilter, Criteria criteria) {
        if (usuarioSistemaFilter != null) {

            if (usuarioSistemaFilter.getId() != null) {
                criteria.add(Restrictions.eq("id", usuarioSistemaFilter.getId()));
            }

            if (!StringUtils.isEmpty(usuarioSistemaFilter.getPrimerNombre())) {
                criteria.add(Restrictions.ilike("primerNombre", usuarioSistemaFilter.getPrimerNombre(), MatchMode.ANYWHERE));
            }
            if (!StringUtils.isEmpty(usuarioSistemaFilter.getSegundoNombre())) {
                criteria.add(Restrictions.ilike("segundoNombre", usuarioSistemaFilter.getSegundoNombre(), MatchMode.ANYWHERE));
            }
            if (!StringUtils.isEmpty(usuarioSistemaFilter.getPrimerApellido())) {
                criteria.add(Restrictions.ilike("primerApellido", usuarioSistemaFilter.getPrimerApellido(), MatchMode.ANYWHERE));
            }
            if (!StringUtils.isEmpty(usuarioSistemaFilter.getSegundoApellido())) {
                criteria.add(Restrictions.ilike("SegundoApellido", usuarioSistemaFilter.getSegundoApellido(), MatchMode.ANYWHERE));
            }
            if (!StringUtils.isEmpty(usuarioSistemaFilter.getSexo())) {
                criteria.add(Restrictions.ilike("sexo", usuarioSistemaFilter.getSexo(), MatchMode.ANYWHERE));
            }
            if (usuarioSistemaFilter.getUsuario() != null) {
                criteria.add(Restrictions.eq("usuario", usuarioSistemaFilter.getUsuario()));
            }

        }
    }

}

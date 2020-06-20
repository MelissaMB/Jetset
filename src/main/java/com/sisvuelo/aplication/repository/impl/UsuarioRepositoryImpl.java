package com.sisvuelo.aplication.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import com.sisvuelo.aplication.repository.helper.UsuarioHelper;
import com.sisvuelo.aplication.filter.UsuarioFilter;
import com.sisvuelo.aplication.model.Usuario;



public class UsuarioRepositoryImpl implements UsuarioHelper {

	@PersistenceContext
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	public Page<Usuario> filtrar(UsuarioFilter  usuarioFilter, Pageable pageable) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Usuario.class);

		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistro = paginaAtual * totalRegistrosPorPagina;

		criteria.setFirstResult(primeiroRegistro);
		criteria.setMaxResults(totalRegistrosPorPagina);

		addFilter(usuarioFilter, criteria);

		return new PageImpl<>(criteria.list(), pageable, total(usuarioFilter));
	}

	private Long total(UsuarioFilter usuarioFilter) {

		Criteria criteria = manager.unwrap(Session.class).createCriteria(Usuario.class);
		addFilter(usuarioFilter, criteria);
		criteria.setProjection(Projections.rowCount());
		return (Long) criteria.uniqueResult();
	}

	private void addFilter(UsuarioFilter usuarioFilter, Criteria criteria) {
		if (usuarioFilter != null) {
			
                      if (usuarioFilter.getId() != null) {
				criteria.add(Restrictions.eq("id", usuarioFilter.getId()));
			}

           if (!StringUtils.isEmpty(usuarioFilter.getEmail())) {
				criteria.add(Restrictions.ilike("email", usuarioFilter.getEmail(), MatchMode.ANYWHERE));
			}
			

           if (!StringUtils.isEmpty(usuarioFilter.getPassword())) {
				criteria.add(Restrictions.ilike("password", usuarioFilter.getPassword(), MatchMode.ANYWHERE));
			}
			

            if (usuarioFilter.getFechaCreacion() != null) {
				criteria.add(Restrictions.eq("fechaCreacion", usuarioFilter.getFechaCreacion()));
			}

            if (usuarioFilter.getRol() != null) {
				criteria.add(Restrictions.eq("rol", usuarioFilter.getRol()));
			}



		}
	}

}

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

import com.sisvuelo.aplication.repository.helper.ClaseHelper;
import com.sisvuelo.aplication.filter.ClaseFilter;
import com.sisvuelo.aplication.model.Clase;



public class ClaseRepositoryImpl implements ClaseHelper {

	@PersistenceContext
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	public Page<Clase> filtrar(ClaseFilter  claseFilter, Pageable pageable) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Clase.class);

		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistro = paginaAtual * totalRegistrosPorPagina;

		criteria.setFirstResult(primeiroRegistro);
		criteria.setMaxResults(totalRegistrosPorPagina);

		addFilter(claseFilter, criteria);

		return new PageImpl<>(criteria.list(), pageable, total(claseFilter));
	}

	private Long total(ClaseFilter claseFilter) {

		Criteria criteria = manager.unwrap(Session.class).createCriteria(Clase.class);
		addFilter(claseFilter, criteria);
		criteria.setProjection(Projections.rowCount());
		return (Long) criteria.uniqueResult();
	}

	private void addFilter(ClaseFilter claseFilter, Criteria criteria) {
		if (claseFilter != null) {
			
                      if (claseFilter.getId() != null) {
				criteria.add(Restrictions.eq("id", claseFilter.getId()));
			}

           if (!StringUtils.isEmpty(claseFilter.getNombreClase())) {
				criteria.add(Restrictions.ilike("nombreClase", claseFilter.getNombreClase(), MatchMode.ANYWHERE));
			}
			

criteria.add(Restrictions.eq("estado", claseFilter.isEstado()));
			



		}
	}

}

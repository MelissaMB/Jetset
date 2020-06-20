package com.sisvuelo.aplication.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.sisvuelo.aplication.model.Ciudad;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.util.StringUtils;

import com.sisvuelo.aplication.repository.helper.DestinoHelper;
import com.sisvuelo.aplication.filter.DestinoFilter;
import com.sisvuelo.aplication.model.Destino;



public class DestinoRepositoryImpl implements DestinoHelper {

	@PersistenceContext
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	public Page<Destino> filtrar(DestinoFilter  destinoFilter, Pageable pageable) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Destino.class);

		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistro = paginaAtual * totalRegistrosPorPagina;

		criteria.setFirstResult(primeiroRegistro);
		criteria.setMaxResults(totalRegistrosPorPagina);

		addFilter(destinoFilter, criteria);

		return new PageImpl<>(criteria.list(), pageable, total(destinoFilter));
	}


	private Long total(DestinoFilter destinoFilter) {

		Criteria criteria = manager.unwrap(Session.class).createCriteria(Destino.class);
		addFilter(destinoFilter, criteria);
		criteria.setProjection(Projections.rowCount());
		return (Long) criteria.uniqueResult();
	}

	private void addFilter(DestinoFilter destinoFilter, Criteria criteria) {
		if (destinoFilter != null) {
			
                      if (destinoFilter.getId() != null) {
				criteria.add(Restrictions.eq("id", destinoFilter.getId()));
			}

            if (destinoFilter.getAerolinea() != null) {
				criteria.add(Restrictions.eq("aerolinea", destinoFilter.getAerolinea()));
			}

            if (destinoFilter.getAeropuerto() != null) {
				criteria.add(Restrictions.eq("aeropuerto", destinoFilter.getAeropuerto()));
			}



		}
	}

}

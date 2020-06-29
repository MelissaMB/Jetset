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

import com.sisvuelo.aplication.repository.helper.CapacidadHelper;
import com.sisvuelo.aplication.filter.CapacidadFilter;
import com.sisvuelo.aplication.model.Capacidad;



public class CapacidadRepositoryImpl implements CapacidadHelper {

	@PersistenceContext
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	public Page<Capacidad> filtrar(CapacidadFilter  capacidadFilter, Pageable pageable) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Capacidad.class);

		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistro = paginaAtual * totalRegistrosPorPagina;

		criteria.setFirstResult(primeiroRegistro);
		criteria.setMaxResults(totalRegistrosPorPagina);

		addFilter(capacidadFilter, criteria);

		return new PageImpl<>(criteria.list(), pageable, total(capacidadFilter));
	}

	private Long total(CapacidadFilter capacidadFilter) {

		Criteria criteria = manager.unwrap(Session.class).createCriteria(Capacidad.class);
		addFilter(capacidadFilter, criteria);
		criteria.setProjection(Projections.rowCount());
		return (Long) criteria.uniqueResult();
	}

	private void addFilter(CapacidadFilter capacidadFilter, Criteria criteria) {
		if (capacidadFilter != null) {
			
                      if (capacidadFilter.getId() != null) {
				criteria.add(Restrictions.eq("id", capacidadFilter.getId()));
			}

            if (capacidadFilter.getClase() != null) {
				criteria.add(Restrictions.eq("clase", capacidadFilter.getClase()));
			}

            if (capacidadFilter.getAvion() != null) {
				criteria.add(Restrictions.eq("avion", capacidadFilter.getAvion()));
			}

            if (capacidadFilter.getCantidad() != null) {
				criteria.add(Restrictions.eq("cantidad", capacidadFilter.getCantidad()));
			}



		}
	}

}

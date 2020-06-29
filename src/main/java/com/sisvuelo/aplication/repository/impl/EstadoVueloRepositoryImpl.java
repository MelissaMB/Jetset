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

import com.sisvuelo.aplication.repository.helper.EstadoVueloHelper;
import com.sisvuelo.aplication.filter.EstadoVueloFilter;
import com.sisvuelo.aplication.model.EstadoVuelo;



public class EstadoVueloRepositoryImpl implements EstadoVueloHelper {

	@PersistenceContext
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	public Page<EstadoVuelo> filtrar(EstadoVueloFilter  estadoVueloFilter, Pageable pageable) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(EstadoVuelo.class);

		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistro = paginaAtual * totalRegistrosPorPagina;

		criteria.setFirstResult(primeiroRegistro);
		criteria.setMaxResults(totalRegistrosPorPagina);

		addFilter(estadoVueloFilter, criteria);

		return new PageImpl<>(criteria.list(), pageable, total(estadoVueloFilter));
	}

	private Long total(EstadoVueloFilter estadoVueloFilter) {

		Criteria criteria = manager.unwrap(Session.class).createCriteria(EstadoVuelo.class);
		addFilter(estadoVueloFilter, criteria);
		criteria.setProjection(Projections.rowCount());
		return (Long) criteria.uniqueResult();
	}

	private void addFilter(EstadoVueloFilter estadoVueloFilter, Criteria criteria) {
		if (estadoVueloFilter != null) {
			
                      if (estadoVueloFilter.getId() != null) {
				criteria.add(Restrictions.eq("id", estadoVueloFilter.getId()));
			}

           if (!StringUtils.isEmpty(estadoVueloFilter.getEstado_Vuelo())) {
				criteria.add(Restrictions.ilike("estado_Vuelo", estadoVueloFilter.getEstado_Vuelo(), MatchMode.ANYWHERE));
			}
			



		}
	}

}

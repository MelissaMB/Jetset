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

import com.sisvuelo.aplication.repository.helper.AvionHelper;
import com.sisvuelo.aplication.filter.AvionFilter;
import com.sisvuelo.aplication.model.Avion;



public class AvionRepositoryImpl implements AvionHelper {

	@PersistenceContext
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	public Page<Avion> filtrar(AvionFilter  avionFilter, Pageable pageable) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Avion.class);

		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistro = paginaAtual * totalRegistrosPorPagina;

		criteria.setFirstResult(primeiroRegistro);
		criteria.setMaxResults(totalRegistrosPorPagina);

		addFilter(avionFilter, criteria);

		return new PageImpl<>(criteria.list(), pageable, total(avionFilter));
	}

	private Long total(AvionFilter avionFilter) {

		Criteria criteria = manager.unwrap(Session.class).createCriteria(Avion.class);
		addFilter(avionFilter, criteria);
		criteria.setProjection(Projections.rowCount());
		return (Long) criteria.uniqueResult();
	}

	private void addFilter(AvionFilter avionFilter, Criteria criteria) {
		if (avionFilter != null) {
			
                      if (avionFilter.getId() != null) {
				criteria.add(Restrictions.eq("id", avionFilter.getId()));
			}

            if (avionFilter.getModelo() != null) {
				criteria.add(Restrictions.eq("modelo", avionFilter.getModelo()));
			}

            if (avionFilter.getAerolinea() != null) {
				criteria.add(Restrictions.eq("aerolinea", avionFilter.getAerolinea()));
			}

           if (!StringUtils.isEmpty(avionFilter.getNombre())) {
				criteria.add(Restrictions.ilike("nombre", avionFilter.getNombre(), MatchMode.ANYWHERE));
			}
			

            if (avionFilter.getAnioFabricacion() != null) {
				criteria.add(Restrictions.eq("anioFabricacion", avionFilter.getAnioFabricacion()));
			}

			



		}
	}

}

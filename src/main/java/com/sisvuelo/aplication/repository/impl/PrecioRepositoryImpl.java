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

import com.sisvuelo.aplication.repository.helper.PrecioHelper;
import com.sisvuelo.aplication.filter.PrecioFilter;
import com.sisvuelo.aplication.model.Precio;



public class PrecioRepositoryImpl implements PrecioHelper {

	@PersistenceContext
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	public Page<Precio> filtrar(PrecioFilter  precioFilter, Pageable pageable) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Precio.class);

		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistro = paginaAtual * totalRegistrosPorPagina;

		criteria.setFirstResult(primeiroRegistro);
		criteria.setMaxResults(totalRegistrosPorPagina);

		addFilter(precioFilter, criteria);

		return new PageImpl<>(criteria.list(), pageable, total(precioFilter));
	}

	private Long total(PrecioFilter precioFilter) {

		Criteria criteria = manager.unwrap(Session.class).createCriteria(Precio.class);
		addFilter(precioFilter, criteria);
		criteria.setProjection(Projections.rowCount());
		return (Long) criteria.uniqueResult();
	}

	private void addFilter(PrecioFilter precioFilter, Criteria criteria) {
		if (precioFilter != null) {
			
                      if (precioFilter.getId() != null) {
				criteria.add(Restrictions.eq("id", precioFilter.getId()));
			}

            if (precioFilter.getClase() != null) {
				criteria.add(Restrictions.eq("clase", precioFilter.getClase()));
			}

            if (precioFilter.getVuelo() != null) {
				criteria.add(Restrictions.eq("vuelo", precioFilter.getVuelo()));
			}

            if (precioFilter.getPrecio() != 0) {
				criteria.add(Restrictions.eq("precio", precioFilter.getPrecio()));
			}



		}
	}

}

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

import com.sisvuelo.aplication.repository.helper.CiudadHelper;
import com.sisvuelo.aplication.filter.CiudadFilter;
import com.sisvuelo.aplication.model.Ciudad;



public class CiudadRepositoryImpl implements CiudadHelper {

	@PersistenceContext
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	public Page<Ciudad> filtrar(CiudadFilter  ciudadFilter, Pageable pageable) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Ciudad.class);

		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistro = paginaAtual * totalRegistrosPorPagina;

		criteria.setFirstResult(primeiroRegistro);
		criteria.setMaxResults(totalRegistrosPorPagina);

		addFilter(ciudadFilter, criteria);

		return new PageImpl<>(criteria.list(), pageable, total(ciudadFilter));
	}

	private Long total(CiudadFilter ciudadFilter) {

		Criteria criteria = manager.unwrap(Session.class).createCriteria(Ciudad.class);
		addFilter(ciudadFilter, criteria);
		criteria.setProjection(Projections.rowCount());
		return (Long) criteria.uniqueResult();
	}

	private void addFilter(CiudadFilter ciudadFilter, Criteria criteria) {
		if (ciudadFilter != null) {
			
                      if (ciudadFilter.getId() != null) {
				criteria.add(Restrictions.eq("id", ciudadFilter.getId()));
			}

            if (ciudadFilter.getPais() != null) {
				criteria.add(Restrictions.eq("pais", ciudadFilter.getPais()));
			}

           if (!StringUtils.isEmpty(ciudadFilter.getNombre())) {
				criteria.add(Restrictions.ilike("nombre", ciudadFilter.getNombre(), MatchMode.ANYWHERE));
			}
			



		}
	}

}

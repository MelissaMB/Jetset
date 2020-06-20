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

import com.sisvuelo.aplication.repository.helper.PaisHelper;
import com.sisvuelo.aplication.filter.PaisFilter;
import com.sisvuelo.aplication.model.Pais;



public class PaisRepositoryImpl implements PaisHelper {

	@PersistenceContext
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	public Page<Pais> filtrar(PaisFilter  paisFilter, Pageable pageable) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Pais.class);

		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistro = paginaAtual * totalRegistrosPorPagina;

		criteria.setFirstResult(primeiroRegistro);
		criteria.setMaxResults(totalRegistrosPorPagina);

		addFilter(paisFilter, criteria);

		return new PageImpl<>(criteria.list(), pageable, total(paisFilter));
	}

	private Long total(PaisFilter paisFilter) {

		Criteria criteria = manager.unwrap(Session.class).createCriteria(Pais.class);
		addFilter(paisFilter, criteria);
		criteria.setProjection(Projections.rowCount());
		return (Long) criteria.uniqueResult();
	}

	private void addFilter(PaisFilter paisFilter, Criteria criteria) {
		if (paisFilter != null) {
			
                      if (paisFilter.getId() != null) {
				criteria.add(Restrictions.eq("id", paisFilter.getId()));
			}

           if (!StringUtils.isEmpty(paisFilter.getCodigo())) {
				criteria.add(Restrictions.ilike("codigo", paisFilter.getCodigo(), MatchMode.ANYWHERE));
			}
			

           if (!StringUtils.isEmpty(paisFilter.getNombre())) {
				criteria.add(Restrictions.ilike("nombre", paisFilter.getNombre(), MatchMode.ANYWHERE));
			}
			



		}
	}

}

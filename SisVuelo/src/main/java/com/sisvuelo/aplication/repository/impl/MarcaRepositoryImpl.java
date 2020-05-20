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

import com.sisvuelo.aplication.repository.helper.MarcaHelper;
import com.sisvuelo.aplication.filter.MarcaFilter;
import com.sisvuelo.aplication.model.Marca;



public class MarcaRepositoryImpl implements MarcaHelper {

	@PersistenceContext
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	public Page<Marca> filtrar(MarcaFilter  marcaFilter, Pageable pageable) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Marca.class);

		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistro = paginaAtual * totalRegistrosPorPagina;

		criteria.setFirstResult(primeiroRegistro);
		criteria.setMaxResults(totalRegistrosPorPagina);

		addFilter(marcaFilter, criteria);

		return new PageImpl<>(criteria.list(), pageable, total(marcaFilter));
	}

	private Long total(MarcaFilter marcaFilter) {

		Criteria criteria = manager.unwrap(Session.class).createCriteria(Marca.class);
		addFilter(marcaFilter, criteria);
		criteria.setProjection(Projections.rowCount());
		return (Long) criteria.uniqueResult();
	}

	private void addFilter(MarcaFilter marcaFilter, Criteria criteria) {
		if (marcaFilter != null) {
			
                      if (marcaFilter.getId() != null) {
				criteria.add(Restrictions.eq("id", marcaFilter.getId()));
			}

           if (!StringUtils.isEmpty(marcaFilter.getNombre())) {
				criteria.add(Restrictions.ilike("nombre", marcaFilter.getNombre(), MatchMode.ANYWHERE));
			}
			



		}
	}

}

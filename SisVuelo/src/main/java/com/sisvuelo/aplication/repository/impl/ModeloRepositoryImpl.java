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

import com.sisvuelo.aplication.repository.helper.ModeloHelper;
import com.sisvuelo.aplication.filter.ModeloFilter;
import com.sisvuelo.aplication.model.Modelo;



public class ModeloRepositoryImpl implements ModeloHelper {

	@PersistenceContext
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	public Page<Modelo> filtrar(ModeloFilter  modeloFilter, Pageable pageable) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Modelo.class);

		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistro = paginaAtual * totalRegistrosPorPagina;

		criteria.setFirstResult(primeiroRegistro);
		criteria.setMaxResults(totalRegistrosPorPagina);

		addFilter(modeloFilter, criteria);

		return new PageImpl<>(criteria.list(), pageable, total(modeloFilter));
	}

	private Long total(ModeloFilter modeloFilter) {

		Criteria criteria = manager.unwrap(Session.class).createCriteria(Modelo.class);
		addFilter(modeloFilter, criteria);
		criteria.setProjection(Projections.rowCount());
		return (Long) criteria.uniqueResult();
	}

	private void addFilter(ModeloFilter modeloFilter, Criteria criteria) {
		if (modeloFilter != null) {
			
                      if (modeloFilter.getId() != null) {
				criteria.add(Restrictions.eq("id", modeloFilter.getId()));
			}

            if (modeloFilter.getMarca() != null) {
				criteria.add(Restrictions.eq("marca", modeloFilter.getMarca()));
			}

           if (!StringUtils.isEmpty(modeloFilter.getNombre())) {
				criteria.add(Restrictions.ilike("nombre", modeloFilter.getNombre(), MatchMode.ANYWHERE));
			}
			



		}
	}

}

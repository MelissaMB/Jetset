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

import com.sisvuelo.aplication.repository.helper.HangarHelper;
import com.sisvuelo.aplication.filter.HangarFilter;
import com.sisvuelo.aplication.model.Hangar;



public class HangarRepositoryImpl implements HangarHelper {

	@PersistenceContext
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	public Page<Hangar> filtrar(HangarFilter  hangarFilter, Pageable pageable) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Hangar.class);

		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistro = paginaAtual * totalRegistrosPorPagina;

		criteria.setFirstResult(primeiroRegistro);
		criteria.setMaxResults(totalRegistrosPorPagina);

		addFilter(hangarFilter, criteria);

		return new PageImpl<>(criteria.list(), pageable, total(hangarFilter));
	}

	private Long total(HangarFilter hangarFilter) {

		Criteria criteria = manager.unwrap(Session.class).createCriteria(Hangar.class);
		addFilter(hangarFilter, criteria);
		criteria.setProjection(Projections.rowCount());
		return (Long) criteria.uniqueResult();
	}

	private void addFilter(HangarFilter hangarFilter, Criteria criteria) {
		if (hangarFilter != null) {
			
                      if (hangarFilter.getId() != null) {
				criteria.add(Restrictions.eq("id", hangarFilter.getId()));
			}

           if (!StringUtils.isEmpty(hangarFilter.getCodigo())) {
				criteria.add(Restrictions.ilike("codigo", hangarFilter.getCodigo(), MatchMode.ANYWHERE));
			}
			

            if (hangarFilter.getAeropuerto() != null) {
				criteria.add(Restrictions.eq("aeropuerto", hangarFilter.getAeropuerto()));
			}

criteria.add(Restrictions.eq("estado", hangarFilter.isEstado()));
			

            if (hangarFilter.getCapacidad() != null) {
				criteria.add(Restrictions.eq("capacidad", hangarFilter.getCapacidad()));
			}



		}
	}

}

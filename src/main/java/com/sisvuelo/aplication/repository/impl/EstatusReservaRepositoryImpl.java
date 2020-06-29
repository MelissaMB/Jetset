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

import com.sisvuelo.aplication.repository.helper.EstatusReservaHelper;
import com.sisvuelo.aplication.filter.EstatusReservaFilter;
import com.sisvuelo.aplication.model.EstatusReserva;



public class EstatusReservaRepositoryImpl implements EstatusReservaHelper {

	@PersistenceContext
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	public Page<EstatusReserva> filtrar(EstatusReservaFilter  estatusReservaFilter, Pageable pageable) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(EstatusReserva.class);

		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistro = paginaAtual * totalRegistrosPorPagina;

		criteria.setFirstResult(primeiroRegistro);
		criteria.setMaxResults(totalRegistrosPorPagina);

		addFilter(estatusReservaFilter, criteria);

		return new PageImpl<>(criteria.list(), pageable, total(estatusReservaFilter));
	}

	private Long total(EstatusReservaFilter estatusReservaFilter) {

		Criteria criteria = manager.unwrap(Session.class).createCriteria(EstatusReserva.class);
		addFilter(estatusReservaFilter, criteria);
		criteria.setProjection(Projections.rowCount());
		return (Long) criteria.uniqueResult();
	}

	private void addFilter(EstatusReservaFilter estatusReservaFilter, Criteria criteria) {
		if (estatusReservaFilter != null) {
			
                      if (estatusReservaFilter.getId() != null) {
				criteria.add(Restrictions.eq("id", estatusReservaFilter.getId()));
			}

           if (!StringUtils.isEmpty(estatusReservaFilter.getEstatus())) {
				criteria.add(Restrictions.ilike("estatus", estatusReservaFilter.getEstatus(), MatchMode.ANYWHERE));
			}
			



		}
	}

}

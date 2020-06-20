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

import com.sisvuelo.aplication.repository.helper.AerolineaHelper;
import com.sisvuelo.aplication.filter.AerolineaFilter;
import com.sisvuelo.aplication.model.Aerolinea;

public class AerolineaRepositoryImpl implements AerolineaHelper {

	@PersistenceContext
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	public Page<Aerolinea> filtrar(AerolineaFilter aerolineaFilter, Pageable pageable) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Aerolinea.class);

		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistro = paginaAtual * totalRegistrosPorPagina;

		criteria.setFirstResult(primeiroRegistro);
		criteria.setMaxResults(totalRegistrosPorPagina);

		addFilter(aerolineaFilter, criteria);

		return new PageImpl<>(criteria.list(), pageable, total(aerolineaFilter));
	}

	private Long total(AerolineaFilter aerolineaFilter) {

		Criteria criteria = manager.unwrap(Session.class).createCriteria(Aerolinea.class);
		addFilter(aerolineaFilter, criteria);
		criteria.setProjection(Projections.rowCount());
		return (Long) criteria.uniqueResult();
	}

	private void addFilter(AerolineaFilter aerolineaFilter, Criteria criteria) {
		if (aerolineaFilter != null) {

			if (aerolineaFilter.getId() != null) {
				criteria.add(Restrictions.eq("id", aerolineaFilter.getId()));
			}

			if (aerolineaFilter.getPais() != null) {
				criteria.add(Restrictions.eq("pais", aerolineaFilter.getPais()));
			}

			if (!StringUtils.isEmpty(aerolineaFilter.getCodigo())) {
				criteria.add(Restrictions.ilike("codigo", aerolineaFilter.getCodigo(), MatchMode.ANYWHERE));
			}

			if (!StringUtils.isEmpty(aerolineaFilter.getNombreCorto())) {
				criteria.add(Restrictions.ilike("nombreCorto", aerolineaFilter.getNombreCorto(), MatchMode.ANYWHERE));
			}

			if (!StringUtils.isEmpty(aerolineaFilter.getNombreLargo())) {
				criteria.add(Restrictions.ilike("nombreLargo", aerolineaFilter.getNombreLargo(), MatchMode.ANYWHERE));
			}

			if (!StringUtils.isEmpty(aerolineaFilter.getRepresentante())) {
				criteria.add(
						Restrictions.ilike("representante", aerolineaFilter.getRepresentante(), MatchMode.ANYWHERE));
			}

			if (!StringUtils.isEmpty(aerolineaFilter.getEmail())) {
				criteria.add(Restrictions.ilike("email", aerolineaFilter.getEmail(), MatchMode.ANYWHERE));
			}

			if (aerolineaFilter.getFechaFundacion() != null) {
				criteria.add(Restrictions.eq("fechaFundacion", aerolineaFilter.getFechaFundacion()));
			}

			//criteria.add(Restrictions.eq("estado", aerolineaFilter.isEstado()));

		}
	}

}

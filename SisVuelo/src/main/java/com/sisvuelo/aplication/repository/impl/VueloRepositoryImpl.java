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

import com.sisvuelo.aplication.repository.helper.VueloHelper;
import com.sisvuelo.aplication.filter.VueloFilter;
import com.sisvuelo.aplication.model.Vuelo;



public class VueloRepositoryImpl implements VueloHelper {

	@PersistenceContext
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	public Page<Vuelo> filtrar(VueloFilter  vueloFilter, Pageable pageable) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Vuelo.class);

		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistro = paginaAtual * totalRegistrosPorPagina;

		criteria.setFirstResult(primeiroRegistro);
		criteria.setMaxResults(totalRegistrosPorPagina);

		addFilter(vueloFilter, criteria);

		return new PageImpl<>(criteria.list(), pageable, total(vueloFilter));
	}

	private Long total(VueloFilter vueloFilter) {

		Criteria criteria = manager.unwrap(Session.class).createCriteria(Vuelo.class);
		addFilter(vueloFilter, criteria);
		criteria.setProjection(Projections.rowCount());
		return (Long) criteria.uniqueResult();
	}

	private void addFilter(VueloFilter vueloFilter, Criteria criteria) {
		if (vueloFilter != null) {
			
                      if (vueloFilter.getId() != null) {
				criteria.add(Restrictions.eq("id", vueloFilter.getId()));
			}

           if (!StringUtils.isEmpty(vueloFilter.getCodigo())) {
				criteria.add(Restrictions.ilike("codigo", vueloFilter.getCodigo(), MatchMode.ANYWHERE));
			}
			

            if (vueloFilter.getOrigen() != null) {
				criteria.add(Restrictions.eq("origen", vueloFilter.getOrigen()));
			}

            if (vueloFilter.getDestino() != null) {
				criteria.add(Restrictions.eq("destino", vueloFilter.getDestino()));
			}

            if (vueloFilter.getAerolinea() != null) {
				criteria.add(Restrictions.eq("aerolinea", vueloFilter.getAerolinea()));
			}

            if (vueloFilter.getCosto() != 0) {
				criteria.add(Restrictions.eq("costo", vueloFilter.getCosto()));
			}

            if (vueloFilter.getMillasReales() != 0) {
				criteria.add(Restrictions.eq("millasReales", vueloFilter.getMillasReales()));
			}

            if (vueloFilter.getMillasPasajeros() != 0) {
				criteria.add(Restrictions.eq("millasPasajeros", vueloFilter.getMillasPasajeros()));
			}

            if (vueloFilter.getFecha() != null) {
				criteria.add(Restrictions.eq("fecha", vueloFilter.getFecha()));
			}

            if (vueloFilter.getHoraDespegue() != null) {
				criteria.add(Restrictions.eq("horaDespegue", vueloFilter.getHoraDespegue()));
			}

            if (vueloFilter.getHoraAterrizaje() != null) {
				criteria.add(Restrictions.eq("horaAterrizaje", vueloFilter.getHoraAterrizaje()));
			}


			



		}
	}

}

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

import com.sisvuelo.aplication.repository.helper.ReservaHelper;
import com.sisvuelo.aplication.filter.ReservaFilter;
import com.sisvuelo.aplication.model.Reserva;



public class ReservaRepositoryImpl implements ReservaHelper {

	@PersistenceContext
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	public Page<Reserva> filtrar(ReservaFilter  reservaFilter, Pageable pageable) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Reserva.class);

		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistro = paginaAtual * totalRegistrosPorPagina;

		criteria.setFirstResult(primeiroRegistro);
		criteria.setMaxResults(totalRegistrosPorPagina);

		addFilter(reservaFilter, criteria);

		return new PageImpl<>(criteria.list(), pageable, total(reservaFilter));
	}

	private Long total(ReservaFilter reservaFilter) {

		Criteria criteria = manager.unwrap(Session.class).createCriteria(Reserva.class);
		addFilter(reservaFilter, criteria);
		criteria.setProjection(Projections.rowCount());
		return (Long) criteria.uniqueResult();
	}

	private void addFilter(ReservaFilter reservaFilter, Criteria criteria) {
		if (reservaFilter != null) {
			
                      if (reservaFilter.getId() != null) {
				criteria.add(Restrictions.eq("id", reservaFilter.getId()));
			}

            if (reservaFilter.getPasajero() != null) {
				criteria.add(Restrictions.eq("pasajero", reservaFilter.getPasajero()));
			}

            if (reservaFilter.getEstatusReserva() != null) {
				criteria.add(Restrictions.eq("estatusReserva", reservaFilter.getEstatusReserva()));
			}

            if (reservaFilter.getVuelo() != null) {
				criteria.add(Restrictions.eq("vuelo", reservaFilter.getVuelo()));
			}

            if (reservaFilter.getClase() != null) {
				criteria.add(Restrictions.eq("clase", reservaFilter.getClase()));
			}

            if (reservaFilter.getCantidad() != null) {
				criteria.add(Restrictions.eq("cantidad", reservaFilter.getCantidad()));
			}

            if (reservaFilter.getNumeroEquipaje() != null) {
				criteria.add(Restrictions.eq("numeroEquipaje", reservaFilter.getNumeroEquipaje()));
			}

            if (reservaFilter.getFechaReserva() != null) {
				criteria.add(Restrictions.eq("fechaReserva", reservaFilter.getFechaReserva()));
			}



		}
	}

}

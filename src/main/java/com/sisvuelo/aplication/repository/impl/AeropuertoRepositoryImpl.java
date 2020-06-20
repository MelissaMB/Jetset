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

import com.sisvuelo.aplication.repository.helper.AeropuertoHelper;
import com.sisvuelo.aplication.filter.AeropuertoFilter;
import com.sisvuelo.aplication.model.Aeropuerto;



public class AeropuertoRepositoryImpl implements AeropuertoHelper {

	@PersistenceContext
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	public Page<Aeropuerto> filtrar(AeropuertoFilter  aeropuertoFilter, Pageable pageable) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Aeropuerto.class);

		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistro = paginaAtual * totalRegistrosPorPagina;

		criteria.setFirstResult(primeiroRegistro);
		criteria.setMaxResults(totalRegistrosPorPagina);

		addFilter(aeropuertoFilter, criteria);

		return new PageImpl<>(criteria.list(), pageable, total(aeropuertoFilter));
	}

	private Long total(AeropuertoFilter aeropuertoFilter) {

		Criteria criteria = manager.unwrap(Session.class).createCriteria(Aeropuerto.class);
		addFilter(aeropuertoFilter, criteria);
		criteria.setProjection(Projections.rowCount());
		return (Long) criteria.uniqueResult();
	}

	private void addFilter(AeropuertoFilter aeropuertoFilter, Criteria criteria) {
		if (aeropuertoFilter != null) {
			
                      if (aeropuertoFilter.getId() != null) {
				criteria.add(Restrictions.eq("id", aeropuertoFilter.getId()));
			}

            if (aeropuertoFilter.getCiudad() != null) {
				criteria.add(Restrictions.eq("ciudad", aeropuertoFilter.getCiudad()));
			}

           if (!StringUtils.isEmpty(aeropuertoFilter.getCodigo())) {
				criteria.add(Restrictions.ilike("codigo", aeropuertoFilter.getCodigo(), MatchMode.ANYWHERE));
			}
			

           if (!StringUtils.isEmpty(aeropuertoFilter.getNombre())) {
				criteria.add(Restrictions.ilike("nombre", aeropuertoFilter.getNombre(), MatchMode.ANYWHERE));
			}
			

           if (!StringUtils.isEmpty(aeropuertoFilter.getTelefono())) {
				criteria.add(Restrictions.ilike("telefono", aeropuertoFilter.getTelefono(), MatchMode.ANYWHERE));
			}
			

           if (!StringUtils.isEmpty(aeropuertoFilter.getResponsable())) {
				criteria.add(Restrictions.ilike("Responsable", aeropuertoFilter.getResponsable(), MatchMode.ANYWHERE));
			}
			

            if (aeropuertoFilter.getNumeroBahias() != null) {
				criteria.add(Restrictions.eq("numeroBahias", aeropuertoFilter.getNumeroBahias()));
			}

            if (aeropuertoFilter.getNumeroHangares() != null) {
				criteria.add(Restrictions.eq("numeroHangares", aeropuertoFilter.getNumeroHangares()));
			}


			



		}
	}

}

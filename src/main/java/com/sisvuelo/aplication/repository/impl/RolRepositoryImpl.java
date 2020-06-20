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

import com.sisvuelo.aplication.repository.helper.RolHelper;
import com.sisvuelo.aplication.filter.RolFilter;
import com.sisvuelo.aplication.model.Rol;



public class RolRepositoryImpl implements RolHelper {

	@PersistenceContext
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	public Page<Rol> filtrar(RolFilter  rolFilter, Pageable pageable) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Rol.class);

		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistro = paginaAtual * totalRegistrosPorPagina;

		criteria.setFirstResult(primeiroRegistro);
		criteria.setMaxResults(totalRegistrosPorPagina);

		addFilter(rolFilter, criteria);

		return new PageImpl<>(criteria.list(), pageable, total(rolFilter));
	}

	private Long total(RolFilter rolFilter) {

		Criteria criteria = manager.unwrap(Session.class).createCriteria(Rol.class);
		addFilter(rolFilter, criteria);
		criteria.setProjection(Projections.rowCount());
		return (Long)criteria.uniqueResult();
	}

	private void addFilter(RolFilter rolFilter, Criteria criteria) {
		if (rolFilter != null) {
			
                      if (rolFilter.getId() != null) {
				criteria.add(Restrictions.eq("id", rolFilter.getId()));
			}

           if (!StringUtils.isEmpty(rolFilter.getNombre())) {
				criteria.add(Restrictions.ilike("nombre", rolFilter.getNombre(), MatchMode.ANYWHERE));
			}
			

           if (!StringUtils.isEmpty(rolFilter.getDescripcion())) {
				criteria.add(Restrictions.ilike("descripcion", rolFilter.getDescripcion(), MatchMode.ANYWHERE));
			}
			



		}
	}

}

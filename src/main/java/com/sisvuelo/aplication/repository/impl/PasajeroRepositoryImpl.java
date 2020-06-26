package com.sisvuelo.aplication.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.sisvuelo.aplication.filter.PasajeroFilter;
import com.sisvuelo.aplication.model.Pasajero;
import com.sisvuelo.aplication.repository.helper.PasajeroHelper;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

public class PasajeroRepositoryImpl implements PasajeroHelper {

    @PersistenceContext
    private EntityManager manager;

    @SuppressWarnings("unchecked")
    public Page<Pasajero> filtrar(PasajeroFilter pasajeroFilter, Pageable pageable){
        Criteria criteria = manager.unwrap(Session.class).createCriteria(Pasajero.class);

        int paginaActual = pageable.getPageNumber();
        int totalRegistrosPorPagina = pageable.getPageSize();
        int primerRegistro = paginaActual*totalRegistrosPorPagina;

        criteria.setFirstResult(primerRegistro);
        criteria.setMaxResults(totalRegistrosPorPagina);

        addFilter(pasajeroFilter, criteria);

        return new PageImpl<>(criteria.list(),pageable, total(pasajeroFilter));


    }

    private Long total(PasajeroFilter pasajeroFilter){
        Criteria criteria = manager.unwrap(Session.class).createCriteria(Pasajero.class);
        addFilter(pasajeroFilter, criteria);
        criteria.setProjection(Projections.rowCount());
        return (Long) criteria.uniqueResult();
    }

    private void addFilter(PasajeroFilter pasajeroFilter, Criteria criteria){
        if(pasajeroFilter !=null){
            if(pasajeroFilter.getNumeroViajero()!=null){
                criteria.add(Restrictions.eq("numeroViajero", pasajeroFilter.getNumeroViajero()));
            }
            if(pasajeroFilter.getNit()!=null){
                criteria.add(Restrictions.eq("nit", pasajeroFilter.getNit()));
            }

            if(!StringUtils.isEmpty(pasajeroFilter.getTelefonoFijo())){
                criteria.add(Restrictions.ilike("telefonoFijo", pasajeroFilter.getTelefonoFijo(), MatchMode.ANYWHERE));
            }

            if(!StringUtils.isEmpty(pasajeroFilter.getTelefonoMovil())){
                criteria.add(Restrictions.ilike("telefonoMovil", pasajeroFilter.getTelefonoMovil(), MatchMode.ANYWHERE));
            }
            if(!StringUtils.isEmpty(pasajeroFilter.getEmail())){
                criteria.add(Restrictions.ilike("email", pasajeroFilter.getEmail(), MatchMode.ANYWHERE));
            }
            if(pasajeroFilter.getTipoPasajero()!=null){
                criteria.add(Restrictions.eq("tipoPasajero", pasajeroFilter.getTipoPasajero()));
            }

        }
    }
}

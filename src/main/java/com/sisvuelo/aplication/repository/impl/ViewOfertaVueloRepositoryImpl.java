package com.sisvuelo.aplication.repository.impl;

import com.sisvuelo.aplication.filter.UsuarioFilter;
import com.sisvuelo.aplication.filter.ViewOfertaVueloFilter;
import com.sisvuelo.aplication.model.Usuario;
import com.sisvuelo.aplication.model.ViewOfertaVuelo;
import com.sisvuelo.aplication.repository.helper.ViewOfertaVueloHelper;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class ViewOfertaVueloRepositoryImpl implements ViewOfertaVueloHelper {

    @PersistenceContext
    private EntityManager manager;

    @SuppressWarnings("unchecked")
    public Page<ViewOfertaVuelo> filtrar(ViewOfertaVueloFilter viewOfertaVueloFilter, Pageable pageable) {
        Criteria criteria = manager.unwrap(Session.class).createCriteria(ViewOfertaVuelo.class);

        int paginaAtual = pageable.getPageNumber();
        int totalRegistrosPorPagina = pageable.getPageSize();
        int primeiroRegistro = paginaAtual * totalRegistrosPorPagina;

        criteria.setFirstResult(primeiroRegistro);
        criteria.setMaxResults(totalRegistrosPorPagina);
        addFilter(viewOfertaVueloFilter, criteria);

        return new PageImpl<>(criteria.list(), pageable, total(viewOfertaVueloFilter));
    }
    private Long total(ViewOfertaVueloFilter viewOfertaVueloFilter) {

        Criteria criteria = manager.unwrap(Session.class).createCriteria(Usuario.class);
        addFilter(viewOfertaVueloFilter, criteria);
        criteria.setProjection(Projections.rowCount());
        return (Long) criteria.uniqueResult();
    }



    private void addFilter(ViewOfertaVueloFilter viewOfertaVueloFilter, Criteria criteria){
        if(viewOfertaVueloFilter!= null){
            if(viewOfertaVueloFilter.getIdent()!=null){
                criteria.add(Restrictions.eq("identificador", viewOfertaVueloFilter.getIdent()));
            }
        }
    }




}

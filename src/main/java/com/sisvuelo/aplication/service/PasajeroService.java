package com.sisvuelo.aplication.service;

import com.sisvuelo.aplication.model.Pasajero;
import com.sisvuelo.aplication.repository.PasajeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PasajeroService {
    private String errorDelete = "this record is related to other tables.";

    @Autowired
    private PasajeroRepository pasajeroRepository;

    @Transactional
    public void save(Pasajero pasajero){
        pasajeroRepository.save(pasajero);

    }

    @Transactional
    public void delete(Pasajero pasajero){
        try {
            pasajeroRepository.delete(pasajero);
        }catch (Exception e){
            if (e instanceof org.hibernate.exception.ConstraintViolationException
                    || e instanceof DataIntegrityViolationException) {
                throw new IllegalArgumentException(errorDelete);
            }
            throw e;
        }
    }

}

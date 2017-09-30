/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autocar.dao.impl;

import com.autocar.dao.CarroDAO;
import com.autocar.dao.GenericDAO;
import com.autocar.model.Carro;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author lucas kolecha
 */
@ApplicationScoped
public class CarroDAOImpl extends GenericDAO<Carro, Long> implements CarroDAO {

    private static final Logger LOG = LoggerFactory.getLogger(CarroDAOImpl.class);

    public CarroDAOImpl() {
        super(Carro.class);
    }

    @Override
    public Logger getLogger() {
        return LOG;
    }

    @Override
    public List<Carro> findByAno(int ano) {
        Query query = getEntityManager().createNamedQuery("Carro.findByAno", Carro.class);
        query.setParameter("ano", ano);

        List<Carro> carros = query.getResultList();
        if (carros == null || carros.isEmpty()) {
            return null;
        } else {
            return carros;
        }
    }
    
    @Override
    public Carro findByModelo(String modelo) {

        Query query = getEntityManager().createNamedQuery("Carro.findByModelo", Carro.class);
        query.setParameter("modelo", modelo);

        List<Carro> carros = query.getResultList();
        if (carros == null || carros.isEmpty()) {
            throw new NonUniqueResultException();
        } else {
            return carros.get(0);
        }

    }
    
    @Override
    public Carro findByCor(String cor) {

        Query query = getEntityManager().createNamedQuery("Carro.findByCor", Carro.class);
        query.setParameter("cor", cor);

        List<Carro> carros = query.getResultList();
        if (carros == null || carros.isEmpty()) {
            throw new NonUniqueResultException();
        } else {
            return carros.get(0);
        }

    }
    
    
}

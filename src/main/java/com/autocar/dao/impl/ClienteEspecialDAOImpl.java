/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autocar.dao.impl;

import com.autocar.dao.ClienteEspecialDAO;
import com.autocar.dao.GenericDAO;
import com.autocar.model.ClienteEspecial;
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
public class ClienteEspecialDAOImpl extends GenericDAO<ClienteEspecial, Long> implements ClienteEspecialDAO {

    private static final Logger LOG = LoggerFactory.getLogger(ClienteEspecialDAOImpl.class);

    public ClienteEspecialDAOImpl() {
        super(ClienteEspecial.class);
    }

    @Override
    public Logger getLogger() {
        return LOG;
    }

    @Override
    public ClienteEspecial findByQuilometragemExtra(int quilometragemExtra) {

        Query query = getEntityManager().createNamedQuery("ClienteEspecial.findByQuilometragemExtra", ClienteEspecial.class);
        query.setParameter("quilometragemExtra", quilometragemExtra);

        List<ClienteEspecial> clientesespeciais = query.getResultList();
        if (clientesespeciais == null || clientesespeciais.isEmpty()) {
            throw new NonUniqueResultException();
        } else {
            return clientesespeciais.get(0);
        }

    }

    @Override
    public ClienteEspecial findByTaxaDesconto(float taxaDesconto) {

        Query query = getEntityManager().createNamedQuery("ClienteEspecial.findByTaxaDesconto", ClienteEspecial.class);
        query.setParameter("taxaDesconto", taxaDesconto);

        List<ClienteEspecial> clientesespeciais = query.getResultList();
        if (clientesespeciais == null || clientesespeciais.isEmpty()) {
            throw new NonUniqueResultException();
        } else {
            return clientesespeciais.get(0);
        }

    }

}

package com.autocar.dao.impl;

import com.autocar.dao.ClienteDAO;
import com.autocar.dao.GenericDAO;
import com.autocar.model.Cliente;
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
public class ClienteDAOImpl extends GenericDAO<Cliente, Long> implements ClienteDAO {

    private static final Logger LOG = LoggerFactory.getLogger(ClienteDAOImpl.class);

    public ClienteDAOImpl() {
        super(Cliente.class);
    }

    @Override
    public Logger getLogger() {
        return LOG;
    }

    @Override
    public List<Cliente> findByContato(String contato) {
        Query query = getEntityManager().createNamedQuery("Cliente.findByContato", Cliente.class);
        query.setParameter("contato", contato);

        List<Cliente> clientes = query.getResultList();
        if (clientes == null || clientes.isEmpty()) {
            return null;
        } else {
            return clientes;
        }
    }

    @Override
    public Cliente findByCpf(String cpf) {

        Query query = getEntityManager().createNamedQuery("Cliente.findByCpf", Cliente.class);
        query.setParameter("cpf", cpf);

        List<Cliente> clientes = query.getResultList();
        if (clientes == null || clientes.isEmpty()) {
            throw new NonUniqueResultException();
        } else {
            return clientes.get(0);
        }

    }

    @Override
    public Cliente findByEndereco(String endereco) {

        Query query = getEntityManager().createNamedQuery("Cliente.findByEndereco", Cliente.class);
        query.setParameter("endereco", endereco);

        List<Cliente> clientes = query.getResultList();
        if (clientes == null || clientes.isEmpty()) {
            throw new NonUniqueResultException();
        } else {
            return clientes.get(0);
        }

    }

}

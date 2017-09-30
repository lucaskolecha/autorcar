package com.autocar.dao.impl;

import com.autocar.dao.GenericDAO;
import com.autocar.dao.LocadoraDAO;
import com.autocar.model.Locadora;
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
public class LocadoraDAOImpl extends GenericDAO<Locadora, Long> implements LocadoraDAO {

    private static final Logger LOG = LoggerFactory.getLogger(LocadoraDAOImpl.class);

    public LocadoraDAOImpl() {
        super(Locadora.class);
    }

    @Override
    public Logger getLogger() {
        return LOG;
    }

    @Override
    public Locadora findByCnpj(String cnpj) {

        Query query = getEntityManager().createNamedQuery("Locadora.findByCnpj", Locadora.class);
        query.setParameter("cnpj", cnpj);

        List<Locadora> locadoras = query.getResultList();
        if (locadoras == null || locadoras.isEmpty()) {
            throw new NonUniqueResultException();
        } else {
            return locadoras.get(0);
        }

    }
    
    @Override
    public List<Locadora> findByEndereco(String endereco) {
        Query query = getEntityManager().createNamedQuery("Locadora.findByEndereco", Locadora.class);
        query.setParameter("endereco", endereco);

        List<Locadora> locadoras = query.getResultList();
        if (locadoras == null || locadoras.isEmpty()) {
            return null;
        } else {
            return locadoras;
        }
    }

}

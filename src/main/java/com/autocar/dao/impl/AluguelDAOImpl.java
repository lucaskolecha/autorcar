package com.autocar.dao.impl;

import com.autocar.dao.AluguelDAO;
import com.autocar.dao.GenericDAO;
import com.autocar.model.Aluguel;
import java.util.Date;
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
public class AluguelDAOImpl extends GenericDAO<Aluguel, Long> implements AluguelDAO {

    private static final Logger LOG = LoggerFactory.getLogger(AluguelDAOImpl.class);

    public AluguelDAOImpl() {
        super(Aluguel.class);
    }

    @Override
    public Logger getLogger() {
        return LOG;
    }

    @Override
    public Aluguel findByDataAluguel(Date dataAluguel) {

        Query query = getEntityManager().createNamedQuery("Aluguel.findByDataAluguel", Aluguel.class);
        query.setParameter("dataAluguel", dataAluguel);

        List<Aluguel> aluguels = query.getResultList();
        if (aluguels == null || aluguels.isEmpty()) {
            throw new NonUniqueResultException();
        } else {
            return aluguels.get(0);
        }

    }

    @Override
    public Aluguel findByQuilometragem(int quilometragem) {

        Query query = getEntityManager().createNamedQuery("Aluguel.findByQuilometragem", Aluguel.class);
        query.setParameter("quilometragem", quilometragem);

        List<Aluguel> aluguels = query.getResultList();
        if (aluguels == null || aluguels.isEmpty()) {
            throw new NonUniqueResultException();
        } else {
            return aluguels.get(0);
        }

    }

    @Override
    public Aluguel findByValorAluguel(float valorAluguel) {

        Query query = getEntityManager().createNamedQuery("Aluguel.findByValorAluguel", Aluguel.class);
        query.setParameter("valorAluguel", valorAluguel);

        List<Aluguel> aluguels = query.getResultList();
        if (aluguels == null || aluguels.isEmpty()) {
            throw new NonUniqueResultException();
        } else {
            return aluguels.get(0);
        }

    }

}

package com.autocar.service.impl;

import com.autocar.dao.CarroDAO;
import com.autocar.dao.DAO;
import com.autocar.model.Carro;
import com.autocar.service.CarroService;
import com.autocar.service.GenericCRUDRestService;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author lucas kolecha
 */
public class CarroRestService extends GenericCRUDRestService<Carro> implements CarroService {

    private static final Logger LOG = LoggerFactory.getLogger(CarroRestService.class);

    @Inject
    private CarroDAO carroDAO;

    public CarroRestService() {
        super(Carro.class);
    }

    @Override
    public GenericEntity listToGenericEntity(List<Carro> list) {
        return new GenericEntity<List<Carro>>(list) {
        };
    }

    @Override
    public DAO getDao() {
        return carroDAO;
    }

    @Override
    public Logger getLogger() {
        return LOG;
    }

    @GET
    @Path("/ano/{param}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Override
    public List<Carro> findByAno(@PathParam("param") int ano) {
        getLogger().debug("Search Carro object by ano: {}", ano);
        List<Carro> found = carroDAO.findByAno(ano);
        if (found == null) {
            return null;
        }
        return found;
    }

    @GET
    @Path("/modelo/{param}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Override
    public Response getByModelo(@PathParam("param") String modelo) {
        getLogger().debug("Search Carro object by modelo: {}", modelo);
        Carro found = carroDAO.findByModelo(modelo);
        if (found == null) {
            return Response.noContent().build();
        }
        return Response.ok().entity(found).build();
    }

    @GET
    @Path("/cor/{param}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Override
    public Response getByCor(@PathParam("param") String cor) {
        getLogger().debug("Search Carro object by cor: {}", cor);
        Carro found = carroDAO.findByModelo(cor);
        if (found == null) {
            return Response.noContent().build();
        }
        return Response.ok().entity(found).build();
    }

}

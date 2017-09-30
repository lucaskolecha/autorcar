package com.autocar.service.impl;

import com.autocar.dao.AluguelDAO;
import com.autocar.dao.DAO;
import com.autocar.model.Aluguel;
import com.autocar.service.AluguelService;
import com.autocar.service.GenericCRUDRestService;
import java.util.Date;
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
public class AluguelRestService extends GenericCRUDRestService<Aluguel> implements AluguelService {

    private static final Logger LOG = LoggerFactory.getLogger(AluguelRestService.class);

    @Inject
    private AluguelDAO aluguelDAO;

    public AluguelRestService() {
        super(Aluguel.class);
    }

    @Override
    public GenericEntity listToGenericEntity(List<Aluguel> list) {
        return new GenericEntity<List<Aluguel>>(list) {
        };
    }

    @Override
    public DAO getDao() {
        return aluguelDAO;
    }

    @Override
    public Logger getLogger() {
        return LOG;
    }

    @GET
    @Path("/dataAluguel/{param}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Override
    public Response getByDataAluguel(@PathParam("param") Date dataAluguel) {
        getLogger().debug("Search Aluguel object by dataAluguel: {}", dataAluguel);
        Aluguel found = aluguelDAO.findByDataAluguel(dataAluguel);
        if (found == null) {
            return Response.noContent().build();
        }
        return Response.ok().entity(found).build();
    }

    @GET
    @Path("/quilometragem/{param}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Override
    public Response getByQuilometragem(@PathParam("param") int quilometragem) {
        getLogger().debug("Search Aluguel object by quilometragem: {}", quilometragem);
        Aluguel found = aluguelDAO.findByQuilometragem(quilometragem);
        if (found == null) {
            return Response.noContent().build();
        }
        return Response.ok().entity(found).build();
    }

    @GET
    @Path("/valorAluguel/{param}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Override
    public Response getByValorAluguel(float valorAluguel) {
        getLogger().debug("Search Aluguel object by valorAluguel: {}", valorAluguel);
        Aluguel found = aluguelDAO.findByValorAluguel(valorAluguel);
        if (found == null) {
            return Response.noContent().build();
        }
        return Response.ok().entity(found).build();
    }

}

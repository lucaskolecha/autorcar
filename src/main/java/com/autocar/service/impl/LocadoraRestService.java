package com.autocar.service.impl;

import com.autocar.dao.DAO;
import com.autocar.dao.LocadoraDAO;
import com.autocar.model.Locadora;
import com.autocar.service.GenericCRUDRestService;
import com.autocar.service.LocadoraService;
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
public class LocadoraRestService extends GenericCRUDRestService<Locadora> implements LocadoraService {

    private static final Logger LOG = LoggerFactory.getLogger(LocadoraRestService.class);

    @Inject
    private LocadoraDAO locadoraDAO;

    public LocadoraRestService() {
        super(Locadora.class);
    }

    @Override
    public GenericEntity listToGenericEntity(List<Locadora> list) {
        return new GenericEntity<List<Locadora>>(list) {
        };
    }

    @Override
    public DAO getDao() {
        return locadoraDAO;
    }

    @Override
    public Logger getLogger() {
        return LOG;
    }

    @GET
    @Path("/cnpj/{param}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Override
    public Response getByCnpj(@PathParam("param") String cnpj) {
        getLogger().debug("Search Locadora object by cnpj: {}", cnpj);
        Locadora found = locadoraDAO.findByCnpj(cnpj);
        if (found == null) {
            return Response.noContent().build();
        }
        return Response.ok().entity(found).build();
    }

    @GET
    @Path("/endereco/{param}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Override
    public List<Locadora> findByEndereco(@PathParam("param") String endereco) {
        getLogger().debug("Search Locadora object by endereco: {}", endereco);
        List<Locadora> found = locadoraDAO.findByEndereco(endereco);
        if (found == null) {
            return null;
        }
        return found;
    }

}

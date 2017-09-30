package com.autocar.service.impl;

import com.autocar.dao.ClienteEspecialDAO;
import com.autocar.dao.DAO;
import com.autocar.model.ClienteEspecial;
import com.autocar.service.ClienteEspecialService;
import com.autocar.service.GenericCRUDRestService;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
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
public class ClienteEspecialRestService extends GenericCRUDRestService<ClienteEspecial> implements ClienteEspecialService {

    private static final Logger LOG = LoggerFactory.getLogger(ClienteEspecialRestService.class);

    @Inject
    private ClienteEspecialDAO clienteEspecialDAO;

    public ClienteEspecialRestService() {
        super(ClienteEspecial.class);
    }

    @Override
    public GenericEntity listToGenericEntity(List<ClienteEspecial> list) {
        return new GenericEntity<List<ClienteEspecial>>(list) {
        };
    }

    @Override
    public DAO getDao() {
        return clienteEspecialDAO;
    }

    @Override
    public Logger getLogger() {
        return LOG;
    }

    @GET
    @Path("/quilometragemExtra/{param}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Override
    public Response getByQuilometragemExtra(int quilometragemExtra) {
        getLogger().debug("Search ClienteEspecial object by quilometragemExtra: {}", quilometragemExtra);
        ClienteEspecial found = clienteEspecialDAO.findByQuilometragemExtra(quilometragemExtra);
        if (found == null) {
            return Response.noContent().build();
        }
        return Response.ok().entity(found).build();
    }

    @GET
    @Path("/taxaDesconto/{param}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Override
    public Response getByTaxaDesconto(float taxaDesconto) {
        getLogger().debug("Search ClienteEspecial object by taxaDesconto: {}", taxaDesconto);
        ClienteEspecial found = clienteEspecialDAO.findByTaxaDesconto(taxaDesconto);
        if (found == null) {
            return Response.noContent().build();
        }
        return Response.ok().entity(found).build();
    }

}

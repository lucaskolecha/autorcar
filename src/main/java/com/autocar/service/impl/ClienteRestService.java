package com.autocar.service.impl;

import com.autocar.dao.ClienteDAO;
import com.autocar.dao.DAO;
import com.autocar.model.Cliente;
import com.autocar.service.ClienteService;
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
public class ClienteRestService extends GenericCRUDRestService<Cliente> implements ClienteService {

    private static final Logger LOG = LoggerFactory.getLogger(ClienteRestService.class);

    @Inject
    private ClienteDAO clienteDAO;

    public ClienteRestService() {
        super(Cliente.class);
    }

    @Override
    public GenericEntity listToGenericEntity(List<Cliente> list) {
        return new GenericEntity<List<Cliente>>(list) {
        };
    }

    @Override
    public DAO getDao() {
        return clienteDAO;
    }

    @Override
    public Logger getLogger() {
        return LOG;
    }

    @GET
    @Path("/contato/{param}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Override
    public List<Cliente> findByContato(@PathParam("param") String contato) {
    getLogger().debug("Search Cliente object by contato: {}", contato);
    List<Cliente> found = clienteDAO.findByContato(contato);
    if (found == null) {
        return null;
    }
    return found;
    }

    @GET
    @Path("/cpf/{param}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Override
    public Response getByCpf(@PathParam("param") String cpf) {
        getLogger().debug("Search Cliente object by cpf: {}", cpf);
        Cliente found = clienteDAO.findByCpf(cpf);
        if (found == null) {
            return Response.noContent().build();
        }
        return Response.ok().entity(found).build();
    }

    @GET
    @Path("/endereco/{param}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Override
    public Response getByEndereco(@PathParam("param") String endereco) {
        getLogger().debug("Search Cliente object by endereco: {}", endereco);
        Cliente found = clienteDAO.findByEndereco(endereco);
        if (found == null) {
            return Response.noContent().build();
        }
        return Response.ok().entity(found).build();
    }

}

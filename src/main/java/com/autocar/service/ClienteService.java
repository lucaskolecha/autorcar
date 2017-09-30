/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autocar.service;

import com.autocar.model.Cliente;
import java.util.List;
import javax.ws.rs.core.Response;

/**
 *
 * @author lucas kolecha
 */
public interface ClienteService extends CRUDRestService<Cliente> {

    List<Cliente> findByContato(String contato);

    Response getByCpf(String cpf);

    Response getByEndereco(String endereco);

}

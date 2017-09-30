/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autocar.service;

import com.autocar.model.Locadora;
import java.util.List;
import javax.ws.rs.core.Response;

/**
 *
 * @author lucas kolecha
 */
public interface LocadoraService extends CRUDRestService<Locadora> {

    Response getByCnpj(String cnpj);

    List<Locadora> findByEndereco(String endereco);

}

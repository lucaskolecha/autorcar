/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autocar.service;

import com.autocar.model.ClienteEspecial;
import javax.ws.rs.core.Response;

/**
 *
 * @author lucas kolecha
 */
public interface ClienteEspecialService extends CRUDRestService<ClienteEspecial> {

    Response getByQuilometragemExtra(int quilometragemExtra);

    Response getByTaxaDesconto(float taxaDesconto);

}

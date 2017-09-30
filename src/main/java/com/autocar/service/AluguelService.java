/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autocar.service;

import com.autocar.model.Aluguel;
import java.util.Date;
import javax.ws.rs.core.Response;

/**
 *
 * @author lucas kolecha
 */
public interface AluguelService extends CRUDRestService<Aluguel> {

    Response getByDataAluguel(Date dataAluguel);

    Response getByQuilometragem(int quilometragem);

    Response getByValorAluguel(float valorAluguel);

}

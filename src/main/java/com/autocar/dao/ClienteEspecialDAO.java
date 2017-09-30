/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autocar.dao;

import com.autocar.model.ClienteEspecial;

/**
 *
 * @author lucas kolecha
 */
public interface ClienteEspecialDAO extends DAO<ClienteEspecial, Long> {

    ClienteEspecial findByQuilometragemExtra(int quilometragemExtra);

    ClienteEspecial findByTaxaDesconto(float taxaDesconto);
}

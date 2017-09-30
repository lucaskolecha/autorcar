package com.autocar.dao;

import com.autocar.model.Locadora;
import java.util.List;

/**
 *
 * @author lucas kolecha
 */
public interface LocadoraDAO extends DAO<Locadora, Long> {

    Locadora findByCnpj(String cnpj);

    List<Locadora> findByEndereco(String endereco);

}

package com.autocar.dao;

import com.autocar.model.Carro;
import java.util.List;

/**
 *
 * @author lucas kolecha
 */
public interface CarroDAO extends DAO<Carro, Long> {

    List<Carro> findByAno(int ano);

    Carro findByModelo(String modelo);

    Carro findByCor(String cor);

}

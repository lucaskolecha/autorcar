package com.autocar.dao;

import com.autocar.model.Aluguel;
import java.util.Date;

/**
 *
 * @author lucas kolecha
 */
public interface AluguelDAO extends DAO<Aluguel, Long> {

    Aluguel findByDataAluguel(Date dataAluguel);

    Aluguel findByQuilometragem(int quilometragem);

    Aluguel findByValorAluguel(float valorAluguel);

}

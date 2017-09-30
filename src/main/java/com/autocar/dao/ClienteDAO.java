package com.autocar.dao;

import com.autocar.model.Cliente;
import java.util.List;

/**
 *
 * @author lucas kolecha
 */
public interface ClienteDAO extends DAO<Cliente, Long> {

    List<Cliente> findByContato(String contato);

    Cliente findByCpf(String cpf);

    Cliente findByEndereco(String endereco);
}

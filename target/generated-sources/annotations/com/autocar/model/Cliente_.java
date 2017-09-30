package com.autocar.model;

import com.autocar.model.Aluguel;
import com.autocar.model.ClienteEspecial;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-09-28T22:56:13")
@StaticMetamodel(Cliente.class)
public class Cliente_ extends AbstractEntity_ {

    public static volatile SingularAttribute<Cliente, String> endereco;
    public static volatile ListAttribute<Cliente, Aluguel> aluguel;
    public static volatile SingularAttribute<Cliente, String> cpf;
    public static volatile SingularAttribute<Cliente, ClienteEspecial> clienteEspecial;
    public static volatile SingularAttribute<Cliente, String> contato;

}
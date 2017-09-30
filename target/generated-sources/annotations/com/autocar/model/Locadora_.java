package com.autocar.model;

import com.autocar.model.Carro;
import com.autocar.model.Cliente;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-09-28T22:56:13")
@StaticMetamodel(Locadora.class)
public class Locadora_ extends AbstractEntity_ {

    public static volatile ListAttribute<Locadora, Carro> carro;
    public static volatile ListAttribute<Locadora, Cliente> cliente;
    public static volatile SingularAttribute<Locadora, String> endereco;
    public static volatile SingularAttribute<Locadora, String> cnpj;

}
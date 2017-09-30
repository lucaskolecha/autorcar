package com.autocar.model;

import com.autocar.model.Carro;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-09-28T22:56:13")
@StaticMetamodel(Aluguel.class)
public class Aluguel_ extends AbstractEntity_ {

    public static volatile SingularAttribute<Aluguel, Carro> carro;
    public static volatile SingularAttribute<Aluguel, Float> valorAluguel;
    public static volatile SingularAttribute<Aluguel, Date> dataAluguel;
    public static volatile SingularAttribute<Aluguel, Integer> quilometragem;

}
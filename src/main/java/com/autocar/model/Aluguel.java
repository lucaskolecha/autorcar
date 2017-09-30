package com.autocar.model;

import java.util.Date;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lucas kolecha
 */
@Entity
@Table(name = "aluguels")
@NamedQueries({
    @NamedQuery(name = "Aluguel.findByDataAluguel", query = "select p from Aluguel p where p.dataAluguel = :dataAluguel")
    ,
    @NamedQuery(name = "Aluguel.findByQuilometragem", query = "select p form Aluguel p where p.quilometragem = :quilometragem")
    ,
    @NamedQuery(name = "Aluguel.findByValorAluguel", query = "select p form Aluguel p where p.valorAluguel = :valorAluguel")
})
@XmlRootElement
public class Aluguel extends AbstractEntity {

    @Column(nullable = false)
    private Date dataAluguel;

    @Column(nullable = false)
    private int quilometragem;

    @Column(nullable = false)
    private float valorAluguel;

    @OneToOne(cascade = CascadeType.ALL)
    private Carro carro;

    public Aluguel() {
    }

    public Aluguel(Date dataAluguel, int quilometragem, float valorAluguel, Carro carro) {
        this.dataAluguel = dataAluguel;
        this.quilometragem = quilometragem;
        this.valorAluguel = valorAluguel;
        this.carro = carro;
    }

    public Date getDataAluguel() {
        return dataAluguel;
    }

    public void setDataAluguel(Date dataAluguel) {
        this.dataAluguel = dataAluguel;
    }

    public int getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(int quilometragem) {
        this.quilometragem = quilometragem;
    }

    public float getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(float valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.dataAluguel);
        hash = 23 * hash + this.quilometragem;
        hash = 23 * hash + Float.floatToIntBits(this.valorAluguel);
        hash = 23 * hash + Objects.hashCode(this.carro);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Aluguel other = (Aluguel) obj;
        return true;
    }

    @Override
    public String toString() {
        return "Aluguel{" + "dataAluguel=" + dataAluguel + ", quilometragem=" + quilometragem + ", valorAluguel=" + valorAluguel + ", carro=" + carro + '}';
    }

    @Override
    public void updateParameters(Object entity) {
        final Aluguel other = (Aluguel) entity;
        this.dataAluguel = other.dataAluguel;
        this.quilometragem = other.quilometragem;
        this.valorAluguel = other.valorAluguel;
    }

}

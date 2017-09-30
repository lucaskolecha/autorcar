/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autocar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author lucas kolecha
 */
@Entity
@Table(name = "clientesespeciais")
@NamedQueries({
    @NamedQuery(name = "ClienteEspecial.findByQuilometragemExtra", query = "select p from ClienteEspecial p where p.quilometragemExtra = :quilometragemExtra")
    ,
    @NamedQuery(name = "ClienteEspecial.findByTaxaDesconto", query = "select p from ClienteEspecial p where p.taxaDesconto = :taxaDesconto")
})
public class ClienteEspecial extends AbstractEntity {

    @Column(nullable = false)
    private int quilometragemExtra;

    @Column(nullable = false)
    private float taxaDesconto;

    public ClienteEspecial() {
    }

    public ClienteEspecial(int quilometragemExtra, float taxaDesconto) {
        this.quilometragemExtra = quilometragemExtra;
        this.taxaDesconto = taxaDesconto;
    }

    public int getQuilometragemExtra() {
        return quilometragemExtra;
    }

    public void setQuilometragemExtra(int quilometragemExtra) {
        this.quilometragemExtra = quilometragemExtra;
    }

    public float getTaxaDesconto() {
        return taxaDesconto;
    }

    public void setTaxaDesconto(float taxaDesconto) {
        this.taxaDesconto = taxaDesconto;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.quilometragemExtra;
        hash = 71 * hash + Float.floatToIntBits(this.taxaDesconto);
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
        final ClienteEspecial other = (ClienteEspecial) obj;
        if (this.quilometragemExtra != other.quilometragemExtra) {
            return false;
        }
        if (Float.floatToIntBits(this.taxaDesconto) != Float.floatToIntBits(other.taxaDesconto)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ClienteEspecial{" + "quilometragemExtra=" + quilometragemExtra + ", taxaDesconto=" + taxaDesconto + '}';
    }

    @Override
    public void updateParameters(Object entity) {
        final ClienteEspecial other = (ClienteEspecial) entity;
        this.quilometragemExtra = other.quilometragemExtra;
        this.taxaDesconto = other.taxaDesconto;
    }

}

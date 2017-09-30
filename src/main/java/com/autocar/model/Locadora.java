/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autocar.model;

import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lucas kolecha
 */
@Entity
@Table(name = "locadoras")
@NamedQueries({
    @NamedQuery(name = "Locadora.findByCnpj", query = "select p from Locadora p where p.cnpj = :cnpj")
    ,
    @NamedQuery(name = "Locadora.findByEndereco", query = "select p from Locadora p where p.endereco = :endereco")
})
@XmlRootElement
public class Locadora extends AbstractEntity {

    @Column(length = 255, nullable = false, unique = true)
    private String cnpj;

    @Column(length = 255, nullable = false)
    private String endereco;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Carro> carro;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Cliente> cliente;

    public Locadora() {
    }

    public Locadora(String cnpj, String endereco, List<Carro> carro, List<Cliente> cliente) {
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.carro = carro;
        this.cliente = cliente;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Carro> getCarro() {
        return carro;
    }

    public void setCarro(List<Carro> carro) {
        this.carro = carro;
    }

    public List<Cliente> getCliente() {
        return cliente;
    }

    public void setCliente(List<Cliente> cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.cnpj);
        hash = 29 * hash + Objects.hashCode(this.endereco);
        hash = 29 * hash + Objects.hashCode(this.carro);
        hash = 29 * hash + Objects.hashCode(this.cliente);
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
        final Locadora other = (Locadora) obj;
        if (!Objects.equals(this.cnpj, other.cnpj)) {
            return false;
        }
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        if (!Objects.equals(this.carro, other.carro)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Locadora{" + "cnpj=" + cnpj + ", endereco=" + endereco + ", carro=" + carro + ", cliente=" + cliente + '}';
    }

    @Override
    public void updateParameters(Object entity) {
        final Locadora other = (Locadora) entity;
        this.cnpj = other.cnpj;
        this.endereco = other.endereco;
        this.carro = other.carro;
        this.cliente = other.cliente;
    }

}

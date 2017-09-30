/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autocar.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lucas kolecha
 */
@Entity
@Table(name = "carros")
@NamedQueries({
    @NamedQuery(name = "Carro.findByAno", query = "select p from Carro p where p.ano = :ano")
    ,
    @NamedQuery(name = "Carro.findByModelo", query = "select p from Carro p where p.modelo = :modelo")
    ,
    @NamedQuery(name = "Carro.findByCor", query = "select p from Carro p where p.cor = :cor")
})
@XmlRootElement
public class Carro extends AbstractEntity {

    @Column(nullable = false)
    private int ano;

    @Column(length = 255, nullable = false)
    private String modelo;

    @Column(length = 255, nullable = false)
    private String cor;

    public Carro() {
    }

    public Carro(int ano, String modelo, String cor) {
        this.ano = ano;
        this.modelo = modelo;
        this.cor = cor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.ano;
        hash = 59 * hash + Objects.hashCode(this.modelo);
        hash = 59 * hash + Objects.hashCode(this.cor);
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
        final Carro other = (Carro) obj;
        if (this.ano != other.ano) {
            return false;
        }
        if (!Objects.equals(this.modelo, other.modelo)) {
            return false;
        }
        if (!Objects.equals(this.cor, other.cor)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Carro{" + "ano=" + ano + ", modelo=" + modelo + ", cor=" + cor + '}';
    }

    @Override
    public void updateParameters(Object entity) {
        final Carro other = (Carro) entity;
        this.ano = other.ano;
        this.modelo = other.modelo;
        this.cor = other.cor;
    }

}

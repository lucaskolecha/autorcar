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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author lucas kolecha
 */
@Entity
@Table(name = "clientes")
@NamedQueries({
    @NamedQuery(name = "Cliente.findByContato", query = "select p from Cliente p where p.contato = :contato")
    ,
    @NamedQuery(name = "Cliente.findByCpf", query = "select p from Cliente p where p.cpf = :cpf")
    ,
    @NamedQuery(name = "Cliente.findByEndereco", query = "select p from Cliente p where p.endereco = :endereco")
})
public class Cliente extends AbstractEntity {

    @Column(length = 255, nullable = false)
    private String contato;

    @Column(length = 255, nullable = false)
    private String cpf;

    @Column(length = 255, nullable = false)
    private String endereco;

    @OneToOne(cascade = CascadeType.ALL)
    private ClienteEspecial clienteEspecial;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Aluguel> aluguel;

    public Cliente() {
    }

    public Cliente(String contato, String cpf, String endereco, ClienteEspecial clienteEspecial, List<Aluguel> aluguel) {
        this.contato = contato;
        this.cpf = cpf;
        this.endereco = endereco;
        this.clienteEspecial = clienteEspecial;
        this.aluguel = aluguel;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public ClienteEspecial getClienteEspecial() {
        return clienteEspecial;
    }

    public void setClienteEspecial(ClienteEspecial clienteEspecial) {
        this.clienteEspecial = clienteEspecial;
    }

    public List<Aluguel> getAluguel() {
        return aluguel;
    }

    public void setAluguel(List<Aluguel> aluguel) {
        this.aluguel = aluguel;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.contato);
        hash = 79 * hash + Objects.hashCode(this.cpf);
        hash = 79 * hash + Objects.hashCode(this.endereco);
        hash = 79 * hash + Objects.hashCode(this.clienteEspecial);
        hash = 79 * hash + Objects.hashCode(this.aluguel);
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
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.contato, other.contato)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        if (!Objects.equals(this.clienteEspecial, other.clienteEspecial)) {
            return false;
        }
        if (!Objects.equals(this.aluguel, other.aluguel)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cliente{" + "contato=" + contato + ", cpf=" + cpf + ", endereco=" + endereco + ", clienteEspecial=" + clienteEspecial + ", aluguel=" + aluguel + '}';
    }

    @Override
    public void updateParameters(Object entity) {
        final Cliente other = (Cliente) entity;
        this.contato = other.contato;
        this.cpf = other.cpf;
        this.endereco = other.endereco;
        this.clienteEspecial = other.clienteEspecial;
        this.aluguel = other.aluguel;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.hotellucena.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author bibim
 */
@Entity
@Table(name = "categoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categoria.findAll", query = "SELECT c FROM Categoria c")
    , @NamedQuery(name = "Categoria.findByCodigoCategoria", query = "SELECT c FROM Categoria c WHERE c.codigoCategoria = :codigoCategoria")
    , @NamedQuery(name = "Categoria.findByCapacidade", query = "SELECT c FROM Categoria c WHERE c.capacidade = :capacidade")
    , @NamedQuery(name = "Categoria.findByTipoCategoria", query = "SELECT c FROM Categoria c WHERE c.tipoCategoria = :tipoCategoria")
    , @NamedQuery(name = "Categoria.findByValorDiaria", query = "SELECT c FROM Categoria c WHERE c.valorDiaria = :valorDiaria")})
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigoCategoria")
    private Integer codigoCategoria;
    @Column(name = "capacidade")
    private Integer capacidade;
    @Size(max = 255)
    @Column(name = "tipoCategoria")
    private String tipoCategoria;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorDiaria")
    private Float valorDiaria;
    @OneToMany(mappedBy = "categoriacodigoCategoria")
    private List<Apartamento> apartamentoList;

    public Categoria() {
    }

    public Categoria(Integer codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    public Integer getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(Integer codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    public String getTipoCategoria() {
        return tipoCategoria;
    }

    public void setTipoCategoria(String tipoCategoria) {
        this.tipoCategoria = tipoCategoria;
    }

    public Float getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(Float valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    @XmlTransient
    public List<Apartamento> getApartamentoList() {
        return apartamentoList;
    }

    public void setApartamentoList(List<Apartamento> apartamentoList) {
        this.apartamentoList = apartamentoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoCategoria != null ? codigoCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.codigoCategoria == null && other.codigoCategoria != null) || (this.codigoCategoria != null && !this.codigoCategoria.equals(other.codigoCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hotel.model.Categoria[ codigoCategoria=" + codigoCategoria + " ]";
    }
    
}

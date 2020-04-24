/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.hotellucena.model;

import br.cesjf.hotellucena.model.Reservas;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bibim
 */
@Entity
@Table(name = "itens")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Itens.findAll", query = "SELECT i FROM Itens i")
    , @NamedQuery(name = "Itens.findByIdItem", query = "SELECT i FROM Itens i WHERE i.idItem = :idItem")
    , @NamedQuery(name = "Itens.findByNomeItem", query = "SELECT i FROM Itens i WHERE i.nomeItem = :nomeItem")
    , @NamedQuery(name = "Itens.findByDescricaoItem", query = "SELECT i FROM Itens i WHERE i.descricaoItem = :descricaoItem")
    , @NamedQuery(name = "Itens.findByValorItem", query = "SELECT i FROM Itens i WHERE i.valorItem = :valorItem")})
public class Itens implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idItem")
    private Integer idItem;
    @Size(max = 255)
    @Column(name = "nomeItem")
    private String nomeItem;
    @Size(max = 255)
    @Column(name = "descricaoItem")
    private String descricaoItem;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorItem")
    private Double valorItem;
    @JoinColumn(name = "codigoReserva", referencedColumnName = "codigoReserva")
    @ManyToOne
    private Reservas codigoReserva;

    public Itens() {
    }

    public Itens(Integer idItem) {
        this.idItem = idItem;
    }

    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    public String getNomeItem() {
        return nomeItem;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    public String getDescricaoItem() {
        return descricaoItem;
    }

    public void setDescricaoItem(String descricaoItem) {
        this.descricaoItem = descricaoItem;
    }

    public Double getValorItem() {
        return valorItem;
    }

    public void setValorItem(Double valorItem) {
        this.valorItem = valorItem;
    }

    public Reservas getCodigoReserva() {
        return codigoReserva;
    }

    public void setCodigoReserva(Reservas codigoReserva) {
        this.codigoReserva = codigoReserva;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idItem != null ? idItem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Itens)) {
            return false;
        }
        Itens other = (Itens) object;
        if ((this.idItem == null && other.idItem != null) || (this.idItem != null && !this.idItem.equals(other.idItem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.cesjf.hotellucena.controller.Itens[ idItem=" + idItem + " ]";
    }
    
}

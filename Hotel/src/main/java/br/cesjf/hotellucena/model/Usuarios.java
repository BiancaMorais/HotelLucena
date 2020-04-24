/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.hotellucena.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u")
    , @NamedQuery(name = "Usuarios.findByIdUsuario", query = "SELECT u FROM Usuarios u WHERE u.idUsuario = :idUsuario")
    , @NamedQuery(name = "Usuarios.findByCodUsuario", query = "SELECT u FROM Usuarios u WHERE u.codUsuario = :codUsuario")
    , @NamedQuery(name = "Usuarios.findByContatoUsuario", query = "SELECT u FROM Usuarios u WHERE u.contatoUsuario = :contatoUsuario")
    , @NamedQuery(name = "Usuarios.findByNomeUsuario", query = "SELECT u FROM Usuarios u WHERE u.nomeUsuario = :nomeUsuario")
    , @NamedQuery(name = "Usuarios.findByTipoUsuariol", query = "SELECT u FROM Usuarios u WHERE u.tipoUsuariol = :tipoUsuariol")
    , @NamedQuery(name = "Usuarios.findByEmail", query = "SELECT u FROM Usuarios u WHERE u.email = :email")
    , @NamedQuery(name = "Usuarios.findBySenha", query = "SELECT u FROM Usuarios u WHERE u.senha = :senha")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idUsuario")
    private Integer idUsuario;
    @Column(name = "codUsuario")
    private Integer codUsuario;
    @Size(max = 255)
    @Column(name = "contatoUsuario")
    private String contatoUsuario;
    @Size(max = 255)
    @Column(name = "nomeUsuario")
    private String nomeUsuario;
    @Size(max = 255)
    @Column(name = "tipoUsuariol")
    private String tipoUsuariol;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "email")
    private String email;
    @Size(max = 30)
    @Column(name = "senha")
    private String senha;

    public Usuarios() {
    }

    public Usuarios(Integer idUsuario, Integer codUsuario, String contatoUsuario, String nomeUsuario, String tipoUsuariol, String email, String senha) {
        this.idUsuario = idUsuario;
        this.codUsuario = codUsuario;
        this.contatoUsuario = contatoUsuario;
        this.nomeUsuario = nomeUsuario;
        this.tipoUsuariol = tipoUsuariol;
        this.email = email;
        this.senha = senha;
    }
    
    

    public Usuarios(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(Integer codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getContatoUsuario() {
        return contatoUsuario;
    }

    public void setContatoUsuario(String contatoUsuario) {
        this.contatoUsuario = contatoUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getTipoUsuariol() {
        return tipoUsuariol;
    }

    public void setTipoUsuariol(String tipoUsuariol) {
        this.tipoUsuariol = tipoUsuariol;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hotel.model.Usuarios[ idUsuario=" + idUsuario + " ]";
    }
    
}

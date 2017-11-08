/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uninphu.models;

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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Portatil-BM
 */
@Entity
@Table(name = "telefono")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Telefono.findAll", query = "SELECT t FROM Telefono t")
    , @NamedQuery(name = "Telefono.findByIdTelefono", query = "SELECT t FROM Telefono t WHERE t.idTelefono = :idTelefono")
    , @NamedQuery(name = "Telefono.findByNumeroTele", query = "SELECT t FROM Telefono t WHERE t.numeroTele = :numeroTele")})
public class Telefono implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTelefono")
    private Integer idTelefono;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NumeroTele")
    private int numeroTele;
    @JoinColumn(name = "DatosUsu_Documento", referencedColumnName = "Documento")
    @ManyToOne(optional = false)
    private Datosusu datosUsuDocumento;

    public Telefono() {
    }

    public Telefono(Integer idTelefono) {
        this.idTelefono = idTelefono;
    }

    public Telefono(Integer idTelefono, int numeroTele) {
        this.idTelefono = idTelefono;
        this.numeroTele = numeroTele;
    }

    public Integer getIdTelefono() {
        return idTelefono;
    }

    public void setIdTelefono(Integer idTelefono) {
        this.idTelefono = idTelefono;
    }

    public int getNumeroTele() {
        return numeroTele;
    }

    public void setNumeroTele(int numeroTele) {
        this.numeroTele = numeroTele;
    }

    public Datosusu getDatosUsuDocumento() {
        return datosUsuDocumento;
    }

    public void setDatosUsuDocumento(Datosusu datosUsuDocumento) {
        this.datosUsuDocumento = datosUsuDocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTelefono != null ? idTelefono.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Telefono)) {
            return false;
        }
        Telefono other = (Telefono) object;
        if ((this.idTelefono == null && other.idTelefono != null) || (this.idTelefono != null && !this.idTelefono.equals(other.idTelefono))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ""+numeroTele;
    }
    
}

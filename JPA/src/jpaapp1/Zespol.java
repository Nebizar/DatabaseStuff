/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaapp1;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author student
 */
@Entity
@Table(name = "ZESPOLY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zespol.findAll", query = "SELECT z FROM Zespol z ORDER BY z.idZesp")
    , @NamedQuery(name = "Zespol.findByIdZesp", query = "SELECT z FROM Zespol z WHERE z.idZesp = :idZesp")
    , @NamedQuery(name = "Zespol.findByNazwa", query = "SELECT z FROM Zespol z WHERE z.nazwa = :nazwa")
    , @NamedQuery(name = "Zespol.findByAdres", query = "SELECT z FROM Zespol z WHERE z.adres = :adres")})
public class Zespol implements Serializable {

    @OneToMany(mappedBy = "idZesp")
    private Collection<Pracownik> pracownikCollection;

    private static final long serialVersionUID = 1L;
    @SequenceGenerator(name="SEQ_JPA_ZESPOLY",sequenceName="SEQ_JPA_ZESPOLY")
    @Id
    @GeneratedValue(strategy=SEQUENCE, generator="SEQ_JPA_ZESPOLY")
    @Column(name = "ID_ZESP")
    private Short idZesp;
    @Column(name = "NAZWA")
    private String nazwa;
    @Column(name = "ADRES")
    private String adres;

    public Zespol() {
    }

    public Zespol(Short idZesp) {
        this.idZesp = idZesp;
    }

    public Short getIdZesp() {
        return idZesp;
    }

    public void setIdZesp(Short idZesp) {
        this.idZesp = idZesp;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idZesp != null ? idZesp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zespol)) {
            return false;
        }
        Zespol other = (Zespol) object;
        if ((this.idZesp == null && other.idZesp != null) || (this.idZesp != null && !this.idZesp.equals(other.idZesp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpaapp1.Zespol[ idZesp=" + idZesp + " ]";
    }

    @XmlTransient
    public Collection<Pracownik> getPracownikCollection() {
        return pracownikCollection;
    }

    public void setPracownikCollection(Collection<Pracownik> pracownikCollection) {
        this.pracownikCollection = pracownikCollection;
    }
    
}

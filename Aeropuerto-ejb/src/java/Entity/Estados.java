/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author white
 */
@Entity
@Table(name = "Estados", schema = "JGCR2019")
@NamedQueries({
    @NamedQuery(name = "findEstados", query = "Select e From Estados e")
})
public class Estados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 35, nullable = false)
    private String nombre;
    
    @JoinColumn(name = "Pais", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Paises pais;
    
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "Estado")
    private List <Ciudades> ciudadesList;
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estados)) {
            return false;
        }
        Estados other = (Estados) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[Estado id=" + id + ", Nombre= "+getNombre()+", Pais= "+getPais().getNombre()+" ]";
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the pais
     */
    public Paises getPais() {
        return pais;
    }

    /**
     * @param pais the pais to set
     */
    public void setPais(Paises pais) {
        this.pais = pais;
    }

    /**
     * @return the ciudadesList
     */
    public List <Ciudades> getCiudadesList() {
        return ciudadesList;
    }

    /**
     * @param ciudadesList the ciudadesList to set
     */
    public void setCiudadesList(List <Ciudades> ciudadesList) {
        this.ciudadesList = ciudadesList;
    }
    
}

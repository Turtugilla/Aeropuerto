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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author white
 */
@Entity
@Table(name = "Paises", schema = "Airport")
@NamedQueries({
    @NamedQuery(name = "findPaises", query = "Select p From Paises p"),
    @NamedQuery(name = "findByNombre",  query = "Select p From Paises p Where p.nombre=:nombrePais")
})
public class Paises implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nombre", length = 35, nullable = false)
    private String nombre;
    
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "Pais")
    private List <Estados> estadosList;

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
        if (!(object instanceof Paises)) {
            return false;
        }
        Paises other = (Paises) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[Pais id=" + id + ", Nombre= "+getNombre()+" ]";
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
     * @return the estadosList
     */
    public List <Estados> getEstadosList() {
        return estadosList;
    }

    /**
     * @param estadosList the estadosList to set
     */
    public void setEstadosList(List <Estados> estadosList) {
        this.estadosList = estadosList;
    }
    
}

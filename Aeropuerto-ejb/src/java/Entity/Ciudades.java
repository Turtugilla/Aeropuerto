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
@Table(name = "Ciudades", schema = "Airport")
@NamedQueries({
    @NamedQuery(name = "findCiudades", query = "Select c From Ciudades c"),
    @NamedQuery(name = "findByPais", query = "Select c From Ciudades c Where c.estado.pais.nombre =:nombrePais")
})
public class Ciudades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 35,nullable = false)
    private String nombre;
    
    @JoinColumn(name = "Estado", referencedColumnName ="id", nullable = false)
    @ManyToOne(optional = false)
    private Estados estado;
    
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "Origen")
    private List <Vuelos> listVuelosOrigen;
    
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "Destino")
    private List <Vuelos> listVuelosDestino;
    
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
        if (!(object instanceof Ciudades)) {
            return false;
        }
        Ciudades other = (Ciudades) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[Ciudad id=" + id + ", Nombre="+getNombre()+", Estado="+getEstado().getNombre()+" ]";
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
     * @return the estado
     */
    public Estados getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(Estados estado) {
        this.estado = estado;
    }

    /**
     * @return the listVuelosOrigen
     */
    public List <Vuelos> getListVuelosOrigen() {
        return listVuelosOrigen;
    }

    /**
     * @param listVuelosOrigen the listVuelosOrigen to set
     */
    public void setListVuelosOrigen(List <Vuelos> listVuelosOrigen) {
        this.listVuelosOrigen = listVuelosOrigen;
    }

    /**
     * @return the listVuelosDestino
     */
    public List <Vuelos> getListVuelosDestino() {
        return listVuelosDestino;
    }

    /**
     * @param listVuelosDestino the listVuelosDestino to set
     */
    public void setListVuelosDestino(List <Vuelos> listVuelosDestino) {
        this.listVuelosDestino = listVuelosDestino;
    }
    
}

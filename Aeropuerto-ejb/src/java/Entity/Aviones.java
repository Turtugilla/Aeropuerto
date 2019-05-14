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
@Table(name = "Aviones", schema = "JGCR2019")
@NamedQueries({
    @NamedQuery(name = "findAviones", query = "Select a From Aviones a"),
    @NamedQuery(name = "findByNumeroAvionPasajeros", query = "Select a From Aviones a Where a.numero_avion=:numeroAvion And a.capacidad_pasajeros=:capacidadPasajeros")
})
public class Aviones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_avion", length = 20, nullable = false)
    private String numero_avion;
    
    @Column(name = "capacidad_pasajeros", nullable = false)
    private int capacidad_pasajeros;
    
    @Column(name = "modelo", length = 25, nullable = false)
    private String modelo;
    
    @Column(name = "Aerolinea", length = 35, nullable = false)
    private String Aerolinea;
    
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "avion")
    private List <Vuelos> vuelosList;
    
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
        if (!(object instanceof Aviones)) {
            return false;
        }
        Aviones other = (Aviones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[Avion id=" + id + ", Numero de Avion="+getNumero_avion()+", Capacidad de Pasajeros="+getCapacidad_pasajeros()+" ]";
    }

    /**
     * @return the numero_avion
     */
    public String getNumero_avion() {
        return numero_avion;
    }

    /**
     * @param numero_avion the numero_avion to set
     */
    public void setNumero_avion(String numero_avion) {
        this.numero_avion = numero_avion;
    }

    /**
     * @return the capacidad_pasajeros
     */
    public int getCapacidad_pasajeros() {
        return capacidad_pasajeros;
    }

    /**
     * @param capacidad_pasajeros the capacidad_pasajeros to set
     */
    public void setCapacidad_pasajeros(int capacidad_pasajeros) {
        this.capacidad_pasajeros = capacidad_pasajeros;
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the Aerolinea
     */
    public String getAerolinea() {
        return Aerolinea;
    }

    /**
     * @param Aerolinea the Aerolinea to set
     */
    public void setAerolinea(String Aerolinea) {
        this.Aerolinea = Aerolinea;
    }

    /**
     * @return the vuelosList
     */
    public List <Vuelos> getVuelosList() {
        return vuelosList;
    }

    /**
     * @param vuelosList the vuelosList to set
     */
    public void setVuelosList(List <Vuelos> vuelosList) {
        this.vuelosList = vuelosList;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author white
 */
@Entity
@Table(name = "Vuelos", schema = "JGCR2019")
@NamedQueries({
    @NamedQuery(name = "findVuelos", query = "Select v From Vuelos v"),
})
public class Vuelos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "numero_vuelo",length = 20, nullable = false)
    private String numero_vuelo;
    
    @JoinColumn(name = "avion", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Aviones avion;
    
    @JoinColumn(name = "Origen", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Ciudades origen;
    
    @JoinColumn(name = "Destino", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Ciudades destino;
    
    @Column(name = "numero_pasajeros")
    private int numero_pasajeros;
    
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fecha_inicio;
    
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fecha_fin;
    
    @Column(name = "hora_inicio")
    @Temporal(TemporalType.TIME)
    private Date hora_inicio;
    
    @Column(name = "hora_fin")
    @Temporal(TemporalType.TIME)
    private Date hora_fin;
    
    
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
        if (!(object instanceof Vuelos)) {
            return false;
        }
        Vuelos other = (Vuelos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[Vuelo Id=" + id + ", \tNumero de Vuelo= "+getNumero_vuelo()+", \tNumero de Avions= "+getAvion().getAerolinea()+
                ", \tOrigen= "+getOrigen().getNombre()+", \tDestiono= "+getDestino().getNombre()+"]";
    }

    /**
     * @return the numero_vuelo
     */
    public String getNumero_vuelo() {
        return numero_vuelo;
    }

    /**
     * @param numero_vuelo the numero_vuelo to set
     */
    public void setNumero_vuelo(String numero_vuelo) {
        this.numero_vuelo = numero_vuelo;
    }

    /**
     * @return the numero_avion
     */
    public Aviones getNumero_avion() {
        return getAvion();
    }

    /**
     * @param numero_avion the numero_avion to set
     */
    public void setNumero_avion(Aviones avion) {
        this.setAvion(avion);
    }

    /**
     * @return the origen
     */
    public Ciudades getOrigen() {
        return origen;
    }

    /**
     * @param origen the origen to set
     */
    public void setOrigen(Ciudades origen) {
        this.origen = origen;
    }

    /**
     * @return the destino
     */
    public Ciudades getDestino() {
        return destino;
    }

    /**
     * @param destino the destino to set
     */
    public void setDestino(Ciudades destino) {
        this.destino = destino;
    }

    /**
     * @return the numero_pasajeros
     */
    public int getNumero_pasajeros() {
        return numero_pasajeros;
    }

    /**
     * @param numero_pasajeros the numero_pasajeros to set
     */
    public void setNumero_pasajeros(int numero_pasajeros) {
        this.numero_pasajeros = numero_pasajeros;
    }

    /**
     * @return the fecha_inicio
     */
    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    /**
     * @param fecha_inicio the fecha_inicio to set
     */
    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    /**
     * @return the fecha_fin
     */
    public Date getFecha_fin() {
        return fecha_fin;
    }

    /**
     * @param fecha_fin the fecha_fin to set
     */
    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    /**
     * @return the hora_inicio
     */
    public Date getHora_inicio() {
        return hora_inicio;
    }

    /**
     * @param hora_inicio the hora_inicio to set
     */
    public void setHora_inicio(Date hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    /**
     * @return the hora_fin
     */
    public Date getHora_fin() {
        return hora_fin;
    }

    /**
     * @param hora_fin the hora_fin to set
     */
    public void setHora_fin(Date hora_fin) {
        this.hora_fin = hora_fin;
    }

    /**
     * @return the avion
     */
    public Aviones getAvion() {
        return avion;
    }

    /**
     * @param avion the avion to set
     */
    public void setAvion(Aviones avion) {
        this.avion = avion;
    }
    
}

package Entity;

import Entity.Vuelos;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-01T23:28:17")
@StaticMetamodel(Aviones.class)
public class Aviones_ { 

    public static volatile SingularAttribute<Aviones, String> numero_avion;
    public static volatile ListAttribute<Aviones, Vuelos> vuelosList;
    public static volatile SingularAttribute<Aviones, String> Aerolinea;
    public static volatile SingularAttribute<Aviones, Long> id;
    public static volatile SingularAttribute<Aviones, Integer> capacidad_pasajeros;
    public static volatile SingularAttribute<Aviones, String> modelo;

}
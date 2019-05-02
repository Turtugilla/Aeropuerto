package Entity;

import Entity.Aviones;
import Entity.Ciudades;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-01T23:28:17")
@StaticMetamodel(Vuelos.class)
public class Vuelos_ { 

    public static volatile SingularAttribute<Vuelos, Date> fecha_inicio;
    public static volatile SingularAttribute<Vuelos, Date> fecha_fin;
    public static volatile SingularAttribute<Vuelos, Date> hora_inicio;
    public static volatile SingularAttribute<Vuelos, Date> hora_fin;
    public static volatile SingularAttribute<Vuelos, Long> id;
    public static volatile SingularAttribute<Vuelos, Ciudades> origen;
    public static volatile SingularAttribute<Vuelos, Ciudades> destino;
    public static volatile SingularAttribute<Vuelos, String> numero_vuelo;
    public static volatile SingularAttribute<Vuelos, Aviones> avion;
    public static volatile SingularAttribute<Vuelos, Integer> numero_pasajeros;

}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.Ciudades;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author white
 */
@Stateless
@LocalBean
public class CiudadesFacade {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @PersistenceContext(unitName = "Evidencia_8-ejbPU")
    private EntityManager em;
    
    public List<Ciudades> findAll(){
        TypedQuery <Ciudades> query;
        query = em.createQuery("Select c From Ciudades c", Ciudades.class);
        return query.getResultList();
    }
    
    public List<Ciudades> finAll2(){
        Query query;
        query = em.createNamedQuery("findCiudades");
        return query.getResultList();
    }
    
    public Ciudades findById(Long idCiudad){
        TypedQuery <Ciudades> query;   
        query = em.createQuery("Select c From Ciudades c Where c.id=:idCiudad", Ciudades.class);
        query.setParameter("idCiudad", idCiudad);
        return query.getSingleResult();
    }
    
    public List<Ciudades> findByEstado(String nombreEstado){
        TypedQuery <Ciudades> query;
        query = em.createQuery("Select c From Ciudades c Where c.estado.nombre =:nombreEstado", Ciudades.class);
        query.setParameter("nombreEstado", nombreEstado);
        return query.getResultList();
    }
    
    public List<Ciudades> findByPais(String nombrePais){
        Query query;
        query = em.createNamedQuery("findByPais");
        query.setParameter("nombrePais", nombrePais);
        return query.getResultList();
    }
    
    public void Insert(Ciudades c){
        em.persist(c);
    }
    
    public void Update(Ciudades c){
        em.merge(c);
    }
    
    public void Delete(Ciudades c){
        em.remove(em.merge(c));
    }
    
    public Ciudades find(Long id){
        return em.find(Ciudades.class, id);
    }
}

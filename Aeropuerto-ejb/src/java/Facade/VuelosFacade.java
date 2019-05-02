/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.Vuelos;
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
public class VuelosFacade {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @PersistenceContext(unitName = "Evidencia_8-ejbPU")
    private EntityManager em;
    
    public List<Vuelos> findAll(){
        TypedQuery <Vuelos> query;
        query = em.createQuery("Select v From Vuelos v", Vuelos.class);
        return query.getResultList();
    }
    
    public List<Vuelos> findAll2(){
        Query query;
        query = em.createNamedQuery("findVuelos");
        return query.getResultList();
    }
    
    public Vuelos findById(Long idVuelo){
        TypedQuery <Vuelos> query;
        query = em.createQuery("Select v  From Vuelos v Where v.id=:idVuelo", Vuelos.class);
        query.setParameter("idVuelo", idVuelo);
        return query.getSingleResult();
    }
    
    public Vuelos findByNumeroVuelo(String numeroVuelo){
        TypedQuery<Vuelos> query;
        query = em.createQuery("Select v From Vuelos v Where v.numero_vuelo=:numeroVuelo", Vuelos.class);
        query.setParameter("numeroVuelo", numeroVuelo);
        
        return query.getSingleResult();
    }
    
    public void Insert(Vuelos v){
        em.persist(v);
    }
    
    public void Update(Vuelos v){
        em.merge(v);
    }
    
    public void Delete(Vuelos v){
        em.remove(em.merge(v));
    }
    
}

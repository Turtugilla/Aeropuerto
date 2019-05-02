/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.Aviones;
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
public class AvionesFacade {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @PersistenceContext(unitName = "Evidencia_8-ejbPU")
    private EntityManager em;
    
    public List<Aviones> findAll(){
        TypedQuery <Aviones> query;
        query = em.createQuery("Select a From Aviones a", Aviones.class);
        
        return query.getResultList();        
    }
    
    public List<Aviones> finAll2(){
            Query query;
            query = em.createNamedQuery("findAviones");
            return query.getResultList();
    }
    
    public Aviones findById(Long idAvion){
        TypedQuery <Aviones> query;
        query = em.createQuery("Select a From Aviones a Where a.id=:idAvion", Aviones.class);
        query.setParameter("idAvion", idAvion);
        return query.getSingleResult();
    }
    
    public Aviones findByNumeroAvion(String numeroAvion){
        TypedQuery <Aviones> query;
        query = em.createQuery("Select a From Aviones a Where a.numero_avion=:numeroAvion", Aviones.class);
        query.setParameter("numeroAvion", numeroAvion);
        return query.getSingleResult();
    }
    
    public Aviones findByNumeroAvionPasajeros(String numeroAvion, int capacidadPasajeros){
        Query query;
        query = em.createNamedQuery("findByNumeroAvionPasajeros");
        query.setParameter("numeroAvion", numeroAvion);
        query.setParameter("capacidadPasajeros", capacidadPasajeros);
        return (Aviones) query.getSingleResult();
        
    }
    
    public void Insert(Aviones a){
        em.persist(a);
    }
    
    public void Update(Aviones a){
        em.merge(a);
    }
    
    public Aviones find(Long id){
        return em.find(Aviones.class, id);
    }
    
    public void Delete(Aviones a){
        em.remove(em.merge(a));
    }
}

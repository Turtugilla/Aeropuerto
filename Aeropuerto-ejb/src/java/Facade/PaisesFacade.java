/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.Paises;
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
public class PaisesFacade {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @PersistenceContext(unitName = "Aeropuerto-ejbPU")
    private EntityManager em;
    
    public List<Paises> finAll(){
        TypedQuery <Paises> query;
        query = em.createQuery("Select p From Paises p", Paises.class);
        return query.getResultList();
    }
    
    public List<Paises> findAll2(){
        Query query;
        query = em.createNamedQuery("findPaises");
        return query.getResultList();
    }
    
    public Paises findById(Long idPais){
        TypedQuery <Paises> query;
        query = em.createQuery("Select p From Paises p Where p.id=:idPais", Paises.class);
        query.setParameter("idPais", idPais);
        return query.getSingleResult();
    }
    
    public Paises findByNombre(String nombrePais){
        Query query;
        query = em.createNamedQuery("findByNombre");
        query.setParameter("nombrePais", nombrePais);
        return (Paises)query.getSingleResult();
    }
    
    public void Insert(Paises p){
        em.persist(p);
    }
    
    public void Update(Paises p){
        em.merge(p);
    }
    
    public void Delete(Paises p){
        em.remove(em.merge(p));
    }
    
    public Paises find(Long id){
        return em.find(Paises.class, id);
    }
}

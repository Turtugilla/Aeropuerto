/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.Estados;
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
public class EstadosFacade {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @PersistenceContext(unitName = "Evidencia_8-ejbPU")
    private EntityManager em;
    
    public List<Estados> findAll(){
        TypedQuery <Estados> query;
        query = em.createQuery("Select e From Estados e", Estados.class);
        return query.getResultList();
    }
    
    public List<Estados> findAll2(){
        Query query;
        query = em.createNamedQuery("findEstados");
        return query.getResultList();
    }
    
    public Estados findById(Long idEstado){
        TypedQuery <Estados> query;
        query = em.createQuery("Select e From Estados e Where e.id=:idEstado", Estados.class);
        
        query.setParameter("idEstado", idEstado);
        return query.getSingleResult();
    }
    
    public void Insert(Estados e){
        em.persist(e);
    }
    
    public void Update(Estados e){
        em.merge(e);
    }
    
    public void Delete(Estados e){
        em.remove(em.merge(e));
    }
    
    public Estados find(Long id){
        return em.find(Estados.class, id);
    }
}

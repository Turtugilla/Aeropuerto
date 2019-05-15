/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author cdis
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "Evidencia_8-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    public Usuario findByEmailAndPass(String nombreUsuario, String pass) {
        TypedQuery<Usuario> query;
        query = em.createQuery("SELECT u FROM Usuario u WHERE u.nombreUsuario=:nombreUsuario AND u.pass=:pass", Usuario.class);
        query.setParameter("nombreUsuario", nombreUsuario);
        query.setParameter("pass", pass);
        try {
            return query.getSingleResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}

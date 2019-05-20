/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Usuario;
import Facade.UsuarioFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 *
 * @author CDIS Desarrollo de Talento
 */
@Named(value = "usuarioController")
@SessionScoped
public class UsuarioController implements Serializable {
    
    
    @EJB
    private UsuarioFacade ejbUsuario;
    private Usuario currentUser;

    /**
     * Creates a new instance of UsuarioController
     */
    public UsuarioController() {
        currentUser = new Usuario();
    }
    
    
    
    public void create(){
        ejbUsuario.create(currentUser);
    }

    /**
     * @return the ejbUsuario
     */
    public UsuarioFacade getEjbUsuario() {
        return ejbUsuario;
    }

    /**
     * @param ejbUsuario the ejbUsuario to set
     */
    public void setEjbUsuario(UsuarioFacade ejbUsuario) {
        this.ejbUsuario = ejbUsuario;
    }

    /**
     * @return the currentUser
     */
    public Usuario getCurrentUser() {
        return currentUser;
    }

    /**
     * @param currentUser the currentUser to set
     */
    public void setCurrentUser(Usuario currentUser) {
        this.currentUser = currentUser;
    }
    
    
    
    
    
    
}

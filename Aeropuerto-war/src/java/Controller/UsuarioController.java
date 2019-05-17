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
import javax.faces.context.FacesContext;

/**
 *
 * @author cdis
 */
@Named(value = "usuarioController")
@SessionScoped
public class UsuarioController implements Serializable {

    @EJB
    private UsuarioFacade usuarioFacade;
    private String nombreUsuario, pass;

    public UsuarioController() {
    }

    public String inicioSesion() {
        Usuario currentUser = getUsuarioFacade().
                findByEmailAndPass(getNombreUsuario(), getPass());

        if (currentUser == null) {
            System.out.println("Usaurio o contraseña incorrecta");
            return null;
        } else {
            FacesContext.getCurrentInstance().getExternalContext().
                    getSessionMap().put("sesionUsuario", currentUser);
            return "index";
        }
    }

    public boolean usuarioLogeado() {
        Usuario usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().
                getSessionMap().get("sesionUsuario");
        
        return usuario != null;
    }
    
    
    public String cerrarSesion(){
        FacesContext.getCurrentInstance().getExternalContext().
                getSessionMap().put("sesionUsuario", null);
        return "/login";
    }

    /**
     * @return the usuarioFacade
     */
    public UsuarioFacade getUsuarioFacade() {
        return usuarioFacade;
    }

    /**
     * @param usuarioFacade the usuarioFacade to set
     */
    public void setUsuarioFacade(UsuarioFacade usuarioFacade) {
        this.usuarioFacade = usuarioFacade;
    }

    /**
     * @return the nombreUsuario
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * @param nombreUsuario the nombreUsuario to set
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

}

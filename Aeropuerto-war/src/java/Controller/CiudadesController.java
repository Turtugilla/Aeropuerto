/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Ciudades;
import Facade.CiudadesFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author white
 */
@Named(value = "ciudadesController")
@SessionScoped
public class CiudadesController implements Serializable {

    @EJB
    private CiudadesFacade ciudadesFacade;
    private Ciudades ciudades = new Ciudades();
    private boolean confirm = false;

    public List<Ciudades> findAll() {
        return ciudadesFacade.findAll();
    }

    public List<Ciudades> findAll2() {
        return ciudadesFacade.finAll2();
    }

    public Ciudades findById(Long idCiudad) {
        return ciudadesFacade.findById(idCiudad);
    }

    public List<Ciudades> findByEstado(String nombreEstado) {
        return ciudadesFacade.findByEstado(nombreEstado);
    }

    public List<Ciudades> findByPais(String nombrePais) {
        return ciudadesFacade.findByPais(nombrePais);
    }

    public String MainClean(String url) {
        ciudades = new Ciudades();
        setConfirm(false);
        return url;
    }

    public void Clean() {
        ciudades = new Ciudades();
    }

    public String Insert() {
        FacesMessage msj;
        try {
            ciudadesFacade.Insert(ciudades);
            msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro " + ciudades.getNombre() + " se agrego correctamente.", "");
            FacesContext.getCurrentInstance().addMessage("ciudadesAlta", msj);
            Clean();
        } catch (Exception e) {
            msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El registro " + ciudades.getNombre() + " no se puedo ingresar. Contacte a soporte", "");
            FacesContext.getCurrentInstance().addMessage("ciudadesAlta", msj);
        }
        return "ciudadesAlta";
    }

    public String prepareEdit(Ciudades c) {
        ciudades = c;
        return "ciudadesEdit";
    }

    public String Update() {
        FacesMessage msj;
        try {
            ciudadesFacade.Update(ciudades);
            msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro " + ciudades.getNombre() + " se actualizó correctamente.", "");
            FacesContext.getCurrentInstance().addMessage("ciudadesEdit", msj);
        } catch (Exception e) {
            msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro " + ciudades.getNombre() + " no pudo ser actualizoado. Contacte con soporte", "");
            FacesContext.getCurrentInstance().addMessage("ciudadesEdit", msj);
        }

        return "";
    }

    public Ciudades find(Long id) {
        return ciudadesFacade.find(id);
    }

    public String prepareDelete() {
        setConfirm(true);
        return "ciudadesList";
    }

    public void Delete(Ciudades c) {
        FacesMessage msj;
        try {
            if (c.getListVuelosOrigen().isEmpty() && c.getListVuelosDestino().isEmpty()) {
                ciudades = c;
                ciudadesFacade.Delete(ciudades);

                msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro " + c.getNombre() + " fue eliminado exitosamente.", "");
                FacesContext.getCurrentInstance().addMessage("ciudadesList", msj);
            } else {
                msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El registro " + c.getNombre() + " no puede ser eliminado por que tiene un Vuelo dependiente.", "");
                FacesContext.getCurrentInstance().addMessage("ciudadesList", msj);
            }

        } catch (Exception e) {
            msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El registro " + ciudades.getNombre() + " no pudo ser eliminado. Contacte a soporte", "");
            FacesContext.getCurrentInstance().addMessage("ciudadesList", msj);
        }
        MainClean("ciudadesList");
    }

    /**
     * @return the ciudades
     */
    public Ciudades getCiudades() {
        return ciudades;
    }

    /**
     * @param ciudades the ciudades to set
     */
    public void setCiudades(Ciudades ciudades) {
        this.ciudades = ciudades;
    }

    /**
     * @return the confirm
     */
    public boolean isConfirm() {
        return confirm;
    }

    /**
     * @param confirm the confirm to set
     */
    public void setConfirm(boolean confirm) {
        this.confirm = confirm;
    }

}

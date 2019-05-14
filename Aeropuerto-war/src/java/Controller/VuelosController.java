/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Vuelos;
import Facade.VuelosFacade;
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
@Named(value = "vuelosController")
@SessionScoped
public class VuelosController implements Serializable {

    @EJB
    private VuelosFacade vuelosFacade;
    private Vuelos vuelos = new Vuelos();
    private boolean confirm = false;

    public List<Vuelos> findAll() {
        return vuelosFacade.findAll();
    }

    public List<Vuelos> findAll2() {
        return vuelosFacade.findAll2();
    }

    public Vuelos findById(Long idVuelo) {
        return vuelosFacade.findById(idVuelo);
    }

    public Vuelos findByNumeroVuelo(String numeroVuelo) {
        return vuelosFacade.findByNumeroVuelo(numeroVuelo);
    }

    public void Clean() {
        vuelos = new Vuelos();
    }

    public String MainClean(String url) {
        vuelos = new Vuelos();
        setConfirm(false);
        return url;
    }

    public String Insert() {
        FacesMessage msj;
        try {
            vuelosFacade.Insert(vuelos);
            msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro " + vuelos.getNumero_vuelo() + " fue agregado correctamente.", "");
            FacesContext.getCurrentInstance().addMessage("vuelosAlta", msj);
            Clean();
        } catch (Exception e) {
            msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El registro " + vuelos.getNumero_vuelo() + " no pudo ser agregado. Contacte con soporte", "");
            FacesContext.getCurrentInstance().addMessage("vuelosAlta", msj);
        }
        return "vuelosAlta?faces-redirect=true";
    }

    public String prepareEdit(Vuelos v) {
        vuelos = v;
        return "vuelosEdit";
    }

    public String Update() {
        FacesMessage msj;
        try {
            vuelosFacade.Update(vuelos);
            msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro " + vuelos.getNumero_vuelo() + " fue actualizado correctamente.", "");
            FacesContext.getCurrentInstance().addMessage("vuelosEdit", msj);
        } catch (Exception e) {
            msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro " + vuelos.getNumero_vuelo() + " no pudo ser actualizado. Contacte con soporte", "");
            FacesContext.getCurrentInstance().addMessage("vuelosEdit", msj);
        }

        return "";
    }

    public String prepareDelete() {
        setConfirm(true);
        return "vuelosList";
    }

    public void Delete(Vuelos v) {
        FacesMessage msj;
        try {
            vuelos = v;
            vuelosFacade.Delete(vuelos);
            msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro " + v.getNumero_vuelo() + " fue eliminado correctamente.", "");
            FacesContext.getCurrentInstance().addMessage("vuelosList", msj);
        } catch (Exception e) {
            msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El registro " + v.getNumero_vuelo() + " no pudo ser eliminado. Contacte con soporte.", "");
            FacesContext.getCurrentInstance().addMessage("vuelosList", msj);
        }
        MainClean("vuelosList");
    }

    /**
     * @return the vuelos
     */
    public Vuelos getVuelos() {
        return vuelos;
    }

    /**
     * @param vuelos the vuelos to set
     */
    public void setVuelos(Vuelos vuelos) {
        this.vuelos = vuelos;
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

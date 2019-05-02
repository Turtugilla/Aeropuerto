/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Aviones;
import Facade.AvionesFacade;
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
@Named(value = "avionesController")
@SessionScoped
public class AvionesController implements Serializable {

    @EJB
    private AvionesFacade avionesFacade;
    private Aviones aviones = new Aviones();
    private boolean confirm = false;

    public List<Aviones> finAll() {
        return avionesFacade.findAll();
    }

    public List<Aviones> finAll2() {
        return avionesFacade.finAll2();
    }

    public Aviones findById(Long idAvion) {
        return avionesFacade.findById(idAvion);
    }

    public Aviones findByNumeroAvionPasajeros(String numeroAvion, int cantidadPasajeros) {
        return avionesFacade.findByNumeroAvionPasajeros(numeroAvion, cantidadPasajeros);
    }

    public Aviones findByNumeroAvion(String numeroAvion) {
        return avionesFacade.findByNumeroAvion(numeroAvion);
    }

    public String Insert() {
        FacesMessage msj;
        try {
            avionesFacade.Insert(aviones);
            msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro " + aviones.getNumero_avion() + " fue agregado existosamente.", "");
            FacesContext.getCurrentInstance().addMessage("avionesAlta", msj);
            Clean();
        } catch (Exception e) {
            msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El registro " + aviones.getNumero_avion() + " no se pudo agregar correctamente. Contacte a soporte", "");
            FacesContext.getCurrentInstance().addMessage("avionesAlta", msj);
        }
        return "avionesAlta";
    }

    public String prepareEdit(Aviones a) {
        aviones = a;
        return "avionesEdit";
    }

    public String update() {
        FacesMessage msj;
        try {
            avionesFacade.Update(aviones);
            msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro " + aviones.getNumero_avion() + " se actualizó existosamente.", "");
            FacesContext.getCurrentInstance().addMessage("avionesEdit", msj);
        } catch (Exception e) {
            msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El registro " + aviones.getNumero_avion() + " no pudo ser actulizado. Contacte a soporte", "");
            FacesContext.getCurrentInstance().addMessage("avionesEdit", msj);
        }

        return "";
    }

    public String MainClean(String url) {
        aviones = new Aviones();
        setConfirm(false);
        return url;
    }

    public void Clean() {
        aviones = new Aviones();
    }

    public Aviones find(Long id) {
        return avionesFacade.find(id);
    }

    public String prepareDelete() {
        setConfirm(true);
        return "avionesList";
    }

    public void Delete(Aviones a) {
        FacesMessage msj;
        try {
            if (a.getVuelosList().isEmpty()) {
                aviones = a;
                avionesFacade.Delete(aviones);
                msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro " + a.getNumero_avion() + " fue eliminado existosamente", "");
                FacesContext.getCurrentInstance().addMessage("avionesList", msj);
            } else {
                msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El registro " + a.getNumero_avion() + " no puede ser eliminado por que tiene un Vuelo dependiente.", "");
                FacesContext.getCurrentInstance().addMessage("avionesList", msj);
            }

        } catch (Exception e) {
            msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El registro " + aviones.getNumero_avion() + " no pudo ser eliminado. Conctacte a soporte", "");
            FacesContext.getCurrentInstance().addMessage("avionesList", msj);
        }
        MainClean("avionesList");
    }

    /**
     * @return the aviones
     */
    public Aviones getAviones() {
        return aviones;
    }

    /**
     * @param aviones the aviones to set
     */
    public void setAviones(Aviones aviones) {
        this.aviones = aviones;
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

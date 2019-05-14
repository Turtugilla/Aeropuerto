/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Paises;
import Facade.AvionesFacade;
import Facade.PaisesFacade;
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
@Named(value = "paisesController")
@SessionScoped
public class PaisesController implements Serializable {

    @EJB
    private PaisesFacade paisesFacade;
    private Paises paises = new Paises();
    private boolean confirm = false;

    public List<Paises> findAll() {
        return paisesFacade.finAll();
    }

    public List<Paises> findAll2() {
        return paisesFacade.findAll2();
    }

    public Paises findById(Long idPais) {
        return paisesFacade.findById(idPais);
    }

    public Paises findByNombre(String nombrePais) {
        return paisesFacade.findByNombre(nombrePais);
    }

    public String Insert() {
        FacesMessage msj;
        try {
            paisesFacade.Insert(paises);
            msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro " + paises.getNombre() + " fue agreagado correctamente.", "");
            FacesContext.getCurrentInstance().addMessage("paisesAlta", msj);
            Clean();
        } catch (Exception e) {
            msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El registro " + paises.getNombre() + " no pudo ser agregado. Contacte con soporte", "");
            FacesContext.getCurrentInstance().addMessage("paisesAlta", msj);
        }
        return "paisesAlta";
    }

    public String prepareEdit(Paises p) {
        paises = p;
        return "paisesEdit";
    }

    public String Update() {
        FacesMessage msj;
        try {
            paisesFacade.Update(paises);

            msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro " + paises.getNombre() + " fue actualizadó correctamente.", "");
            FacesContext.getCurrentInstance().addMessage("paisesList", msj);
        } catch (Exception e) {
            msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El registro " + paises.getNombre() + " no pudo ser actualizado. Contacte con soporte", "");
            FacesContext.getCurrentInstance().addMessage("paisesList", msj);
        }

        return "";
    }

    public String MainClean(String url) {
        paises = new Paises();
        setConfirm(false);
        return url;
    }

    public Paises find(Long id) {
        return paisesFacade.find(id);
    }

    public void Clean() {
        paises = new Paises();
    }

    public String prepareDelete() {
        setConfirm(true);
        return "paisesList";
    }

    public void Delete(Paises p) {
        FacesMessage msj;
        try {
            if (p.getEstadosList().isEmpty()) {
                paises = p;
                paisesFacade.Delete(paises);

                msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro " + p.getNombre() + " fue eliminado correctamente.", "");
                FacesContext.getCurrentInstance().addMessage("paisesList", msj);
            } else {
                msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El registro " + p.getNombre() + " no puede ser eliminado por que tiene Estados dependites.", "");
                FacesContext.getCurrentInstance().addMessage("paisesList", msj);
            }
        } catch (Exception e) {
            msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro " + paises.getNombre() + " el registro no puedo ser eleiminado. Contacte con soporte.", "");
            FacesContext.getCurrentInstance().addMessage("paisesList", msj);
        }
        MainClean("paisesList");
    }

    /**
     * @return the paises
     */
    public Paises getPaises() {
        return paises;
    }

    /**
     * @param paises the paises to set
     */
    public void setPaises(Paises paises) {
        this.paises = paises;
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

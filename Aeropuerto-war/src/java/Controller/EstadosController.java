/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Estados;
import Facade.EstadosFacade;
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
@Named(value = "estadosController")
@SessionScoped
public class EstadosController implements Serializable {

    @EJB
    private EstadosFacade estadosFacade;
    private Estados estados = new Estados();
    private boolean confirm = false;

    public List<Estados> findAll() {
        return estadosFacade.findAll();
    }

    public List<Estados> findAll2() {
        return estadosFacade.findAll2();
    }

    public Estados findById(Long idEstado) {
        return estadosFacade.findById(idEstado);
    }

    public String MainClean(String url) {
        estados = new Estados();
        setConfirm(false);
        return url;
    }

    public void Clean() {
        estados = new Estados();
    }

    public String Insert() {
        FacesMessage msj;
        try {
            estadosFacade.Insert(estados);
            msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro " + estados.getNombre() + " fue agregado exitosamente", "");
            FacesContext.getCurrentInstance().addMessage("estadosAlta", msj);
            Clean();
        } catch (Exception e) {
            msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El registro " + estados.getNombre() + " no pudo ser agregado. Contacte a soporte", "");
            FacesContext.getCurrentInstance().addMessage("estadosAlta", msj);
        }
        return "estadosAlta";
    }

    public String prepareEdit(Estados e) {
        estados = e;
        return "estadosEdit";
    }

    public String Update() {
        FacesMessage msj;
        try {
            estadosFacade.Update(estados);

            msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro " + estados.getNombre() + " fue actualizadó correctamente.", "");
            FacesContext.getCurrentInstance().addMessage("estadosEdit", msj);
        } catch (Exception e) {
            msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro " + estados.getNombre() + " no se pudo actualizar. Contacte a soporte", "");
            FacesContext.getCurrentInstance().addMessage("estadosEdit", msj);
        }

        return "";
    }

    public Estados find(Long id) {
        return estadosFacade.find(id);
    }

    public String preapareDelete() {
        setConfirm(true);
        return "estadosList";
    }

    public void Delete(Estados e) {
        FacesMessage msj;
        try {
            if (e.getCiudadesList().isEmpty()) {
                estados = e;
                estadosFacade.Delete(estados);

                msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro " + e.getNombre() + " fue eliminado exitosamente", "");
                FacesContext.getCurrentInstance().addMessage("estadosList", msj);
            } else {
                msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El registro " + e.getNombre() + " no puedo ser eliminado por que tiene Ciudades dependientes.", "");
                FacesContext.getCurrentInstance().addMessage("estadosList", msj);
            }
        } catch (Exception ex) {
            msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El registro " + estados.getNombre() + " no puedo ser eliminado. Contacte a soporte", "");
            FacesContext.getCurrentInstance().addMessage("estadosList", msj);
        }
        MainClean("estadosList");
    }

    /**
     * @return the estados
     */
    public Estados getEstados() {
        return estados;
    }

    /**
     * @param estados the estados to set
     */
    public void setEstados(Estados estados) {
        this.estados = estados;
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

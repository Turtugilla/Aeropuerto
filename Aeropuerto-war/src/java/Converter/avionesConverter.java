/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import Controller.AvionesController;
import Entity.Aviones;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author white
 */
@FacesConverter(forClass=Aviones.class)
public class avionesConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        AvionesController avionesController = context.getApplication().evaluateExpressionGet(context, "#{avionesController}", AvionesController.class);
        return avionesController.find(Long.parseLong(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Aviones avion = (Aviones) value;
        return avion.getId().toString();
    }
    
}

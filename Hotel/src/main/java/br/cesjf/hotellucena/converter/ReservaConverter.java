/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.hotellucena.converter;

import br.cesjf.hotellucena.model.Reservas;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author bibim
 */
@FacesConverter("reservaConverter")
@ManagedBean
public class ReservaConverter implements Converter{
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if (value != null && !value.isEmpty()) {
            return (Reservas) uic.getAttributes().get(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object value) {
        if (value instanceof Reservas) {
            Reservas reserva = (Reservas) value;
            if (reserva != null && reserva instanceof Reservas && reserva.getCodigoReserva()!= null) {
                uic.getAttributes().put(reserva.getCodigoReserva().toString(), reserva);
                return reserva.getCodigoReserva().toString();
            }
        }
        return "";
    }
}

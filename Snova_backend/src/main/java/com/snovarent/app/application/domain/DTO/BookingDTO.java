package com.spacehotel.app.application.domain.DTO;

import com.sun.istack.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

import java.sql.Date;

public class BookingDTO {

    @NotNull
    @NotEmpty
    public Date fechaIn;

    @NotNull
    @NotEmpty
    public Date fechaOut;

    @NotNull
    @NotEmpty
    public float precioTotal;

    @NotNull
    @NotEmpty
    public long id_habitacion;

    @NotNull
    @NotEmpty
    public long cliente_id;


//-- GEttER's y SetTTers --


    public Date getFechaIn() {
        return fechaIn;
    }

    public void setFechaIn(Date fechaIn) {
        this.fechaIn = fechaIn;
    }

    public Date getFechaOut() {
        return fechaOut;
    }

    public void setFechaOut(Date fechaOut) {
        this.fechaOut = fechaOut;
    }

    public float getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(float precioTotal) {
        this.precioTotal = precioTotal;
    }

    public long getId_habitacion() {
        return id_habitacion;
    }

    public void setId_habitacion(long id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    public long getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(long cliente_id) {
        this.cliente_id = cliente_id;
    }

    @Override
    public String toString() {
        String jsonMsg = "BookingDTO{" +
                  "fechaIn='" + fechaIn + '\'' +
                ", fechaOut='" + fechaOut + '\'' +
                ", precioTotal='" + precioTotal +
                "', id_habitacion='" + id_habitacion +
                "', cliente_id='" + cliente_id +
                "'}";

        return jsonMsg;

    }
}


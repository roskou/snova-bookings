package com.snovarent.app.application.domain.DTO;

import com.sun.istack.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

import java.sql.Date;

public class CostDTO {

    @NotNull
    @NotEmpty
    public Date preCheckIn;

    @NotNull
    @NotEmpty
    public Date preCheckOut;

    @NotNull
    @NotEmpty
    public float precio;

    //Getters -------------------------------------------

    public Date getPreCheckIn() {
        return preCheckIn;
    }

    public Date getPreCheckOut() {
        return preCheckOut;
    }

    public float getPrecio() {
        return precio;
    }
}

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
    public long precio;

    //Getters -------------------------------------------

    public Date getPreCheckIn() {
        return preCheckIn;
    }

    public Date getPreCheckOut() {
        return preCheckOut;
    }

    public long getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "CostDTO{" +
                "preCheckIn='" + preCheckIn + '\'' +
                ", preCheckOut='" + preCheckOut + '\'' +
                ", precio='" + precio + '\'' +
                '}';
    }
}

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
    public long client;

    @NotNull
    @NotEmpty
    public long idRoom;

    public CostDTO(){}

    public CostDTO(Date preCheckIn, Date preCheckOut, long client, long idRoom) {
        this.preCheckIn = preCheckIn;
        this.preCheckOut = preCheckOut;
        this.client = client;
        this.idRoom = idRoom;
    }

    public Date getPreCheckIn() {
        return preCheckIn;
    }

    public void setPreCheckIn(Date preCheckIn) {
        this.preCheckIn = preCheckIn;
    }

    public Date getPreCheckOut() {
        return preCheckOut;
    }

    public void setPreCheckOut(Date preCheckOut) {
        this.preCheckOut = preCheckOut;
    }

    public long getClient() {
        return client;
    }

    public void setClient(long client) {
        this.client = client;
    }

    public long getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(long idRoom) {
        this.idRoom = idRoom;
    }
}

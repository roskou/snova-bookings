package com.snovarent.app.application.domain.DTO;

import com.sun.istack.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

import java.time.LocalDate;
import java.util.Objects;


public class CostDTO {

    @NotNull
    @NotEmpty
    public LocalDate preCheckIn;

    @NotNull
    @NotEmpty
    public LocalDate preCheckOut;

    @NotNull
    @NotEmpty
    public long client;

    @NotNull
    @NotEmpty
    public long idRoom;

    @NotNull
    @NotEmpty
    public long npax;

    //Getters -------------------------------------------

    public LocalDate getPreCheckIn() {
        return preCheckIn;
    }

    public LocalDate getPreCheckOut() {
        return preCheckOut;
    }

    public long getClient() { return client; }

    public long getIdRoom() {
        return idRoom;
    }

    public long getNpax() { return npax; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CostDTO costDTO = (CostDTO) o;
        return idRoom == costDTO.idRoom &&
                Objects.equals(preCheckIn, costDTO.preCheckIn) &&
                Objects.equals(preCheckOut, costDTO.preCheckOut);
    }

    @Override
    public int hashCode() {
        return Objects.hash(preCheckIn, preCheckOut, idRoom);
    }
}

package com.snovarent.app.application.domain.DTO;

import com.sun.istack.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

import java.sql.Date;

public class CostDTO {

    @NotNull
    @NotEmpty
    public Date fechaIn;

    @NotNull
    @NotEmpty
    public Date fechaOut;

    @NotNull
    @NotEmpty
    public float precio;

    @NotNull
    @NotEmpty
    public long cliente_id;
}

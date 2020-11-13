package com.snovarent.app.application.domain.DTO;

import com.sun.istack.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

public class TotalsDTO {
    @NotNull
    @NotEmpty
    public float totalPrice;

    @NotNull
    @NotEmpty
    public float totalDiscount;

    @NotNull
    @NotEmpty
    public long client;

    @NotNull
    @NotEmpty
    public long idRoom;

    @NotNull
    @NotEmpty
    public long npax;

}

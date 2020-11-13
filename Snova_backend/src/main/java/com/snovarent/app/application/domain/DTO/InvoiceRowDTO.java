package com.snovarent.app.application.domain.DTO;

import com.sun.istack.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

public class InvoiceRowDTO {

    @NotNull
    @NotEmpty
    public String description;

    @NotNull
    @NotEmpty
    public long days;

    @NotNull
    @NotEmpty
    public double price;

    public InvoiceRowDTO(String description, long days, double price) {
        this.description = description;
        this.days = days;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getDays() {
        return days;
    }


    public void setDays(long days) {
        this.days = days;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}


package com.snovarent.app.application.domain.DTO;

import com.sun.istack.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.ArrayList;
import java.util.List;

public class InvoiceDTO {

    @NotNull
    @NotEmpty
    public double finalPrice;
    public double additionalCharges;
    public List<InvoiceRowDTO> invoiceRows;

    public InvoiceDTO() {

        this.finalPrice = 0;
        this.additionalCharges = 0;
        this.invoiceRows = new ArrayList<>();
    }


    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public List<InvoiceRowDTO> getInvoice() {
        return invoiceRows;
    }

    public void setInvoice(List<InvoiceRowDTO> invoiceRows) {
        this.invoiceRows = invoiceRows;
    }

    public double getAdditionalCharges() {
        return additionalCharges;
    }

    public void setAdditionalCharges(double additionalCharges) {
        this.additionalCharges = additionalCharges;
    }
}
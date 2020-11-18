package com.snovarent.app.application.services;

import com.snovarent.app.application.domain.DTO.CostDTO;
import com.snovarent.app.application.domain.DTO.InvoiceDTO;

public interface CostService {



    InvoiceDTO getInvoice(CostDTO costData);


}

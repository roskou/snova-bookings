package com.snovarent.app.ui.controllers;


import com.snovarent.app.application.services.CostService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

public class CostAPIControllerTest {
    @MockBean
    private CostService mockCostService;
    @Autowired
    private WebApplicationContext context;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private CostAPIControllerTest costApiControllerTest;

    @Before("")
    public void setup() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
    }

    @Test
    @DisplayName("Endpoint: \"/api/cupon")
    void cuponGenerator() throws Exception {

    }

//    @Test
//    public void ShouldGenerateCupon() throws  Exception{
//        String theCupon="arsgshj";
//        when(mockCostService.cuponGenerator());
//        mockMvc.perform(get("/api/cupon").accept(MediaType.))
//                .andDo(print())
//                .andExpect(status().isOk());
//    }

}

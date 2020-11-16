package com.snovarent.app.ui.controllers;

import com.snovarent.app.ProjectApplication;
import com.snovarent.app.application.models.RoomModel;
import com.snovarent.app.application.services.RoomService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
    @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = ProjectApplication.class)
    class  RestAPIControllerTest {
        @MockBean
        private RoomService mockRoomService;
        @Autowired
        private WebApplicationContext context;
        @Autowired
        private MockMvc mockMvc;
        @Autowired
        private RestAPIController restApiController;
        @Before("")
        public void setup(){
            mockMvc = MockMvcBuilders
                    .webAppContextSetup(context)
                    .build();
        }
        @Test
        @DisplayName("Endpoint: \"/api/flat")
        void showAllRooms() throws Exception{


        }

        @Test
        @DisplayName("Endpoint: \"/api/flatType")
        void tiposHabitacion() throws Exception{
        }

        @Test
        @DisplayName("Endpoint: \"/flatID/{id}\"")
        void showHabitacionByID() throws Exception {
            RoomModel theRoom = new RoomModel();
            theRoom.setId(3);
            theRoom.setPrecio(300);
            theRoom.setCodigo("La Casa de Frodo");
            when(mockRoomService.showRoomByID(3)).thenReturn(theRoom);
            this.mockMvc.perform(get("/api/flatID/3")
                    .accept(MediaType.APPLICATION_JSON))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.roomModel.precio").value(300.00))
                    .andExpect(jsonPath("$.roomModel.codigo").value("La Casa de Frodo"));
        }
    }
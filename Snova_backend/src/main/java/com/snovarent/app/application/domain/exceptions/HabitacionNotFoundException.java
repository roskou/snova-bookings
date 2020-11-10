package com.snovarent.app.application.domain.exceptions;


    public class HabitacionNotFoundException extends RuntimeException {

        public HabitacionNotFoundException(Long id) {
           // super( "{\" Error \": \" Habitcion no Encotrada\", \" ID Habitacion\": \"" + id + "\"}");
            super("{\"Error\": \"Habitacion no encontrada\", \"ID_Habitacion\": \"" + id + "\"}");
        }
    }


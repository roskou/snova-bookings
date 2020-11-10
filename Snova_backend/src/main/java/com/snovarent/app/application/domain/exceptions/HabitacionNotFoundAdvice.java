package com.spacehotel.app.application.domain.exceptions;

import org.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class HabitacionNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(HabitacionNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    JSONException HabitacionNotFoundHandler(HabitacionNotFoundException ex) {
        String msg = ex.getMessage();
        JSONException json = new JSONException(msg);
        return (json);
    }
}
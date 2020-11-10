package com.snovarent.app.application.domain.DTO;

import com.sun.istack.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

public class LoginDTO {

    @NotNull
    @NotEmpty
    public String email;

    //Setters--------------------------------------
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //toStrig--------------------------------------
    @Override
    public String toString() {
        return "LoginDTO{" +
                "email='" + email + '\'' +
                '}';
    }
}

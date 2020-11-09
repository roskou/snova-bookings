package com.spacehotel.app.application.domain.DTO;

public class LoginDTO {

    public String email;



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "LoginDTO{" +
                "email='" + email + '\'' +
                '}';
    }
}

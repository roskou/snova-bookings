package com.snovarent.app.application.models;

public class ClientModel {
    private long id;
    private String nombre;
    private String apellido;
    private String email;
    private String cupon;

    public ClientModel(String nombre, String apellido, String email, String cupon) {
        setNombre (nombre);
        setApellido (apellido);
        setEmail (email);
        setCupon (cupon);
    }

    public ClientModel(long id, String nombre, String apellido, String email, String cupon) {
        setId (id);
        setNombre (nombre);
        setApellido (apellido);
        setEmail (email);
        setCupon (cupon);
    }

    public ClientModel(long id) {
        setId (id);

    }

    public ClientModel() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCupon() { return cupon;}

    public void setCupon(String cupon) { this.cupon = cupon; }

    @Override
    public String toString() {
        return "ClientModel{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

package com.spacehotel.app.application.domain.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="cliente")
public class ClientEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String apellido;
    private String email;
    private String cupon;
    @OneToMany(mappedBy="cliente", fetch=FetchType.EAGER)
    private Set<BookingEntity> reservas;


    public ClientEntity(long id, String nombre, String apellido, String email) {
        setId (id);
        setNombre (nombre);
        setApellido (apellido);
        setEmail (email);
        setCupon (cupon);
        setReservaEntities (reservas);
    }

    public ClientEntity(String nombre, String apellido, String email) {
        setNombre (nombre);
        setApellido (apellido);
        setEmail (email);
        setCupon (cupon);
        setReservaEntities (reservas);
    }

    public ClientEntity() {
    }

    public ClientEntity(long id, String nombre, String apellido, String email, String cupon) {
    }

    public String getCupon() {
        return cupon;
    }

    public void setCupon(String cupon) {
        this.cupon = cupon;
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

    public void setReservaEntities(Set<BookingEntity> reservas_id) {
        this.reservas = reservas_id;
    }

    @Override
    public String toString() {
        return "ClientEntity{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", email='" + cupon + '\'' +
                ", reservaEntities=" + reservas +
                '}';
    }
}

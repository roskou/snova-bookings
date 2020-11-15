package com.snovarent.app.application.domain.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "reserva")
public class BookingEntity implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private java.sql.Date fechaIn;
    private java.sql.Date fechaOut;
    private double precioTotal;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="cliente_id")
    private ClientEntity cliente;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_habitacion")
    private RoomEntity habitacion;

    public BookingEntity(long id, java.sql.Date fechaIn, java.sql.Date fechaOut, double precioTotal, ClientEntity clientEntity_id, RoomEntity habitacion) {
        setId (id);
        setFechaIn (fechaIn);
        setFechaOut (fechaOut);
        setPrecioTotal (precioTotal);
        setClienteEntity_id (clientEntity_id);
        setHabitacionEntity_id (habitacion);
    }

    public BookingEntity(java.sql.Date fechaIn, java.sql.Date fechaOut, double precioTotal, ClientEntity clientEntity_id, RoomEntity roomEntity) {
        setFechaIn (fechaIn);
        setFechaOut (fechaOut);
        setPrecioTotal (precioTotal);
        setClienteEntity_id (clientEntity_id);
        setHabitacionEntity_id (roomEntity);
    }

    public BookingEntity() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public java.sql.Date getFechaIn() {
        return fechaIn;
    }

    public void setFechaIn(java.sql.Date fechaIn) {
        this.fechaIn = fechaIn;
    }

    public java.sql.Date getFechaOut() {
        return fechaOut;
    }

    public void setFechaOut(java.sql.Date fechaOut) {
        this.fechaOut = fechaOut;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public ClientEntity getClienteEntity_id() {
        return cliente;
    }

    public void setClienteEntity_id(ClientEntity clientEntity) {
        this.cliente = clientEntity;
    }

    public RoomEntity getHabitacion() {
        return habitacion;
    }

    public void setHabitacionEntity_id(RoomEntity habitacion) {
        this.habitacion = habitacion;
    }


    @Override
    public String toString() {
        return "ReservaEntity{" +
                "fechaIn=" + fechaIn +
                ", fechaOut=" + fechaOut +
                ", precioTotal=" + precioTotal +
                ", clienteEntity=" + cliente +
                //", habitacionEntity=" + habitacionEntity_id +
                '}';
    }

}

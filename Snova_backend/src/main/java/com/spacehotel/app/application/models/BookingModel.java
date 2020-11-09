package com.spacehotel.app.application.models;

public class BookingModel {
    private long id;
    private java.sql.Date fechaIn;
    private java.sql.Date fechaOut;
    private float precioTotal;
    ClientModel cliente;
    RoomModel habitacion;

    public BookingModel(java.sql.Date fechaIn, java.sql.Date fechaOut, float precioTotal, ClientModel cliente, RoomModel habitacion) {
        setFechaIn (fechaIn);
        setFechaOut (fechaOut);
        setPrecioTotal (precioTotal);
        setCliente (cliente);
        setHabitacion (habitacion);
    }

    public BookingModel(long id, java.sql.Date fechaIn, java.sql.Date fechaOut, float precioTotal, ClientModel cliente, RoomModel habitacion) {
        setId (id);
        setFechaIn (fechaIn);
        setFechaOut (fechaOut);
        setPrecioTotal (precioTotal);
        setCliente (cliente);
        setHabitacion (habitacion);
    }

    public BookingModel() {
    }

//    public BookingModel(Date fechaIn, Date fechaOut, float precioTotal, float precioTotal1, ClientModel clientModel, RoomModel roomModel) {
//    }

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

    public float getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(float precioTotal) {
        this.precioTotal = precioTotal;
    }

    public ClientModel getCliente() {
        return cliente;
    }

    public void setCliente(ClientModel clientModel) {
        this.cliente = clientModel;
    }

    public RoomModel getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(RoomModel habitacion) {
        this.habitacion = habitacion;
    }

    @Override
    public String toString() {
        return "ReservaModel{" +
                "fechaIn=" + fechaIn +
                ", fechaOut=" + fechaOut +
                ", precioTotal=" + precioTotal +
                ", clienteModel=" + cliente +
                ", habitacionModels=" + habitacion +
                '}';
    }
}

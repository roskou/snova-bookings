package com.snovarent.app.application.models;

public class RoomModel {
    private long id;
    private String codigo;
    private String descripcion;
    private float precio;
    RoomTypeModel roomTypeModel;
    private int numpersonas;
    private int m2;
    private String localidad;

    public RoomModel(String codigo, String descripcion, float precio, RoomTypeModel roomTypeModel, int numpersonas, int m2, String localidad) {
        setCodigo (codigo);
        setDescripcion (descripcion);
        setPrecio (precio);
        setTipoModel (roomTypeModel);
        setNumpersonas(numpersonas);
        setM2 (m2);
        setLocalidad (localidad);
    }

    public RoomModel(long id, String codigo, String descripcion, float precio, RoomTypeModel roomTypeModel, int numpersonas, int m2, String localidad) {
        setId (id);
        setCodigo (codigo);
        setDescripcion (descripcion);
        setPrecio (precio);
        setTipoModel (roomTypeModel);
        setNumpersonas(numpersonas);
        setM2 (m2);
        setLocalidad (localidad);
    }
    public RoomModel(long id){
        setId (id);
    }

    public int getM2() {
        return m2;
    }

    public void setM2(int m2) {
        this.m2 = m2;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public RoomTypeModel getTipoModel() {
        return roomTypeModel;
    }

    public void setTipoModel(RoomTypeModel roomTypeModel) {
        this.roomTypeModel = roomTypeModel;
    }

    public int getNumpersonas() {
        return numpersonas;
    }

    public void setNumpersonas(int numpersonas) {
        this.numpersonas = numpersonas;
    }

    @Override
    public String toString() {
        return "HabitacionModel{" +
                "codigo='" + codigo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", tipoModel=" + roomTypeModel +
                '}';
    }
}

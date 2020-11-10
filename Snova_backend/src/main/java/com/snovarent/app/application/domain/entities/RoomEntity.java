package com.spacehotel.app.application.domain.entities;

import javax.persistence.*;

@Entity
@Table (name="habitacion")
public class RoomEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String codigo;
    private String descripcion;
    private float precio;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="tipo_id")
    private RoomTypeEntity tipo;
    private int numpersonas;
    private int m2;
    private String localidad;


    public RoomEntity(long id, String codigo, String descripcion, float precio, RoomTypeEntity tipo, int numpersonas, int m2, String localidad) {
        setId (id);
        setCodigo (codigo);
        setDescripcion (descripcion);
        setPrecio (precio);
        setTipo(tipo);
        setNumpersonas(numpersonas);
        setM2 (m2);
        setLocalidad (localidad);
    }



    public RoomEntity() {
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

    public RoomTypeEntity getTipo() {
        return tipo;
    }

    public void setTipo(RoomTypeEntity tipo) {
        this.tipo = tipo;
    }

    public int getNumpersonas() {
        return numpersonas;
    }

    public void setNumpersonas(int numpersonas) {
        this.numpersonas = numpersonas;
    }

    @Override
    public String toString() {
        return "HabitacionEntity{" +
                "codigo='" + codigo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", tipoEntity=" + tipo +
                //", reservaEntity=" + reserva +
                '}';
    }
}

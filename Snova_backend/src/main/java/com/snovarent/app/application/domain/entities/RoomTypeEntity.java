package com.snovarent.app.application.domain.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name="tipo")
public class RoomTypeEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String descripcion;
    @OneToMany(mappedBy="tipo", fetch=FetchType.EAGER)
    private List<RoomEntity> habitaciones;

    public RoomTypeEntity(long id, String nombre, String descripcion) {
        setId (id);
        setNombre (nombre);
        setDescripcion (descripcion);
    }

    public RoomTypeEntity(String nombre, String descripcion) {
        setNombre (nombre);
        setDescripcion (descripcion);
    }

    public RoomTypeEntity() {
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<RoomEntity> getHabitacionEntityList() {
        return habitaciones;
    }

    public void setHabitacionEntityList(List<RoomEntity> roomEntityList) {
        this.habitaciones = roomEntityList;
    }

    @Override
    public String toString() {
        return "TipoEntity{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", habitacionEntityList=" + habitaciones +
                '}';
    }
}

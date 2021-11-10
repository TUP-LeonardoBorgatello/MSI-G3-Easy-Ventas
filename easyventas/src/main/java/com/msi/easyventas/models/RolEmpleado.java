package com.msi.easyventas.models;

import javax.persistence.*;

@Entity
@Table(name = "roles_empleado")
public class RolEmpleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol_empleado", length = 10)
    private long id;
    @Column(length = 50, nullable = false)
    private String descripcion;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public RolEmpleado(String descripcion) {
        this.descripcion = descripcion;
    }

    public RolEmpleado() {
    }
}

package com.msi.easyventas.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ciudades")
public class Ciudad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ciudad", length = 10)
    private long id;
    @Column(length = 30, nullable = false)
    private String descripcion;

    @OneToMany(mappedBy = "rolEmpleado")
    private List<Empleado> empleados;

    @OneToMany(mappedBy = "tipoDoc")
    private List<Cliente> clientes;

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

    public Ciudad(String descripcion) {
        this.descripcion = descripcion;
    }

    public Ciudad() {
    }
}

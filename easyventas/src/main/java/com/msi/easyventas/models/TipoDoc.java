package com.msi.easyventas.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tipos_documento")
public class TipoDoc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_doc", length = 10)
    private long id;

    @Column(length = 50, nullable = false)
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

    public TipoDoc(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoDoc() {
    }
}

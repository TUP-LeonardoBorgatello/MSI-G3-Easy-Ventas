package com.msi.easyventas.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tipos_productos")
public class TipoProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_producto", length = 10)
    private long id;

    @Column(length = 50, nullable = false)
    private String descripcion;

    public TipoProducto(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoProducto() {
    }

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
}

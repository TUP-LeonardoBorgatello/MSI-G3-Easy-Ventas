package com.msi.easyventas.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "formas_entrega")
public class FormaEntrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_forma_entrega", length = 10)
    private long idFormaEntrega;
    @Column(length = 50, nullable = false)
    private String descripcion;

    @OneToMany(mappedBy = "formaEntrega")
    private List<Factura> facturas;

    public long getIdFormaEntrega() {
        return idFormaEntrega;
    }

    public void setIdFormaEntrega(long idFormaEntrega) {
        this.idFormaEntrega = idFormaEntrega;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    public FormaEntrega(String descripcion, List<Factura> facturas) {
        this.descripcion = descripcion;
        this.facturas = facturas;
    }

    public FormaEntrega() {
    }
}

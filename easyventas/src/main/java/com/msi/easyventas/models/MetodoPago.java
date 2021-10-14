package com.msi.easyventas.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "metodo_pago")
public class MetodoPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_metodo_pago", length = 10)
    private long idPago;
    @Column(length = 50, nullable = false)
    private String descripcion;

    @OneToMany(mappedBy = "metodoPago")
    private List<Factura> facturas;

    public MetodoPago(String descripcion, List<Factura> facturas) {
        this.descripcion = descripcion;
        this.facturas = facturas;
    }

    public MetodoPago() {
    }

    public long getIdPago() {
        return idPago;
    }

    public void setIdPago(long idPago) {
        this.idPago = idPago;
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
}

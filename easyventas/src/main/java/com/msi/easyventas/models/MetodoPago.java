package com.msi.easyventas.models;

import javax.persistence.*;

@Entity
@Table(name = "metodo_pago")
public class MetodoPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_metodo_pago", length = 10)
    private long idPago;
    @Column(length = 50, nullable = false)
    private String descripcion;


    public MetodoPago(String descripcion) {
        this.descripcion = descripcion;

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

}

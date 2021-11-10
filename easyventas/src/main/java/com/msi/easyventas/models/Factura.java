package com.msi.easyventas.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "facturas")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_factura", length = 10)
    private long idFactura;
    @Column(nullable = false)
    private LocalDate fecha;

    @ManyToOne()
    @JoinColumn(name = "id_metodo_pago", nullable = false)
    private MetodoPago metodoPago;

    @ManyToOne()
    @JoinColumn(name = "id_forma_entrega", nullable = false)
    private FormaEntrega formaEntrega;


    public Factura(LocalDate fecha, MetodoPago metodoPago, FormaEntrega formaEntrega) {
        this.fecha = fecha;
        this.metodoPago = metodoPago;
        this.formaEntrega = formaEntrega;

    }

    public Factura() {
    }

    public long getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(long idFactura) {
        this.idFactura = idFactura;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }


    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public FormaEntrega getFormaEntrega() {
        return formaEntrega;
    }

    public void setFormaEntrega(FormaEntrega formaEntrega) {
        this.formaEntrega = formaEntrega;
    }
}

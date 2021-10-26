package com.msi.easyventas.models;

import javax.persistence.*;

@Entity
@Table(name = "detalles_facturas")
public class DetalleFactura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_factura", length = 10)
    private long idDetalleFactura;
    @Column(nullable = false)
    private double monto;

    @ManyToOne()
    @JoinColumn(name = "id_factura", nullable = false)
    private Factura factura;

    @ManyToOne()
    @JoinColumn(name = "id_pedido", nullable = false)
    private Pedido pedido;

    public DetalleFactura(double monto, Factura factura, Pedido pedido) {
        this.monto = monto;
        this.factura = factura;
        this.pedido = pedido;
    }

    public DetalleFactura() {
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public long getIdDetalleFactura() {
        return idDetalleFactura;
    }

    public void setIdDetalleFactura(long idDetalleFactura) {
        this.idDetalleFactura = idDetalleFactura;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double precio) {
        this.monto = precio;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }


}

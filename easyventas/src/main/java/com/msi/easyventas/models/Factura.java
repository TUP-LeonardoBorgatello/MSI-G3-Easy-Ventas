package com.msi.easyventas.models;

import javax.persistence.*;
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
    private Date fecha;

    @ManyToOne()
    @JoinColumn(name = "id_metodo_pago", nullable = false)
    private MetodoPago metodoPago;

    @ManyToOne()
    @JoinColumn(name = "id_forma_entrega", nullable = false)
    private FormaEntrega formaEntrega;

    @OneToMany(mappedBy = "factura")
    private List<DetalleFactura> detalleFacturas;

    public Factura(Date fecha, MetodoPago metodoPago, FormaEntrega formaEntrega, List<DetalleFactura> detalleFacturas) {
        this.fecha = fecha;
        this.metodoPago = metodoPago;
        this.formaEntrega = formaEntrega;
        this.detalleFacturas = detalleFacturas;
    }

    public Factura() {
    }

    public List<DetalleFactura> getDetalleFacturas() {
        return detalleFacturas;
    }

    public void setDetalleFacturas(List<DetalleFactura> detalleFacturas) {
        this.detalleFacturas = detalleFacturas;
    }

    public long getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(long idFactura) {
        this.idFactura = idFactura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
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

package com.msi.easyventas.dtos;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class FacturaResponseDTO {

    private long id_factura;
    private LocalDate fechaFactura;
    private String formaEntrega;
    private String metodoPago;
    private String nombreCliente;
    private String apellidoCliente;
    private int documento;
    private String domicilio;
    private List<DetallePedidoResponseDTO> detalles;
    private double montoTotal;

    public FacturaResponseDTO(long id_factura, LocalDate fechaFactura, String formaEntrega, String metodoPago,
                              String nombreCliente, String apellidoCliente, int documento, String domicilio,
                              List<DetallePedidoResponseDTO> detalles, double montoTotal) {
        this.id_factura = id_factura;
        this.fechaFactura = fechaFactura;
        this.formaEntrega = formaEntrega;
        this.metodoPago = metodoPago;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.documento = documento;
        this.domicilio = domicilio;
        this.detalles = detalles;
        this.montoTotal = montoTotal;
    }

    public FacturaResponseDTO() {
    }

    public long getId_factura() {
        return id_factura;
    }

    public void setId_factura(long id_factura) {
        this.id_factura = id_factura;
    }

    public LocalDate getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(LocalDate fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public String getFormaEntrega() {
        return formaEntrega;
    }

    public void setFormaEntrega(String formaEntrega) {
        this.formaEntrega = formaEntrega;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public List<DetallePedidoResponseDTO> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetallePedidoResponseDTO> detalles) {
        this.detalles = detalles;
    }
}

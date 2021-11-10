package com.msi.easyventas.dtos;

import java.time.LocalDate;

public class PedidoRequestDTO {

    private LocalDate fecha_pedido;
    private int documentoCliente;
    private int documentoEmpleado;
    private long cantidad;
    private int sku;

    public PedidoRequestDTO(LocalDate fecha_pedido, int documentoCliente, int documentoEmpleado, long cantidad, int sku) {
        this.fecha_pedido = fecha_pedido;
        this.documentoCliente = documentoCliente;
        this.documentoEmpleado = documentoEmpleado;
        this.cantidad = cantidad;
        this.sku = sku;
    }

    public PedidoRequestDTO() {
    }

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }

    public int getSku() {
        return sku;
    }

    public void setSku(int sku) {
        this.sku = sku;
    }

    public LocalDate getFecha_pedido() {
        return fecha_pedido;
    }

    public void setFecha_pedido(LocalDate fecha_pedido) {
        this.fecha_pedido = fecha_pedido;
    }

    public int getDocumentoCliente() {
        return documentoCliente;
    }

    public void setDocumentoCliente(int documentoCliente) {
        this.documentoCliente = documentoCliente;
    }

    public int getDocumentoEmpleado() {
        return documentoEmpleado;
    }

    public void setDocumentoEmpleado(int documentoEmpleado) {
        this.documentoEmpleado = documentoEmpleado;
    }

}

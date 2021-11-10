package com.msi.easyventas.dtos;

import java.time.LocalDate;

public class PedidoRequestDTO {

    private LocalDate fecha_pedido;
    private int documentoCliente;
    private int documentoEmpleado;
    private long cantidad;
    private long id_producto;

    public PedidoRequestDTO(LocalDate fecha_pedido, int documentoCliente, int documentoEmpleado, long cantidad, long id_producto) {
        this.fecha_pedido = fecha_pedido;
        this.documentoCliente = documentoCliente;
        this.documentoEmpleado = documentoEmpleado;
        this.cantidad = cantidad;
        this.id_producto = id_producto;
    }

    public PedidoRequestDTO() {
    }

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }

    public long getId_producto() {
        return id_producto;
    }

    public void setId_producto(long id_producto) {
        this.id_producto = id_producto;
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

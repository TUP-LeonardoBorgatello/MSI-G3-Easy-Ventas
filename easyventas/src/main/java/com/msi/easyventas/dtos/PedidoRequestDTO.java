package com.msi.easyventas.dtos;

import java.time.LocalDate;

public class PedidoRequestDTO {

    private LocalDate fecha_pedido;
    private long id_cliente;
    private long id_empleado;
    private long cantidad;
    private long id_producto;

    public PedidoRequestDTO(LocalDate fecha_pedido, long id_cliente, long id_empleado, long cantidad, long id_producto) {
        this.fecha_pedido = fecha_pedido;
        this.id_cliente = id_cliente;
        this.id_empleado = id_empleado;
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

    public long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public long getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(long id_empleado) {
        this.id_empleado = id_empleado;
    }

}

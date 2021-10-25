package com.msi.easyventas.dtos;

import javax.persistence.Column;

public class DetallePedidoRequestDTO {

    private long cantidad;
    private long id_pedido;
    private long id_producto;

    public long getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(long id_pedido) {
        this.id_pedido = id_pedido;
    }

    public long getId_producto() {
        return id_producto;
    }

    public void setId_producto(long id_producto) {
        this.id_producto = id_producto;
    }

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }

    public DetallePedidoRequestDTO() {
    }

    public DetallePedidoRequestDTO(long cantidad, long id_pedido, long id_producto) {
        this.cantidad = cantidad;
        this.id_pedido = id_pedido;
        this.id_producto = id_producto;
    }
}

package com.msi.easyventas.dtos;

public class DetallePedidoRequestDTO {

    private long cantidad;
    private long id_producto;

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

    public DetallePedidoRequestDTO(long cantidad, long id_producto) {
        this.cantidad = cantidad;
        this.id_producto = id_producto;
    }
}

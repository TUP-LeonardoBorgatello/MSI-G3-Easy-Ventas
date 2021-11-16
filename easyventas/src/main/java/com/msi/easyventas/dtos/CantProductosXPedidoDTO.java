package com.msi.easyventas.dtos;

public class CantProductosXPedidoDTO {

    private long cantidad;
    private long numeroPedido;

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }

    public long getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(long numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public CantProductosXPedidoDTO(long cantidad, long numeroPedido) {
        this.cantidad = cantidad;
        this.numeroPedido = numeroPedido;
    }

    public CantProductosXPedidoDTO() {
    }
}

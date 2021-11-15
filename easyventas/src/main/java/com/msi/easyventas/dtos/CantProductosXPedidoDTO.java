package com.msi.easyventas.dtos;

public class CantProductosXPedidoDTO {

    private long cantidad;
    private long numeroFactura;

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }

    public long getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(long numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public CantProductosXPedidoDTO(long cantidad, long numeroFactura) {
        this.cantidad = cantidad;
        this.numeroFactura = numeroFactura;
    }

    public CantProductosXPedidoDTO() {
    }
}

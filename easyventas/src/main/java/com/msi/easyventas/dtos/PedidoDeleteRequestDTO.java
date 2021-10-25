package com.msi.easyventas.dtos;

public class PedidoDeleteRequestDTO {

    private long id_pedido;

    public PedidoDeleteRequestDTO(long idPedido) {
        this.id_pedido = idPedido;
    }

    public long getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(long id_pedido) {
        this.id_pedido = id_pedido;
    }

    public PedidoDeleteRequestDTO() {
    }
}

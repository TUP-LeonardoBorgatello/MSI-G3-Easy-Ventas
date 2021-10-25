package com.msi.easyventas.dtos;

import java.time.LocalDate;

public class PedidoRequestDTO {

    private LocalDate fecha_pedido;
    private long id_cliente;
    private long id_empleado;
    private long id_estado;

    public PedidoRequestDTO(LocalDate fechaPedido, long id_cliente, long id_empleado, long id_estado) {
        this.fecha_pedido = fechaPedido;
        this.id_cliente = id_cliente;
        this.id_empleado = id_empleado;
        this.id_estado = id_estado;
    }

    public PedidoRequestDTO() {
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

    public long getId_estado() {
        return id_estado;
    }

    public void setId_estado(long id_estado) {
        this.id_estado = id_estado;
    }
}
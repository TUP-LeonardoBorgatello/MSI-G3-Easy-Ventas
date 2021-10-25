package com.msi.easyventas.dtos;

import java.time.LocalDate;

public class PedidoResponseDTO {

    private long idPedido;
    private LocalDate fechaPedido;
    private String nombreCliente;
    private String apellidoCliente;
    private double monto;
    private long cantidad;
    private String estado;

    public PedidoResponseDTO(long idPedido, LocalDate fechaPedido, String nombreCliente, String apellidoCliente, double monto, long cantidad, String estado) {
        this.idPedido = idPedido;
        this.fechaPedido = fechaPedido;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.monto = monto;
        this.cantidad = cantidad;
        this.estado = estado;
    }

    public PedidoResponseDTO() {
    }

    public long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(long idPedido) {
        this.idPedido = idPedido;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
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

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}

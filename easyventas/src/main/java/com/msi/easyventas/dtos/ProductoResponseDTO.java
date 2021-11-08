package com.msi.easyventas.dtos;

import javax.persistence.Column;

public class ProductoResponseDTO
{
    private String descripcion;
    private long stock;
    private double precioVenta;
    private long sku;
    private String tipoProducto;

    public ProductoResponseDTO(){}

    public ProductoResponseDTO(String descripcion, long stock, double precioVenta, long sku, String tipoProducto)
    {
        this.descripcion = descripcion;
        this.stock = stock;
        this.precioVenta = precioVenta;
        this.sku = sku;
        this.tipoProducto = tipoProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public long getStock() {
        return stock;
    }

    public void setStock(long stock) {
        this.stock = stock;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public long getSku() {
        return sku;
    }

    public void setSku(long sku) {
        this.sku = sku;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }
}

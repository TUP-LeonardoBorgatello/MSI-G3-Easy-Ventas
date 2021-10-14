package com.msi.easyventas.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto", length = 10)
    private long idProducto;
    @Column(length = 50, nullable = false)
    private String descripcion;
    @Column(nullable = false)
    private long stock;
    @Column(nullable = false)
    private double precioVenta;

    @OneToMany(mappedBy = "producto")
    private List<DetallePedido> detallePedidos;

    public long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(long idProducto) {
        this.idProducto = idProducto;
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

    public Producto() {
    }

    public Producto(String descripcion, long stock, double precioVenta) {
        this.descripcion = descripcion;
        this.stock = stock;
        this.precioVenta = precioVenta;
    }
}

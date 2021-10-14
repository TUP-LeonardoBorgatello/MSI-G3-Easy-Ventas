package com.msi.easyventas.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "estados")
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado", length = 10)
    private long idEstado;
    @Column(length =50, nullable = false)
    private String descripcion;

    @OneToMany(mappedBy = "estado")
    private List<Pedido> pedidos;

    public Estado(String descripcion, List<Pedido> pedidos) {
        this.descripcion = descripcion;
        this.pedidos = pedidos;
    }

    public Estado() {
    }

    public long getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(long idEstado) {
        this.idEstado = idEstado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}

package com.msi.easyventas.models;

import javax.persistence.*;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente", length = 10)
    private long id;
    @Column(length = 30, nullable = false)
    private String nombre;
    @Column(length = 30, nullable = false)
    private int documento;
    @Column(length = 30, nullable = false)
    private String apellido;
    @Column(length = 50, nullable = false)
    private String domicilio;
    @Column(length = 50, nullable = false)
    private String email;
    @Column(nullable = false)
    private Boolean estado;

    @ManyToOne()
    @JoinColumn(name = "id_ciudad", nullable = false)
    private Ciudad ciudad;

    @ManyToOne()
    @JoinColumn(name = "id_tipo_doc", nullable = false)
    private TipoDoc tipoDoc;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public TipoDoc getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(TipoDoc tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public Cliente(String nombre, int documento, String apellido, String domicilio, String email, Boolean estado, Ciudad ciudad, TipoDoc tipoDoc) {
        this.nombre = nombre;
        this.documento = documento;
        this.apellido = apellido;
        this.domicilio = domicilio;
        this.email = email;
        this.estado = estado;
        this.ciudad = ciudad;
        this.tipoDoc = tipoDoc;
    }

    public Cliente() {
    }
}

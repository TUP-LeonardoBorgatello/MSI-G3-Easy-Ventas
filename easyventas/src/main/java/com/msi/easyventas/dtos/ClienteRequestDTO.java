package com.msi.easyventas.dtos;


public class ClienteRequestDTO {

    private String nombre;

    private String apellido;

    private String domicilio;

    private String email;

    private Boolean estado;

    private long id_ciudad;

    private long id_tipo_doc;

    private int documento;


    public ClienteRequestDTO() {
    }

    public ClienteRequestDTO(String nombre, String apellido, String domicilio, String email, Boolean estado, long id_ciudad, long id_tipo_doc, int documento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.domicilio = domicilio;
        this.email = email;
        this.estado = estado;
        this.id_ciudad = id_ciudad;
        this.id_tipo_doc = id_tipo_doc;
        this.documento = documento;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public long getId_ciudad() {
        return id_ciudad;
    }

    public void setId_ciudad(long id_ciudad) {
        this.id_ciudad = id_ciudad;
    }

    public long getId_tipo_doc() {
        return id_tipo_doc;
    }

    public void setId_tipo_doc(long id_tipo_doc) {
        this.id_tipo_doc = id_tipo_doc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
}

package com.msi.easyventas.dtos;

public class EmpleadoRequestDTO {

    private String nombre;
    private String apellido;
    private String domicilio;
    private Boolean estado;
    private long id_ciudad;
    private long id_tipo_doc;
    private int documento;
    private int genero;
    private String contraseña;

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
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

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
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

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    public EmpleadoRequestDTO(String nombre, String apellido, String domicilio, Boolean estado, long id_ciudad, long id_tipo_doc, int documento, int genero, String contraseña) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.domicilio = domicilio;
        this.estado = estado;
        this.id_ciudad = id_ciudad;
        this.id_tipo_doc = id_tipo_doc;
        this.documento = documento;
        this.genero = genero;
        this.contraseña = contraseña;
    }

    public EmpleadoRequestDTO() {
    }
}

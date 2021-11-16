package com.msi.easyventas.dtos;

public class ClienteResponseDTO {

    private String nombre;
    private String apellido;
    private String domicilio;
    private String email;
    private String estado;
    private String ciudad;
    private String tipoDocumento;
    private int documento;

    public ClienteResponseDTO() {
    }

    public ClienteResponseDTO(String nombre, String apellido, String domicilio, String email, String estado, String ciudad, String tipoDocumento, int documento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.domicilio = domicilio;
        this.email = email;
        this.estado = estado;
        this.ciudad = ciudad;
        this.tipoDocumento = tipoDocumento;
        this.documento = documento;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}

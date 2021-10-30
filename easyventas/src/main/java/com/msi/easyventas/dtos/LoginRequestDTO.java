package com.msi.easyventas.dtos;

public class LoginRequestDTO {
    private int documentoLogin;
    private String contraseña;

    public int getDocumentoLogin() {
        return documentoLogin;
    }

    public void setDocumentoLogin(int documentoLogin) {
        this.documentoLogin = documentoLogin;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public LoginRequestDTO() {
    }

    public LoginRequestDTO(int documentoLogin, String contraseña) {
        this.documentoLogin = documentoLogin;
        this.contraseña = contraseña;
    }
}

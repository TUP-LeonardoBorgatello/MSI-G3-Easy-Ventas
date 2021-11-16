package com.msi.easyventas.dtos;

public class ClienteDeleteDTO {

    private int documento;

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public ClienteDeleteDTO(int documento) {
        this.documento = documento;
    }

    public ClienteDeleteDTO() {
    }
}

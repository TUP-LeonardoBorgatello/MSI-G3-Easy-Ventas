package com.msi.easyventas.dtos;

public class EmpleadoChangeStatusDTO {

    private int documento;
    private String rolEmpleado;

    public EmpleadoChangeStatusDTO(int documento, String rolEmpleado) {
        this.documento = documento;
        this.rolEmpleado = rolEmpleado;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getRolEmpleado() {
        return rolEmpleado;
    }

    public void setRolEmpleado(String rolEmpleado) {
        this.rolEmpleado = rolEmpleado;
    }

    public EmpleadoChangeStatusDTO() {
    }
}

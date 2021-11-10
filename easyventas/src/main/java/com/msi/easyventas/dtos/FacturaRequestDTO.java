package com.msi.easyventas.dtos;

import java.util.Date;

public class FacturaRequestDTO {

    private Date fecha;
    private long id_forma_entrega;
    private long id_metodo_pago;

    public FacturaRequestDTO() {
    }

    public FacturaRequestDTO(Date fecha, long id_forma_entrega, long id_metodo_pago) {

        this.fecha = fecha;
        this.id_forma_entrega = id_forma_entrega;
        this.id_metodo_pago = id_metodo_pago;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public long getId_forma_entrega() {
        return id_forma_entrega;
    }

    public void setId_forma_entrega(long id_forma_entrega) {
        this.id_forma_entrega = id_forma_entrega;
    }

    public long getId_metodo_pago() {
        return id_metodo_pago;
    }

    public void setId_metodo_pago(long id_metodo_pago) {
        this.id_metodo_pago = id_metodo_pago;
    }
}

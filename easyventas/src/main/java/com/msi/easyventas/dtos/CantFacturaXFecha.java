package com.msi.easyventas.dtos;

import java.time.LocalDate;

public class CantFacturaXFecha {

    private long cantFacturas;
    private LocalDate fecha;

    public long getCantFacturas() {
        return cantFacturas;
    }

    public void setCantFacturas(long cantFacturas) {
        this.cantFacturas = cantFacturas;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public CantFacturaXFecha() {
    }

    public CantFacturaXFecha(long cantFacturas, LocalDate fecha) {
        this.fecha = fecha;
        this.cantFacturas = cantFacturas;
    }
}

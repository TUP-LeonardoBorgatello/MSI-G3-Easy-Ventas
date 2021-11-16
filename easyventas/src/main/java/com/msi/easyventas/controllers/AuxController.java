package com.msi.easyventas.controllers;

import com.msi.easyventas.dtos.CantFacturaXFecha;
import com.msi.easyventas.dtos.CantProductosXPedidoDTO;
import com.msi.easyventas.models.*;
import com.msi.easyventas.services.AuxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/easyventas")
public class AuxController {
    @Autowired
    AuxService auxService;

    @CrossOrigin(origins = "*")
    @GetMapping("/tiposdocumentos")
    public List<TipoDoc> getAllTipoDoc() {
        return auxService.findAllTipoDoc();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/ciudades")
    public List<Ciudad> getAllCiudad() {
        return auxService.findAllCiudad();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/empleadoconid")
    public List<Empleado> getAllEmpleadoWithId() {
        return auxService.findAllEmpleadosWithId();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/formaentrega")
    public List<FormaEntrega> getAllFormaEntrega() {
        return auxService.findAllFormaEntrega();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/metodopago")
    public List<MetodoPago> getAllMetodoPago() {
        return auxService.findAllMetodoPago();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/reporte1")
    public List<CantProductosXPedidoDTO> getReporte1() {
        return auxService.findAllReporte1();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/reporte1/{idPedido}")
    public List<CantProductosXPedidoDTO> getReporte1ByIdPedido(@PathVariable long idPedido) throws Exception {
            return auxService.findReporte1ByIdPedido(idPedido);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/reporte2")
    public List<CantFacturaXFecha> getReporte2() {
        return auxService.findAllReporte2();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/reporte2/{fecha1}/{fecha2}")
    public List<CantFacturaXFecha> getReporte2(@PathVariable String fecha1, @PathVariable String fecha2) {
        return auxService.findAllReporte3(fecha1, fecha2);
    }
}

package com.msi.easyventas.controllers;

import com.msi.easyventas.dtos.CantFacturaXFecha;
import com.msi.easyventas.dtos.CantProductosXPedidoDTO;
import com.msi.easyventas.models.*;
import com.msi.easyventas.services.AuxService;
import com.msi.easyventas.services.ServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/reporte1All")
    public List<CantProductosXPedidoDTO> getReporte1() {
        return auxService.findAllReporte1();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/reporte1")
    public ResponseEntity<?> getReporte1ByIdPedido(@RequestParam long idPedido) throws Exception {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(auxService.findReporte1ByIdPedido(idPedido));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el pedido.");
        }
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/reporte2")
    public List<CantFacturaXFecha> getReporte2() {
        return auxService.findAllReporte2();
    }
}

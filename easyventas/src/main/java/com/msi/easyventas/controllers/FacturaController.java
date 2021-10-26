package com.msi.easyventas.controllers;

import com.msi.easyventas.dtos.FacturaRequestDTO;
import com.msi.easyventas.dtos.FacturaResponseDTO;
import com.msi.easyventas.services.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/easyventas")
public class FacturaController {

    @Autowired
    FacturaService facturaService;

    @GetMapping("/factura")
    public FacturaResponseDTO getFactura() {
        return facturaService.Factura();
    }

    @PostMapping("/add/factura")
    public ResponseEntity<?> addFactura(@RequestBody FacturaRequestDTO nuevaFactura) throws Exception {
        if (nuevaFactura != null) {
            try {
                facturaService.addFactura(nuevaFactura);
                Thread.sleep(1000);
                facturaService.addDetalleFactura();
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se puedo agregar la factura. Verifique los datos.");
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body("Factura cargada con éxito");
    }
}

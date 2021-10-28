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
    public ResponseEntity<?> addFactura(@RequestBody FacturaRequestDTO nuevaFactura, @RequestParam long idPedido) throws Exception {
        if (nuevaFactura != null) {
            try {
                facturaService.addFactura(nuevaFactura, idPedido);
                Thread.sleep(1000);
                facturaService.addDetalleFactura(idPedido);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Alguno de los datos no existe. Verificar el" +
                        " método de pago, la forma de entrega o si el pedido está cancelado.");
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body("Factura cargada con éxito");
    }
}

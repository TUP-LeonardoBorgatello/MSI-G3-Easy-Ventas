package com.msi.easyventas.controllers;

import com.msi.easyventas.dtos.DetallePedidoResponseDTO;
import com.msi.easyventas.dtos.FacturaRequestDTO;
import com.msi.easyventas.dtos.FacturaResponseDTO;
import com.msi.easyventas.services.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/easyventas")
public class FacturaController {

    @Autowired
    FacturaService facturaService;

    @GetMapping("/factura")
    public FacturaResponseDTO getFactura(@RequestParam long idPedido) {
        return facturaService.Factura(idPedido);
    }

    @GetMapping("/detalle/factura")
    public List<DetallePedidoResponseDTO> getDetallesFactura(@RequestParam long idPedido) {
        return facturaService.getDetallesFactura(idPedido);
    }

    @PostMapping("/add/factura")
    public ResponseEntity<?> addFactura(@RequestBody FacturaRequestDTO nuevaFactura) throws Exception {
        if (nuevaFactura != null) {
            try {
                facturaService.addFactura(nuevaFactura);
                Thread.sleep(1000);
                facturaService.addDetalleFactura(nuevaFactura);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Alguno de los datos no existe. Verificar el" +
                        " método de pago, la forma de entrega o si el pedido está cancelado.");
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body("Factura cargada con éxito");
    }
}

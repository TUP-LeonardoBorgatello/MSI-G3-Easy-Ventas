package com.msi.easyventas.controllers;

import com.msi.easyventas.dtos.DetallePedidoResponseDTO;
import com.msi.easyventas.dtos.FacturaRequestDTO;
import com.msi.easyventas.dtos.FacturaResponseDTO;
import com.msi.easyventas.services.FacturaService;
import com.msi.easyventas.services.ServiceResponse;
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
    public FacturaResponseDTO getFactura(@RequestBody FacturaRequestDTO nuevaFactura) {
        return facturaService.Factura(nuevaFactura);
    }

    @GetMapping("/detalle/factura")
    public List<DetallePedidoResponseDTO> getDetallesFactura(@RequestBody FacturaRequestDTO nuevaFactura) {
        return facturaService.getDetallesFactura(nuevaFactura);
    }

    @PostMapping("/add/factura")
    public ResponseEntity<?> addFactura(@RequestBody FacturaRequestDTO nuevaFactura) throws Exception {
        ServiceResponse<?> response = new ServiceResponse<>("success", "Factura agregado con éxito");
        ServiceResponse<?> response2 = new ServiceResponse<>("error", "No se puedo agregar la factura. Verifique los datos.");
        if (nuevaFactura != null) {
            try {
                facturaService.addFactura(nuevaFactura);
                Thread.sleep(1000);
                facturaService.addDetalleFactura(nuevaFactura);
            } catch (Exception e) {
                return new ResponseEntity<Object>(response2, HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }
}

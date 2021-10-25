package com.msi.easyventas.controllers;

import com.msi.easyventas.dtos.*;
import com.msi.easyventas.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/easyventas")
public class PedidoController {

    @Autowired
    PedidoService pedidoService;

    @GetMapping("/pedidos")
    public List<PedidoResponseDTO> getAllPedidos() {
        return pedidoService.findAllPedidos();
    }

    @PostMapping("/add/pedido")
    public ResponseEntity<?> addPedido(@RequestBody PedidoRequestDTO nuevoPedido) throws Exception {
        if (nuevoPedido != null) {
            try {
                pedidoService.addPedido(nuevoPedido);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se puedo agregar el Pedido. Verifique los datos.");
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body("Pedido agregado con éxito");
    }

    @PostMapping("/add/detalle/pedido")
    public ResponseEntity<?> addDetallePedido(@RequestBody DetallePedidoRequestDTO nuevoDetallePedido) throws Exception {
        if (nuevoDetallePedido != null) {
            try {
                pedidoService.addDetallePedido(nuevoDetallePedido);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se puedo agregar el detalle del Pedido. Verifique los datos.");
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body("Detalle de pedido agregado con éxito");
    }

    @PostMapping("pedido/delete")
    public String deletePedido(@RequestBody PedidoDeleteRequestDTO pedido) throws Exception {
        pedidoService.deletePedido(pedido);
        return "Pedido modificado.";
    }


}

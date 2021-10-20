package com.msi.easyventas.controllers;

import com.msi.easyventas.dtos.ClienteRequestDTO;
import com.msi.easyventas.dtos.PedidoRequestDTO;
import com.msi.easyventas.dtos.PedidoResponseDTO;
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
}

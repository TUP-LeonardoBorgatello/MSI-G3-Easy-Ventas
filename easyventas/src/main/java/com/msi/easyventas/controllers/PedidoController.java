package com.msi.easyventas.controllers;

import com.msi.easyventas.dtos.*;
import com.msi.easyventas.services.PedidoService;
import com.msi.easyventas.services.ServiceResponse;
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
        ServiceResponse<?> response = new ServiceResponse<>("success", "Pedido agregado con éxito");
        ServiceResponse<?> response2 = new ServiceResponse<>("error", "No se puedo agregar el Pedido. Verifique los datos y el stock.");
        if (nuevoPedido != null) {
            try {
                pedidoService.addPedido(nuevoPedido);
            } catch (Exception e) {
                return new ResponseEntity<Object>(response2, HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    @PostMapping("/add/detalle/pedido")
    public ResponseEntity<?> addDetallePedido(@RequestBody PedidoRequestDTO nuevoDetallePedido) throws Exception{
        ServiceResponse<?> response = new ServiceResponse<>("success", "Detalle de pedido agregado con éxito");
        ServiceResponse<?> response2 = new ServiceResponse<>("error", "No se puedo agregar el detalle del Pedido. Verifique los datos y el stock.");
        if (nuevoDetallePedido != null) {
            try {
                pedidoService.addDetallePedido(nuevoDetallePedido);
            } catch (Exception e) {
                return new ResponseEntity<Object>(response2, HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    @PostMapping("pedido/delete")
    public ResponseEntity<?> deletePedido(@RequestBody PedidoDeleteRequestDTO pedido) throws Exception {
        ServiceResponse<?> response = new ServiceResponse<>("success", "Se canceló correctamente el pedido.");
        ServiceResponse<?> response2 = new ServiceResponse<>("error", "No se pudo cancelar el pedido. No se encuentra o está finalizado o cancelado.");
            try {
                pedidoService.deletePedido(pedido);
            } catch (Exception e) {
                return new ResponseEntity<Object>(response2, HttpStatus.BAD_REQUEST);
            }

        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }


}

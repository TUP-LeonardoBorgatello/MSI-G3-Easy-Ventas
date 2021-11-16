package com.msi.easyventas.Unit;

import com.msi.easyventas.controllers.PedidoController;
import com.msi.easyventas.dtos.PedidoRequestDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;



public class PedidoControllerTest {

    @InjectMocks
    PedidoController controller;


    @Test
    void addPedidoThrowExceptionByNullParams() throws Exception {
        //LocalDate date = LocalDate.parse("2021-02-20");

        PedidoRequestDTO pedidoRequestDTO = new PedidoRequestDTO();
        pedidoRequestDTO.setCantidad(50);
        pedidoRequestDTO.setDocumentoCliente(3215);
        pedidoRequestDTO.setFecha_pedido(null);

        Assertions.assertThrows(Exception.class, () -> controller.addPedido(pedidoRequestDTO));
    }
}

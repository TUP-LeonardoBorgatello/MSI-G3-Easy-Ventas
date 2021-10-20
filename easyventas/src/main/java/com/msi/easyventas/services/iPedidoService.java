package com.msi.easyventas.services;

import com.msi.easyventas.dtos.PedidoRequestDTO;
import com.msi.easyventas.dtos.PedidoResponseDTO;

import java.util.List;

public interface iPedidoService {

    List<PedidoResponseDTO> findAllPedidos() throws Exception;

    void addPedido(PedidoRequestDTO pedidoRequestDTO) throws Exception;
}

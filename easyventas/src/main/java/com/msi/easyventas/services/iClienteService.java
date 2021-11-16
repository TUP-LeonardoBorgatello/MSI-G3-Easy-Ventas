package com.msi.easyventas.services;

import com.msi.easyventas.dtos.ClienteDeleteDTO;
import com.msi.easyventas.dtos.ClienteRequestDTO;
import com.msi.easyventas.dtos.ClienteResponseDTO;

import java.util.List;

public interface iClienteService {

    List<ClienteResponseDTO> findAllClientes() throws Exception;

    List<ClienteResponseDTO> findClienteByDocumento(int documento) throws Exception;

    void addCliente(ClienteRequestDTO clienteRequestDTO) throws Exception;

    void updateCliente(ClienteRequestDTO cliente) throws Exception;

    void changeClienteStatus(ClienteDeleteDTO cliente) throws Exception;
}

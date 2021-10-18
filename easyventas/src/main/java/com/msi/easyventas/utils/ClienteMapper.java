package com.msi.easyventas.utils;

import com.msi.easyventas.dtos.ClienteResponseDTO;
import com.msi.easyventas.models.Cliente;

public class ClienteMapper {
    public static ClienteResponseDTO toDTO(Cliente cliente) {

        ClienteResponseDTO clienteResponseDTO = new ClienteResponseDTO();

        clienteResponseDTO.setNombre(cliente.getNombre());
        clienteResponseDTO.setApellido(cliente.getApellido());
        clienteResponseDTO.setCiudad(cliente.getCiudad().getDescripcion());
        clienteResponseDTO.setDomicilio(cliente.getDomicilio());
        clienteResponseDTO.setEmail(cliente.getEmail());
        clienteResponseDTO.setEstado(cliente.getEstado());
        clienteResponseDTO.setTipoDocumento(cliente.getTipoDoc().getDescripcion());
        clienteResponseDTO.setDocumento(cliente.getDocumento());

        return clienteResponseDTO;
    }
}

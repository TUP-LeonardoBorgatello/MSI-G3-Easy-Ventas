package com.msi.easyventas.services;

import com.msi.easyventas.dtos.ClienteRequestDTO;
import com.msi.easyventas.dtos.ClienteResponseDTO;
import com.msi.easyventas.models.Ciudad;
import com.msi.easyventas.models.Cliente;
import com.msi.easyventas.models.TipoDoc;
import com.msi.easyventas.repositories.ClienteRepository;
import com.msi.easyventas.utils.ClienteMapper;
import javassist.NotFoundException;
import javassist.tools.web.BadHttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public List<ClienteResponseDTO> findAllClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream().map(ClienteMapper::toDTO).collect(Collectors.toList());
    }

    public void addCliente(ClienteRequestDTO clienteRequestDTO) throws Exception {

        if (clienteRepository.existsByApellido(clienteRequestDTO.getApellido())){
            throw new NotFoundException("El cliente ya existe.");
        }

        Ciudad ciudad = clienteRepository.findById(clienteRequestDTO.getId_ciudad()).orElseThrow().getCiudad();
        TipoDoc tipoDoc = clienteRepository.findById(clienteRequestDTO.getId_tipo_doc()).orElseThrow().getTipoDoc();


        Cliente c = new Cliente();
        c.setNombre(clienteRequestDTO.getNombre());
        c.setApellido(clienteRequestDTO.getApellido());
        c.setDomicilio(clienteRequestDTO.getDomicilio());
        c.setEmail(clienteRequestDTO.getEmail());
        c.setEstado(clienteRequestDTO.getEstado());
        c.setCiudad(ciudad);
        c.setTipoDoc(tipoDoc);

        clienteRepository.save(c);
    }


}

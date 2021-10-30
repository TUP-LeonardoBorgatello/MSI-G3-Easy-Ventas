package com.msi.easyventas.services;

import com.msi.easyventas.dtos.ClienteRequestDTO;
import com.msi.easyventas.dtos.ClienteResponseDTO;
import com.msi.easyventas.models.Ciudad;
import com.msi.easyventas.models.Cliente;
import com.msi.easyventas.models.TipoDoc;
import com.msi.easyventas.repositories.CiudadRepository;
import com.msi.easyventas.repositories.ClienteRepository;
import com.msi.easyventas.repositories.TipoDocRepository;
import com.msi.easyventas.utils.ClienteMapper;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ClienteService implements iClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    CiudadRepository ciudadRepository;

    @Autowired
    TipoDocRepository tipoDocRepository;

    @Override
    public List<ClienteResponseDTO> findAllClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream().map(ClienteMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public void addCliente(ClienteRequestDTO clienteRequestDTO) throws Exception {

        if (clienteRepository.existsByDocumento(clienteRequestDTO.getDocumento())) {
            throw new Exception("El cliente ya existe.");
        }
        else {
            Ciudad ciudad = ciudadRepository.findById(clienteRequestDTO.getId_ciudad()).orElseThrow();
            TipoDoc tipoDoc = tipoDocRepository.findById(clienteRequestDTO.getId_tipo_doc()).orElseThrow();

            Cliente c = new Cliente();
            c.setNombre(clienteRequestDTO.getNombre());
            c.setApellido(clienteRequestDTO.getApellido());
            c.setDomicilio(clienteRequestDTO.getDomicilio());
            c.setEmail(clienteRequestDTO.getEmail());
            c.setEstado(clienteRequestDTO.getEstado());
            c.setCiudad(ciudad);
            c.setTipoDoc(tipoDoc);
            c.setDocumento(clienteRequestDTO.getDocumento());

            clienteRepository.save(c);
        }

    }

    @Override
    public List<ClienteResponseDTO> findClienteByDocumento(int documento) throws Exception {
        List<Cliente> clientes = existClienteByDocumento(documento);
        for (Cliente c : clientes) {
            if (c.getDocumento() != documento) {
                throw new NotFoundException("El cliente no se encuentra en el sistema.");
            }
        }
        return clientes.stream().map(ClienteMapper::toDTO).collect(Collectors.toList());
    }

    public List<Cliente> existClienteByDocumento(int documento) {
        return clienteRepository.searchByDocumento(documento);
    }

    @Override
    public void deleteCliente(ClienteResponseDTO cliente) throws Exception {
        if (clienteRepository.existsByDocumento(cliente.getDocumento())) {
            clienteRepository.deleteByDocumento(cliente.getDocumento());
        } else {
            throw new Exception("No se puede eliminar el cliente.");
        }
    }

    @Override
    public void updateCliente(ClienteRequestDTO clienteDTO) throws Exception {
        if (clienteDTO.getDocumento() != 0) {
            List<Cliente> clientes = clienteRepository.searchByDocumento(clienteDTO.getDocumento());
            if (clienteRepository.existsByDocumento(clienteDTO.getDocumento())) {
                for (Cliente c : clientes) {
                    c.setNombre(clienteDTO.getNombre());
                    c.setApellido(clienteDTO.getApellido());
                    c.setEmail(clienteDTO.getEmail());
                    Ciudad ciudad = ciudadRepository.findById(clienteDTO.getId_ciudad()).orElseThrow();
                    c.setCiudad(ciudad);
                    TipoDoc tipoDoc = tipoDocRepository.findById(clienteDTO.getId_tipo_doc()).orElseThrow();
                    c.setTipoDoc(tipoDoc);
                    c.setEstado(clienteDTO.getEstado());
                    c.setDomicilio(clienteDTO.getDomicilio());
                    clienteRepository.save(c);
                }
            } else {
                throw new Exception("No existe el cliente.");
            }
        } else {
            throw new Exception("No existe el cliente. Se requiere el documento.");
        }
    }
}

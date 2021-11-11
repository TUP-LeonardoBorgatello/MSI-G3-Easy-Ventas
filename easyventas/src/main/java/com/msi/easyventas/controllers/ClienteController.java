package com.msi.easyventas.controllers;

import com.msi.easyventas.dtos.ClienteRequestDTO;
import com.msi.easyventas.dtos.ClienteResponseDTO;
import com.msi.easyventas.models.Cliente;
import com.msi.easyventas.services.ClienteService;
import com.msi.easyventas.services.ServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/easyventas")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @CrossOrigin(origins = "*")
    @GetMapping("/clientes")
    public List<ClienteResponseDTO> getAllClientes() {
        return clienteService.findAllClientes();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/clientesconid")
    public List<Cliente> getAllClientesConID() {
        return clienteService.findAllClientesConId();
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/add/cliente")
    public ResponseEntity<?> addCliente(@RequestBody ClienteRequestDTO nuevoCliente) throws Exception {
        ServiceResponse<?> response = new ServiceResponse<>("success", "Se agregó correctamente el cliente.");
        ServiceResponse<?> response2 = new ServiceResponse<>("error", "Cliente ya existe, o seleccione una ciudad y tipo de documento válido.");
        if (nuevoCliente != null) {
            try {
                clienteService.addCliente(nuevoCliente);
            } catch (Exception e) {
                return new ResponseEntity<Object>(response2, HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/cliente")
    public ResponseEntity<?> findClienteByDocumento(@RequestParam int documento) throws Exception {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(clienteService.findClienteByDocumento(documento));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el cliente.");
        }
    }

    @CrossOrigin(origins = "*")
    @PostMapping("cliente/delete")
    public ResponseEntity<?> deleteCliente(@RequestBody ClienteResponseDTO cliente) throws Exception {
        ServiceResponse<?> response = new ServiceResponse<>("success", "Se eliminó correctamente el cliente");
        ServiceResponse<?> response2 = new ServiceResponse<>("error", "No se puede eliminar el cliente, verifique si el dni existe");
        try{
            clienteService.deleteCliente(cliente);
        } catch (Exception e){
            return  new ResponseEntity<Object>(response2, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @ResponseBody
    @PutMapping("cliente/update")
    public ResponseEntity<?> updateCliente(@RequestBody ClienteRequestDTO cliente) throws Exception {
        ServiceResponse<?> response = new ServiceResponse<>("success", "Se actualizó correctamente el cliente");
        ServiceResponse<?> response2 = new ServiceResponse<>("error", "No se encontró el cliente con ese documento o los valores ingresados no corresponden");
        try {
            clienteService.updateCliente(cliente);
        } catch (Exception e) {
            return  new ResponseEntity<Object>(response2, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Object>(response, HttpStatus.OK);

    }
}


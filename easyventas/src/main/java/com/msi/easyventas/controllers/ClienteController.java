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

    @PostMapping("/add/cliente")
    public ResponseEntity<?> addCliente(@RequestBody ClienteRequestDTO nuevoCliente) throws Exception {
        if (nuevoCliente != null) {
            try {
                clienteService.addCliente(nuevoCliente);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cliente ya existe, o seleccione una ciudad y tipo de documento válido.");
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body("Agregado con éxito");
    }

    @GetMapping("/cliente")
    public ResponseEntity<?> findClienteByDocumento(@RequestParam int documento) throws Exception {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(clienteService.findClienteByDocumento(documento));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el cliente.");
        }
    }


    @PostMapping("cliente/delete")
    public String deleteCliente(@RequestBody ClienteResponseDTO cliente) throws Exception {
        clienteService.deleteCliente(cliente);
        return "Cliente eliminado.";
    }

    @CrossOrigin(origins = "*")
    @ResponseBody
    @PutMapping("cliente/update")
    public ResponseEntity<?> updateCliente(@RequestBody ClienteRequestDTO cliente) throws Exception {
        ServiceResponse<?> response = new ServiceResponse<String>("success", "Se actualizó correctamente el cliente");
        ServiceResponse<?> response2 = new ServiceResponse<String>("error", "No se encontró el cliente con ese documento o los valores ingresados no corresponden");
        try {
            clienteService.updateCliente(cliente);
        } catch (Exception e) {
            //return new ResponseEntity<>("No se encontró el cliente con ese documento o los valores ingresados no corresponden.", new HttpHeaders(), HttpStatus.BAD_REQUEST);
            return  new ResponseEntity<Object>(response2, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Object>(response, HttpStatus.OK);

    }
}


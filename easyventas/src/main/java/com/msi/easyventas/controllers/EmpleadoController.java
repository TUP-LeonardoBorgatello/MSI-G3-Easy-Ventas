package com.msi.easyventas.controllers;

import com.msi.easyventas.dtos.EmpleadoRequestDTO;
import com.msi.easyventas.dtos.EmpleadoResponseDTO;
import com.msi.easyventas.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/easyventas")
public class EmpleadoController {

    @Autowired
    EmpleadoService empleadoService;

    @GetMapping("/empleados")
    public List<EmpleadoResponseDTO> getAllClientes() {
        return empleadoService.findAllEmpleados();
    }

    @PostMapping("/add/empleado")
    public ResponseEntity<?> addEmpleado(@RequestBody EmpleadoRequestDTO nuevoEmpleado) throws Exception {
        if (nuevoEmpleado != null) {
            try {
                empleadoService.addEmpleado(nuevoEmpleado);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Empleado ya existe");
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body("Agregado con éxito");
    }

    @GetMapping("/empleado")
    public ResponseEntity<?> findEmpleadoByDocumento(@RequestParam int documento) throws Exception {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(empleadoService.findEmpleadoByDocumento(documento));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el empleado.");
        }
    }

    @PostMapping("empleado/status")
    public String changeStatusEmpleado(@RequestBody EmpleadoResponseDTO empleado) throws Exception {
        empleadoService.changeEmpleadoStatus(empleado);
        return "Se ha modificado el estado del empleado.";
    }

/*    @PutMapping("cliente/update")
    public ResponseEntity<?> updateCliente(@RequestBody ClienteRequestDTO cliente) throws Exception {
        try {
            clienteService.updateCliente(cliente);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se encontró el cliente con ese documento.");
        }
        return ResponseEntity.status(HttpStatus.OK).body("El cliente se modificó correctamente.");
    }*/
}
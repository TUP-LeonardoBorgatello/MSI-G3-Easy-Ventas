package com.msi.easyventas.controllers;

import com.msi.easyventas.dtos.EmpleadoChangeStatusDTO;
import com.msi.easyventas.dtos.EmpleadoRequestDTO;
import com.msi.easyventas.dtos.EmpleadoResponseDTO;
import com.msi.easyventas.services.EmpleadoService;
import com.msi.easyventas.services.ServiceResponse;
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
        ServiceResponse<?> response = new ServiceResponse<>("success", "Empleado agregado con éxito.");
        ServiceResponse<?> response2 = new ServiceResponse<>("error", "No se puedo agregar el empleado.");
        if (nuevoEmpleado != null) {
            try {
                empleadoService.addEmpleado(nuevoEmpleado);
            } catch (Exception e) {
                return new ResponseEntity<Object>(response2, HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    @GetMapping("/empleado")
    public ResponseEntity<?> findEmpleadoByDocumento(@RequestParam int documento) throws Exception {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(empleadoService.findEmpleadoByDocumento(documento));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El vendedor no se encuentra en el sistema.");
        }
    }

    @PostMapping("empleado/status")
    public ResponseEntity<?> changeStatusEmpleado(@RequestBody EmpleadoChangeStatusDTO empleado) throws Exception {
        ServiceResponse<?> response = new ServiceResponse<>("success", "Estado modificado");
        ServiceResponse<?> response2 = new ServiceResponse<>("error", "No se puedo modificar el estado, verificar que sea vendedor.");
        try {
            empleadoService.changeEmpleadoStatus(empleado);
        } catch (Exception e) {
            return new ResponseEntity<Object>(response2, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Object>(response, HttpStatus.OK);

    }

    @PutMapping("empleado/update")
    public ResponseEntity<?> updateCliente(@RequestBody EmpleadoRequestDTO empleado) throws Exception {
        ServiceResponse<?> response = new ServiceResponse<>("success", "Empleado modificado");
        ServiceResponse<?> response2 = new ServiceResponse<>("error", "No se puedo modificar el empleado, verificar si es vendedor.");
        try {
            empleadoService.updateEmpleado(empleado);
        } catch (Exception e) {
            return new ResponseEntity<Object>(response2, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }
}

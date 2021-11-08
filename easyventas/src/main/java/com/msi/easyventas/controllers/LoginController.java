package com.msi.easyventas.controllers;

import com.msi.easyventas.dtos.LoginRequestDTO;
import com.msi.easyventas.services.EmpleadoService;
import com.msi.easyventas.services.ServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/easyventas")
public class LoginController {

    @Autowired
    EmpleadoService empleadoService;

    @PostMapping("/empleados/login")
    public ResponseEntity<?> loginEmpleados(@RequestBody LoginRequestDTO loginEmpleado) throws Exception {
        String mensaje;
        ServiceResponse<?> response = new ServiceResponse<String>("error", "No se encontró el cliente con ese documento o los valores ingresados no corresponden");
        try {
            empleadoService.login(loginEmpleado);
            if (empleadoService.isAdministrador(loginEmpleado)) {
                mensaje = "Administrador logueado.";
            } else {
                mensaje = "Vendedor logueado.";
            }
        } catch (Exception e) {
            return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
        }
        return  new ResponseEntity<Object>(new ServiceResponse<>("success", mensaje), HttpStatus.OK);
    }
}

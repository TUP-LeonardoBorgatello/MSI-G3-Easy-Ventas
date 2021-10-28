package com.msi.easyventas.controllers;

import com.msi.easyventas.dtos.LoginRequestDTO;
import com.msi.easyventas.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String loginEmpleados(@RequestBody LoginRequestDTO loginEmpleado) throws Exception {
        String mensaje;
        try {
            empleadoService.login(loginEmpleado);
            if (empleadoService.isAdministrador(loginEmpleado)) {
                mensaje = "Administrador logueado.";
            } else {
                mensaje = "Vendedor logueado.";
            }
        } catch (Exception e) {
            return "No se pudo realizar el login. Verificar contraseña y/o nombre de usuario.";
        }
        return mensaje;
    }
}

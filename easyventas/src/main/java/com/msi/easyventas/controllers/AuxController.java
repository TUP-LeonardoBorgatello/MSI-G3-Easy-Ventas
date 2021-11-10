package com.msi.easyventas.controllers;

import com.msi.easyventas.models.Ciudad;
import com.msi.easyventas.models.Empleado;
import com.msi.easyventas.models.TipoDoc;
import com.msi.easyventas.services.AuxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/easyventas")
public class AuxController {
    @Autowired
    AuxService auxService;

    @CrossOrigin(origins = "*")
    @GetMapping("/tiposdocumentos")
    public List<TipoDoc> getAllTipoDoc() {
        return auxService.findAllTipoDoc();
    }


    @CrossOrigin(origins = "*")
    @GetMapping("/ciudades")
    public List<Ciudad> getAllCiudad() {
        return auxService.findAllCiudad();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/empleadoconid")
    public List<Empleado> getAllEmpleadoWithId() {
        return auxService.findAllEmpleadosWithId();
    }
}

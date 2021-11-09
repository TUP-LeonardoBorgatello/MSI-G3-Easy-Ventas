package com.msi.easyventas.controllers;

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
    public List<String> getAllTipoDoc() {
        return auxService.findAllTipoDoc();
    }
}

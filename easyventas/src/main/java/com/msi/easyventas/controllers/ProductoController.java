package com.msi.easyventas.controllers;

import com.msi.easyventas.dtos.ProductoResponseDTO;
import com.msi.easyventas.models.Producto;
import com.msi.easyventas.services.ProductoServicie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/easyventas")
public class ProductoController {
    @Autowired
    private ProductoServicie productoServicie;

    @GetMapping("/productossinid")
    public List<ProductoResponseDTO> getAllProductosSinId() {
        return productoServicie.findAllProductosSinId();
    }

    @GetMapping("/productos")
    public List<Producto> getAllProductos() {
        return productoServicie.findAllProductos();
    }


}

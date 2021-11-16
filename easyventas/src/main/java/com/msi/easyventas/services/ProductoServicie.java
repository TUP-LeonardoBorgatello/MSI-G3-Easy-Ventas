package com.msi.easyventas.services;

import com.msi.easyventas.dtos.ProductoResponseDTO;
import com.msi.easyventas.models.Producto;
import com.msi.easyventas.repositories.iProductoRepository;
import com.msi.easyventas.utils.ProductoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductoServicie
{
    @Autowired
    private iProductoRepository productoRepository;

    public List<ProductoResponseDTO> findAllProductosSinId()
    {
        List<Producto> productos = productoRepository.findAll();
        return productos.stream().map(ProductoMapper::toDTO).collect(Collectors.toList());
    }

    public List<Producto> findAllProductos()
    {
        return productoRepository.findAll();
    }

}

package com.msi.easyventas.utils;



import com.msi.easyventas.dtos.ProductoResponseDTO;
import com.msi.easyventas.models.Producto;

public class ProductoMapper
{
    public static ProductoResponseDTO toDTO(Producto producto)
    {

        ProductoResponseDTO productoResponseDTO = new ProductoResponseDTO();

        productoResponseDTO.setDescripcion(producto.getDescripcion());
        productoResponseDTO.setPrecioVenta(producto.getPrecioVenta());
        productoResponseDTO.setStock(producto.getStock());
        productoResponseDTO.setSku(producto.getSku());
        productoResponseDTO.setTipoProducto(producto.getTipoProducto().getDescripcion());

        return productoResponseDTO;
    }
}

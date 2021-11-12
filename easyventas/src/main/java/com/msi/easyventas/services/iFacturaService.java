package com.msi.easyventas.services;

import com.msi.easyventas.dtos.DetallePedidoResponseDTO;
import com.msi.easyventas.dtos.FacturaRequestDTO;
import com.msi.easyventas.dtos.FacturaResponseDTO;

import java.util.List;

public interface iFacturaService {

    FacturaResponseDTO Factura(long idPedido) throws Exception;

    void addFactura(FacturaRequestDTO facturaRequestDTO, long idPedido) throws Exception;

    void addDetalleFactura(long idPedido) throws Exception;

     List<DetallePedidoResponseDTO> getDetallesFactura(long idPedido);

}

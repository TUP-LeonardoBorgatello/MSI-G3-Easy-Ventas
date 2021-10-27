package com.msi.easyventas.services;

import com.msi.easyventas.dtos.FacturaRequestDTO;
import com.msi.easyventas.dtos.FacturaResponseDTO;

public interface iFacturaService {

    FacturaResponseDTO Factura() throws Exception;

    void addFactura(FacturaRequestDTO facturaRequestDTO, long idPedido) throws Exception;

    void addDetalleFactura(long idPedido) throws Exception;

}

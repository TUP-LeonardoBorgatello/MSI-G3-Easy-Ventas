package com.msi.easyventas.services;

import com.msi.easyventas.dtos.DetallePedidoResponseDTO;
import com.msi.easyventas.dtos.FacturaRequestDTO;
import com.msi.easyventas.dtos.FacturaResponseDTO;
import com.msi.easyventas.models.*;
import com.msi.easyventas.repositories.*;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class FacturaService implements iFacturaService {

    @Autowired
    iPedidoRepository pedidoRepository;

    @Autowired
    iDetallePedidoRepository detallePedidoRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    iEmpleadoRepository empleadoRepository;

    @Autowired
    iEstadoRepository estadoRepository;

    @Autowired
    iProductoRepository productoRepository;

    @Autowired
    FacturaRepository facturaRepository;

    @Autowired
    MetodoEntregaRepository metodoEntregaRepository;

    @Autowired
    MetodoPagoRepository metodoPagoRepository;

    @Autowired
    DetalleFacturaRepository detalleFacturaRepository;

    @Override
    public FacturaResponseDTO Factura(long idPedido) {
        long idFactura = facturaRepository.lastFacturaId();
        Factura factura = facturaRepository.findById(idFactura).orElseThrow();
        List<DetallePedido> detallePedidos = detallePedidoRepository.findDetallePedidoByIdPedido(idPedido);
        FacturaResponseDTO facturaResponseDTO = new FacturaResponseDTO();
        double montoTotal = 0;

        for (DetallePedido d : detallePedidos) {
            montoTotal += d.getProducto().getPrecioVenta() * d.getCantidad();
        }

        facturaResponseDTO.setId_factura(factura.getIdFactura());
        facturaResponseDTO.setFechaFactura(factura.getFecha());
        Pedido pedido = pedidoRepository.getById(idPedido);
        facturaResponseDTO.setDocumento(pedido.getCliente().getDocumento());
        facturaResponseDTO.setApellidoCliente(pedido.getCliente().getApellido());
        facturaResponseDTO.setNombreCliente(pedido.getCliente().getNombre());
        facturaResponseDTO.setDomicilio(pedido.getCliente().getDomicilio());
        facturaResponseDTO.setMetodoPago(factura.getMetodoPago().getDescripcion());
        facturaResponseDTO.setFormaEntrega(factura.getFormaEntrega().getDescripcion());
        facturaResponseDTO.setMontoTotal(montoTotal);

        return facturaResponseDTO;
    }

    public List<DetallePedidoResponseDTO> getDetallesFactura(long idPedido){
        long idFactura = facturaRepository.lastFacturaId();
        Factura factura = facturaRepository.findById(idFactura).orElseThrow();
        List<DetallePedido> detallePedidos = detallePedidoRepository.findDetallePedidoByIdPedido(idPedido);
        List<DetallePedidoResponseDTO> listaDetalles = new ArrayList<>();

        for (DetallePedido d : detallePedidos) {
            DetallePedidoResponseDTO detalles = new DetallePedidoResponseDTO();
            detalles.setNombreProducto(d.getProducto().getDescripcion());
            detalles.setCantidad(d.getCantidad());
            detalles.setPrecioUnitario(d.getProducto().getPrecioVenta());

            listaDetalles.add(detalles);
        }

        return listaDetalles;
    }

    @Override
    public void addFactura(FacturaRequestDTO facturaRequestDTO) throws Exception {

        List<DetallePedido> detallePedidos = detallePedidoRepository.findDetallePedidoByIdPedido(facturaRequestDTO.getIdPedido());
        Pedido pedido = pedidoRepository.findById(facturaRequestDTO.getIdPedido()).orElseThrow();
        if (detallePedidos.isEmpty() || !metodoEntregaRepository.existsById(facturaRequestDTO.getId_forma_entrega())
                || !metodoPagoRepository.existsById(facturaRequestDTO.getId_metodo_pago()) || pedido.getEstado().getIdEstado() != 1) {
            throw new NotFoundException("Alguno de los datos no existe. Verificar el método de pago o la forma de entrega o si el pedido est{a cancelado.");
        } else {
            FormaEntrega formaEntrega = metodoEntregaRepository.findById(facturaRequestDTO.getId_forma_entrega()).orElseThrow();
            MetodoPago metodoPago = metodoPagoRepository.findById(facturaRequestDTO.getId_metodo_pago()).orElseThrow();

            Factura f = new Factura();

            LocalDate fecha = LocalDate.now();
            f.setFecha(fecha);
            f.setFormaEntrega(formaEntrega);
            f.setMetodoPago(metodoPago);

            facturaRepository.save(f);
        }
    }

    @Override
    public void addDetalleFactura(FacturaRequestDTO facturaRequestDTO) throws Exception {
        Pedido pedido= pedidoRepository.findById(facturaRequestDTO.getIdPedido()).orElseThrow();
        List<DetallePedido> detallePedidos = detallePedidoRepository.findDetallePedidoByIdPedido(facturaRequestDTO.getIdPedido());
        double montoTotal = 0;
        long nuevoStock;
        long idFactura = facturaRepository.lastFacturaId();
        Factura factura = facturaRepository.findById(idFactura).orElseThrow();

        for (DetallePedido d : detallePedidos) {
            montoTotal += d.getProducto().getPrecioVenta() * d.getCantidad();
            nuevoStock = d.getProducto().getStock() - d.getCantidad();
            productoRepository.updateProductoStock(nuevoStock, d.getProducto().getIdProducto());
        }

        DetalleFactura d = new DetalleFactura();
        d.setFactura(factura);
        d.setMonto(montoTotal);
        d.setPedido(pedido);

        detalleFacturaRepository.save(d);
        pedidoRepository.updatePedidoFinishedStatus(facturaRequestDTO.getIdPedido());


    }
}


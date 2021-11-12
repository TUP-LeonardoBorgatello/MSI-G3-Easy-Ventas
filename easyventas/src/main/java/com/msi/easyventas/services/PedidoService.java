package com.msi.easyventas.services;

import com.msi.easyventas.dtos.PedidoDeleteRequestDTO;
import com.msi.easyventas.dtos.PedidoRequestDTO;
import com.msi.easyventas.dtos.PedidoResponseDTO;
import com.msi.easyventas.models.*;
import com.msi.easyventas.repositories.*;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PedidoService implements iPedidoService {

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

    @Override
    public List<PedidoResponseDTO> findAllPedidos() {
        List<Pedido> pedidos = pedidoRepository.findAll();
        double monto = 0;
        long cantTotal = 0;

        List<PedidoResponseDTO> listaPedidos = new ArrayList<>();

        for (Pedido p : pedidos) {
            List<DetallePedido> detallePedidos = detallePedidoRepository.findDetallePedidoByIdPedido(p.getIdPedido());
            for (DetallePedido d : detallePedidos) {
                cantTotal += d.getCantidad();
                monto += (d.getProducto().getPrecioVenta() * d.getCantidad());
            }
            PedidoResponseDTO pedidoResponseDTO = new PedidoResponseDTO();
            pedidoResponseDTO.setIdPedido(p.getIdPedido());
            pedidoResponseDTO.setFechaPedido(p.getFechaPedido());
            pedidoResponseDTO.setNombreCliente(p.getCliente().getNombre());
            pedidoResponseDTO.setApellidoCliente(p.getCliente().getApellido());
            pedidoResponseDTO.setCantidad(cantTotal);
            pedidoResponseDTO.setMonto(monto);
            pedidoResponseDTO.setEstado(p.getEstado().getDescripcion());

            listaPedidos.add(pedidoResponseDTO);
            monto = 0;
            cantTotal = 0;

        }
        return listaPedidos;
    }

    @Override
    public void addPedido(PedidoRequestDTO pedidoRequestDTO) throws Exception {

        if (!clienteRepository.existsByDocumento(pedidoRequestDTO.getDocumentoCliente())
                || !empleadoRepository.existsByDocumento(pedidoRequestDTO.getDocumentoEmpleado())) {
            throw new NotFoundException("Alguno de los datos no existe. Verificar el cliente, empleado o estado.");
        } else {
            Cliente cliente = clienteRepository.searchByDocumento1(pedidoRequestDTO.getDocumentoCliente());
            Empleado empleado = empleadoRepository.searchByDocumento(pedidoRequestDTO.getDocumentoEmpleado());

            Estado estado = new Estado();
            estado.setIdEstado(1);

            Pedido p = new Pedido();

            LocalDate fecha = LocalDate.now();

            p.setFechaPedido(fecha);
            p.setCliente(cliente);
            p.setEmpleado(empleado);
            p.setEstado(estado);

            pedidoRepository.save(p);
        }

    }


    public void addDetallePedido(PedidoRequestDTO detallePedidoRequestDTO) throws Exception {

        Producto producto = productoRepository.searchBySKU(detallePedidoRequestDTO.getSku());
        if (producto.getStock() >= 0 &&
                producto.getStock() > detallePedidoRequestDTO.getCantidad() &&
                detallePedidoRequestDTO.getCantidad() > 0) {
            long idPedido = pedidoRepository.lastPedidoId();
            Pedido pedido = pedidoRepository.findById(idPedido).orElseThrow();
            if (pedido.getEstado().getIdEstado() == 1){
                DetallePedido d = new DetallePedido();

                d.setPedido(pedido);
                d.setCantidad(detallePedidoRequestDTO.getCantidad());
                d.setProducto(producto);

                detallePedidoRepository.save(d);
            }
            else {
                throw new NotFoundException("El pedido esta finalizado o cancelado.");
            }
        } else {
            throw new NotFoundException("El producto no tiene stock.");
        }
    }

    public void deletePedido(PedidoDeleteRequestDTO pedidoDelete) throws Exception {

        List<DetallePedido> detallePedidos = detallePedidoRepository.findDetallePedidoByIdPedido(pedidoDelete.getId_pedido());
        Pedido pedido = pedidoRepository.findById(pedidoDelete.getId_pedido()).orElseThrow();
        if (detallePedidos.isEmpty()) {
            pedidoRepository.deleteById(pedidoDelete.getId_pedido());
        } else {
            if (pedido.getEstado().getIdEstado() == 1) {
                pedidoRepository.updatePedidoCanceledStatus(pedidoDelete.getId_pedido());
            } else {
                throw new Exception("El pedido está finalizado o cancelado");
            }
        }
    }


}


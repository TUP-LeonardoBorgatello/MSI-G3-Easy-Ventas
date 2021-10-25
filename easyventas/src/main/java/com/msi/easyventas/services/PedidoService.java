package com.msi.easyventas.services;

import com.msi.easyventas.dtos.DetallePedidoRequestDTO;
import com.msi.easyventas.dtos.PedidoDeleteRequestDTO;
import com.msi.easyventas.dtos.PedidoRequestDTO;
import com.msi.easyventas.dtos.PedidoResponseDTO;
import com.msi.easyventas.models.*;
import com.msi.easyventas.repositories.*;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

        if (!clienteRepository.existsById(pedidoRequestDTO.getId_cliente())
                || !empleadoRepository.existsById(pedidoRequestDTO.getId_empleado())) {
            throw new NotFoundException("Alguno de los datos no existe. Verificar el cliente, empleado o estado.");
        } else {
            Cliente cliente = clienteRepository.findById(pedidoRequestDTO.getId_cliente()).orElseThrow();
            Empleado empleado = empleadoRepository.findById(pedidoRequestDTO.getId_empleado()).orElseThrow();
            Estado estado = new Estado();
            estado.setIdEstado(2);

            Pedido p = new Pedido();

            p.setFechaPedido(pedidoRequestDTO.getFecha_pedido());
            p.setCliente(cliente);
            p.setEmpleado(empleado);
            p.setEstado(estado);

            pedidoRepository.save(p);
        }

    }


    public void addDetallePedido(DetallePedidoRequestDTO detallePedidoRequestDTO) throws Exception {

        if (!clienteRepository.existsById(detallePedidoRequestDTO.getId_pedido())
                || !productoRepository.existsById(detallePedidoRequestDTO.getId_producto())) {
            throw new NotFoundException("Alguno de los datos no existe. Verificar el pedido o poducto.");
        } else {
            Producto producto = productoRepository.findById(detallePedidoRequestDTO.getId_producto()).orElseThrow();
            Pedido pedido = pedidoRepository.getById(detallePedidoRequestDTO.getId_pedido());

            DetallePedido d = new DetallePedido();

            d.setPedido(pedido);
            d.setCantidad(detallePedidoRequestDTO.getCantidad());
            d.setProducto(producto);

            detallePedidoRepository.save(d);
        }

    }

    public void deletePedido(PedidoDeleteRequestDTO pedidoDelete) throws Exception {

        List<DetallePedido> detallePedidos = detallePedidoRepository.findDetallePedidoByIdPedido(pedidoDelete.getId_pedido());
        if (detallePedidos.isEmpty()) {
            pedidoRepository.deleteById(pedidoDelete.getId_pedido());
        } else {
            pedidoRepository.updatePedido(pedidoDelete.getId_pedido());
        }
    }


}


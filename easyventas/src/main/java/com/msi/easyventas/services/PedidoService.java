package com.msi.easyventas.services;

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
                monto += (d.getPrecio() * d.getCantidad());
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
                || !empleadoRepository.existsById(pedidoRequestDTO.getId_empleado())
                || !estadoRepository.existsById(pedidoRequestDTO.getId_estado())) {
            throw new NotFoundException("Alguno de los datos no existe. Verificar el cliente, empleado o estado.");
        } else {
            Cliente cliente = clienteRepository.findById(pedidoRequestDTO.getId_cliente()).orElseThrow();
            Empleado empleado = empleadoRepository.findById(pedidoRequestDTO.getId_empleado()).orElseThrow();
            Estado estado = estadoRepository.findById(pedidoRequestDTO.getId_estado()).orElseThrow();

            Pedido p = new Pedido();

            p.setFechaPedido(pedidoRequestDTO.getFecha_pedido());
            p.setCliente(cliente);
            p.setEmpleado(empleado);
            p.setEstado(estado);

            pedidoRepository.save(p);
        }

    }
}


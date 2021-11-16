package com.msi.easyventas.repositories;

import com.msi.easyventas.dtos.CantProductosXPedidoDTO;
import com.msi.easyventas.models.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface iDetallePedidoRepository extends JpaRepository<DetallePedido, Long> {
    @Query(value = "select * from detalles_pedidos where id_pedido like %:id_pedido%", nativeQuery = true)
    List<DetallePedido> findDetallePedidoByIdPedido(@Param("id_pedido") long id_pedido);

    @Query(value = "select new com.msi.easyventas.dtos.CantProductosXPedidoDTO(d.cantidad, d.pedido.idPedido) from DetallePedido d")
    List<CantProductosXPedidoDTO> cantProdXPedidos();

    @Query(value = "select new com.msi.easyventas.dtos.CantProductosXPedidoDTO(sum(d.cantidad), d.pedido.idPedido) from DetallePedido d where d.pedido.idPedido = ?1")
    List<CantProductosXPedidoDTO> prodXPedido(long idPedido);
}

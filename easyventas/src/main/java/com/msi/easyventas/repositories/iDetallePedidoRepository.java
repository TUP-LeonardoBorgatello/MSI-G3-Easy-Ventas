package com.msi.easyventas.repositories;

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
}

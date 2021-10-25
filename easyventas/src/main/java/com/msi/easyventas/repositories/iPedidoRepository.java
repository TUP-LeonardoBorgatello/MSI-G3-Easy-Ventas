package com.msi.easyventas.repositories;

import com.msi.easyventas.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface iPedidoRepository extends JpaRepository<Pedido, Long> {
    @Modifying
    @Query(value = "UPDATE pedidos SET id_estado = '4' where id_pedido = :id_pedido", nativeQuery = true)
    void updatePedido(@Param("id_pedido") long id_pedido);
}

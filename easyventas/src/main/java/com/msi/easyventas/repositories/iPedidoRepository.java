package com.msi.easyventas.repositories;

import com.msi.easyventas.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iPedidoRepository extends JpaRepository<Pedido, Long> {
}

package com.msi.easyventas.repositories;

import com.msi.easyventas.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iProductoRepository extends JpaRepository<Producto, Long> {
}

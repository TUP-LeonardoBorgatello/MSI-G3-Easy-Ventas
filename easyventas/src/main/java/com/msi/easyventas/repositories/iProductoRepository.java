package com.msi.easyventas.repositories;

import com.msi.easyventas.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface iProductoRepository extends JpaRepository<Producto, Long> {

    @Modifying
    @Query(value = "UPDATE productos SET productos.stock = :stock WHERE productos.id_producto = :id_producto", nativeQuery = true)
    void updateProductoStock(@Param("stock") long stock, @Param("id_producto") long id_producto);
}

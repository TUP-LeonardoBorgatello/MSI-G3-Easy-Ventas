package com.msi.easyventas.repositories;

import com.msi.easyventas.models.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long> {

    @Query(value = "SELECT max(id_factura) from facturas", nativeQuery = true)
    Long lastFacturaId();
}

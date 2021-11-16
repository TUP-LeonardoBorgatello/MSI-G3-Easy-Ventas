package com.msi.easyventas.repositories;

import com.msi.easyventas.dtos.CantFacturaXFecha;
import com.msi.easyventas.models.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long> {

    @Query(value = "SELECT max(id_factura) from facturas", nativeQuery = true)
    Long lastFacturaId();

    @Query(value = "select new com.msi.easyventas.dtos.CantFacturaXFecha(count (f.idFactura), f.fecha) from Factura f group by f.fecha")
    List<CantFacturaXFecha> lista();

    @Query(value = "select new com.msi.easyventas.dtos.CantFacturaXFecha(count (f.idFactura), f.fecha) from Factura f where f.fecha between ?1 and ?2 group by f.fecha")
    List<CantFacturaXFecha> lista2(LocalDate fecha1, LocalDate fecha2);
}

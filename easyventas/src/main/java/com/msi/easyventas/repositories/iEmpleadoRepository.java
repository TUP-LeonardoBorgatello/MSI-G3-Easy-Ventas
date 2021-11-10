package com.msi.easyventas.repositories;

import com.msi.easyventas.models.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface iEmpleadoRepository extends JpaRepository<Empleado, Long> {
    boolean existsByDocumento(int documento);

    @Query(value = "select * from Empleados where documento = :documento LIMIT 1", nativeQuery = true)
    Empleado searchByDocumento(@Param("documento") int documento);
}

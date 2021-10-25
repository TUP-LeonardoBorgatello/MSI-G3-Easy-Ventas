package com.msi.easyventas.repositories;

import com.msi.easyventas.models.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

    boolean existsByDocumento(int documento);

    @Query(value = "select * from Empleados where documento = :documento", nativeQuery = true)
    List<Empleado> searchByDocumento(@Param("documento") int documento);

    @Modifying
    @Query(value = "UPDATE empleados SET estado = FALSE WHERE id_empleado = :id_empleado", nativeQuery = true)
    void updateEmpleadoStatus(@Param("id_empleado") long id_empleado);
}

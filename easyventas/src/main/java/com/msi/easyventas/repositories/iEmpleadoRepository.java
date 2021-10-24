package com.msi.easyventas.repositories;

import com.msi.easyventas.models.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iEmpleadoRepository extends JpaRepository<Empleado, Long> {
}

package com.msi.easyventas.repositories;

import com.msi.easyventas.models.RolEmpleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolEmpleadoRepository extends JpaRepository<RolEmpleado, Long> {
}

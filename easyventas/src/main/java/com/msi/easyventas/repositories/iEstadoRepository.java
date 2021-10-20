package com.msi.easyventas.repositories;

import com.msi.easyventas.models.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iEstadoRepository extends JpaRepository<Estado, Long> {
}

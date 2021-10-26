package com.msi.easyventas.repositories;

import com.msi.easyventas.models.FormaEntrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetodoEntregaRepository extends JpaRepository<FormaEntrega, Long> {
}

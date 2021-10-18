package com.msi.easyventas.repositories;

import com.msi.easyventas.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    boolean existsByDocumento(int documento);

    @Query(value = "select * from Clientes where documento like %:documento%", nativeQuery = true)
    List<Cliente> searchByDocumento(@Param("documento") int documento);

    void deleteByDocumento(int documento);
}

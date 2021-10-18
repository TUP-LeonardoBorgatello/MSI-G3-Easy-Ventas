package com.msi.easyventas.repositories;

import com.msi.easyventas.models.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CiudadRepository extends JpaRepository<Ciudad, Long> {

}

package com.msi.easyventas.repositories;

import com.msi.easyventas.models.TipoDoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDocRepository extends JpaRepository<TipoDoc, Long> {

}

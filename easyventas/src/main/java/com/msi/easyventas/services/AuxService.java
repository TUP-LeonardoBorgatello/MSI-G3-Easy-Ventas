package com.msi.easyventas.services;

import com.msi.easyventas.models.TipoDoc;
import com.msi.easyventas.repositories.TipoDocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AuxService {

    @Autowired
    TipoDocRepository tipoDocRepository;

    public List<TipoDoc> findAllTipoDoc() {
        List<TipoDoc> tipoDocs = tipoDocRepository.findAll();
        return tipoDocs;
    }
}
